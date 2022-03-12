import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.LinkedList;

public class Quiz<question> {
    // Anzahl der einzelnen Stufen je Frage
    private final int numOfQuestions = 5;

    // Stellt eine gültige Zusammenstellung für ein Quiz dar
    private LinkedList<Question> currentQuiz = new LinkedList();
    private LinkedList<Question> questions = new LinkedList();

    /* Source ist für die Quelldatei zuständig. Hier sind die Fragen enthalten
       im Format Stufe:Antwort:Antwort:Antwort:Antwort. Ein $ markiert die
       richtige Antwort
     */
    public Quiz(String source){

        // Einlesen der Datei
        try {
            File sourceFile = new File(source);
            Scanner readFile = new Scanner(sourceFile);

            // Schreiben der Datei in die Datenstruktur
            while (readFile.hasNextLine()) {
                String line = readFile.nextLine();
                String[] parsedString = line.split(":");
                questions.add(new Question(
                        Level.getLevel(Integer.parseInt(parsedString[0])),
                        parsedString[1],
                        parsedString[2],
                        parsedString[3],
                        parsedString[4],
                        parsedString[5]));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Waehle zufaellige Fragen aus jeder Kategorie
    public void shuffleQuestionsInCurrentQuiz(){
        String blacklist = "";
        java.util.Random rand = new Random();

        // Tausche die Elemente (Achtung billige Mische)
        for(int i = 0; i < 1000; i++){
            int number = rand.nextInt(numOfQuestions);
            Question tmpQuestionObject = questions.get(number);
            questions.remove(number);
            questions.add(tmpQuestionObject);
        }

        // Suche die jeweils ersten Elemente ihrer jeweiligen Kategorie in der Liste
        for(Question q : questions){
            if(blacklist.contains(q.getLevelOfAnswer().getLevelNumber() + ";") == false){
                currentQuiz.add(q);
                blacklist += q.getLevelOfAnswer().getLevelNumber() + ";";
            }
        }
        // Sortiere die Liste in der richtigen Reihenfolge mittels einfachem Selectionsort
        LinkedList<Question> sortedList = new LinkedList();
        int sizeOfList = currentQuiz.size(); // Wird benoetigt, da Liste verkleinert wird
        for(int i = 0; i < sizeOfList; i++){
            int minimumNumber = Integer.MAX_VALUE;
            Question tmpElement = null;
            for(Question q : currentQuiz){
                if (q.getLevelOfAnswer().getLevelNumber() < minimumNumber){
                    minimumNumber = q.getLevelOfAnswer().getLevelNumber();
                    tmpElement = q;
                }
            }
            sortedList.add(tmpElement);
            currentQuiz.remove(tmpElement);
        }
        currentQuiz = sortedList;
    }

    public int getNumOfQuestions() {
        return numOfQuestions;
    }

    public LinkedList<Question> getQuestions() {
        return questions;
    }

    public LinkedList<Question> getCurrentQuiz() {
        return currentQuiz;
    }
}
