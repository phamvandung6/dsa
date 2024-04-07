package thuchanh.tuan2.bai3;

import java.util.Arrays;

import thuchanh.tuan2.bai2.SortTComparable;

public class TestCard {
    public static void main(String[] args) {
        System.out.println("Câu a: ");
        Deck deck = new Deck();
        System.out.println(deck);

        System.out.println("Câu b: ");
        CompareCard comparator = new CompareCard();

        System.out.println("Sau khi trộn bài: ");
        deck.shuffle();
        System.out.println(deck);

        System.out.println("Sau khi sắp xếp: ");
        Card[] sortedCards = deck.toArray();
        Arrays.sort(sortedCards, comparator);
        deck.setCards(Arrays.asList(sortedCards));
        System.out.println(deck);

        System.out.println("Câu c: ");
        System.out.println("Sau khi trộn bài: ");
        deck.shuffle();
        System.out.println(deck);
        System.out.println("Sau khi sắp xếp: ");
        SortTComparable.bubbleSort(deck.toArray());
        System.out.println(deck);

        System.out.println("Câu d: ");
        System.out.println("Sau khi trộn bài: ");
        deck.shuffle();
        System.out.println(deck);
    }
}
