package io.github.supercube.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang.math.NumberUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class StringUtils {

    static char[] a_z = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z'};
    static char[] A_Z = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z'};

    public static final String underscore(String camelCaseWord, char... delimiterChars) {
        return _underscore(camelCaseWord, delimiterChars).toLowerCase();
    }

    private static final String _underscore(String camelCaseWord, char... delimiterChars) {
        if (camelCaseWord == null) {
            return null;
        }
        String target = camelCaseWord.trim();
        if (target.length() == 0) {
            return "";
        }
        target = target.replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2");
        target = target.replaceAll("([a-z\\d])([A-Z])", "$1_$2");
        if (delimiterChars != null) {
            char[] arrayOfChar;
            int j = (arrayOfChar = delimiterChars).length;
            for (int i = 0; i < j; i++) {
                char delimiterChar = arrayOfChar[i];
                target = target.replace(delimiterChar, '_');
            }
        }
        return target;
    }


    public static final String cleanXSS(String input) {
        if (org.springframework.util.StringUtils.isEmpty(input)) {
            return input;
        }
        input = input.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        input = input.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        input = input.replaceAll("'", "&#39;");
        input = input.replaceAll("eval\\((.*)\\)", "");
        input = input.replaceAll("[\\\"\\'][\\s]*javascript:(.*)[\\\"\\']",
                "\"\"");
        input = input.replaceAll("script", "");
        return input;
    }


    /**
     * 获取输入字符的拼音
     *
     * @param src 输入字符
     *
     * @return 拼间字符
     * */
    public static String getPinYin(String src) {
        try {
            src = URLDecoder.decode(src, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("无法识别的汉字编码");
        }
        char[] t1 = src.toCharArray();
        String[] t2;

        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        String t4 = "";
        try {
            for (char c : t1) {
                if (Character.toString(c).matches("[\\u4E00-\\u9FA5]+")) {
                    t2 = PinyinHelper.toHanyuPinyinStringArray(c, t3);
                    t4 = t4 + t2[0];
                } else {
                    t4 = t4 + c;
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            throw new RuntimeException("汉字转化拼音失败");
        }
        return t4;
    }

    /**
     * 填充字符串
     * <p>{@code fillString(6,1); return "000001"}</p>
     *
     * @param length 填充字符要求长度
     * @param value  当前数值
     * @return 返回填充后的字符串
     */
    public static String fillString(int length, long value) {
        String result = (new Long(value)).toString();
        while (length > result.length()) {
            result = "0" + result;
        }
        return result;
    }

    /**
     * 解析子字符串
     * <p> example: {@code parseSubstring("11001105",2);return 05;} </p>
     *
     * @param target      目标字符串
     * @param parseLength 解析字符长度
     * @return 解析后的字符串
     */
    public static long parseSubstring(String target, int parseLength) {
        long result = 0;
        if (target.length() >= parseLength) {
            String strNo = target.substring(target.length() - parseLength);
            if (NumberUtils.isNumber(strNo)) {
                result = Long.parseLong(strNo);
            }
        }
        return result;
    }

    /**
     * 获取转码后的字符串
     *
     * @param str 目标字符
     * @return 结果字符串
     */
    public static String getEncoding(String str) {

        String encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }

        encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }

        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";
    }

    /**
     * 将字符串编码格式转成UTF-8
     *
     * @param str 源字符
     * @return UTF8字符
     */
    public static String EncodeToUTF8(String str) {
        try {
            String strEncode = StringUtils.getEncoding(str);
            String temp = new String(str.getBytes(strEncode), StandardCharsets.UTF_8);
            return temp;
        } catch (java.io.IOException ex) {
            return null;
        }
    }

    public static final String camelCaseWord(String underscoreWord) {
        if ((underscoreWord == null) || (underscoreWord.equals(""))) {
            return "";
        }
        StringBuilder sb = new StringBuilder(underscoreWord.length());

        int i = 0;
        int length = underscoreWord.length();
        for (int j = 0; j < length; j++) {
            if (underscoreWord.charAt(j) == '_') {
                if (j == length - 1) {
                    break;
                }
                while (underscoreWord.charAt(++j) == '_') {
                }
                i = j;
                char c = underscoreWord.charAt(i);
                for (int k = 0; k < a_z.length; k++) {
                    if (a_z[k] == c) {
                        c = A_Z[k];
                        break;
                    }
                }
                sb.append(c);
            } else {
                sb.append(underscoreWord.charAt(j));
            }
        }
        return sb.toString();
    }
}
