package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * カードのデッキを表すクラスです。
 */
public class Deck {

    private final List<Card> cardList;

    public Deck() {
        Card[] cardArray = Card.values();
        // Arrays.asList()ではイミュータブルなリストが返るので、
        // それをArrayListに変換することでミュータブルにしています。
        this.cardList = new ArrayList<>(Arrays.asList(cardArray));
        // ランダムにシャッフル
        Collections.shuffle(cardList);
    }

    /**
     * デッキからカードを1枚払い出します。
     * @return カード
     */
    public Card draw() {
        return cardList.remove(0);
    }
}
