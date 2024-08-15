public class GuessingGame {
    private String original = "";
    private String guess = "";
    private String output = "";
    private double score = 0;

    public GuessingGame(String og){
        original = og;
    }

    public int getWordLength(){
        return original.length();
    }
    
    public String userGuess(String ug){
        guess = ug;
        output = "";
        score = 0;
        
        for (int i = 0; i < original.length(); i++){
            if (guess.substring(i, i+1).equals(original.substring(i, i+1))){
                output += guess.substring(i, i+1);
                score += 1;
            }
            else if (original.contains(guess.substring(i, i+1))){
                output += "+";
                score += 0.5;
            }
            else {
                output += "*";
                score += 0;
            }
        }   
    
        return output;
    }

    public double getScore(){
        return score;
    }
}