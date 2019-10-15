/*
 *
 * заголовок тела состоит из слов
 *
 * тело:
 * создает текст из предложений. дает возможность начать новый параграф.
 *
 * так же методы:
 * дополнить текст, вывести на
 * консоль текст, заголовок текста.
 *
 */

package by.epam.programmingWithClasses.agrigationAndComposition.t1_TextCreator;

class Text {

    public Text() {

        this.textHead = "";
        this.textBody = "";
    }

    public Text(Sentence... sentencesForBody) {
        this.textHead = "";
        addToTextBody(sentencesForBody);
    }

    public Text(Word... wordsForHead) {
        setOrResetTextHead(wordsForHead);
        this.textBody = "";
    }


    String textHead;
    String textBody;


    public void printText() {
        System.out.println(getText());
    }


    public void printTextPart(String textPart) {
        System.out.println(textPart);
    }


    public String getText() {
        return "        " + textHead + "\n\n  " + textBody;
    }

    public String getTextHead() {
        return textHead;
    }

    public String getTextBody() {
        return textBody;
    }


    public void setOrResetTextHead(Word... words) {

        textHead = "";
        for (int i = 0; i < words.length; i++) {
            textHead = textHead + " " + words[i].getWord();
        }
    }


    public void cleanTextBody() {
        textBody = "";
    }


    public void resetTextBody(Sentence... sentences) {
        cleanTextBody();
        addToTextBody(sentences);
    }


    public void addToTextBody(Sentence... sentences) {

        for (int i = 0; i < sentences.length; i++) {
            textBody = textBody + sentences[i].getSentence();
        }

    }


    public void addParagraph() {

        textBody += "\n  ";
    }
}//class
