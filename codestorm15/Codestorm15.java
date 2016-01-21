/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codestorm15;

//import static codestorm15.Codestorm15.readFile;
import static codestorm15.Round1a.showAlert;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author PUNEET
 */




public class Codestorm15 {
    public static String[] minSec;
    public static Round1a round1a;
    public static Round1b round1b;
    
    /**
     * @param args the command line arguments
     */
    public static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static long offset = 1800000;
    // 0 is EQUIVALENT TO 30 MINS
    //public static long timeToSet = 2400000 - offset;
    public static long timeToSet = 240000 - offset;
    
    public static int flag = 0;
    
    public static void main(String[] args) throws IOException {
        
       
        
        
        readEverything();
        
        round1a = new Round1a();
        round1a.setSize(1366, 768);
        round1a.setVisible(true);
                    
        round1a.setDefaultCloseOperation(round1a.DO_NOTHING_ON_CLOSE);
     
        Round1a.jButton1.doClick();
        
        round1b = new Round1b();
        round1b.setSize(1366, 768);
        //round1b.setVisible(true);
                    
        round1b.setDefaultCloseOperation(round1a.DO_NOTHING_ON_CLOSE);
     
        Round1b.jButton1.doClick();
        
        
            TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                timeToSet -= 1000;
                String time = (new SimpleDateFormat("mm:ss", Locale.US)).format(new Date(timeToSet));
                minSec = time.split(":");
                Round1a.mins.setText(minSec[0]);
                Round1a.secs.setText(minSec[1]);
                
                if (time.equals("00:01")) {
                    //TIME'S UP!
                    round1a.setVisible(false);
                    Round1b.mins.setText("hi");
                    Round1b.secs.setText("he");
                    round1b.setVisible(true);
                    
                    timeToSet -= 1000;
                    
                   // round1b.mins.setText(minSec[0]);
                    //round1b.mins.setText(minSec[1]);
                  /*  End end = new End();
                    end.setSize(1366, 768);
                    end.setVisible(true);
                    end.jLabel4.setText("" + Round1a.currentScore);*/
                    
                }
                if (time.equalsIgnoreCase("00:00"))
                {
                    round1b.setVisible(false);
                    End end = new End();
                    end.setSize(1366, 768);
                    end.setVisible(true);
                    end.jLabel4.setText("" + Round1a.currentScore);
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 0, 1000);
    }

    public static ArrayList<Question> questionsEasy = new ArrayList<>();
    public static ArrayList<Question> questionsMedium = new ArrayList<>();
    public static ArrayList<Question> questionsHard = new ArrayList<>();
   // public static ArrayList<Question2> quest = new ArrayList<>();
    
    public static void readEverything() throws IOException {
        questionsEasy = readFile("easy.dat");
        questionsMedium = readFile("medium.dat");
        questionsHard = readFile("hard.dat");
     //   quest = readFile("string.dat");
        
        final int sizeEasy = Codestorm15.questionsEasy.size();
        final int sizeMedium = Codestorm15.questionsMedium.size();
        final int sizeHard = Codestorm15.questionsHard.size();
       // final int sizestring = Codestorm15.quest.size();
        showAlert("Total Questions: " + (sizeEasy + sizeMedium + sizeHard));
    }

    
    
    public static ArrayList<Question> readFile(String name) throws IOException {
        
      
        ArrayList<Question> listFile = new ArrayList<>();
        String file = readFile(name, StandardCharsets.US_ASCII);
        String[] fileSplits = file.split("###");
        for (int i = 0; i < (fileSplits.length);) {
            Question question = new Question(
                    fileSplits[i],
                    fileSplits[i + 1],
                    fileSplits[i + 2],
                    fileSplits[i + 3],
                    fileSplits[i + 4],
                    Integer.parseInt(fileSplits[i + 5]));
            i += 6;
            if (question.question != null && !question.question.isEmpty()) {
                listFile.add(question);
            }
        }
        return listFile;
        }
}
        
