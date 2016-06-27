package com.wsq.jhone.util;

import java.security.MessageDigest;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtil {
	public static String formatPositionString(String positionString, Object[] args)
	  {
	    return MessageFormat.format(positionString, args);
	  }

	  public static String formatPatternString(String patternString, Object[] args)
	  {
	    return String.format(patternString, args);
	  }

	  public static String removeBreakingWhitespace(String original)
	  {
	    StringTokenizer whitespaceStripper = new StringTokenizer(original);
	    StringBuilder builder = new StringBuilder();
	    while (whitespaceStripper.hasMoreTokens()) {
	      builder.append(whitespaceStripper.nextToken());
	      builder.append(" ");
	    }
	    return builder.toString();
	  }

	  public static int chineseLength(String s)
	  {
	    if (s == null)
	      return 0;
	    char[] c = s.toCharArray();
	    int len = 0;
	    int i = 0; for (int j = c.length; i < j; i++) {
	      len++;
	      if (!isLetter(c[i])) {
	        len++;
	      }
	    }
	    return len;
	  }

	  public static boolean isLetter(char c)
	  {
	    int k = 128;
	    return c / k == 0;
	  }

	  public static String subString(String value, int length)
	  {
	    int chlen = chineseLength(value);
	    if (chlen <= length) {
	      return value;
	    }
	    value = value.substring(0, value.length() - 1);
	    return subString(value, length);
	  }

	  public static String getMD5NumberStr(String nr)
	  {
	    nr = nr.replaceAll("\r\n", "\n");
	    byte[] source = nr.getBytes();
	    String s = null;
	    char[] hexDigits = { '1', '2', '4', '7', '0', '2', '3', '5', '6', '8', '7', '1', '2', '8', '9', '0' };
	    try {
	      MessageDigest md = MessageDigest.getInstance("MD5");
	      md.update(source);
	      byte[] tmp = md.digest();

	      char[] str = new char[32];

	      int k = 0;
	      for (int i = 0; i < 16; i++)
	      {
	        byte byte0 = tmp[i];
	        str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];

	        str[(k++)] = hexDigits[(byte0 & 0xF)];
	      }

	      s = new String(str);
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	    return s;
	  }
	  public static String replaceString(String str, int num) {
	    String temp = "";
	    String ret = "";

	    if ((str == null) || ("".equals(str.trim())) || (str.indexOf("#") < 0)) {
	      return str;
	    }
	    while (str.indexOf("#") >= 0) {
	      temp = str.substring(0, str.indexOf("#"));
	      str = str.substring(str.indexOf("#") + 1);
	      if (ret.length() == 0)
	        ret = new StringBuilder().append(temp).append(num).toString();
	      else {
	        ret = new StringBuilder().append(ret).append(temp).append(num).toString();
	      }
	      if (str.indexOf("#") < 0) {
	        ret = new StringBuilder().append(ret).append(str).toString();
	      }
	    }

	    return ret;
	  }

	  public static String[] split(String strSource, String strReg)
	  {
	    StringTokenizer st = new StringTokenizer(strSource, strReg);
	    ArrayList matchList = new ArrayList();
	    while (st.hasMoreTokens()) {
	      matchList.add(st.nextToken());
	    }
	    int resultSize = matchList.size();
	    String[] result = new String[resultSize];
	    return (String[])(String[])matchList.subList(0, resultSize).toArray(result);
	  }

	  public static String arrayToString(Object[] param)
	  {
	    if ((param == null) || (param.length == 0)) {
	      return "";
	    }
	    StringBuilder sb = new StringBuilder();
	    int i = 0; for (int j = param.length; i < j; i++) {
	      sb.append(param[i]);
	      if (i != j - 1) {
	        sb.append(",");
	      }
	    }
	    return sb.toString();
	  }

	  public static String bytesToHexString(byte[] b)
	  {
	    StringBuilder ret = new StringBuilder();
	    String hex = "";
	    int i = 0; for (int j = b.length; i < j; i++) {
	      hex = Integer.toHexString(b[i] & 0xFF);
	      if (hex.length() == 1) {
	        hex = new StringBuilder().append('0').append(hex).toString();
	      }
	      ret.append(hex.toUpperCase());
	    }

	    return ret.toString();
	  }

	  public static String fillUpDigits(String value, int length)
	  {
	    return fillUpDigits(value, length, 0);
	  }

	  public static String fillUpDigits(String value, int length, int type)
	  {
	    if (value == null) {
	      value = "";
	    }
	    value = value.trim();
	    if (length < 1) {
	      return value;
	    }
	    int len = value.length();
	    if (len > length) {
	      return value.substring(0, length);
	    }
	    String digit = "";
	    for (int i = 0; i < length - len; i++) {
	      digit = new StringBuilder().append(digit).append("0").toString();
	    }
	    if (type == 0)
	      return new StringBuilder().append(digit).append(value).toString();
	    if (type == 1) {
	      return new StringBuilder().append(value).append(digit).toString();
	    }
	    return value;
	  }

	  public static List<String> getList(Object value) {
	    if (value == null) {
	      return null;
	    }
	    if ((value instanceof List))
	      return (List)value;
	    if ((value instanceof String[])) {
	      return Arrays.asList((String[])(String[])value);
	    }
	    return Arrays.asList(value.toString().split(","));
	  }
}
