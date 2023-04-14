package com.example;

import com.example.exception.IllegalIndexException;
import com.example.exception.TooManyCardsException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 手札を表すコレクションクラスです。
 *
 * （イミュータブルでないなど、改善すべき点は多くあると思います）
 */
public class Hand {

    private final List<Card> cardList;

    /**
     * 手札を0枚で初期化します。
     */
    public Hand() {
        this.cardList = new ArrayList<>();
    }

    /**
     * 手札にカードを1枚追加します。
     * @param card
     */
    public void draw(Card card) {
        if (cardList.size() == 5) {
            throw new TooManyCardsException();
        }
        cardList.add(card);
    }

    /**
     * 手札からカードを1枚削除します。
     * @param index 削除対象のカードのインデックス（最初が0番目）
     * @return 削除されたカード
     */
    public Card fold(int index) {
        if (index < 0 || cardList.size() <= index) {
            throw new IllegalIndexException(index);
        }
        return cardList.remove(index);
    }

    /**
     * 手札内の全カードのリストを返します。
     * このリストはイミュータブルです。
     * @return カードのリスト
     */
    public List<Card> getCardList() {
        return Collections.unmodifiableList(cardList);
    }

    /**
     * 手札を1列に並べた文字列を返します。
     * @return 手札の文字列表現
     */
    @Override
    public String toString() {
        return cardList.stream()
                .map(card -> card.toString())
                .collect(Collectors.joining(", "));
    }
}
