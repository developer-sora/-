package com.mz.rc;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class RM {

   public static void calc(HttpServletRequest request) {
      Random random = new Random();
      int r = random.nextInt(8);
      int ren = random.nextInt(8);
      int imgNum = 0;

      int[][] menuImg = new int[8][8];
      for (int i = 0; i < 8; i++) {
         for (int j = 0; j < 8; j++) {
            imgNum++;
            menuImg[i][j] = imgNum;
         }
      }

      String[][] menu = new String[][] {
            // 8*8
            { "�ø�", "�ӹ�", "��", "���ö�", "��", "����", "��", "��/�" },//�ѽ�
            { "¥���", "«��", "������", "������", "���󼧱�", "��ٷο�", "������", "����" },//�߽�
            { "���", "�ʹ�", "ȸ", "�쵿", "����", "����", "���", "ī��" },//�Ͻ�
            { "�ܹ���", "������ġ", "�佺Ʈ", "�ֵ���", "����", "����", "����", "�ɟ�" },//�н�Ʈ/����Ʈ
            { "�ұ���", "�Ľ�Ÿ", "������ũ", "��Ÿ��", "�߽�ĭ", "�������", "�ε�ī��", "����" },//�ƽþ�//���
            { "�߰���", "����", "����", "�Ұ��", "��ȸ", "��������", "�Ұ��", "��������" },//���
            { "���ġŲ", "�Ķ��̵�", "����ġŲ", "���", "�����", "�ߵ�����", "����ġŲ", "�߰���" },//ġŲ
            { "������", "�߹�", "����", "���", "����", "����", "��â", "���" } };//�н�/�߽�

      request.setAttribute("menuRandom", menu[r][ren]);
      request.setAttribute("menuRandomImg", menuImg[r][ren]);

   }

}