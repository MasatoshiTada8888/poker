package com.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player human = new Player("人間", new Hand());
        Player computer = new Player("コンピューター", new Hand());
        Deck deck = new Deck();

        // カードを5枚引く
        initialDraw(human, deck);
        initialDraw(computer, deck);

        // カードを最大2回交換する（コンピューターは必ず2回。人間は交換しないことも可能）
        foldHuman(human, deck);
        foldComputer(computer, deck);
        foldHuman(human, deck);
        foldComputer(computer, deck);

        // 結果を表示
        System.out.println(human.toString());
        System.out.println(computer.toString());
    }

    /**
     * カードを5枚引きます。
     * @param player カードを引くプレイヤー
     * @param deck カードのデッキ
     */
    private static void initialDraw(Player player, Deck deck) {
        for (int i = 0; i < 5; i++) {
            player.draw(deck.draw());
        }
    }

    /**
     * 人間がカードを1枚捨てたあと、デッキから1枚引きます。
     * @param human 人間
     * @param deck カードのデッキ
     */
    public static void foldHuman(Player human, Deck deck) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("現在の状態 : " + human.toString());
        System.out.print("捨てるカードのインデックスを入力してください(捨てない場合は9) -> ");
        int index = scanner.nextInt();
        if (index != 9) {
            human.fold(index);
            human.draw(deck.draw());
        }
        System.out.println("現在の状態 : " + human.toString());
    }

    /**
     * コンピューターがカードを1枚捨てたあと、デッキから1枚引きます。
     * 捨てるカードはランダムに選択します。
     * @param computer コンピューター
     * @param deck カードのデッキ
     */
    public static void foldComputer(Player computer, Deck deck) {
        Random random = new Random();
        System.out.print("捨てるカードのインデックスを入力してください -> ");
        int index = random.nextInt(5);
        computer.fold(index);
        computer.draw(deck.draw());
    }
}
