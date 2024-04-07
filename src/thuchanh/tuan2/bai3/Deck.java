package thuchanh.tuan2.bai3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        // Define ranks and suits
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
        String[] suits = { "Bích", "Tép", "Rô", "Cơ" };

        // Create cards
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public String toString() {
        return cards.toString();
    }

    public Card[] toArray() {
        return cards.toArray(new Card[cards.size()]);
    }

    public void setCards(List<Card> newCards) {
        cards.clear();
        cards.addAll(newCards);
    }
}
