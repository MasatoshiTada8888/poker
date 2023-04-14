package com.example;

/**
 * トランプの番号を表すEnumです。
 */
public enum Number {
    /** エースです。*/
    ACE(1, "A", 14),  // エースが一番強い
    /** 2です。*/
    TWO(2, "2", 2),
    /** 3です。*/
    THREE(3, "3", 3),
    /** 4です。*/
    FOUR(4, "4", 4),
    /** 5です。*/
    FIVE(5, "5", 5),
    /** 6です。*/
    SIX(6, "6", 6),
    /** 7です。*/
    SEVEN(7, "7", 7),
    /** 8です。*/
    EIGHT(8, "8", 8),
    /** 9です。*/
    NINE(9, "9", 9),
    /** 10です。*/
    TEN(10, "10", 10),
    /** ジャックです。*/
    JACK(11, "J", 11),
    /** クイーンです。*/
    QUEEN(12, "Q", 12),
    /** キングです。*/
    KING(13, "K", 13);

    /**
     * カードが表す数字です。
     */
    private final int value;

    /**
     * カードに書かれている文字を表します。
     */
    private final String initial;

    /**
     * 番号間の強弱関係を表します。
     * 数値が大きいほど強いです。
     */
    private final int grade;

    Number(int value, String initial, int grade) {
        this.value = value;
        this.initial = initial;
        this.grade = grade;
    }

    public int getValue() {
        return value;
    }

    public String getInitial() {
        return initial;
    }

    public int getGrade() {
        return grade;
    }
}
