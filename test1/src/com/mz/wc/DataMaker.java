package com.mz.wc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class DataMaker {

   public static void save(HttpServletRequest request) {

      request.setAttribute("userData", request.getParameter("select"));
   }

   public static int saveA(HttpServletRequest request) {

      String userDataSum = request.getParameter("userDataSum") + request.getParameter("select");

      // ����1ȸ�� ���� // �ʱ� �Է��� null �϶� ���ϱ� ���ϱ�
      if (request.getParameter("userDataSum") == null) {
         userDataSum = request.getParameter("select");
      }

      ArrayList<Integer> rank_32 = new ArrayList<Integer>();
      ArrayList<Integer> rank_16 = new ArrayList<Integer>();
      ArrayList<Integer> rank_8 = new ArrayList<Integer>();
      ArrayList<Integer> rank_4 = new ArrayList<Integer>();
      ArrayList<Integer> rank_2 = new ArrayList<Integer>();
      ArrayList<Integer> rank_1 = new ArrayList<Integer>();

      String[][] menu = new String[][]

      {
            // 8*8
            { "�ø�", "�ӹ�", "��", "���ö�", "��", "����", "��", "��/�" },
            { "¥���", "«��", "������", "������", "���󼧱�", "��ٷο�", "������", "����" },
            { "���", "�ʹ�", "ȸ", "�쵿", "����", "����", "���", "ī��" },
            { "�ܹ���", "������ġ", "�佺Ʈ", "�ֵ���", "����", "����", "����", "�ɟ�" /* 32���� */ },
            { "�ұ���", "�Ľ�Ÿ", "������ũ", "��Ÿ��", "�߽�ĭ", "�������", "�ε�ī��", "����" },
            { "�߰���", "����", "����", "�Ұ��", "��ȸ", "��������", "�Ұ��", "��������" },
            { "���ġŲ", "�Ķ��̵�", "����ġŲ", "���", "�����", "�ߵ�����", "����ġŲ", "�߰���" },
            { "������", "�߹�", "����", "���", "����", "����", "��â", "���" } };
      String[] menuList = new String[64];
      int num = 0;
      for (int i = 0; i < 8; i++) {
         for (int j = 0; j < 8; j++) {

            menuList[num] = menu[i][j];
            num++;
         }

      }

      int count = userDataSum.length();// 64��
      int countimg1 = userDataSum.length() * 2 + 1;// 64��
      int countimg2 = userDataSum.length() * 2 + 2;// 64��
      int round = 0;
      request.setAttribute("count", count);
      request.setAttribute("countImg1", countimg1);
      request.setAttribute("countImg2", countimg2);
      request.setAttribute("userData", userDataSum);
      if (count < 32) {
         request.setAttribute("MenuL", menuList[countimg1 - 1]);
         request.setAttribute("MenuR", menuList[countimg2 - 1]);
      }

      request.setAttribute("round", request.getParameter("round"));
      request.setAttribute("nextRound32", request.getParameter("nextRound32"));
      request.setAttribute("nextRound16", request.getParameter("nextRound16"));
      request.setAttribute("nextRound8", request.getParameter("nextRound8"));
      request.setAttribute("nextRound4", request.getParameter("nextRound4"));
      request.setAttribute("nextRound2", request.getParameter("nextRound2"));
      request.setAttribute("nextRound1", request.getParameter("nextRound1"));

      if (request.getParameter("nextRound32").equals("")) {
         round = 1;
         request.setAttribute("round", round);
      } else if (request.getParameter("nextRound16").equals("")) {
         round = 2;
         request.setAttribute("round", round);

      } else if (request.getParameter("nextRound8").equals("")) {
         round = 3;
         request.setAttribute("round", round);

      } else if (request.getParameter("nextRound4").equals("")) {
         round = 4;
         request.setAttribute("round", round);

      } else if (request.getParameter("nextRound2").equals("")) {
         round = 5;
         request.setAttribute("round", round);

      } else if (request.getParameter("nextRound1").equals("")) {
         round = 6;
         request.setAttribute("round", round);

      } else {
         round = 100;
         request.setAttribute("round", round);
      }
      
   
      request.setAttribute("roundV", 64);// �


      String[] userData32 = ((String) request.getAttribute("nextRound32")).split("");
      String[] userData16 = ((String) request.getAttribute("nextRound16")).split("");
      String[] userData8 = ((String) request.getAttribute("nextRound8")).split("");
      String[] userData4 = ((String) request.getAttribute("nextRound4")).split("");
      String[] userData2 = ((String) request.getAttribute("nextRound2")).split("");
      String[] userData1 = ((String) request.getAttribute("nextRound1")).split("");
      String[] userData;

      // -------------------------------------------------
      if (round >= 2) { // ���尡 2 �̻��ϋ��� �����ؾ���
         for (int i = 1; i < 32 + 1; i++) {
            if (userData32[i - 1].equals("1")) {
               rank_32.add(i * 2 - 1);
            } else if (userData32[i - 1].equals("2")) {
               rank_32.add(i * 2);
            }
         }

         // 0
         // 1
         countimg1 = userDataSum.length() * 2 + 1;// 64��
         countimg2 = userDataSum.length() * 2 + 2;// 64��
         if (userDataSum.length() <= 15) {
            request.setAttribute("countImg1", rank_32.get((countimg1 - 1)));
            request.setAttribute("countImg2", rank_32.get((countimg2 - 1)));
            request.setAttribute("MenuL", menuList[rank_32.get((countimg1 - 1)) - 1]);
            request.setAttribute("MenuR", menuList[rank_32.get((countimg2 - 1)) - 1]);
            request.setAttribute("roundV", 32);// �

         }
      }
      if (round >= 3) { // ���尡 3 �̻��ϋ��� �����ؾ���
         for (int i = 1; i < 16 + 1; i++) {

            if (userData16[i - 1].equals("1")) {
               rank_16.add(rank_32.get(i * 2 - 2));
            } else if (userData16[i - 1].equals("2")) {
               rank_16.add(rank_32.get(i * 2 - 1));
            }
         }
         // 0
         // 1
         countimg1 = userDataSum.length() * 2 + 1;// 64��
         countimg2 = userDataSum.length() * 2 + 2;// 64��
         if (userDataSum.length() <= 7) {
            request.setAttribute("countImg1", rank_16.get((countimg1 - 1)));
            request.setAttribute("countImg2", rank_16.get((countimg2 - 1)));
            request.setAttribute("MenuL", menuList[rank_16.get((countimg1 - 1)) - 1]);
            request.setAttribute("MenuR", menuList[rank_16.get((countimg2 - 1)) - 1]);
            request.setAttribute("roundV", 16);// �
         }
      }
      if (round >= 4) { // ���尡 4 �̻��ϋ��� �����ؾ���
         for (int i = 1; i < 8 + 1; i++) {

            if (userData8[i - 1].equals("1")) {
               rank_8.add(rank_16.get(i * 2 - 2));
            } else if (userData8[i - 1].equals("2")) {
               rank_8.add(rank_16.get(i * 2 - 1));
            }
         }
         // 0
         // 1
         countimg1 = userDataSum.length() * 2 + 1;// 64��
         countimg2 = userDataSum.length() * 2 + 2;// 64��
         if (userDataSum.length() <= 3) {
            request.setAttribute("countImg1", rank_8.get((countimg1 - 1)));
            request.setAttribute("countImg2", rank_8.get((countimg2 - 1)));
            request.setAttribute("MenuL", menuList[rank_8.get((countimg1 - 1)) - 1]);
            request.setAttribute("MenuR", menuList[rank_8.get((countimg2 - 1)) - 1]);
            request.setAttribute("roundV", 8);// �
         }
      }
      if (round >= 5) { // ���尡 5 �̻��ϋ��� �����ؾ���
         for (int i = 1; i < 4 + 1; i++) {

            if (userData4[i - 1].equals("1")) {
               rank_4.add(rank_8.get(i * 2 - 2));
            } else if (userData4[i - 1].equals("2")) {
               rank_4.add(rank_8.get(i * 2 - 1));
            }
         }
         // 0
         // 1
         countimg1 = userDataSum.length() * 2 + 1;// 64��
         countimg2 = userDataSum.length() * 2 + 2;// 64��
         if (userDataSum.length() <= 1) {
            request.setAttribute("countImg1", rank_4.get((countimg1 - 1)));
            request.setAttribute("countImg2", rank_4.get((countimg2 - 1)));
            request.setAttribute("MenuL", menuList[rank_4.get((countimg1 - 1)) - 1]);
            request.setAttribute("MenuR", menuList[rank_4.get((countimg2 - 1)) - 1]);
            request.setAttribute("roundV", 4);// �
         }
      }
      if (round >= 6) { // ���尡 6 �̻��ϋ��� �����ؾ���
         for (int i = 1; i < 2 + 1; i++) {

            if (userData2[i - 1].equals("1")) {
               rank_2.add(rank_4.get(i * 2 - 2));
            } else if (userData2[i - 1].equals("2")) {
               rank_2.add(rank_4.get(i * 2 - 1));
            }
         }
         // 0
         // 1
         countimg1 = userDataSum.length() * 2 + 1;// 64��
         countimg2 = userDataSum.length() * 2 + 2;// 64��
         if (userDataSum.length() <= 15) {
            request.setAttribute("countImg1", rank_32.get((countimg1 - 1)));
            request.setAttribute("countImg2", rank_32.get((countimg2 - 1)));
            request.setAttribute("roundV", 2);// �
         }
      }

      // �� �ؿ� �̹��� �� ���̺��ؾ���
      // �� �ؿ��� ���

//--------------------------------------------------------------------------------
      if ((round == 1) && (request.getParameter("userDataSum") + request.getParameter("select")).length() == 32) {
         userData = userDataSum.split("");
         request.setAttribute("nextRound32", userDataSum);
         request.setAttribute("userData", "");

         for (int i = 1; i < 32 + 1; i++) {

            if (userData[i - 1].equals("1")) {
               rank_32.add(i * 2 - 1);
            } else if (userData[i - 1].equals("2")) {
               rank_32.add(i * 2);
            }

         }
         request.setAttribute("countImg1", rank_32.get(0));
         request.setAttribute("countImg2", rank_32.get(1));
         request.setAttribute("MenuL", menuList[rank_32.get(0) - 1]);
         request.setAttribute("MenuR", menuList[rank_32.get(1) - 1]);
         request.setAttribute("roundV", 32);// �

      }
      if (round == 2 && (request.getParameter("userDataSum") + request.getParameter("select")).length() == 16) {
         userData = userDataSum.split("");
         request.setAttribute("nextRound16", userDataSum);
         request.setAttribute("userData", "");
         request.setAttribute("count", "");
         ;

         for (int i = 1; i < 16 + 1; i++) {

            if (userData[i - 1].equals("1")) {
               rank_16.add(rank_32.get(i * 2 - 2));
            } else if (userData[i - 1].equals("2")) {
               rank_16.add(rank_32.get(i * 2 - 1));
            }

         }
         // -------------------------------�� �����ε� �ϼ��ؾ���
         request.setAttribute("countImg1", rank_16.get(0));
         request.setAttribute("countImg2", rank_16.get(1));
         request.setAttribute("MenuL", menuList[rank_16.get(0) - 1]);
         request.setAttribute("MenuR", menuList[rank_16.get(1) - 1]);
         request.setAttribute("roundV", 16);// �

      }
      if (round == 3 && (request.getParameter("userDataSum") + request.getParameter("select")).length() == 8) {
         userData = userDataSum.split("");
         request.setAttribute("nextRound8", userDataSum);
         request.setAttribute("userData", "");
         request.setAttribute("count", "");

         for (int i = 1; i < 8 + 1; i++) {

            if (userData[i - 1].equals("1")) {
               rank_8.add(rank_16.get(i * 2 - 2));
            } else if (userData[i - 1].equals("2")) {
               rank_8.add(rank_16.get(i * 2 - 1));
            }

         }
         // -------------------------------�� �����ε� �ϼ��ؾ���
         request.setAttribute("countImg1", rank_8.get(0));
         request.setAttribute("countImg2", rank_8.get(1));
         request.setAttribute("MenuL", menuList[rank_8.get(0) - 1]);
         request.setAttribute("MenuR", menuList[rank_8.get(1) - 1]);
         request.setAttribute("roundV", 8);// �

      }
      if (round == 4 && (request.getParameter("userDataSum") + request.getParameter("select")).length() == 4) {
         userData = userDataSum.split("");
         request.setAttribute("nextRound4", userDataSum);
         request.setAttribute("userData", "");
         request.setAttribute("count", "");
         for (int i = 1; i < 4 + 1; i++) {

            if (userData[i - 1].equals("1")) {
               rank_4.add(rank_8.get(i * 2 - 2));
            } else if (userData[i - 1].equals("2")) {
               rank_4.add(rank_8.get(i * 2 - 1));
            }

         }
         // -------------------------------�� �����ε� �ϼ��ؾ���
         request.setAttribute("countImg1", rank_4.get(0));
         request.setAttribute("countImg2", rank_4.get(1));
         request.setAttribute("MenuL", menuList[rank_4.get(0) - 1]);
         request.setAttribute("MenuR", menuList[rank_4.get(1) - 1]);
         request.setAttribute("roundV", 4);// �

      }
      if (round == 5 && (request.getParameter("userDataSum") + request.getParameter("select")).length() == 2) {
         userData = userDataSum.split("");
         request.setAttribute("nextRound2", userDataSum);
         request.setAttribute("userData", "");
         request.setAttribute("count", "");
         for (int i = 1; i < 2 + 1; i++) {

            if (userData[i - 1].equals("1")) {
               rank_2.add(rank_4.get(i * 2 - 2));
            } else if (userData[i - 1].equals("2")) {
               rank_2.add(rank_4.get(i * 2 - 1));
            }

         }
         // -------------------------------�� �����ε� �ϼ��ؾ���
         request.setAttribute("countImg1", rank_2.get(0));
         request.setAttribute("countImg2", rank_2.get(1));
         request.setAttribute("MenuL", menuList[rank_2.get(0) - 1]);
         request.setAttribute("MenuR", menuList[rank_2.get(1) - 1]);
         request.setAttribute("roundV", 2);// �

      }
      if (round == 6 && (request.getParameter("userDataSum") + request.getParameter("select")).length() == 1) {
         userData = userDataSum.split("");
         request.setAttribute("nextRound1", userDataSum);
         request.setAttribute("userData", "");
         request.setAttribute("count", "");
         for (int i = 1; i < 1 + 1; i++) {

            if (userData[i - 1].equals("1")) {
               rank_1.add(rank_2.get(i * 2 - 2));
            } else if (userData[i - 1].equals("2")) {
               rank_1.add(rank_2.get(i * 2 - 1));
            }
            request.setAttribute("rank_1", rank_1.get(0));

         }
         // -------------------------------�� �����ε� �ϼ��ؾ���
         request.setAttribute("countImg1", rank_1.get(0));
         request.setAttribute("countImg2", "");// 1���� �Ѱ�
         request.setAttribute("MenuL", menuList[rank_1.get(0) - 1]);
         request.setAttribute("MenuR", "");
         return 1;

      }
      return 0;

   

   }

}