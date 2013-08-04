/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.form;

import assignment.model.AssgGroupMst;
import assignment.model.AssgGroupUser;
import GD.model.ChatUser;
import quiz.model.QzQuestions;
import quiz.model.QzQuizes;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author admin
 */
public class QuizForm extends org.apache.struts.action.ActionForm {
    
    private List<QzQuizes> quizList;
    private List<QzQuestions> questionList;

    private String quizId;
    private String quizName;

    public String getQzQuestion() {
        return qzQuestion;
    }

    public void setQzQuestion(String qzQuestion) {
        this.qzQuestion = qzQuestion;
    }


     private Integer qzQuestionId;
     private String qzQuestion;
     private String qzOption1;
     private String qzOption2;
     private String qzOption3;
     private String qzOption4;
     private Integer qzCorrectAnswer;
     private Float qzQuestionMarks;
     private Float qzNegQuestionMarks;

    public Integer getQzQuestionId() {
        return qzQuestionId;
    }

    public void setQzQuestionId(Integer qzQuestionId) {
        this.qzQuestionId = qzQuestionId;
    }

    
     
     
    public String getQzOption1() {
        return qzOption1;
    }

    public void setQzOption1(String qzOption1) {
        this.qzOption1 = qzOption1;
    }

    public String getQzOption2() {
        return qzOption2;
    }

    public void setQzOption2(String qzOption2) {
        this.qzOption2 = qzOption2;
    }

    public String getQzOption3() {
        return qzOption3;
    }

    public void setQzOption3(String qzOption3) {
        this.qzOption3 = qzOption3;
    }

    public String getQzOption4() {
        return qzOption4;
    }

    public void setQzOption4(String qzOption4) {
        this.qzOption4 = qzOption4;
    }

    public Integer getQzCorrectAnswer() {
        return qzCorrectAnswer;
    }

    public void setQzCorrectAnswer(Integer qzCorrectAnswer) {
        this.qzCorrectAnswer = qzCorrectAnswer;
    }

    public Float getQzQuestionMarks() {
        return qzQuestionMarks;
    }

    public void setQzQuestionMarks(Float qzQuestionMarks) {
        this.qzQuestionMarks = qzQuestionMarks;
    }

    public Float getQzNegQuestionMarks() {
        return qzNegQuestionMarks;
    }

    public void setQzNegQuestionMarks(Float qzNegQuestionMarks) {
        this.qzNegQuestionMarks = qzNegQuestionMarks;
    }

    
    
    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }
    
    public List<QzQuestions> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QzQuestions> questionList) {
        this.questionList = questionList;
    }
    
    public List<QzQuizes> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<QzQuizes> quizList) {
        this.quizList = quizList;
    }
    
 
    /**
     * @return
     */
        /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        String key=request.getParameter("callmethod");
        ActionErrors errors = new ActionErrors();
//        if (getName() == null || getName().length() < 1) {
//            errors.add("name", new ActionMessage("error.name.required"));
//            // TODO: add 'error.name.required' key to your resources
//        }
        
        return null;
    }
}
