package com.example;

public class Player {

    private final String name;

    private final Hand hand;

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    public void draw(Card card) {
        hand.draw(card);
    }

    public Card fold(int index) {
        return hand.fold(index);
    }

    @Override
    public String toString() {
        return name + ": " + hand.toString();
    }
}
