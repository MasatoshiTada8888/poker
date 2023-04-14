package com.example;

/**
 * ポーカーの役を表すenumです。
 */
public enum PokerHand {
    ROYAL_STRAIGHT_FLUSH(10),
    STRAIGHT_FLUSH(9),
    FOUR_OF_A_KIND(8),
    FULL_HOUSE(7),
    FLUSH(6),
    STRAIGHT(5),
    THREE_OF_A_KIND(4),
    TWO_PAIR(3),
    ONE_PAIR(2),
    HIGH_CARD(1),
    ;

    /**
     * 役の強さを表す数値です。
     * 数値が大きいほど強いです。
     */
    private final int grade;

    PokerHand(int grade) {
        this.grade = grade;
    }


}
