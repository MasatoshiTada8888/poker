package com.example;

import com.example.exception.IllegalIndexException;
import com.example.exception.TooManyCardsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HandTest {

    @Nested
    @DisplayName("コンストラクタ")
    class ConstructorTest {
        @Test
        @DisplayName("初期化直後はカード0枚")
        void init() {
            Hand hand = new Hand();
            assertEquals("", hand.toString());
        }
    }

    @Nested
    @DisplayName("draw()")
    class DrawTest {
        @Test
        @DisplayName("draw()を1回呼び出すとカード1枚")
        void draw1() {
            Hand hand = new Hand();
            hand.draw(Card.SPADE_A);
            assertEquals("♠A", hand.toString());
        }

        @Test
        @DisplayName("draw()を5回呼び出すとカード5枚")
        void draw5() {
            Hand hand = new Hand();
            hand.draw(Card.SPADE_A);
            hand.draw(Card.HEART_A);
            hand.draw(Card.DIAMOND_A);
            hand.draw(Card.CLUB_A);
            hand.draw(Card.SPADE_2);
            assertEquals("♠A, ♥A, ♦A, ♣A, ♠2", hand.toString());
        }

        @Test
        @DisplayName("draw()を6回呼び出すとTooManyCardsException")
        void draw6() {
            Hand hand = new Hand();
            hand.draw(Card.SPADE_A);
            hand.draw(Card.HEART_A);
            hand.draw(Card.DIAMOND_A);
            hand.draw(Card.CLUB_A);
            hand.draw(Card.SPADE_2);
            assertThrows(TooManyCardsException.class, () -> hand.draw(Card.SPADE_3));
        }
    }

    @Nested
    @DisplayName("fold()")
    class FoldTest {
        @Test
        @DisplayName("カード5枚の手札から、0番目を削除できる")
        void fold0() {
            Hand hand = new Hand();
            hand.draw(Card.SPADE_A);
            hand.draw(Card.HEART_A);
            hand.draw(Card.DIAMOND_A);
            hand.draw(Card.CLUB_A);
            hand.draw(Card.SPADE_2);
            Card actual = hand.fold(0);
            assertAll(
                    () -> assertEquals(Card.SPADE_A, actual),
                    () -> assertEquals("♥A, ♦A, ♣A, ♠2", hand.toString())
            );
        }

        @Test
        @DisplayName("カード5枚の手札から、4番目を削除できる")
        void fold4() {
            Hand hand = new Hand();
            hand.draw(Card.SPADE_A);
            hand.draw(Card.HEART_A);
            hand.draw(Card.DIAMOND_A);
            hand.draw(Card.CLUB_A);
            hand.draw(Card.SPADE_2);
            Card actual = hand.fold(4);
            assertAll(
                    () -> assertEquals(Card.SPADE_2, actual),
                    () -> assertEquals("♠A, ♥A, ♦A, ♣A", hand.toString())
            );
        }

        @Test
        @DisplayName("カード0枚の手札から削除しようとするとIllegalIndexException")
        void fold_from_empty() {
            Hand hand = new Hand();
            assertThrows(IllegalIndexException.class, () -> hand.fold(0));
        }

        @Test
        @DisplayName("負のインデックスを指定するとIllegalIndexException")
        void fold_negative() {
            Hand hand = new Hand();
            hand.draw(Card.SPADE_A);
            hand.draw(Card.HEART_A);
            hand.draw(Card.DIAMOND_A);
            hand.draw(Card.CLUB_A);
            hand.draw(Card.SPADE_2);
            assertThrows(IllegalIndexException.class, () -> hand.fold(-1));
        }

        @Test
        @DisplayName("サイズ以上のインデックスを指定するとIllegalIndexException")
        void fold_over() {
            Hand hand = new Hand();
            hand.draw(Card.SPADE_A);
            hand.draw(Card.HEART_A);
            hand.draw(Card.DIAMOND_A);
            hand.draw(Card.CLUB_A);
            hand.draw(Card.SPADE_2);
            assertThrows(IllegalIndexException.class, () -> hand.fold(5));
        }
    }
}
