package com.example.app.service;

import java.util.List;

public class Stringbuilder {
    public static String builder(List<YolpData> dataList) {

        StringBuilder tags = new StringBuilder();

        for (YolpData data : dataList) {
            if (tags.length() > 0) {
                tags.append(", ");
            }
            tags.append(data.tag);
        }
        return tags.toString();
    }
}
