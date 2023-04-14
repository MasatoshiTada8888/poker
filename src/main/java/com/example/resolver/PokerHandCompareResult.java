package com.example.resolver;

/**
 * 同じ役同士の手札を比較した際に、どちらが勝つかを表すenumです。
 *
 * @see PokerHandResolver
 */
public enum PokerHandCompareResult {
    /** 1つ目の引数が勝つことを表します。 */
    WIN_1,
    /** 2つ目の引数が勝つことを表します。 */
    WIN_2;
}
