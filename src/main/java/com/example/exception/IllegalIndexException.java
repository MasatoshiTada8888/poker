package com.example.exception;

public class IllegalIndexException extends RuntimeException {

    public IllegalIndexException(int index) {
        super("インデックス" + index + "は手札の範囲外です。");
    }
}
