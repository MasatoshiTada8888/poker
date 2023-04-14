package com.example.resolver;

import com.example.Card;
import com.example.Hand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoyalStraightFlushResolverTest {

    RoyalStraightFlushResolver resolver = new RoyalStraightFlushResolver();

    @Nested
    @DisplayName("canResolve()")
    class CanResolveTest {
        @Test
        @DisplayName("スペードのロイヤルストレートフラッシュの手札を渡すとtrue")
        void spades() {
            Hand hand = new Hand();
            hand.draw(Card.SPADE_10);
            hand.draw(Card.SPADE_J);
            hand.draw(Card.SPADE_Q);
            hand.draw(Card.SPADE_K);
            hand.draw(Card.SPADE_A);
            assertTrue(resolver.canResolve(hand));
        }

        @Test
        @DisplayName("ハートのロイヤルストレートフラッシュの手札を渡すとtrue")
        void hearts() {
            Hand hand = new Hand();
            hand.draw(Card.HEART_10);
            hand.draw(Card.HEART_J);
            hand.draw(Card.HEART_Q);
            hand.draw(Card.HEART_K);
            hand.draw(Card.HEART_A);
            assertTrue(resolver.canResolve(hand));
        }

        @Test
        @DisplayName("ダイヤのロイヤルストレートフラッシュの手札を渡すとtrue")
        void diamonds() {
            Hand hand = new Hand();
            hand.draw(Card.DIAMOND_10);
            hand.draw(Card.DIAMOND_J);
            hand.draw(Card.DIAMOND_Q);
            hand.draw(Card.DIAMOND_K);
            hand.draw(Card.DIAMOND_A);
            assertTrue(resolver.canResolve(hand));
        }

        @Test
        @DisplayName("クラブのロイヤルストレートフラッシュの手札を渡すとtrue")
        void clubs() {
            Hand hand = new Hand();
            hand.draw(Card.CLUB_10);
            hand.draw(Card.CLUB_J);
            hand.draw(Card.CLUB_Q);
            hand.draw(Card.CLUB_K);
            hand.draw(Card.CLUB_A);
            assertTrue(resolver.canResolve(hand));
        }

        @Test
        @DisplayName("ストレートフラッシュの手札を渡すとfalse")
        void straight_flush() {
            Hand hand = new Hand();
            hand.draw(Card.CLUB_9);
            hand.draw(Card.CLUB_10);
            hand.draw(Card.CLUB_J);
            hand.draw(Card.CLUB_Q);
            hand.draw(Card.CLUB_K);
            assertFalse(resolver.canResolve(hand));
        }

        @Test
        @DisplayName("ストレートの手札を渡すとfalse")
        void straight() {
            Hand hand = new Hand();
            hand.draw(Card.CLUB_10);
            hand.draw(Card.CLUB_J);
            hand.draw(Card.CLUB_Q);
            hand.draw(Card.CLUB_K);
            hand.draw(Card.SPADE_A);
            assertFalse(resolver.canResolve(hand));
        }

        @Test
        @DisplayName("フラッシュの手札を渡すとfalse")
        void flush() {
            Hand hand = new Hand();
            hand.draw(Card.CLUB_2);
            hand.draw(Card.CLUB_10);
            hand.draw(Card.CLUB_J);
            hand.draw(Card.CLUB_Q);
            hand.draw(Card.CLUB_K);
            assertFalse(resolver.canResolve(hand));
        }
    }
}
