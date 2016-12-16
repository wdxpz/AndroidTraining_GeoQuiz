package com.sw.tain.geoquiz;

/**
 * Created by home on 2016/8/31.
 */
public class Question {
    private int mQuestionResId;
    private boolean mAnswerTrue;


    public int getQuestionResId() {
        return mQuestionResId;
    }

    public void setQuestionResId(int questionResId) {
        mQuestionResId = questionResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }



    public Question(int questionResId, boolean answerTrue) {
        mQuestionResId = questionResId;
        mAnswerTrue = answerTrue;
    }




}
