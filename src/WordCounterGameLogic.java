import java.util.Scanner;
public class WordCounterGameLogic {

    private Scanner scan;
    private String answer = null;
    private WordCounterGame game;
    public WordCounterGameLogic () {
        scan = new Scanner(System.in);
    }
    public void start () {
        startingCode();
        goAgain();
    }

    private void startingCode () {
        System.out.println("Welcome to the Word Counter Game, the goals of this game is to write down as much word you know with the chosen lengths or random lengths.");
        System.out.println("Each word give you one point and you need to reach a certain amount of points that is either random or chosen.");
        System.out.print("Do you want to set your points, life and length of the word or randomized it?(y/n, y = randomized, n = set): ");
        answer = scan.nextLine();
        settingBasic(answer);
        System.out.println("The game now began");
        mainCode();
    }
    private void settingBasic () {
        int life = 0;
        int length = 0;
        int score = 0;
        System.out.print("Please enter the amount of life you want (it must not be above 8 and not negative): ");
        life = scan.nextInt();
        scan.nextLine();
        while (life > 8 || life < 0) {
            System.out.print("Please enter an amount of life that follow the conditions: ");
            life = scan.nextInt();
            scan.nextLine();
        }
        System.out.print("Please enter the length of the words you want (it must be higher than 3 letters): ");
        length = scan.nextInt();
        scan.nextLine();
        while (length < 3) {
            System.out.print("Please enter a length that follow the conditions: ");
            length = scan.nextInt();
            scan.nextLine();
        }
        System.out.print("Please enter the score you have to reach (it must be higher than 10): ");
        score = scan.nextInt();
        scan.nextLine();
        while (score < 1) {
            System.out.print("Please enter a score you have to reach that follow the conditions: ");
            score = scan.nextInt();
            scan.nextLine();
        }
        game = new WordCounterGame(life, length, score);
    }
    private void settingBasic (String answer) {
        if (answer.equals("y")) {
            game = new WordCounterGame();
        }
        else if (answer.equals("n")) {
            settingBasic();
        } else {
            System.out.print("Please enter a valid answer choice: ");
            answer = scan.nextLine();
            settingBasic(answer);
        }
    }
    private void mainCode() {
        System.out.println("You are starting with " + game.getLife() + " life.");
        System.out.println("The length of each word you put must be " + game.getLength() + " letters.");
        System.out.println("The score you have to reach is " + game.getScoreReached() + " points.");
        int amount = 1;
        answer = "";
        String recentAnswer;
        while (answer.length() < game.getLength()) {
            answer += "a";
        }
        for (int i = game.getLife(); i > 0; i--) {
            System.out.println("Your life right now: " + i);
            while (game.checkWord(answer)) {
                System.out.print("Please enter your " + amount + " word: ");
                answer = scan.nextLine();
                recentAnswer = answer;
                if (game.checkWord(answer)) {
                    game.addScore();
                    game.addWordUsed(answer);
                    answer = "";
                    while (answer.length() < game.getLength()) {
                        answer += "a";
                    }
                }
                amount++;
                if (game.getScore() == game.getScoreReached()) {
                    i -= game.getLife();
                    answer = recentAnswer;
                }
                System.out.println("Score right now: " + game.getScore() + " points.");
            }
            if (game.getScore() == game.getScoreReached()) {
                System.out.println("You won with " + amount + " words. Congratulations, try again with a random setting or even harder setting!");
            } else {
                System.out.println("You made a mistake, now you have one less life.");
            }
            answer = "";
            while (answer.length() < game.getLength()) {
                answer += "a";
            }
        }
        System.out.println("Here are the words that you have inputted!");
        System.out.print(game.getWordUsed());
    }
    private void goAgain() {
        answer = null;
        System.out.print("Do you want to play again? (y/n): ");
        answer = scan.nextLine();
        while (answer.equals("y")) {
            startingCode();
            System.out.print("Do you want to play again? (y/n): ");
            answer = scan.nextLine();
        }
        System.out.print("Thank you for playing this game, I hope you enjoy, goodbye! \n");
    }
}
