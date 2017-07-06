package com.blant.vertify;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;

import com.blant.util.UpdateListener;
import com.blant.util.ValueAnimatorProxy;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditText;
    /**
     * send
     */
    private Button mButton;
    private EditText mEditText2;
    /**
     * SEND
     */
    private Button mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mEditText2 = (EditText) findViewById(R.id.editText2);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //TYPE 1
            case R.id.button:
                ValueAnimatorProxy valueAnimatorProxy = new ValueAnimatorProxy(mButton, 60, 0);
                valueAnimatorProxy.setUpdateListener(new UpdateListener() {
                    @Override
                    public void onComplete() {
                        mButton.setText(R.string.send);
                    }

                    @Override
                    public void onTick(int current) {
                        //使用default 可以对这个方法进行空实现
                    }
                });
                valueAnimatorProxy.start();
                break;
            //TYPE 2
            case R.id.button2:
                CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {
                    @Override
                    public void onTick(long l) {
                        mButton2.setText(l / 1000 + "");
                    }

                    @Override
                    public void onFinish() {
                        mButton2.setClickable(true);

                    }
                };
                countDownTimer.start();
                mButton2.setClickable(false);
                break;
        }
    }
}
