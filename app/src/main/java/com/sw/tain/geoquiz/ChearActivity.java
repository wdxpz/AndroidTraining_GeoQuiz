package com.sw.tain.geoquiz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ChearActivity extends AppCompatActivity {

    private TextView mAnswerTextView;
    private Button mCheatButton;

    private static final String EXTRA_ANSWER_TRUE = "com.sw.tain.geoquiz.answer_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.sw.tain.geoquiz.answer_shown";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chear);

        mAnswerTextView = (TextView)findViewById(R.id.answer_textview);
        mCheatButton = (Button)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isAnswerTrue = getExtraAnswer(getIntent());
                if(isAnswerTrue)
                    mAnswerTextView.setText(R.string.true_button);
                else
                    mAnswerTextView.setText(R.string.false_button);

                mAnswerTextView.setVisibility(View.VISIBLE);
                int cx = mAnswerTextView.getWidth()/2;
                int cy = mAnswerTextView.getHeight()/2;
                float radius = mAnswerTextView.getWidth();
                Animator anim;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    anim = ViewAnimationUtils.createCircularReveal(mAnswerTextView, cx, cy, radius, 0);
                }

                if(anim!=null) {
                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            mAnswerTextView.setVisibility(View.INVISIBLE);
                        }
                    });
                    anim.start();
                }
                mAnswerTextView.setVisibility(View.VISIBLE);
                Integer version = Build.VERSION.SDK_INT;
                mAnswerTextView.setText("API LEVEL: "+version.toString());
                Intent i = new Intent();
                i.putExtra(EXTRA_ANSWER_SHOWN, true);
                setResult(RESULT_OK, i);

            }
        });
    }

    private boolean getExtraAnswer(Intent i) {
        return i.getBooleanExtra(EXTRA_ANSWER_TRUE, false);
    }

    public static Intent CreateIntent(Context context, boolean answer_true) {
        Intent i = new Intent(context, ChearActivity.class);
        i.putExtra(EXTRA_ANSWER_TRUE, answer_true);
        return i;
    }
}
