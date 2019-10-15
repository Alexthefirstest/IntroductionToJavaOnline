/*
 *
 *  Programming with classes
 *
 *
 *  2.Агрегация и композиция
 *
 *  1. Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
 * консоль текст, заголовок текста.
 *
 * - psvm only
 */


package by.epam.programmingWithClasses.agrigationAndComposition.t1_TextCreator;

public class T1_TextCreator {

    public static void main(String[] args) {

        Word word1ForHead = new Word("Working");

        Word word2ForHead = new Word("immediately");


        Word word1 = new Word("It");
        Word word2 = new Word("is");
        Word word3 = new Word("alive");
        Sentence sentence1 = new Sentence(word1, word2, word3);
        sentence1.addPunctuationMark('.');


        Text text = new Text(word1ForHead, word2ForHead);
        text.addToTextBody(sentence1);
        text.printText();


        sentence1.resetSentence(word1, word2);
        Word word4 = new Word("not");
        sentence1.addWords(word4, word3);
        sentence1.addEllipsis();

        System.out.println("\n\n\n");
        text.resetTextBody(sentence1);
        text.printText();

        Word word6 = new Word("But");
        Word word7 = new Word("work");
        Word word8 = new Word("know");

        Sentence sentence2 = new Sentence(word6, word7, word8);
        sentence2.addPunctuationMark('!');

        text.addToTextBody(sentence2);
        text.addParagraph();

        Word word9 = new Word("happy");
        Word word10 = new Word("end");
        Sentence sentence3 = new Sentence(word9, word10);

        text.addToTextBody(sentence3);
        text.setOrResetTextHead(word4, word1ForHead, word2ForHead);
        System.out.println("\n\n\n");
        text.printTextPart(text.getTextHead());
        text.printTextPart(text.getTextBody());

        System.out.println("\n\n\n");
        text.printText();
    }

}//class


