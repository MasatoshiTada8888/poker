package com.example;

import com.example.resolver.PokerHandResolver;
import com.example.resolver.RoyalStraightFlushResolver;

/**
 * ポーカーの役を表すenumです。
 */
public enum PokerHand {
    ROYAL_STRAIGHT_FLUSH(10, new RoyalStraightFlushResolver()),
    STRAIGHT_FLUSH(9, null),
    FOUR_OF_A_KIND(8, null),
    FULL_HOUSE(7, null),
    FLUSH(6, null),
    STRAIGHT(5, null),
    THREE_OF_A_KIND(4, null),
    TWO_PAIR(3, null),
    ONE_PAIR(2, null),
    HIGH_CARD(1, null)
    ;

    /**
     * 役の強さを表す数値です。
     * 数値が大きいほど強いです。
     */
    private final int grade;

    private final PokerHandResolver resolver;

    PokerHand(int grade, PokerHandResolver resolver) {
        this.grade = grade;
        this.resolver = resolver;
    }

    /**
     * 手札に対応する役を返します。
     * @param hand 手札
     * @return 手札に対応する役
     */
    public static PokerHand resolve(Hand hand) {
        // 強い順に判定する
        if (ROYAL_STRAIGHT_FLUSH.resolver.canResolve(hand)) {
            return ROYAL_STRAIGHT_FLUSH;
        }
        if (STRAIGHT_FLUSH.resolver.canResolve(hand)) {
            return STRAIGHT_FLUSH;
        }
        if (FOUR_OF_A_KIND.resolver.canResolve(hand)) {
            return FOUR_OF_A_KIND;
        }

        // TODO 残りの役を実装
        return HIGH_CARD;
    }

    public boolean isGreaterThan(PokerHand other) {
        // TODO 同じPokerHandだった場合の比較
        return this.grade > other.grade;
    }
}
