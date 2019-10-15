/*
 *
 * создает слово
 *
 */

package by.epam.programmingWithClasses.agrigationAndComposition.t1_TextCreator;

class Word {

    public Word(String word) {
        this.word = word;
    }


    private String word;


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word.trim();
    }

}
