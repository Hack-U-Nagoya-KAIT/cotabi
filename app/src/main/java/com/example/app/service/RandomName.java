package com.example.app.service;

import java.util.Random;

public class RandomName {
    public static String random(String result) {
        //String result = "ゲームインファンファン藤沢店, スイーツファンタジー・パックン　戸塚店, 有限会社プレイアイシー　東海大学前店, 株式会社ドラマ　八王子高倉店, プレビ アリオ橋本店, 株式会社ナムコ・プラボ　都筑店, セガワールド古淵, ソピア八王子店, 有限会社洋光, タイトーサイト, アドアーズ藤沢北口店, ハローズガーデン綾瀬店, カプセル永山, タイトーFステーション イオン伊勢原店, プレイランド大和鶴間店, ナムコランドジャスコ　相模原店, こころっこ町田根岸店, クラブセガ相模大野, アドアーズ八王子店, 有限会社Ｍ．Ｙ．Ｃ.";

        String[] names = result.split(", ");
        Random random = new Random();
        int randomIndex = random.nextInt(names.length);

        return names[randomIndex].toString();
    }
}

