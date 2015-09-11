package edu.illinois.rp2015;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    String[] textSnippets = {
            "a meeting of the minds",
            "a celebration of computer science",
            "competing in mechmania",
            "open to everyone",
            "more than just a conference",
            "an annual event",
            "puzzling over Puzzlebang!",
            "student-run",
            "going above and beyond",
            "21 years running"
    };

    int currIndex = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment,container,false);

        final TextView changingText = (TextView) v.findViewById(R.id.changingText);
        changingText.setText("a meeting of the minds");

        final Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(3000);

        final Animation out = new AlphaAnimation(1.0f, 0.0f);
        out.setDuration(3000);

        changingText.startAnimation(out);

        in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                changingText.startAnimation(out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                changingText.setText(textSnippets[currIndex]);
                changingText.setGravity(Gravity.LEFT);
                changingText.startAnimation(in);

                if(currIndex == textSnippets.length - 1) {
                    currIndex = 0;
                } else {
                    currIndex++;
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        return v;
    }
}
