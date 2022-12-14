
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Timer;
import javax.swing.JProgressBar;
import org.jsoup.Jsoup;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import javax.swing.JFileChooser;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author liam
 * 
 * This window is the game window where the player types away trying to beat there score
 * The window pulls a sentence from the api and the player trys to recreate the sentence as fast as possible.
 * The scores get saved into highscores.txt
 */
public class GameWin extends javax.swing.JFrame {
    private PlayMenuWin menuPlay;
    private Timer timer;
    private GameTimerTask task;
    
    public GameWin() {
        initComponents();
        typingProgressBar.setValue(0);
        generateNewSentence();

        // Start WPM tracker
        timer = new Timer();
        task = new GameTimerTask(this);

        timer.scheduleAtFixedRate(task, 0, 1000);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typingProgressBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        typingbox = new javax.swing.JTextArea();
        btnBack = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        sentences = new javax.swing.JEditorPane();
        wpmLabel = new javax.swing.JLabel();
        btnNewSent = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Type Away");

        typingProgressBar.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setText("Words Per Min");

        typingbox.setColumns(20);
        typingbox.setLineWrap(true);
        typingbox.setRows(5);
        typingbox.setWrapStyleWord(true);
        typingbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                typingboxKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(typingbox);

        btnBack.setText("Main Menu");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        sentences.setMaximumSize(new java.awt.Dimension(331, 2147483647));
        sentences.setPreferredSize(new java.awt.Dimension(300, 50));
        jScrollPane3.setViewportView(sentences);

        wpmLabel.setText("jLabel2");

        btnNewSent.setText("New Sentence");
        btnNewSent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewSentActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abc.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBack)
                            .addComponent(btnNewSent))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(wpmLabel))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(typingProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(wpmLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typingProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnNewSent)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setPlayMenu(PlayMenuWin myCreator){
        menuPlay = myCreator;
    }
    
    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
        menuPlay.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void typingboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_typingboxKeyTyped
        int numCorrect = 0;

        String targetText = getSentencesText();

        // get text from typing box
        String typingText = typingbox.getText();
        // the new key typed is not included in the .getText() result,
        // so if it is not a backspace, we should add it to the text
        if (evt.getKeyChar() != '\b') {
            typingText += evt.getKeyChar();
        }

        // set up string builder to hold new sentence with color styles
        StringBuilder newSentencesHTML = new StringBuilder();
        newSentencesHTML.append("<p>");
        sentences.setContentType("text/html");

        // red text: <font color=red> </font>
        // green text: <font color=green> </font>
        // for each character in the typing box string:
        for (int i = 0; i < typingText.length(); i++) {

            // check if the character matches the character at that index in the sentences text
            if (typingText.charAt(i) == targetText.charAt(i)) {
                // if it matches, set the character in the sentence box to green
                newSentencesHTML.append("<font color=green>");
                numCorrect++;

            } else {
                // otherwise red
                newSentencesHTML.append("<font color=red>");
            }
            newSentencesHTML.append(targetText.charAt(i));
            newSentencesHTML.append("</font>");

        }
        
        typingProgressBar.setValue((int) (((double) numCorrect / targetText.length()) * 100));
        typingProgressBar.setStringPainted(true);

        if (typingProgressBar.getValue() == 100) {
            try {
                saveProgress(Integer.parseInt(wpmLabel.getText()));
            } catch (IOException ex) {
                Logger.getLogger(GameWin.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(false);
            HighScoresWin highScores;
            try {
                highScores = new HighScoresWin(menuPlay);
                highScores.setVisible(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GameWin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GameWin.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
     
        if (typingText.length() < targetText.length()) {

            // set the remaining characters in the sentences box to black (not typed yet)
            String restOfTargetText = targetText.substring(typingText.length());
            newSentencesHTML.append(restOfTargetText);
        }

        newSentencesHTML.append("</p>");
        sentences.setText(newSentencesHTML.toString());

        if (typingText.length() == targetText.length()+ 1) {
            typingbox.setEditable(false);
        }
    }//GEN-LAST:event_typingboxKeyTyped

    private void btnNewSentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewSentActionPerformed
            
        generateNewSentence();
        typingbox.setText("");
        typingProgressBar.setValue(0);
        

        // Reset the counter on the WPM

        task.resetCounter();
      
    }//GEN-LAST:event_btnNewSentActionPerformed
    
    
    
    public void generateNewSentence() {
            try {
            // Taken and changed from: https://stackoverflow.com/questions/1485708/how-do-i-do-a-http-get-in-java
            URL url = new URL("http://api.quotable.io/random"); // ?maxLength=100
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            StringBuilder result = new StringBuilder();

            try ( BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                for (String line; (line = reader.readLine()) != null;) {
                    result.append(line);
                }
            }
//            sentences.maxLength=100;
            sentences.setContentType("text/html");

            Gson gson = new Gson();
            Quote randomQuote = gson.fromJson(result.toString(), Quote.class);
            sentences.setText("<p>" + randomQuote.getContent() + "</p>");
            sentences.setEditable(false);

        } catch (MalformedURLException ex) {
            Logger.getLogger(GameWin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(GameWin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GameWin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setWpmLabelText(int wpm) {
        wpmLabel.setText(String.valueOf(wpm));
    }

    public String getSentencesText() {
        // get text from sentences box
        String sentencesText = sentences.getText();

        // strip <html> tags from text
        String parsedText = Jsoup.parse(sentencesText).text();
        return parsedText;
    }

    public String getTypingBoxText() {
        return typingbox.getText();
    }

    public void saveProgress(int wpm) throws IOException {

        FileWriter writer = new FileWriter("src/main/resources/highscores.txt", true);
        writer.write(String.valueOf(wpm));
                writer.write("\n");

        
        writer.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
 
      
      
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameWin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNewSent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JEditorPane sentences;
    private javax.swing.JProgressBar typingProgressBar;
    private javax.swing.JTextArea typingbox;
    private javax.swing.JLabel wpmLabel;
    // End of variables declaration//GEN-END:variables
}
