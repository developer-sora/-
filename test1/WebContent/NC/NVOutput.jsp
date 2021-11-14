<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="index.css">
<title>Ű����� ��Ұ˻��ϰ� ������� ǥ���ϱ�</title>
</head>
<body>
   <div class="map_wrap">
      <div id="map" 
         style="width: 50%; height: 500px; position: relative; bottom: 0px;">
</div>
      <div id="menu_wrap" class="bg_white">
         <div class="option">
            <div>
               <form onsubmit="searchPlaces(); return false;"></form>
            </div>
         </div>
         
         <hr>
         <ul id="placesList"></ul>
         <div id="pagination"></div>
      </div>
   </div>

   <script type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=df59ebee3f8c194cfdea176146376eb8&libraries=services"></script>
   <script>
      // ����� ��ǥ�� ã���ִ� �Լ�
      var lati, longi;

      var options = {
         enableHighAccuracy : true,
         timeout : 5000,
         maximumAge : 0
      };

      function success(pos) {
         crd = pos.coords;
         lati = crd.latitude;
         longi = crd.longitude;

         map();
      };

      function error(err) {
         console.warn('ERROR(' + err.code + '): ' + err.message);
      };

      navigator.geolocation.getCurrentPosition(success, error, options);

      var markers = [];
      var map;
      var ps;
      var infowindow;
      // ��Ŀ�� Ŭ���ϸ� ��Ҹ��� ǥ���� ���������� �Դϴ�

      function map() {

         // ��Ŀ�� ���� �迭�Դϴ�
         var markers = [];

         var mapContainer = document.getElementById('map'), // ������ ǥ���� div 
         mapOption = {
            center : new kakao.maps.LatLng(lati, longi), // ������ �߽���ǥ
            level : 5
         // ������ Ȯ�� ����
         };

         // ������ �����մϴ�    
         var map = new kakao.maps.Map(mapContainer, mapOption);

         // ��� �˻� ��ü�� �����մϴ�
         var ps = new kakao.maps.services.Places(map);

         // ī�װ��� �˻� �մϴ�
         ps.categorySearch('${param.category}', placesSearchCB, {
            useMapBounds : true
         });

         // �˻� ��� ����̳� ��Ŀ�� Ŭ������ �� ��Ҹ��� ǥ���� ���������츦 �����մϴ�
         var infowindow = new kakao.maps.InfoWindow({
            zIndex : 1
         });

         // ��Ұ˻��� �Ϸ���� �� ȣ��Ǵ� �ݹ��Լ� �Դϴ�
         function placesSearchCB(data, status, pagination) {
            if (status === kakao.maps.services.Status.OK) {

               // ���������� �˻��� �Ϸ������
               // �˻� ��ϰ� ��Ŀ�� ǥ���մϴ�
               displayPlaces(data);

               // ������ ��ȣ�� ǥ���մϴ�
               displayPagination(pagination);

            }
         }

         // �˻� ��� ��ϰ� ��Ŀ�� ǥ���ϴ� �Լ��Դϴ�
         function displayPlaces(places) {

            var listEl = document.getElementById('placesList'), menuEl = document
                  .getElementById('menu_wrap'), fragment = document
                  .createDocumentFragment(), bounds = new kakao.maps.LatLngBounds(), listStr = '';

            // �˻� ��� ��Ͽ� �߰��� �׸���� �����մϴ�
            removeAllChildNods(listEl);

            // ������ ǥ�õǰ� �ִ� ��Ŀ�� �����մϴ�
            removeMarker();

            for (var i = 0; i < places.length; i++) {

               // ��Ŀ�� �����ϰ� ������ ǥ���մϴ�
               var placePosition = new kakao.maps.LatLng(places[i].y,
                     places[i].x), marker = addMarker(placePosition, i), itemEl = getListItem(
                     i, places[i]); // �˻� ��� �׸� Element�� �����մϴ�

               // �˻��� ��� ��ġ�� �������� ���� ������ �缳���ϱ�����
               // LatLngBounds ��ü�� ��ǥ�� �߰��մϴ�
               bounds.extend(placePosition);

               // ��Ŀ�� �˻���� �׸� mouseover ������
               // �ش� ��ҿ� ���������쿡 ��Ҹ��� ǥ���մϴ�
               // mouseout ���� ���� ���������츦 �ݽ��ϴ�
               (function(marker, title) {
                  kakao.maps.event.addListener(marker, 'mouseover',
                        function() {
                           displayInfowindow(marker, title);
                        });

                  kakao.maps.event.addListener(marker, 'mouseout',
                        function() {
                           infowindow.close();
                        });

                  itemEl.onmouseover = function() {
                     displayInfowindow(marker, title);
                  };

                  itemEl.onmouseout = function() {
                     infowindow.close();
                  };
               })(marker, places[i].place_name);

               fragment.appendChild(itemEl);
            }

            // �˻���� �׸���� �˻���� ��� Elemnet�� �߰��մϴ�
            listEl.appendChild(fragment);
            menuEl.scrollTop = 0;

            // �˻��� ��� ��ġ�� �������� ���� ������ �缳���մϴ�
            map.setBounds(bounds);
         }

         // �˻���� �׸��� Element�� ��ȯ�ϴ� �Լ��Դϴ�
         function getListItem(index, places) {

            var el = document.createElement('li'), itemStr = '<span class="markerbg marker_'
                  + (index + 1)
                  + '"></span>'
                  + '<div class="info">'
                  + '   <h5>' + places.place_name + '</h5>';

            if (places.road_address_name) {
               itemStr += '    <span>' + places.road_address_name
                     + '</span>' + '   <span class="jibun gray">'
                     + places.address_name + '</span>';
            } else {
               itemStr += '    <span>' + places.address_name + '</span>';
            }

            itemStr += '  <span class="tel">' + places.phone + '</span>'
                  + '</div>';

            el.innerHTML = itemStr;
            el.className = 'item';

            return el;
         }

         // ��Ŀ�� �����ϰ� ���� ���� ��Ŀ�� ǥ���ϴ� �Լ��Դϴ�
         function addMarker(position, idx, title) {
            var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // ��Ŀ �̹��� url, ��������Ʈ �̹����� ���ϴ�
            imageSize = new kakao.maps.Size(36, 37), // ��Ŀ �̹����� ũ��
            imgOptions = {
               spriteSize : new kakao.maps.Size(36, 691), // ��������Ʈ �̹����� ũ��
               spriteOrigin : new kakao.maps.Point(0, (idx * 46) + 10), // ��������Ʈ �̹��� �� ����� ������ �»�� ��ǥ
               offset : new kakao.maps.Point(13, 37)
            // ��Ŀ ��ǥ�� ��ġ��ų �̹��� �������� ��ǥ
            }, markerImage = new kakao.maps.MarkerImage(imageSrc,
                  imageSize, imgOptions), marker = new kakao.maps.Marker(
                  {
                     position : position, // ��Ŀ�� ��ġ
                     image : markerImage
                  });

            marker.setMap(map); // ���� ���� ��Ŀ�� ǥ���մϴ�
            markers.push(marker); // �迭�� ������ ��Ŀ�� �߰��մϴ�

            return marker;
         }

         // ���� ���� ǥ�õǰ� �ִ� ��Ŀ�� ��� �����մϴ�
         function removeMarker() {
            for (var i = 0; i < markers.length; i++) {
               markers[i].setMap(null);
            }
            markers = [];
         }

         // �˻���� ��� �ϴܿ� ��������ȣ�� ǥ�ô� �Լ��Դϴ�
         function displayPagination(pagination) {
            var paginationEl = document.getElementById('pagination'), fragment = document
                  .createDocumentFragment(), i;

            // ������ �߰��� ��������ȣ�� �����մϴ�
            while (paginationEl.hasChildNodes()) {
               paginationEl.removeChild(paginationEl.lastChild);
            }

            for (i = 1; i <= pagination.last; i++) {
               var el = document.createElement('a');
               el.href = "#";
               el.innerHTML = i;

               if (i === pagination.current) {
                  el.className = 'on';
               } else {
                  el.onclick = (function(i) {
                     return function() {
                        pagination.gotoPage(i);
                     }
                  })(i);
               }

               fragment.appendChild(el);
            }
            paginationEl.appendChild(fragment);
         }

         // �˻���� ��� �Ǵ� ��Ŀ�� Ŭ������ �� ȣ��Ǵ� �Լ��Դϴ�
         // ���������쿡 ��Ҹ��� ǥ���մϴ�
         function displayInfowindow(marker, title) {
            var content = '<div style="padding:5px;z-index:1;">' + title
                  + '</div>';

            infowindow.setContent(content);
            infowindow.open(map, marker);
         }

         // �˻���� ����� �ڽ� Element�� �����ϴ� �Լ��Դϴ�
         function removeAllChildNods(el) {
            while (el.hasChildNodes()) {
               el.removeChild(el.lastChild);
            }
         }
      }
   </script>
</body>
</html>