package com.example.resolver;

import com.example.Hand;

/**
 * 手札を各役に解決できるか判定するインタフェースです。
 *
 * @see com.example.PokerHand
 */
public interface PokerHandResolver {

    /**
     * 手札が役に解決できたらtrueを返します。
     * @param hand 手札
     * @return 手札が役に解決できたらtrue
     */
    boolean canResolve(Hand hand);

    /**
     * 同じ役同士を比較して、どちらが勝つかを判定します。
     * @param hand1 1つ目の手札
     * @param hand2 2つ目の手札
     * @return 1つ目の手札が勝つ場合はWIN_1、2つ目の手札が勝つ場合はWIN_2
     */
    PokerHandCompareResult compare(Hand hand1, Hand hand2);
}
