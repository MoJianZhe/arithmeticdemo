package org.example.demo;


import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class UrlDemo {
    private static final String EMPTY = "{}";
    private static final String SPLIT = ":";
    private static final String SPLIPT= ",";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String objects = findObjects(in.next());
        System.out.println(objects);
    }

    public static String findObjects(String url) {
        if (url == null || url.length() == 0) {
            return EMPTY;
        }

        String[] urls = url.split("\\?");
        if (urls == null || urls.length < 2) {
            return EMPTY;
        }

        String params = urls[1];
        if (params == null || params.length() == 0) {
            return EMPTY;
        }

        Map<String ,String > map = buildParam(params);
        System.out.println(map);
        return mapToString(map);

    }

    /**
     * 将参数单元转成 map
     * @param param 参数单元 eg:a=111
     * @return key ：val
     */
    private static Map<String, String> buildParam(String  param) {
        if (param == null || param.length() == 0) {
            return null;
        }
        Map<String ,String > map = new HashMap<>();
        try {
            String[] paramArray = param.split("&");
            if (paramArray == null || paramArray.length == 0) {
                return map;
            }
            for (int i = 0; i < paramArray.length; i++) {
                String unit = paramArray[i];
                String[] dataArray = unit.split("=");
                map.put(dataArray[0], dataArray[1]);
            }
            return map;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String mapToString(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return EMPTY;
        }
        StringBuilder stringBuilder = new StringBuilder("{");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(SPLIT)
                    .append(entry.getValue())
                    .append(SPLIPT);
        }

//        return stringBuilder.substring(0, stringBuilder.length() - 1) + "}";
        return stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).append("}").toString();
    }

}