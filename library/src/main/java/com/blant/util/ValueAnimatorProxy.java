package com.blant.util;

import android.animation.ValueAnimator;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

/**
 * Created by hash on 2017/7/6.
 */

public class ValueAnimatorProxy {
    private ValueAnimator valueAnimator;
    private UpdateListener updateListener;

    public ValueAnimatorProxy(TextView view, int... values) {
        valueAnimator = ValueAnimator.ofInt(values);
        initAnimator(view);
    }

    private void initAnimator(final TextView view) {
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(60000);//default
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((int) valueAnimator.getAnimatedValue() != 0) {
                    view.setText(valueAnimator.getAnimatedValue() + "");
                    view.setClickable(false);
                    updateListener.onTick((int) valueAnimator.getAnimatedValue());
                } else {
                    view.setClickable(true);
                    updateListener.onComplete();
                }
            }
        });
    }

    public void setUpdateListener(UpdateListener updateListener) {
        this.updateListener = updateListener;
    }

    public void start() {
        valueAnimator.start();
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void pause() {
        valueAnimator.pause();
    }
}
