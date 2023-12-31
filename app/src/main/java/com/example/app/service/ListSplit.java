package com.example.app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.app.model.YolpData;


public class ListSplit {
    public static String Split(List<YolpData> dataList) {

        // dataListを適切な値で初期化する

        Set<String> uniqueTags = new HashSet<>(); // HashSetを用意
        StringBuilder tags = new StringBuilder();

        for (YolpData data : dataList) {
            if (uniqueTags.add(data.getTag())) { // タグがまだ追加されていなければ追加
                if (tags.length() > 0) {
                    tags.append(", ");
                }
                tags.append(data.getTag());
            }
        }

        return tags.toString();
    }
}
