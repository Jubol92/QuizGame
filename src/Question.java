// Datenstruktur einer Frage für ein Quiz

import java.util.Random;

public class Question {
    private final String    rightAnswerMarker = "$";
    private Level           levelOfAnswer;
    private String          question,
                            firstAnswer,
                            secondAnswer,
                            thirdAnswer,
                            fourthAnswer;

    public Question(Level  levelOfAnswer,
                    String question,
                    String firstAnswer,
                    String secondAnswer,
                    String thirdAnswer,
                    String fourthAnswer){
        this.levelOfAnswer  = levelOfAnswer;
        this.question       = question;
        this.firstAnswer    = firstAnswer;
        this.secondAnswer   = secondAnswer;
        this.thirdAnswer    = thirdAnswer;
        this.fourthAnswer   = fourthAnswer;
    }

    // Liefert die richtige Anwort
    public String getRightAnswer(){
        if(firstAnswer.substring(firstAnswer.length() - 1).equals(rightAnswerMarker)){
            return "A";
        }
        else if(secondAnswer.substring(secondAnswer.length() - 1).equals(rightAnswerMarker)){
            return "B";
        }
        else if(thirdAnswer.substring(thirdAnswer.length() - 1).equals(rightAnswerMarker)){
            return "C";
        }
        else if(fourthAnswer.substring(fourthAnswer.length() - 1).equals(rightAnswerMarker)){
            return "D";
        }
        else{
            return "No answer";
        }
    }

    // Getter für die jeweiligen Attribute der Klasse
    public String getQuestion() {
        return question;
    }

    public String getFirstAnswer() {
        if(firstAnswer.substring(firstAnswer.length() - 1).equals(rightAnswerMarker)){
            return firstAnswer.substring(0, firstAnswer.length()-1);
        }
        else {
            return firstAnswer;
        }
    }

    public String getSecondAnswer() {
        if(secondAnswer.substring(secondAnswer.length() - 1).equals(rightAnswerMarker)){
            return secondAnswer.substring(0, secondAnswer.length()-1);
        }
        else {
            return secondAnswer;
        }
    }

    public String getThirdAnswer() {
        if(thirdAnswer.substring(thirdAnswer.length() - 1).equals(rightAnswerMarker)){
            return thirdAnswer.substring(0, thirdAnswer.length()-1);
        }
        else {
            return thirdAnswer;
        }
    }

    public String getFourthAnswer() {
        if(fourthAnswer.substring(fourthAnswer.length() - 1).equals(rightAnswerMarker)){
            return fourthAnswer.substring(0, fourthAnswer.length()-1);
        }
        else {
            return fourthAnswer;
        }
    }

    public Level getLevelOfAnswer() {
        return levelOfAnswer;
    }
}
