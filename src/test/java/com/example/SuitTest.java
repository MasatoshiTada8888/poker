package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SuitTest {

    @Nested
    @DisplayName("isGreaterThan()")
    class IsGreaterThanTest {

        @Test
        @DisplayName("スペードをクラブと比較するとtrueが返る")
        void spade_club() {
            assertTrue(Suit.SPADE.isGreaterThan(Suit.CLUB));
        }

        @Test
        @DisplayName("スペードをスペードと比較するとfalseが返る")
        void spade_spade() {
            assertFalse(Suit.SPADE.isGreaterThan(Suit.SPADE));
        }

        @Test
        @DisplayName("ダイヤとハートを比較するとfalseが返る")
        void diamond_heart() {
            assertFalse(Suit.DIAMOND.isGreaterThan(Suit.HEART));
        }
    }
}
