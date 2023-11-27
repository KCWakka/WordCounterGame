/**
 * This class is used to store all the necessary information for this project(the game) to function
 *
 * @author Kyle Chen
 */
public class WordCounterGame {
    /** The words that the user had inserted */
    private String wordUsed;
    /** The amount of mistakes the user can make before it is game over */
    private int life;
    /** How many character the word have, in order to be able to insert into wordUsed */
    private int length;
    /** The amount of words that the user successfully inputted into wordUsed */
    private int score;
    /** The amount of words that the user need to successfully inputted in order to win */
    private int scoreReached;

    /**
     * Initialized the game by making a WordCounterGame object with value that is randomized
     *
     */
    public WordCounterGame() {
        wordUsed = "";
        life = (int) (Math.random() * 5) + 1;
        length = (int) (Math.random() * 6) + 3;
        scoreReached = (int) (Math.random() * 26) + 10;
    }
    /**
     * Initialized the game by making a WordCounterGame object with value that is set by user
     *
     * @param lifeAmount The amount of mistake that the user can have
     * @param lengthAmount How long the word have to be without considering it as a mistake
     * @param scoreAmount The score the user have to reach, the amount of word the user have to successfully inputted
     */
    public WordCounterGame(int lifeAmount,int lengthAmount, int scoreAmount) {
        wordUsed = "";
        life = lifeAmount;
        length = lengthAmount;
        scoreReached = scoreAmount;
    }

    /** Return the current list of word that the User successfully inputted
     *
     * @return The words that are successfully inputted
     */
    public String getWordUsed () {
        return wordUsed;
    }

    /**
     * Return the current score the user have reach, which is the amount of word that are successfully inputted
     *
     * @return The number of how many word are successfully inputted
     */
    public int getScore () {
        return score;
    }

    /**
     * Return how many mistake the user can still make
     *
     * @return The remaining amount of mistake that the user can make
     */
    public int getLife () {
        return life;
    }

    /**
     * Return how long the character can be
     *
     * @return The amount of character a word must have
     */
    public int getLength () {
        return length;
    }

    /**
     * Return the score needed to win
     *
     * @return The score needed to win
     */
    public int getScoreReached () {
        return scoreReached;
    }

    /**
     * Return the value true or false if the word that is being inputted have the correct length and wasn't used before
     *
     * @param word the word the user is inputting in and is checking if they successfully inputted it
     * @return True or false if the word the user inputted in satisfied all the conditions
     */
    public boolean checkWord (String word) {
        if (wordUsed.indexOf(word) == -1 && word.length() == length) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Increase the variable score by 1
     */
    public void addScore () {
        score++;
    }

    /**
     *
     * @param word the word that is being added to wordUsed
     */
    public void addWordUsed (String word) {
        wordUsed += word + "\n";
    }

}
