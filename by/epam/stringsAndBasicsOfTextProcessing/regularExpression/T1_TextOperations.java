/*
 *
 *  3. Strings and basics of text processing
 *
 *
 *  3.Работа с регулярными выражениями (Pattern, Matcher)
 *
 * 1. Cоздать приложение, разбирающее текст (текст хранится в строке)
 * и позволяющее выполнять с текстом три различных операции:
 * отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
 * отсортировать лексемы в предложении по убыванию количества вхождений заданного символа,
 * а в случае равенства – по алфавиту.
 *
 */

package by.epam.stringsAndBasicsOfTextProcessing.regularExpression;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.regex.*;

public class T1_TextOperations {

    public static void main(String[] args) {
        String text = "Первый абзац. Сколлько предложений? Три! 3.\n" +
                "Второй абзац. А тут два. 2.\n" +
                "3. Третий. Четыре. Будет пусть. 4.\n" +
                "Четвертый. Пусть будет два!!! 2.\n" +
                "Пятый. И многоточие... Больше предложений надо. Еще больше. И еще больше еще. 5.\n" +
                "Шестой. Еще немного. 2.\n" +
                "\n" +
                "Почти самый короткий абзац.\n";

        char symbol = 'е';

        System.out.println(Arrays.toString(textSorterByParagraphs(text)));

        System.out.println("____________________________");
        System.out.println(Arrays.toString(sentenceInTextSorterByWordsLength(text)));

        System.out.println("____________________________");
        System.out.println(Arrays.toString(sentenceInTextSorterByQuantityOfCharOrAlphabet(text, symbol)));

    }


    public static String[] determinatorIntoSomething(String text, String something) {

        Pattern pattern = Pattern.compile(something);
        Matcher matcher = pattern.matcher(text);

        ArrayList<String> elements = new ArrayList<String>();

        while (matcher.find()) {

            elements.add(matcher.group());
        }

        String[] forReturn = new String[elements.size()];
        forReturn = elements.toArray(forReturn);

        return forReturn;
    }


    public static String[] determinatorIntoParagraphs(String text) {

        return determinatorIntoSomething(text, ".*\n");
    }


    public static String[] determinatorIntoSentences(String text) {

        return (determinatorIntoSomething(text, ".+?[\\.\\!\\?]+(?=[\\s\\n])"));
    }


    public static String[] textSorterByParagraphs(String text) {

        String[] paragraphs = determinatorIntoParagraphs(text);
        int quantityOfSentencesInParagraph[] = new int[paragraphs.length];

        for (int i = 0; i < paragraphs.length; i++) {
            String[] sentences = determinatorIntoSentences(paragraphs[i]);
            quantityOfSentencesInParagraph[i] = sentences.length;

            int sentencesValue = quantityOfSentencesInParagraph[i];
            String paragraph = paragraphs[i];
            int j = i - 1;

            for (; j >= 0; j--) {

                if (sentencesValue < quantityOfSentencesInParagraph[j]) {
                    quantityOfSentencesInParagraph[j + 1] = quantityOfSentencesInParagraph[j];
                    paragraphs[j + 1] = paragraphs[j];
                } else {

                    break;
                }

            }
            quantityOfSentencesInParagraph[j + 1] = sentencesValue;
            paragraphs[j + 1] = paragraph;
        }
        return paragraphs;
    }


    public static String[] sentenceInTextSorterByWordsLength(String text) {

        String[] paragraphs = determinatorIntoParagraphs(text);
        String[] sortedParagrapgs = new String[paragraphs.length];

        for (int i = 0; i < sortedParagrapgs.length; i++) {
            sortedParagrapgs[i] = "";
        }

        for (int i = 0; i < paragraphs.length; i++) {
            String[] sentences = determinatorIntoSentences(paragraphs[i]);

            for (int j = 0; j < sentences.length; j++) {

                sortedParagrapgs[i] += Arrays.toString(wordsInSentencesSorterByWordsLenght(sentences[j]));
            }

        }

        return sortedParagrapgs;
    }


    public static String[] determinatorIntoWords(String sentence) {

        String[] words = determinatorIntoSomething(sentence, "[a-zA-Zа-яА-Я\\d]+(?=[\\s\\W])");

        return words;
    }


    public static String[] wordsInSentencesSorterByWordsLenght(String sentence) {

        String[] words = determinatorIntoWords(sentence);

        for (int j = words.length; j > 0; j--) {

            for (int i = 0; i < j - 1; i++) {

                if (words[i].length() > words[i + 1].length()) {
                    String word = words[i];
                    words[i] = words[i + 1];
                    words[i + 1] = word;
                }

            }
        }

        return words;
    }


    public static String[] sentenceInTextSorterByQuantityOfCharOrAlphabet(String text, char symbol) {

        String[] paragraphs = determinatorIntoParagraphs(text);
        String[] sortedParagrapgs = new String[paragraphs.length];

        for (int i = 0; i < sortedParagrapgs.length; i++) {
            sortedParagrapgs[i] = "";
        }

        for (int i = 0; i < paragraphs.length; i++) {

            String[] sentences = determinatorIntoSentences(paragraphs[i]);

            for (int j = 0; j < sentences.length; j++) {

                sortedParagrapgs[i] += Arrays.toString(wordsInSentencesSorterByCharQuantityOrAlphabet(sentences[j], symbol));
            }
        }

        return sortedParagrapgs;
    }


    public static String[] wordsInSentencesSorterByCharQuantityOrAlphabet(String sentence, char symbol) {

        String[] words = determinatorIntoWords(sentence);
        int[] quantityOfCharInWord = new int[words.length];

        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            quantityOfCharInWord[i] = (determinatorIntoSomething(word.toLowerCase(), "" + symbol)).length;

            int charsValue = quantityOfCharInWord[i];
            int j = i - 1;

            for (; j >= 0; j--) {

                if (charsValue > quantityOfCharInWord[j]) {
                    quantityOfCharInWord[j + 1] = quantityOfCharInWord[j];
                    words[j + 1] = words[j];
                } else {
                    boolean word1FirstestThenWord2 = AlphabetCompareWord1FirstestWord2(words[j], word);

                    while (!word1FirstestThenWord2 && charsValue == quantityOfCharInWord[j]) {

                        quantityOfCharInWord[j + 1] = quantityOfCharInWord[j];
                        words[j + 1] = words[j];
                        j--;

                        word1FirstestThenWord2 = j > -1 ? AlphabetCompareWord1FirstestWord2(words[j], word) : true;
                    }

                    break;
                }

            }

            quantityOfCharInWord[j + 1] = charsValue;
            words[j + 1] = word;
        }

        return words;
    }


    public static Boolean AlphabetCompareWord1FirstestWord2(String word1, String word2) {

        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        if (word1.equals(word2)) {
            return true;
        }

        int max = word1.length() < word2.length() ? word1.length() : word2.length();
        boolean word1Firstest = false;

        for (int i = 0; i < max; i++) {

            if (word1.charAt(i) < word2.charAt(i)) {
                word1Firstest = true;
                break;
            } else if ((word1.charAt(i) > word2.charAt(i))) {
                word1Firstest = false;
                break;
            }

        }

        return word1Firstest;
    }

}
