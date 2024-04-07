package thuchanh.tuan2.bai3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CompareCard implements Comparator<Card> {

    private final Map<String, Integer> rankOrder;
    private final Map<String, Integer> suitOrder;

    public CompareCard() {
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

    @Override
    public int compare(Card card1, Card card2) {
        int rankComparison = rankOrder.get(card1.getRank()) - rankOrder.get(card2.getRank());
        if (rankComparison != 0) {
            return rankComparison;
        }
        return suitOrder.get(card1.getSuit()) - suitOrder.get(card2.getSuit());
    }
}
