public class WordCounterGame {
    private String wordUsed;
    private int life;
    private int length;
    private int score;
    private int scoreReached;


    public WordCounterGame() {
        wordUsed = "";
        life = (int) (Math.random() * 5) + 1;
        length = (int) (Math.random()* 6) + 3;
        scoreReached = (int) (Math.random() * 56) + 10;
    }

    public WordCounterGame(int lifeAmount,int lengthAmount, int scoreAmount) {
        wordUsed = "";
        life = lifeAmount;
        length = lengthAmount;
        scoreReached = scoreAmount;
    }

    public String getWordUsed () {
        return wordUsed;
    }
    public int getScore () {
        return score;
    }
    public int getLife () {
        return life;
    }
    public int getLength () {
        return length;
    }

    public int getScoreReached () {
        return scoreReached;
    }

    public boolean checkWord (String word) {
        if (wordUsed.indexOf(word) == -1 && word.length() == length) {
            return true;
        } else {
            return false;
        }
    }
    public void addScore () {
        score++;
    }
    public void addWordUsed (String word) {
        wordUsed += word + "\n";
    }

}
