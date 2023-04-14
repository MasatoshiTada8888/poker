package com.example.exception;

public class TooManyCardsException extends RuntimeException {

    public TooManyCardsException() {
        super("これ以上手札にカードを追加できません。");
    }
}
