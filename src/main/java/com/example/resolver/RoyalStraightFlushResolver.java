package com.example.resolver;

import com.example.Card;
import com.example.Hand;
import com.example.Result;
import com.example.Suit;

import java.util.List;

/**
 * ロイヤルストレートフラッシュを解決するクラスです。
 */
public class RoyalStraightFlushResolver implements PokerHandResolver {

    private static final List<List<Card>> TARGET_CARD_LISTS = List.of(
            List.of(Card.SPADE_10, Card.SPADE_J, Card.SPADE_Q, Card.SPADE_K, Card.SPADE_A),
            List.of(Card.HEART_10, Card.HEART_J, Card.HEART_Q, Card.HEART_K, Card.HEART_A),
            List.of(Card.DIAMOND_10, Card.DIAMOND_J, Card.DIAMOND_Q, Card.DIAMOND_K, Card.DIAMOND_A),
            List.of(Card.CLUB_10, Card.CLUB_J, Card.CLUB_Q, Card.CLUB_K, Card.CLUB_A)
    );

    /**
     * 手札がロイヤルストレートフラッシュであればtrueを返します。
     * @param hand 手札
     * @return 手札がロイヤルストレートフラッシュであればtrue
     */
    @Override
    public boolean canResolve(Hand hand) {
        List<Card> cardListInHand = hand.getCardList();
        for (List<Card> targetList : TARGET_CARD_LISTS) {
            if (allCardsAreSame(cardListInHand, targetList)) {
                return true;
            }
        }
        return false;
    }

    private boolean allCardsAreSame(List<Card> cardList1, List<Card> cardList2) {
        for (int i = 0; i < cardList1.size(); i++) {
            if (cardList1.get(i) != cardList2.get(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * ロイヤルストレートフラッシュ同士の勝敗を判定します。
     * @param hand1 1つ目の手札（ロイヤルストレートフラッシュ）
     * @param hand2 2つ目の手札（ロイヤルストレートフラッシュ）
     * @return 1つ目が勝ちであればWIN_1、2つ目が勝ちであればWIN_2
     */
    @Override
    public Result compare(Hand hand1, Hand hand2) {
        Card card1 = hand1.getCardList().get(0);
        Suit suit1 = card1.getSuit();
        Card card2 = hand2.getCardList().get(0);
        Suit suit2 = card2.getSuit();
        // マークでのみの判定となる
        if (suit1.isGreaterThan(suit2)) {
            return Result.WIN_1;
        } else {
            return Result.WIN_2;
        }
    }
}
