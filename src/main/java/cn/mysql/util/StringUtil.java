package cn.mysql.util;

/**
 * 功能描述: <br>
 * 〈Utils of String operation.〉
 */
public class StringUtil {


    public static boolean equal(String str1, String str2) {
        if (str1 == null & str2 == null) {
            return true;
        }
        if ((str1 == null && str2 != null)
                || (str1 != null & str2 == null)) {
            return false;
        }
        return str1.trim().equals(str2.trim());
    }


    public static boolean notEqual(String str1, String str2) {
        return !equal(str1, str2);
    }


    public static boolean isIn(String str, String[] array) {
        for (String s : array) {
            if (equal(str, s)) {
                return true;
            }
        }
        return false;
    }

    public static boolean notIn(String str, String[] array) {
        return !isIn(str, array);
    }

    public static String sqlFilter(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll(".*([';]+|(--)+).*", "");
    }
}
