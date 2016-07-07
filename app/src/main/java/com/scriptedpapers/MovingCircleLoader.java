package com.scriptedpapers;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/**
 * Created by mahes on 7/5/16.
 */
public class MovingCircleLoader extends View{

    Paint circlePaint = new Paint();
    Paint circle1Paint = new Paint();
    Paint circle2Paint = new Paint();
    Paint circle3Paint = new Paint();
    Paint circle4Paint = new Paint();
    Paint circle5Paint = new Paint();

    public static final int ANIM_DURATION = 500;

    int circleRadius;
    int movableDistance;

    int circleXValue;
    int circle1XValue;
    int circle2XValue;
    int circle3XValue;
    int circle4XValue;
    int circle5XValue;

    AnimatorSet animatorSet;

    public MovingCircleLoader(Context context) {
        super(context);
        initView();
    }

    public MovingCircleLoader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MovingCircleLoader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    void initView() {

        circlePaint.setAntiAlias(true);
        circle1Paint.setAntiAlias(true);
        circle2Paint.setAntiAlias(true);
        circle3Paint.setAntiAlias(true);
        circle4Paint.setAntiAlias(true);
        circle5Paint.setAntiAlias(true);

        circlePaint.setStyle(Paint.Style.FILL);
        circle1Paint.setStyle(Paint.Style.FILL);
        circle2Paint.setStyle(Paint.Style.FILL);
        circle3Paint.setStyle(Paint.Style.FILL);
        circle4Paint.setStyle(Paint.Style.FILL);
        circle5Paint.setStyle(Paint.Style.FILL);

        circlePaint.setColor(0xFFFFFFFF);
        circle1Paint.setColor(0xCCFFFFFF);
        circle2Paint.setColor(0xA6FFFFFF);
        circle3Paint.setColor(0x8CFFFFFF);
        circle4Paint.setColor(0x59FFFFFF);
        circle5Paint.setColor(0x33FFFFFF);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(circleXValue, getHeight()/2, circleRadius, circlePaint);
        canvas.drawCircle(circle1XValue, getHeight()/2, circleRadius, circle1Paint);
        canvas.drawCircle(circle2XValue, getHeight()/2, circleRadius, circle2Paint);
        canvas.drawCircle(circle3XValue, getHeight()/2, circleRadius, circle3Paint);
        canvas.drawCircle(circle4XValue, getHeight()/2, circleRadius, circle4Paint);
        canvas.drawCircle(circle5XValue, getHeight()/2, circleRadius, circle5Paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        circleRadius = w/8;

        if((circleRadius * 2) > h) {
            circleRadius = h/8;
        }

        movableDistance = w - circleRadius;

        startAnimation();
    }

    private void startAnimation() {

        if(animatorSet != null) {
            animatorSet.cancel();
            animatorSet = null;
        }

        animatorSet = new AnimatorSet();

        setCircleXValue(movableDistance);
        setCircle1XValue(movableDistance);
        setCircle2XValue(movableDistance);
        setCircle3XValue(movableDistance);
        setCircle4XValue(movableDistance);
        setCircle5XValue(movableDistance);

        int doubleAnimDuration = ANIM_DURATION * 2;

        ObjectAnimator circleAnimator = ObjectAnimator.ofInt(this, "circleXValue", movableDistance, circleRadius);
        circleAnimator.setDuration(ANIM_DURATION);
        circleAnimator.setInterpolator(new LinearInterpolator());
        circleAnimator.setStartDelay((ANIM_DURATION / 5) * 0);

        ObjectAnimator circleAnimator1 = ObjectAnimator.ofInt(this, "circleXValue", circleRadius, movableDistance);
        circleAnimator1.setDuration(ANIM_DURATION);
        circleAnimator1.setInterpolator(new LinearInterpolator());
        circleAnimator1.setStartDelay(doubleAnimDuration + ((ANIM_DURATION / 5) * 0));

        ObjectAnimator circle1Animator = ObjectAnimator.ofInt(this, "circle1XValue", movableDistance, circleRadius);
        circle1Animator.setDuration(ANIM_DURATION);
        circle1Animator.setInterpolator(new LinearInterpolator());
        circle1Animator.setStartDelay((ANIM_DURATION / 5) * 1);

        ObjectAnimator circle1Animator1 = ObjectAnimator.ofInt(this, "circle1XValue", circleRadius, movableDistance);
        circle1Animator1.setDuration(ANIM_DURATION);
        circle1Animator1.setInterpolator(new LinearInterpolator());
        circle1Animator1.setStartDelay(doubleAnimDuration + ((ANIM_DURATION / 5) * 1));

        ObjectAnimator circle2Animator = ObjectAnimator.ofInt(this, "circle2XValue", movableDistance, circleRadius);
        circle2Animator.setDuration(ANIM_DURATION);
        circle2Animator.setInterpolator(new LinearInterpolator());
        circle2Animator.setStartDelay((ANIM_DURATION / 5) * 2);

        ObjectAnimator circle2Animator1 = ObjectAnimator.ofInt(this, "circle2XValue", circleRadius, movableDistance);
        circle2Animator1.setDuration(ANIM_DURATION);
        circle2Animator1.setInterpolator(new LinearInterpolator());
        circle2Animator1.setStartDelay(doubleAnimDuration + ((ANIM_DURATION / 5) * 2));

        ObjectAnimator circle3Animator = ObjectAnimator.ofInt(this, "circle3XValue", movableDistance, circleRadius);
        circle3Animator.setDuration(ANIM_DURATION);
        circle3Animator.setInterpolator(new LinearInterpolator());
        circle3Animator.setStartDelay((ANIM_DURATION / 5) * 3);

        ObjectAnimator circle3Animator1 = ObjectAnimator.ofInt(this, "circle3XValue", circleRadius, movableDistance);
        circle3Animator1.setDuration(ANIM_DURATION);
        circle3Animator1.setInterpolator(new LinearInterpolator());
        circle3Animator1.setStartDelay(doubleAnimDuration + ((ANIM_DURATION / 5) * 3));

        ObjectAnimator circle4Animator = ObjectAnimator.ofInt(this, "circle4XValue", movableDistance, circleRadius);
        circle4Animator.setDuration(ANIM_DURATION);
        circle4Animator.setInterpolator(new LinearInterpolator());
        circle4Animator.setStartDelay((ANIM_DURATION / 5) * 4);

        ObjectAnimator circle4Animator1 = ObjectAnimator.ofInt(this, "circle4XValue", circleRadius, movableDistance);
        circle4Animator1.setDuration(ANIM_DURATION);
        circle4Animator1.setInterpolator(new LinearInterpolator());
        circle4Animator1.setStartDelay(doubleAnimDuration + ((ANIM_DURATION / 5) * 4));

        ObjectAnimator circle5Animator = ObjectAnimator.ofInt(this, "circle5XValue", movableDistance, circleRadius);
        circle5Animator.setDuration(ANIM_DURATION);
        circle5Animator.setInterpolator(new LinearInterpolator());
        circle5Animator.setStartDelay((ANIM_DURATION / 5) * 5);

        ObjectAnimator circle5Animator1 = ObjectAnimator.ofInt(this, "circle5XValue", circleRadius, movableDistance);
        circle5Animator1.setDuration(ANIM_DURATION);
        circle5Animator1.setInterpolator(new LinearInterpolator());
        circle5Animator1.setStartDelay(doubleAnimDuration + ((ANIM_DURATION / 5) * 5));

        circle5Animator1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {

                if(animatorSet != null)
                    animatorSet.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });

        animatorSet.playTogether(circleAnimator, circle1Animator, circle2Animator, circle3Animator,
                circle4Animator, circle5Animator, circleAnimator1, circle1Animator1, circle2Animator1, circle3Animator1,
                circle4Animator1, circle5Animator1);

        animatorSet.start();

    }

    public void setCircleXValue(int circleXValue) {
        this.circleXValue = circleXValue;
        invalidate();
    }

    public void setCircle1XValue(int circle1XValue) {
        this.circle1XValue = circle1XValue;
        invalidate();
    }

    public void setCircle2XValue(int circle2XValue) {
        this.circle2XValue = circle2XValue;
        invalidate();
    }

    public void setCircle3XValue(int circle3XValue) {
        this.circle3XValue = circle3XValue;
        invalidate();
    }

    public void setCircle4XValue(int circle4XValue) {
        this.circle4XValue = circle4XValue;
        invalidate();
    }

    public void setCircle5XValue(int circle5XValue) {
        this.circle5XValue = circle5XValue;
        invalidate();
    }
}
