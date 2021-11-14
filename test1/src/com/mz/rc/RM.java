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
            { "³Ã¸é", "½Ó¹ä", "Âò", "µµ½Ã¶ô", "Á×", "±¹¹ä", "Àü", "ÅÁ/Âî°³" },//ÇÑ½Ä
            { "Â¥Àå¸é", "Â«»Í", "ÅÁ¼öÀ°", "¸¶¶óÅÁ", "¸¶¶ó¼§±Å", "²ã¹Ù·Î¿ì", "ººÀ½¹ä", "¸¸µÎ" },//Áß½Ä
            { "µ·±î½º", "ÃÊ¹ä", "È¸", "¿ìµ¿", "µ¤¹ä", "Àü°ñ", "¶ó¸à", "Ä«·¹" },//ÀÏ½Ä
            { "ÇÜ¹ö°Å", "»÷µåÀ§Ä¡", "Åä½ºÆ®", "ÇÖµµ±×", "¿ÍÇÃ", "µµ³Ó", "ºù¼ö", "ÄÉŸå" },//ÆÐ½ºÆ®/µðÀúÆ®
            { "½Ò±¹¼ö", "ÆÄ½ºÅ¸", "½ºÅ×ÀÌÅ©", "ÆÌÅ¸ÀÌ", "¸ß½ÃÄ­", "»þºê»þºê", "ÀÎµµÄ«·¹", "ÇÇÀÚ" },//¾Æ½Ã¾È//¾ç½Ä
            { "´ß°¥ºñ", "¾ç°í±â", "»ï°ã»ì", "¼Ò°í±â", "À°È¸", "µÅÁö°¥ºñ", "ºÒ°í±â", "Á¦À°ººÀ½" },//°í±â
            { "¾ç³äÄ¡Å²", "ÈÄ¶óÀÌµå", "°£ÀåÄ¡Å²", "Âò´ß", "»ï°èÅÁ", "´ßµµ¸®ÅÁ", "ÈÆÁ¦Ä¡Å²", "´ß°­Á¤" },//Ä¡Å²
            { "¶±ººÀÌ", "´ß¹ß", "¼ø´ë", "±è¹ä", "Á·¹ß", "º¸½Ó", "°öÃ¢", "¶ó¸é" } };//ºÐ½Ä/¾ß½Ä

      request.setAttribute("menuRandom", menu[r][ren]);
      request.setAttribute("menuRandomImg", menuImg[r][ren]);

   }

}