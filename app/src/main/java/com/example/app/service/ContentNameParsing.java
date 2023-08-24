package com.example.app.service;

import java.util.List;

import com.example.app.model.YolpData;

// public class ContentNameParsing {
//     public static void main(List<YolpData> dataList) {
//         String content = "ゲームセンター,デパート,遊園地"; // カンマで区切られた複数のタグ

//         String[] tags = content.split(",");
//         StringBuilder concatenatedNames = new StringBuilder();

//         for (YolpData data : dataList) {
//             for (String tag : tags) {
//                 if (data.getTag().equals(tag.trim())) {
//                     concatenatedNames.append(data.getName()).append(", ");
//                 }
//             }
//         }

//         // 最後のコンマとスペースを削除して表示
//         String result = concatenatedNames.toString().replaceAll(", $", "");
//         System.out.println("Names matching tags '" + content + "': " + result);
//     }
// }


public class ContentNameParsing{
    public static String NameParsing(List<YolpData> dataList, String content) {

        String[] tags = content.split(",");
        StringBuilder concatenatedNames = new StringBuilder();

        for (YolpData data : dataList) {
            for (String tag : tags) {
                if (data.getTag().equals(tag.trim())) {
                    concatenatedNames.append(data.getName()).append(", ");
                }
            }
        }

        // 最後のコンマとスペースを削除して表示
        String result = concatenatedNames.toString().replaceAll(", $", "");

        // " を削除
        result = result.replaceAll("\"", "");
        return result;
    }
}

