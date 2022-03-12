import java.util.LinkedList;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz("Fragenkatalog");
        Scanner sc= new Scanner(System.in); // Vom Standard-Input-Stream System lesen
        int input = -1,
            steps = 0,
            gewonnenesGeld = 0;
        boolean runGame = true,
                jokerVerwendet = false;
        Variante gewaehlteVariante = Variante.SICHERHEIT;

        quiz.shuffleQuestionsInCurrentQuiz();
        while(input < 1 || input > 2) {
            System.out.print("\tHallo, oh allmächtiger Anwender. Wollen Sie die" +
                    "\n\tZocker- oder Sicherheits-Variante zocken?" +
                    "\n\t(1) Zocker-Variante" +
                    "\n\t(2) Sicherheits-Variante" +
                    "\n\tWaehle weise: ");
            input = sc.nextInt();

            if(input < 1 || input > 2){
                System.out.println("\tNein nein nein! Das war falsch. Mach keinen Scheiß!");
            }
            else{
                gewaehlteVariante = Variante.getMenueNummer(input);
                System.out.println("\t Super. Ich will mit dir ein Spiel spielen mit der " + gewaehlteVariante.getCanonicalName());
            }
        }
        LinkedList<Question> currentQuiz = quiz.getCurrentQuiz();
        for(Question q : currentQuiz) {
            if (runGame) {
                System.out.println("Die Frage um " + q.getLevelOfAnswer().getLevelNumber() + " Euro: " + q.getQuestion());
                System.out.println("\tA: " + q.getFirstAnswer() + "\tB: " + q.getSecondAnswer() + "\n" +
                        "\tC: " + q.getThirdAnswer() + "\tD: " + q.getFourthAnswer());
                System.out.print("Antwort (5050 fuer Joker): ");
                String gewaehlteAntwort = sc.next();

                if(gewaehlteAntwort.equals("5050") && gewaehlteVariante == Variante.ZOCKER && !jokerVerwendet){

                    jokerVerwendet = true;
                }

                if (gewaehlteAntwort.equals(q.getRightAnswer())){
                    System.out.println("Juhu. Richtig. Naechste Frage ...");
                    gewonnenesGeld = q.getLevelOfAnswer().getLevelNumber();
                }
                else{
                    runGame = false;
                    System.out.println("Versager");
                    if(gewaehlteVariante == Variante.SICHERHEIT && gewonnenesGeld >= 300){
                        System.out.println("Na immerhin sins 300 Tacken");
                    }
                }

                if(gewonnenesGeld == 1000){
                    System.out.println("Geilo meilo, du hast gewonnen!");
                }
            }
        }
    }
}