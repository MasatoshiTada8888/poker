package com.example;

/**
 * トランプのマークを表すEnumです。
 */
public enum Suit {

    /**
     * スペード
     */
    SPADE("♠", 4),
    /**
     * ハート
     */
    HEART("♥", 3),
    /**
     * ダイヤ
     */
    DIAMOND("♦", 2),
    /**
     * クラブ
     */
    CLUB("♣", 1);

    /**
     * マークを表す文字列です。
     */
    private final String value;

    /**
     * マーク間の強弱関係を表します。
     * 数値が大きいほど強いです。
     */
    private final int grade;

    Suit(String value, int grade) {
        this.value = value;
        this.grade = grade;
    }

    public String getValue() {
        return value;
    }

    /**
     * 自身と別のSuitを比較して、自身の方が強ければtrueを返します。
     * @param otherSuit 別のSuit
     * @return 自身の方が強ければtrue
     */
    public boolean isGreaterThan(Suit otherSuit) {
        return this.grade > otherSuit.grade;
    }
}
