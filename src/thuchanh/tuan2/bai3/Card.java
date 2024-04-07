package thuchanh.tuan2.bai3;

import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card> {

    private static Map<String, Integer> suitOrder = new HashMap<>();
    private static Map<String, Integer> rankOrder = new HashMap<>();
    static {

        suitOrder = new HashMap<>();
        suitOrder.put("Bích", 1);
        suitOrder.put("Tép", 2);
        suitOrder.put("Rô", 3);
        suitOrder.put("Cơ", 4);

        rankOrder = new HashMap<>();
        rankOrder.put("2", 13);
        rankOrder.put("3", 1);
        rankOrder.put("4", 2);
        rankOrder.put("5", 3);
        rankOrder.put("6", 4);
        rankOrder.put("7", 5);
        rankOrder.put("8", 6);
        rankOrder.put("9", 7);
        rankOrder.put("10", 8);
        rankOrder.put("J", 9);
        rankOrder.put("Q", 10);
        rankOrder.put("K", 11);
        rankOrder.put("A", 12);

    }

    private final String rank; // Hạng bài
    private final String suit; // Chất bài

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " " + suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card o) {
        int rankComparison = rankOrder.get(this.getRank()) - rankOrder.get(o.getRank());
        if (rankComparison != 0) {
            return rankComparison;
        }
        return suitOrder.get(this.getSuit()) - suitOrder.get(o.getSuit());
    }
}
