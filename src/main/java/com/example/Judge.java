package com.example;

public class Judge {

    public Result judge(Hand hand1, Hand hand2) {
        PokerHand pokerHand1 = PokerHand.resolve(hand1);
        PokerHand pokerHand2 = PokerHand.resolve(hand2);
        if (pokerHand1.equals(pokerHand2)) {
            // TODO 同じ役だった場合の比較
        }
        if (pokerHand1.isGreaterThan(pokerHand2)) {
            return Result.WIN_1;
        } else {
            return Result.WIN_2;
        }
    }
}
