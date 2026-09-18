package baseball;

public class Game {

    public String question;

    public GuessResult guess(String guessNumber) {
        assertIllegalArgument(guessNumber);
        if(isSolved(guessNumber)){
            return getGuessResult(true, 3,0);
        } else {
            return createUnresolvedResult(guessNumber);
        }
    }

    private GuessResult createUnresolvedResult(String guessNumber) {
        int strikes = 0;
        int balls = 0;
        for(int i=0;i<question.length();i++){
            if(question.indexOf(guessNumber.charAt(i)) == i){
                strikes++;
            } else if(question.indexOf(guessNumber.charAt(i)) > -1){
                balls++;
            }
        }
        return getGuessResult(false, strikes, balls);
    }

    private static GuessResult getGuessResult(boolean success, int strikes, int balls) {
        return new GuessResult(success, strikes, balls);
    }

    private boolean isSolved(String guessNumber) {
        return guessNumber.equals(question);
    }

    private static void assertIllegalArgument(String guessNumber) {
        if(guessNumber ==null){
            throw new IllegalArgumentException();
        }
        if(guessNumber.length() !=3){
            throw new IllegalArgumentException();
        }

        for(char number: guessNumber.toCharArray()){
            if(number < '0' || number > '9' ){
                throw new IllegalArgumentException();
            }
        }

        if(isDuplicatedNumber(guessNumber)){
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDuplicatedNumber(String guessNumber) {
        return guessNumber.charAt(0) == guessNumber.charAt(1)
                || guessNumber.charAt(1) == guessNumber.charAt(2)
                || guessNumber.charAt(2) == guessNumber.charAt(0);
    }
}
