/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codestorm15;

/**
 *
 * @author Anupam
 */
public class Question {
    public String question;
    public String option1;
    public String option2;
    public String option3;
    public String option4;
    public int correctAnswer;

    public Question(String question, String option1, String option2, String option3, String option4, int correctAnswer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "Question{" + "question=" + question + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", correctAnswer=" + correctAnswer + '}';
    }
}
