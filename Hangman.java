public class Hangman {
    // instance variables
    private String word;
    private char[] foundLetters;
    private int wrongGuess;
    
    // Constructor that creates the hangman object with the hidden word
    public Hangman(String w)
    {
        word = w.toLowerCase();
        foundLetters = new char[word.length()];
        for (int i = 0; i < foundLetters.length; i++)
        {
            foundLetters[i] = '_';
        }
    }

    // Accesors
    public String getWord()
    {
        return word;
    }

    public int getWrongGuesses()
    {
        return wrongGuess;
    }

    public char[] getFoundLetters()
    {
        return foundLetters;
    }

    // Mutators 
    public void setWord(String w)
    {
        word = w;
    }

    public void resetGuesses()
    {
        wrongGuess = 0;
    }

    public char[] guessLetter(char g)
    {
        boolean inWord = false;
        for (int i = 0; i < word.length(); i++)
        {
            if (g == word.charAt(i))
            {
                foundLetters[i] = word.charAt(i);
                inWord = true;
            }
        }

        if (!inWord)
        {
            wrongGuess++;
        }
        return foundLetters;
    }
}  
