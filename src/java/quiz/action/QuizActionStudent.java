/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.action;

import quiz.form.StudentQuizForm;
import assignment.model.AssgGroupMst;
import assignment.model.AssgMst;
import common.helper.HibernateUtil;
import quiz.model.QzQuestions;
import quiz.model.QzQuizes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class QuizActionStudent extends DispatchAction {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String TAKE = "take";
    private static final String QUIZ = "quiz";
    private static final String EDIT = "edit";
    private static final Logger logger = Logger.getLogger(QuizActionStudent.class);

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward loadPage(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        try {
            StudentQuizForm quizForm = (StudentQuizForm) form;
            quizForm.setQuizList(getQuizzes(request));
        } catch (Exception e) {
            logger.error("Error in loadPage method : " + e, e);
        }
        return mapping.findForward(SUCCESS);

    }

    public ActionForward getQuestions(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            StudentQuizForm quizForm = (StudentQuizForm) form;

            quizForm.setQuizId(request.getParameter("quizId"));
            quizForm.setQuizName(request.getParameter("quizName"));

            logger.info("Quiz ID..." + request.getParameter("quizId"));
            quizForm.setQuestionList(getQuestionsForQuiz(request, request.getParameter("quizId")));
        } catch (Exception e) {
            logger.error("Error in getQuestions method : " + e, e);
        }
        return mapping.findForward(QUIZ);

    }

    public ActionForward takeQuiz(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            StudentQuizForm quizForm = (StudentQuizForm) form;

            quizForm.setQuizId(request.getParameter("quizId"));
            quizForm.setQuizName(request.getParameter("quizName"));

            logger.info("Quiz ID..." + request.getParameter("quizId"));

            quizForm.setQuestionList(getQuestionsForQuiz(request, request.getParameter("quizId")));
            logger.info("quizForm.getQuestionList().size()..." + quizForm.getQuestionList().size());
            //  quizForm.setQuizList(getQuizzes(request));  
        } catch (Exception e) {
            logger.error("Error in takeQuiz method : " + e, e);
        }
        return mapping.findForward(TAKE);

    }

    public ActionForward markComplete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            QzQuizes qz = (QzQuizes) session.load(QzQuizes.class, Integer.valueOf(request.getParameter("quizId")));
            tx = session.beginTransaction();
            qz.setStatus("C");
            qz.setFinalStatus("1");
            session.save(qz);
            tx.commit();
            session.close();

            StudentQuizForm quizForm = (StudentQuizForm) form;
            quizForm.setQuizList(getQuizzes(request));
        } catch (Exception ex) {
            logger.error("Error in markComplete method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();
        }
        return mapping.findForward(SUCCESS);

    }

    public ActionForward QuestionHandler(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            StudentQuizForm qzForm = (StudentQuizForm) form;
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            logger.info(":::: Question Id is :::" + request.getParameter("qzQuestionId"));
            tx = session.beginTransaction();
            QzQuestions qz = (QzQuestions) session.load(QzQuestions.class, Integer.valueOf(request.getParameter("qzQuestionId")));
            logger.info("The Question is :::" + qz.getQzQuestion());
            qzForm.setQzQuestion(qz.getQzQuestion());
            qzForm.setQzOption1(qz.getQzOption1());
            qzForm.setQzOption2(qz.getQzOption2());
            qzForm.setQzOption3(qz.getQzOption3());
            qzForm.setQzOption4(qz.getQzOption4());
            qzForm.setQzCorrectAnswer(qz.getQzCorrectAnswer());
            qzForm.setQzNegQuestionMarks(qz.getQzNegQuestionMarks());
            qzForm.setQzQuestionMarks(qz.getQzQuestionMarks());
            tx.commit();
            session.close();

            qzForm.setQuizId(request.getParameter("quizId"));
            qzForm.setQuizList(getQuizzes(request));
            qzForm.setQzQuestionId(Integer.valueOf(request.getParameter("qzQuestionId")));
        } catch (Exception ex) {
            logger.error("Error in QuestionHandler method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();
        }
        return mapping.findForward(EDIT);

    }

    public ActionForward insertQuiz(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            int saveStatus = saveQuiz(request.getParameter("quizName"), request.getParameter("quizDesc"), request.getParameter("quizSubject"), request.getParameter("quizScope"));
            StudentQuizForm quizForm = (StudentQuizForm) form;
            quizForm.setQuizList(getQuizzes(request));
        } catch (Exception e) {
            logger.error("Error in insertQuiz method : " + e, e);
        }
        return mapping.findForward(SUCCESS);

    }

    public ActionForward updateQuestion(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            StudentQuizForm qzForm = (StudentQuizForm) form;

            logger.info(request.getParameter("qzQuestionId"));
            logger.info("Inside Update Question...");
            int saveStatus = updateQuestion(Integer.valueOf(request.getParameter("qzQuestionId")), request.getParameter("qzQuestion"), request.getParameter("qzOption1"), request.getParameter("qzOption2"), request.getParameter("qzOption3"), request.getParameter("qzOption4"), Integer.valueOf(request.getParameter("qzCorrectAnswer")), Float.valueOf(request.getParameter("qzQuestionMarks")), Float.valueOf(request.getParameter("qzNegQuestionMarks")));

            StudentQuizForm quizForm = (StudentQuizForm) form;

            quizForm.setQuizId(request.getParameter("quizId"));
            quizForm.setQuizName(request.getParameter("quizName"));

            quizForm.setQuestionList(getQuestionsForQuiz(request, request.getParameter("quizId")));
        } catch (Exception e) {
            logger.error("Error in updateQuestion method : " + e, e);
        }
        return mapping.findForward(QUIZ);

    }

    public ActionForward insertQuestion(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            StudentQuizForm qzForm = (StudentQuizForm) form;

            int saveStatus = saveQuestion(Integer.valueOf(qzForm.getQuizId()), request.getParameter("qzQuestion"), request.getParameter("qzOption1"), request.getParameter("qzOption2"), request.getParameter("qzOption3"), request.getParameter("qzOption4"), request.getParameter("qzCorrectAnswer"), request.getParameter("qzQuestionMarks"), request.getParameter("qzNegQuestionMarks"));
            //getQuestions(mapping,form,request,response);  

            StudentQuizForm quizForm = (StudentQuizForm) form;

            quizForm.setQuizId(request.getParameter("quizId"));
            quizForm.setQuizName(request.getParameter("quizName"));

            quizForm.setQuestionList(getQuestionsForQuiz(request, request.getParameter("quizId")));
        } catch (Exception e) {
            logger.error("Error in insertQuestion method : " + e, e);
        }
        return mapping.findForward(QUIZ);

    }

    private List<QzQuizes> getQuizzes(HttpServletRequest request) {

        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            logger.info("Inside Quize Getting");

            tx = session.beginTransaction();
            Query q_quizMstQuery = session.createQuery("from QzQuizes where qzUserId = " + 1);

            List<QzQuizes> quizList = new ArrayList<QzQuizes>();
            quizList = (ArrayList<QzQuizes>) q_quizMstQuery.list();
            logger.info("QuizList Size is" + quizList.size());
            tx.commit();
            session.close();
            return quizList;
        } catch (Exception ex) {
            logger.error("Error in getQuizzes method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();
            return null;
        }


    }

    private List<QzQuestions> getQuestionsForQuiz(HttpServletRequest request, String quizId) {

        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;
        try {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();

            tx = session.beginTransaction();
            Query q_questionMstQuery = session.createQuery("from QzQuestions Qz where Qz.qzQuizId = " + quizId);

            List<QzQuestions> questionList = new ArrayList<QzQuestions>();
            questionList = (ArrayList<QzQuestions>) q_questionMstQuery.list();
            logger.info("QuizList Size is" + questionList.size());
            tx.commit();
            session.close();
            return questionList;
        } catch (Exception ex) {
            logger.error("Error in getQuestionsForQuiz method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();
            return null;
        }


    }

    private int updateQuestion(int questionId, String qzQuestion, String qzOption1, String qzOption2, String qzOption3, String qzOption4, int qzCorrectAnswer, float qzQuestionMarks, float qzNegQuestionMarks) {

        SessionFactory factory = null;
        Session session = null;

        Transaction tx = null;

        try {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();
            QzQuestions qz = (QzQuestions) session.load(QzQuestions.class, questionId);
            qz.setQzQuestion(qzQuestion);
            qz.setQzOption1(qzOption1);
            qz.setQzOption2(qzOption2);
            qz.setQzOption3(qzOption3);
            qz.setQzOption4(qzOption4);
            qz.setQzCorrectAnswer(qzCorrectAnswer);
            qz.setQzQuestionMarks(qzQuestionMarks);
            qz.setQzNegQuestionMarks(qzNegQuestionMarks);
            session.update(qz);
            tx.commit();
            session.close();
            return 1;
        } catch (Exception ex) {
            logger.error("Error in updateQuestion method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();
            return -1;
        }
    }

    private int saveQuestion(int quizId, String qzQuestion, String qzOption1, String qzOption2, String qzOption3, String qzOption4, String qzCorrectAnswer, String qzQuestionMarks, String qzNegQuestionMarks) {

        SessionFactory factory = null;
        Session session = null;

        Transaction tx = null;

        try {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();
            QzQuestions qzQue = new QzQuestions(quizId, 1, qzQuestion, qzOption1, qzOption2, qzOption3, qzOption4, Integer.valueOf(qzCorrectAnswer), Float.valueOf(qzQuestionMarks), Float.valueOf(qzNegQuestionMarks), new Date(), "Jyot", 1);
            //session.save(pad);
            //session.save(user);
            //QzQuizes qz = new QzQuizes(quizName, quizDesc,quizScope, quizSubject, new Date(), "Jyot", "I", "0"); 
            session.save(qzQue);
            tx.commit();
            session.close();
            return 1;
        } catch (Exception ex) {
            logger.error("Error in saveQuestion method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();
            return -1;
        }
    }

    private int saveQuiz(String quizName, String quizDesc, String quizSubject, String quizScope) {

        SessionFactory factory = null;
        Session session = null;

        Transaction tx = null;

        try {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();
            //session.save(pad);
            //session.save(user);
            QzQuizes qz = new QzQuizes(1, quizName, quizDesc, quizScope, quizSubject, new Date(), "Jyot", "I", "0");
            session.save(qz);
            tx.commit();
            session.close();
            return 1;
        } catch (Exception ex) {
            logger.error("Error in saveQuiz method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();
            return -1;
        }


    }
}
