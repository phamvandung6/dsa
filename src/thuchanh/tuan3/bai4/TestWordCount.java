package thuchanh.tuan3.bai4;

import java.util.Scanner;

import thuchanh.tuan3.bai3.SimpleLinkedList;

public class TestWordCount {
    public static void main(String[] args) {
        SimpleLinkedList<WordCount> wordList = new SimpleLinkedList<>();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập văn bản: ");
        String inputText = scanner.nextLine();

        String[] words = inputText.split("\\s+");

        for (String word : words) {
            WordCount newWord = new WordCount(word);
            if (wordList.isContain(newWord)) {
                for (int i = 0; i < wordList.size(); i++) {
                    if (wordList.get(i).equals(newWord)) {
                        wordList.get(i).incrementCount();
                        break;
                    }
                }
            } else {
                wordList.add(newWord);
            }
        }

        System.out.println("Word count:");
        for (int i = 0; i < wordList.size(); i++) {
            WordCount word = wordList.get(i);
            System.out.println(word.getWord() + ": " + word.getCount());
        }
        scanner.close();
    }
}