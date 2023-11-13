public class WordCounterGame {
    private String wordUsed;
    private int life;


    public WordCounterGame() {
        wordUsed = "";
        life = (int) (Math.random() * 5) + 1;
    }

    public WordCounterGame(int lifeAmount) {
        wordUsed = "";
        life = lifeAmount;
    }

    public String getWordUsed () {
        return wordUsed;
    }

    public boolean checkWord (String word) {
        if (wordUsed.indexOf(word) == -1) {
            return true;
        } else {
            return false;
        }
    }


}
