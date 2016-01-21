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
public class Question2 {
    public String question2;
    public String corranswer;
    
    public Question2(String questionpar, String corranswerpar) {
        this.question2 = questionpar;
        this.corranswer = corranswerpar;
        }

    @Override
    public String toString() {
        return "Question{" + "question=" + question2 + ", answer=" + corranswer + '}';
    }
    
}
