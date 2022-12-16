/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.TimerTask;


/**
 *
 * @author liam
 * This file is for the game timer and it counts the number of correct words to calculate the users wpm.
 */
public class GameTimerTask extends TimerTask {

    private GameWin game;
    private int timeCounter;
    private int numCorrectWords;
        
    public GameTimerTask(GameWin game) {
        this.game = game;
        timeCounter = 0;
        numCorrectWords = 0;
        
    }
    public void resetCounter() {
        timeCounter = 0;
    }
    @Override
    public void run() {
        
        timeCounter++;
        
        String sentencesText = game.getSentencesText();
        String typingBoxText = game.getTypingBoxText();
        
        String[] sentencesWords = sentencesText.split(" ");
        String[] typingBoxWords = typingBoxText.split(" ");
        
        numCorrectWords = 0;
        for (int i = 0; i < typingBoxWords.length; i++) {
            if (typingBoxWords[i].equals(sentencesWords[i])) {
                numCorrectWords++;
            }
        }
        
        // TODO: calculate words per minute based on correct words and time passed
        double wpm = (double) numCorrectWords / timeCounter * 60;
        game.setWpmLabelText((int) wpm);
        
       

        
    }
   
    
}

