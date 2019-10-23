package io.github.supercube.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlUtil {
    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>";
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>";
    private static final String regEx_html = "<[^>]+>";
    private static final String regEx_space = "\\s*|\t|\r|\n";

    public HtmlUtil() {
    }

    public static String delHTMLTag(String htmlStr) {

        final String regexScript = "<script[^>]*?>[\\s\\S]*?<\\/script>";
        final String regexStyle = "<style[^>]*?>[\\s\\S]*?<\\/style>";
        final String regexHtml = "<[^>]+>";
        final String regexSpace = "\\s*|\t|\r|\n";

        Pattern pScript = Pattern.compile(regexScript, 2);
        Matcher matcher = pScript.matcher(htmlStr);
        htmlStr = matcher.replaceAll("");
        Pattern pStyle = Pattern.compile(regexStyle, 2);
        Matcher mStyle = pStyle.matcher(htmlStr);
        htmlStr = mStyle.replaceAll("");
        Pattern pHtml = Pattern.compile(regexHtml, 2);
        Matcher mHtml = pHtml.matcher(htmlStr);
        htmlStr = mHtml.replaceAll("");
        Pattern pSpace = Pattern.compile(regexSpace, 2);
        Matcher mSpace = pSpace.matcher(htmlStr);
        htmlStr = mSpace.replaceAll("");
        return htmlStr.trim();
    }

    public static String getTextFromHtml(String htmlStr) {
        htmlStr = delHTMLTag(htmlStr);
        htmlStr = htmlStr.replaceAll("&nbsp;", "");
        htmlStr = htmlStr.substring(0, htmlStr.indexOf("。") + 1);
        return htmlStr;
    }

    public static String html2text(String inputString) {
        String htmlStr = inputString;
        String textStr = "";

        try {
            String regexScript = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
            String regexStyle = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
            String regexHtml = "<[^>]+>";
            Pattern pScript = Pattern.compile(regexScript, 2);
            Matcher mScript = pScript.matcher(htmlStr);
            htmlStr = mScript.replaceAll("");
            Pattern pStyle = Pattern.compile(regexStyle, 2);
            Matcher mStyle = pStyle.matcher(htmlStr);
            htmlStr = mStyle.replaceAll("");
            Pattern pHtml = Pattern.compile(regexHtml, 2);
            Matcher mHtml = pHtml.matcher(htmlStr);
            htmlStr = mHtml.replaceAll("");
            textStr = htmlStr;
        } catch (Exception var12) {
            ;
        }

        return textStr;
    }

}
