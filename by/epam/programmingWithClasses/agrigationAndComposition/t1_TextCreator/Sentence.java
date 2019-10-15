/*
 *
 * создает предложение из слов автоматически вставляя между ними пробелы
 * дает возможность добавить необходимый знак пунктуации.
 *
 */

package by.epam.programmingWithClasses.agrigationAndComposition.t1_TextCreator;

class Sentence {

    public Sentence() {
        this.sentence = "";
    }

    public Sentence(Word... words) {
        this.sentence = "";
        addWords(words);
    }


    private String sentence;

    public String getSentence() {
        return sentence;
    }


    public void resetSentence(Word... words) {
        cleanSentence();
        addWords(words);
    }


    public void cleanSentence() {
        this.sentence = "";
    }


    public void addWords(Word... words) {

        for (int i = 0; i < words.length; i++) {
            this.sentence = this.sentence + " " + words[i].getWord();
        }

    }


    public void addEllipsis() {
        this.sentence = this.sentence + "...";
    }

    public void addPunctuationMark(char punctuationMark) {
        this.sentence = this.sentence + punctuationMark;
    }


}//class
