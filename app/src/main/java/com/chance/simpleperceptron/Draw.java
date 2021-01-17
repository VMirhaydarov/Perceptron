package com.chance.simpleperceptron;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import java.text.DecimalFormat;

import static android.app.PendingIntent.getActivity;

public class Draw extends View {

    boolean drawIsVertical;

    private Paint mPaint;
    boolean[] bEntersActive;
    boolean[] bOutersActive;
    String outerValue;
    double[] dOutersValue;

    float width;
    float height;

    float widthSourceVertical;
    float heightSourceVertical;
    float widthSourceHorizontal;
    float heightSourceHorizontal;

    public Draw(Context context) {
        super(context);
        init();
    }

    public Draw(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Draw(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    void init(){

        mPaint = new Paint();
        bEntersActive = new boolean[15];
        for(int i=0;i<15;i++) bEntersActive[i] = false;
        bOutersActive = new boolean[15];
        for(int i=0;i<15;i++) bOutersActive[i] = false;
        outerValue = "";
        dOutersValue = new double[10];
        for(int i=0;i<10;i++) dOutersValue[i] = 0.0;

        drawIsVertical = true;

        /*Display display = getContext().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;*/

        /*Display display = ((WindowManager) getContext().getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        Point p = new Point();
        display.getSize(p);
        width = p.x;
        height = p.y;
        Log.d("DrawTag","width = " + width + " height = " + height);*/

        widthSourceVertical = 1024;
        heightSourceVertical = 993;

        widthSourceHorizontal = 1152;
        heightSourceHorizontal = 816;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float coordX1 = 0;
        float coordX2 = 0;
        float coordX = 0;
        float deltaX = 0;
        float coordY1 = 0;
        float coordY2 = 0;
        float coordY = 0;
        float deltaY = 0;
        float radius = 0;
        float k_width = 0;
        float k_height = 0;

        mPaint.setAntiAlias(true);

        if(drawIsVertical){

            width = canvas.getWidth();
            height = canvas.getHeight();
            Log.d("DrawTag","widthCanvas = " + width + " heightCanvas = " + height);

            k_width = width/widthSourceVertical;
            k_height = height/heightSourceVertical;

            /*
            canvas.drawLine(80, 100, 100, 550, mPaint);
            canvas.drawLine(80, 100, 190, 550, mPaint);
            */
            mPaint.setColor(Color.BLACK);
            coordX1 = 80*k_width;
            coordX2 = 100*k_width;
            deltaX = 90*k_width;
            coordY1 = 100*k_height;
            coordY2 = 550*k_height;
            for(int j=0;j<15;j++) {
                coordX1 = 80*k_width + 60*k_width * j;
                for (int i = 0; i < 10; i++) {
                    coordX = coordX2 + deltaX * i;
                    canvas.drawLine(coordX1, coordY1, coordX, coordY2, mPaint);
                }
            }

            /*
            canvas.drawLine(100, 550, 100, 700, mPaint);
            canvas.drawLine(190, 550, 190, 700, mPaint);
            canvas.drawLine(280, 550, 280, 700, mPaint);
            canvas.drawLine(370, 550, 370, 700, mPaint);
             */

            coordX1 = 100*k_width;
            coordY1 = 550*k_height;
            coordY2 = 700*k_height;
            deltaX = 90*k_width;
            for(int i=0;i<10;i++){
                coordX = coordX1 + deltaX * i;
                canvas.drawLine(coordX,coordY1,coordX,coordY2,mPaint);
            }

            /*
            canvas.drawLine(500, 900, 100, 700, mPaint);
            canvas.drawLine(500, 900, 190, 700, mPaint);
            canvas.drawLine(500, 900, 280, 700, mPaint);
             */

            coordX1 = 500*k_width;
            coordY1 = 900*k_height;
            coordX2 = 100*k_width;
            deltaX = 90*k_width;
            coordY2 = 700*k_height;
            for(int i=0;i<10;i++){
                coordX = coordX2 + deltaX * i;
                canvas.drawLine(coordX1,coordY1,coordX,coordY2,mPaint);
            }

            /*mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[0]) mPaint.setColor(Color.RED);
            canvas.drawCircle(80, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);*/

            coordX1 = 80*k_width;
            Log.d("DrawTag","coordX1 = " + coordX1);
            coordX = 0;
            deltaX = 60*k_width;
            coordY = 100*k_height;
            radius = 20*k_width;
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.BLUE);
            for(int i=0;i<15;i++){
                if (bEntersActive[i]) mPaint.setColor(Color.RED);
                coordX = coordX1 + deltaX*i;
                canvas.drawCircle(coordX, coordY, radius, mPaint);
                mPaint.setColor(Color.BLUE);
            }

            /*mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.WHITE);
            canvas.drawCircle(100, 550, 40, mPaint);
            canvas.drawCircle(190, 550, 40, mPaint);
            canvas.drawCircle(280, 550, 40, mPaint);*/


            coordX1 = 100*k_width;
            deltaX = 90*k_width;
            coordY1 = 550*k_height;
            radius = 40*k_width;
            for(int i=0;i<10;i++){
                coordX = coordX1 + deltaX*i;
                mPaint.setStyle(Paint.Style.FILL);
                mPaint.setColor(Color.WHITE);
                canvas.drawCircle(coordX,coordY1,radius,mPaint);
                mPaint.setStyle(Paint.Style.STROKE);
                mPaint.setColor(Color.BLACK);
                canvas.drawCircle(coordX,coordY1,radius,mPaint);
            }

            /*
            mPaint.setTextSize(40);
            mPaint.setColor(Color.BLACK);
            mPaint.setStyle(Paint.Style.FILL);
            String res;
            if (!bEntersActive[0]) res = "0";
            else res = "1";
            canvas.drawText(res, 67, 60, mPaint);
            if (!bEntersActive[1]) res = "0";
            else res = "1";
            canvas.drawText(res, 127, 60, mPaint);
            if (!bEntersActive[2]) res = "0";
            else res = "1";
            */

            mPaint.setTextSize(40*k_width);
            mPaint.setColor(Color.BLACK);
            mPaint.setStyle(Paint.Style.FILL);
            coordX1 = 67*k_width;
            deltaX = 60*k_width;
            coordY1 = 60*k_width;
            for(int i=0;i<15;i++){
                coordX = coordX1 + deltaX*i;
                String res;
                if (!bEntersActive[i]) res = "0";
                else res = "1";
                canvas.drawText(res,coordX,coordY1,mPaint);
            }

            /*
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[0]) mPaint.setColor(Color.RED);
            canvas.drawCircle(100, 700, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[1]) mPaint.setColor(Color.RED);
            canvas.drawCircle(190, 700, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[2]) mPaint.setColor(Color.RED);
            canvas.drawCircle(280, 700, 40, mPaint);
            */

            mPaint.setStyle(Paint.Style.FILL);
            //mPaint.setColor(Color.BLUE);
            coordX1 = 100*k_width;
            deltaX = 90*k_width;
            coordY1 = 700*k_height;
            radius = 40*k_width;
            for(int i=0;i<10;i++){
                if (bOutersActive[i]) mPaint.setColor(Color.RED);
                else mPaint.setColor(Color.BLUE);
                coordX = coordX1 + deltaX * i;
                canvas.drawCircle(coordX,coordY1,radius,mPaint);
            }

            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.WHITE);
            canvas.drawCircle(500*k_width, 900*k_height, 60*k_width, mPaint);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(Color.BLACK);
            canvas.drawCircle(500*k_width, 900*k_height, 60*k_width, mPaint);

            /*
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.BLACK);
            mPaint.setTextSize(38);
            //String value = Double.toString(dOutersValue[0]);
            String value = new DecimalFormat("#0.00").format(dOutersValue[0]);
            canvas.drawText(value, 62, 562, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[1]);
            canvas.drawText(value, 152, 562, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[2]);
            canvas.drawText(value, 242, 562, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[3]);
            canvas.drawText(value, 332, 562, mPaint);
             */

            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.BLACK);
            mPaint.setTextSize(38*k_width);
            coordX1 = 62*k_width;
            deltaX = 90*k_width;
            coordY1 = 562*k_height;
            for(int i=0;i<10;i++){
                String value = new DecimalFormat("#0.00").format(dOutersValue[i]);
                coordX = coordX1 + deltaX * i;
                canvas.drawText(value,coordX,coordY1,mPaint);
            }

            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.WHITE);
            mPaint.setTextSize(60*k_width);
            canvas.drawText("0", 82*k_width, 721*k_height, mPaint);
            canvas.drawText("1", 172*k_width, 721*k_height, mPaint);
            canvas.drawText("2", 262*k_width, 721*k_height, mPaint);
            canvas.drawText("3", 352*k_width, 721*k_height, mPaint);
            canvas.drawText("4", 442*k_width, 721*k_height, mPaint);
            canvas.drawText("5", 532*k_width, 721*k_height, mPaint);
            canvas.drawText("6", 622*k_width, 721*k_height, mPaint);
            canvas.drawText("7", 712*k_width, 721*k_height, mPaint);
            canvas.drawText("8", 802*k_width, 721*k_height, mPaint);
            canvas.drawText("9", 892*k_width, 721*k_height, mPaint);

            mPaint.setColor(Color.BLACK);
            mPaint.setTextSize(80*k_width);
            canvas.drawText(outerValue, 475*k_width, 930*k_height, mPaint);

        }
        else{
            width = canvas.getWidth();
            height = canvas.getHeight();
            Log.d("DrawTag","widthCanvas = " + width + " heightCanvas = " + height);

            k_width = width/widthSourceHorizontal;
            k_height = height/heightSourceHorizontal;

            mPaint.setColor(Color.BLACK);

            /*
            canvas.drawLine(80, 100, 100, 450, mPaint);
            canvas.drawLine(80, 100, 200, 450, mPaint);
            canvas.drawLine(80, 100, 300, 450, mPaint);
            canvas.drawLine(80, 100, 400, 450, mPaint);
             */
            coordX1 = 80*k_width;
            coordX2 = 100*k_width;
            deltaX = 100*k_width;
            coordY1 = 100*k_height;
            coordY2 = 450*k_height;
            for(int j=0;j<15;j++) {
                coordX1 = 80*k_width + 70*k_width * j;
                for (int i = 0; i < 10; i++) {
                    coordX = coordX2 + deltaX * i;
                    canvas.drawLine(coordX1, coordY1, coordX, coordY2, mPaint);
                }
            }

            /*
            canvas.drawLine(100, 450, 100, 570, mPaint);
            canvas.drawLine(200, 450, 200, 570, mPaint);
            canvas.drawLine(300, 450, 300, 570, mPaint);
             */

            coordX1 = 100*k_width;
            coordY1 = 450*k_height;
            coordY2 = 570*k_height;
            deltaX = 100*k_width;
            for(int i=0;i<10;i++){
                coordX = coordX1 + deltaX * i;
                canvas.drawLine(coordX,coordY1,coordX,coordY2,mPaint);
            }

            /*
            canvas.drawLine(570, 730, 100, 570, mPaint);
            canvas.drawLine(570, 730, 200, 570, mPaint);
            canvas.drawLine(570, 730, 300, 570, mPaint);
             */

            coordX1 = 570*k_width;
            coordY1 = 730*k_height;
            coordX2 = 100*k_width;
            deltaX = 100*k_width;
            coordY2 = 570*k_height;
            for(int i=0;i<10;i++){
                coordX = coordX2 + deltaX * i;
                canvas.drawLine(coordX1,coordY1,coordX,coordY2,mPaint);
            }

            /*
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[0]) mPaint.setColor(Color.RED);
            canvas.drawCircle(80, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[1]) mPaint.setColor(Color.RED);
            canvas.drawCircle(150, 100, 20, mPaint);
             */

            coordX1 = 80*k_width;
            //Log.d("DrawTag","coordX1 = " + coordX1);
            coordX = 0;
            deltaX = 70*k_width;
            coordY = 100*k_height;
            radius = 20*k_width;
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.BLUE);
            for(int i=0;i<15;i++){
                if (bEntersActive[i]) mPaint.setColor(Color.RED);
                coordX = coordX1 + deltaX*i;
                canvas.drawCircle(coordX, coordY, radius, mPaint);
                mPaint.setColor(Color.BLUE);
            }

            /*
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.WHITE);
            canvas.drawCircle(100, 450, 40, mPaint);
            canvas.drawCircle(200, 450, 40, mPaint);
            canvas.drawCircle(300, 450, 40, mPaint);
             */

            coordX1 = 100*k_width;
            deltaX = 100*k_width;
            coordY1 = 450*k_height;
            radius = 40*k_width;
            for(int i=0;i<10;i++){
                coordX = coordX1 + deltaX*i;
                mPaint.setStyle(Paint.Style.FILL);
                mPaint.setColor(Color.WHITE);
                canvas.drawCircle(coordX,coordY1,radius,mPaint);
                mPaint.setStyle(Paint.Style.STROKE);
                mPaint.setColor(Color.BLACK);
                canvas.drawCircle(coordX,coordY1,radius,mPaint);
            }

            /*
            mPaint.setTextSize(40);
            mPaint.setColor(Color.BLACK);
            mPaint.setStyle(Paint.Style.FILL);
            String res;
            if (!bEntersActive[0]) res = "0";
            else res = "1";
            canvas.drawText(res, 67, 60, mPaint);
            if (!bEntersActive[1]) res = "0";
            else res = "1";
            canvas.drawText(res, 137, 60, mPaint);
            if (!bEntersActive[2]) res = "0";
             */

            mPaint.setTextSize(40*k_width);
            mPaint.setColor(Color.BLACK);
            mPaint.setStyle(Paint.Style.FILL);
            coordX1 = 67*k_width;
            deltaX = 70*k_width;
            coordY1 = 60*k_width;
            for(int i=0;i<15;i++){
                coordX = coordX1 + deltaX*i;
                String res;
                if (!bEntersActive[i]) res = "0";
                else res = "1";
                canvas.drawText(res,coordX,coordY1,mPaint);
            }

            /*
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[0]) mPaint.setColor(Color.RED);
            canvas.drawCircle(100, 570, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[1]) mPaint.setColor(Color.RED);
            canvas.drawCircle(200, 570, 40, mPaint);
            mPaint.setColor(Color.BLUE);
             */

            coordX1 = 100*k_width;
            deltaX = 100*k_width;
            coordY1 = 570*k_height;
            radius = 40*k_width;
            for(int i=0;i<10;i++){
                if (bOutersActive[i]) mPaint.setColor(Color.RED);
                else mPaint.setColor(Color.BLUE);
                coordX = coordX1 + deltaX * i;
                canvas.drawCircle(coordX,coordY1,radius,mPaint);
            }

            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.WHITE);
            canvas.drawCircle(570*k_width, 730*k_height, 60*k_width, mPaint);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(Color.BLACK);
            canvas.drawCircle(570*k_width, 730*k_height, 60*k_width, mPaint);

            /*
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.BLACK);
            mPaint.setTextSize(38);
            //String value = Double.toString(dOutersValue[0]);
            String value = new DecimalFormat("#0.00").format(dOutersValue[0]);
            canvas.drawText(value, 62, 462, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[1]);
            canvas.drawText(value, 162, 462, mPaint);
             */

            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.BLACK);
            mPaint.setTextSize(38*k_width);
            coordX1 = 62*k_width;
            deltaX = 100*k_width;
            coordY1 = 462*k_height;
            for(int i=0;i<10;i++){
                String value = new DecimalFormat("#0.00").format(dOutersValue[i]);
                coordX = coordX1 + deltaX * i;
                canvas.drawText(value,coordX,coordY1,mPaint);
            }

            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.WHITE);
            mPaint.setTextSize(60*k_width);
            canvas.drawText("0", 82*k_width, 591*k_height, mPaint);
            canvas.drawText("1", 182*k_width, 591*k_height, mPaint);
            canvas.drawText("2", 282*k_width, 591*k_height, mPaint);
            canvas.drawText("3", 382*k_width, 591*k_height, mPaint);
            canvas.drawText("4", 482*k_width, 591*k_height, mPaint);
            canvas.drawText("5", 582*k_width, 591*k_height, mPaint);
            canvas.drawText("6", 682*k_width, 591*k_height, mPaint);
            canvas.drawText("7", 782*k_width, 591*k_height, mPaint);
            canvas.drawText("8", 882*k_width, 591*k_height, mPaint);
            canvas.drawText("9", 982*k_width, 591*k_height, mPaint);

            mPaint.setColor(Color.BLACK);
            mPaint.setTextSize(80*k_width);
            canvas.drawText(outerValue, 545*k_width, 760*k_height, mPaint);

        }

        /*if (drawIsVertical) {

            mPaint.setAntiAlias(true);

            mPaint.setColor(Color.BLACK);
            canvas.drawLine(80, 100, 100, 550, mPaint);
            canvas.drawLine(80, 100, 190, 550, mPaint);
            canvas.drawLine(80, 100, 280, 550, mPaint);
            canvas.drawLine(80, 100, 370, 550, mPaint);
            canvas.drawLine(80, 100, 460, 550, mPaint);
            canvas.drawLine(80, 100, 550, 550, mPaint);
            canvas.drawLine(80, 100, 640, 550, mPaint);
            canvas.drawLine(80, 100, 730, 550, mPaint);
            canvas.drawLine(80, 100, 820, 550, mPaint);
            canvas.drawLine(80, 100, 910, 550, mPaint);

            canvas.drawLine(140, 100, 100, 550, mPaint);
            canvas.drawLine(140, 100, 190, 550, mPaint);
            canvas.drawLine(140, 100, 280, 550, mPaint);
            canvas.drawLine(140, 100, 370, 550, mPaint);
            canvas.drawLine(140, 100, 460, 550, mPaint);
            canvas.drawLine(140, 100, 550, 550, mPaint);
            canvas.drawLine(140, 100, 640, 550, mPaint);
            canvas.drawLine(140, 100, 730, 550, mPaint);
            canvas.drawLine(140, 100, 820, 550, mPaint);
            canvas.drawLine(140, 100, 910, 550, mPaint);

            canvas.drawLine(200, 100, 100, 550, mPaint);
            canvas.drawLine(200, 100, 190, 550, mPaint);
            canvas.drawLine(200, 100, 280, 550, mPaint);
            canvas.drawLine(200, 100, 370, 550, mPaint);
            canvas.drawLine(200, 100, 460, 550, mPaint);
            canvas.drawLine(200, 100, 550, 550, mPaint);
            canvas.drawLine(200, 100, 640, 550, mPaint);
            canvas.drawLine(200, 100, 730, 550, mPaint);
            canvas.drawLine(200, 100, 820, 550, mPaint);
            canvas.drawLine(200, 100, 910, 550, mPaint);

            canvas.drawLine(260, 100, 100, 550, mPaint);
            canvas.drawLine(260, 100, 190, 550, mPaint);
            canvas.drawLine(260, 100, 280, 550, mPaint);
            canvas.drawLine(260, 100, 370, 550, mPaint);
            canvas.drawLine(260, 100, 460, 550, mPaint);
            canvas.drawLine(260, 100, 550, 550, mPaint);
            canvas.drawLine(260, 100, 640, 550, mPaint);
            canvas.drawLine(260, 100, 730, 550, mPaint);
            canvas.drawLine(260, 100, 820, 550, mPaint);
            canvas.drawLine(260, 100, 910, 550, mPaint);

            canvas.drawLine(320, 100, 100, 550, mPaint);
            canvas.drawLine(320, 100, 190, 550, mPaint);
            canvas.drawLine(320, 100, 280, 550, mPaint);
            canvas.drawLine(320, 100, 370, 550, mPaint);
            canvas.drawLine(320, 100, 460, 550, mPaint);
            canvas.drawLine(320, 100, 550, 550, mPaint);
            canvas.drawLine(320, 100, 640, 550, mPaint);
            canvas.drawLine(320, 100, 730, 550, mPaint);
            canvas.drawLine(320, 100, 820, 550, mPaint);
            canvas.drawLine(320, 100, 910, 550, mPaint);

            canvas.drawLine(380, 100, 100, 550, mPaint);
            canvas.drawLine(380, 100, 190, 550, mPaint);
            canvas.drawLine(380, 100, 280, 550, mPaint);
            canvas.drawLine(380, 100, 370, 550, mPaint);
            canvas.drawLine(380, 100, 460, 550, mPaint);
            canvas.drawLine(380, 100, 550, 550, mPaint);
            canvas.drawLine(380, 100, 640, 550, mPaint);
            canvas.drawLine(380, 100, 730, 550, mPaint);
            canvas.drawLine(380, 100, 820, 550, mPaint);
            canvas.drawLine(380, 100, 910, 550, mPaint);

            canvas.drawLine(440, 100, 100, 550, mPaint);
            canvas.drawLine(440, 100, 190, 550, mPaint);
            canvas.drawLine(440, 100, 280, 550, mPaint);
            canvas.drawLine(440, 100, 370, 550, mPaint);
            canvas.drawLine(440, 100, 460, 550, mPaint);
            canvas.drawLine(440, 100, 550, 550, mPaint);
            canvas.drawLine(440, 100, 640, 550, mPaint);
            canvas.drawLine(440, 100, 730, 550, mPaint);
            canvas.drawLine(440, 100, 820, 550, mPaint);
            canvas.drawLine(440, 100, 910, 550, mPaint);

            canvas.drawLine(500, 100, 100, 550, mPaint);
            canvas.drawLine(500, 100, 190, 550, mPaint);
            canvas.drawLine(500, 100, 280, 550, mPaint);
            canvas.drawLine(500, 100, 370, 550, mPaint);
            canvas.drawLine(500, 100, 460, 550, mPaint);
            canvas.drawLine(500, 100, 550, 550, mPaint);
            canvas.drawLine(500, 100, 640, 550, mPaint);
            canvas.drawLine(500, 100, 730, 550, mPaint);
            canvas.drawLine(500, 100, 820, 550, mPaint);
            canvas.drawLine(500, 100, 910, 550, mPaint);

            canvas.drawLine(560, 100, 100, 550, mPaint);
            canvas.drawLine(560, 100, 190, 550, mPaint);
            canvas.drawLine(560, 100, 280, 550, mPaint);
            canvas.drawLine(560, 100, 370, 550, mPaint);
            canvas.drawLine(560, 100, 460, 550, mPaint);
            canvas.drawLine(560, 100, 550, 550, mPaint);
            canvas.drawLine(560, 100, 640, 550, mPaint);
            canvas.drawLine(560, 100, 730, 550, mPaint);
            canvas.drawLine(560, 100, 820, 550, mPaint);
            canvas.drawLine(560, 100, 910, 550, mPaint);

            canvas.drawLine(620, 100, 100, 550, mPaint);
            canvas.drawLine(620, 100, 190, 550, mPaint);
            canvas.drawLine(620, 100, 280, 550, mPaint);
            canvas.drawLine(620, 100, 370, 550, mPaint);
            canvas.drawLine(620, 100, 460, 550, mPaint);
            canvas.drawLine(620, 100, 550, 550, mPaint);
            canvas.drawLine(620, 100, 640, 550, mPaint);
            canvas.drawLine(620, 100, 730, 550, mPaint);
            canvas.drawLine(620, 100, 820, 550, mPaint);
            canvas.drawLine(620, 100, 910, 550, mPaint);

            canvas.drawLine(680, 100, 100, 550, mPaint);
            canvas.drawLine(680, 100, 190, 550, mPaint);
            canvas.drawLine(680, 100, 280, 550, mPaint);
            canvas.drawLine(680, 100, 370, 550, mPaint);
            canvas.drawLine(680, 100, 460, 550, mPaint);
            canvas.drawLine(680, 100, 550, 550, mPaint);
            canvas.drawLine(680, 100, 640, 550, mPaint);
            canvas.drawLine(680, 100, 730, 550, mPaint);
            canvas.drawLine(680, 100, 820, 550, mPaint);
            canvas.drawLine(680, 100, 910, 550, mPaint);

            canvas.drawLine(740, 100, 100, 550, mPaint);
            canvas.drawLine(740, 100, 190, 550, mPaint);
            canvas.drawLine(740, 100, 280, 550, mPaint);
            canvas.drawLine(740, 100, 370, 550, mPaint);
            canvas.drawLine(740, 100, 460, 550, mPaint);
            canvas.drawLine(740, 100, 550, 550, mPaint);
            canvas.drawLine(740, 100, 640, 550, mPaint);
            canvas.drawLine(740, 100, 730, 550, mPaint);
            canvas.drawLine(740, 100, 820, 550, mPaint);
            canvas.drawLine(740, 100, 910, 550, mPaint);

            canvas.drawLine(800, 100, 100, 550, mPaint);
            canvas.drawLine(800, 100, 190, 550, mPaint);
            canvas.drawLine(800, 100, 280, 550, mPaint);
            canvas.drawLine(800, 100, 370, 550, mPaint);
            canvas.drawLine(800, 100, 460, 550, mPaint);
            canvas.drawLine(800, 100, 550, 550, mPaint);
            canvas.drawLine(800, 100, 640, 550, mPaint);
            canvas.drawLine(800, 100, 730, 550, mPaint);
            canvas.drawLine(800, 100, 820, 550, mPaint);
            canvas.drawLine(800, 100, 910, 550, mPaint);

            canvas.drawLine(860, 100, 100, 550, mPaint);
            canvas.drawLine(860, 100, 190, 550, mPaint);
            canvas.drawLine(860, 100, 280, 550, mPaint);
            canvas.drawLine(860, 100, 370, 550, mPaint);
            canvas.drawLine(860, 100, 460, 550, mPaint);
            canvas.drawLine(860, 100, 550, 550, mPaint);
            canvas.drawLine(860, 100, 640, 550, mPaint);
            canvas.drawLine(860, 100, 730, 550, mPaint);
            canvas.drawLine(860, 100, 820, 550, mPaint);
            canvas.drawLine(860, 100, 910, 550, mPaint);

            canvas.drawLine(920, 100, 100, 550, mPaint);
            canvas.drawLine(920, 100, 190, 550, mPaint);
            canvas.drawLine(920, 100, 280, 550, mPaint);
            canvas.drawLine(920, 100, 370, 550, mPaint);
            canvas.drawLine(920, 100, 460, 550, mPaint);
            canvas.drawLine(920, 100, 550, 550, mPaint);
            canvas.drawLine(920, 100, 640, 550, mPaint);
            canvas.drawLine(920, 100, 730, 550, mPaint);
            canvas.drawLine(920, 100, 820, 550, mPaint);
            canvas.drawLine(920, 100, 910, 550, mPaint);


            canvas.drawLine(100, 550, 100, 700, mPaint);
            canvas.drawLine(190, 550, 190, 700, mPaint);
            canvas.drawLine(280, 550, 280, 700, mPaint);
            canvas.drawLine(370, 550, 370, 700, mPaint);
            canvas.drawLine(460, 550, 460, 700, mPaint);
            canvas.drawLine(550, 550, 550, 700, mPaint);
            canvas.drawLine(640, 550, 640, 700, mPaint);
            canvas.drawLine(730, 550, 730, 700, mPaint);
            canvas.drawLine(820, 550, 820, 700, mPaint);
            canvas.drawLine(910, 550, 910, 700, mPaint);

            canvas.drawLine(500, 900, 100, 700, mPaint);
            canvas.drawLine(500, 900, 190, 700, mPaint);
            canvas.drawLine(500, 900, 280, 700, mPaint);
            canvas.drawLine(500, 900, 370, 700, mPaint);
            canvas.drawLine(500, 900, 460, 700, mPaint);
            canvas.drawLine(500, 900, 550, 700, mPaint);
            canvas.drawLine(500, 900, 640, 700, mPaint);
            canvas.drawLine(500, 900, 730, 700, mPaint);
            canvas.drawLine(500, 900, 820, 700, mPaint);
            canvas.drawLine(500, 900, 910, 700, mPaint);


            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[0]) mPaint.setColor(Color.RED);
            canvas.drawCircle(53, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[1]) mPaint.setColor(Color.RED);
            canvas.drawCircle(93, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[2]) mPaint.setColor(Color.RED);
            canvas.drawCircle(200, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[3]) mPaint.setColor(Color.RED);
            canvas.drawCircle(260, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[4]) mPaint.setColor(Color.RED);
            canvas.drawCircle(320, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[5]) mPaint.setColor(Color.RED);
            canvas.drawCircle(380, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[6]) mPaint.setColor(Color.RED);
            canvas.drawCircle(440, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[7]) mPaint.setColor(Color.RED);
            canvas.drawCircle(500, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[8]) mPaint.setColor(Color.RED);
            canvas.drawCircle(560, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[9]) mPaint.setColor(Color.RED);
            canvas.drawCircle(620, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[10]) mPaint.setColor(Color.RED);
            canvas.drawCircle(680, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[11]) mPaint.setColor(Color.RED);
            canvas.drawCircle(740, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[12]) mPaint.setColor(Color.RED);
            canvas.drawCircle(800, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[13]) mPaint.setColor(Color.RED);
            canvas.drawCircle(860, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[14]) mPaint.setColor(Color.RED);
            canvas.drawCircle(920, 100, 20, mPaint);

            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.WHITE);
            canvas.drawCircle(100, 550, 40, mPaint);
            canvas.drawCircle(190, 550, 40, mPaint);
            canvas.drawCircle(280, 550, 40, mPaint);
            canvas.drawCircle(370, 550, 40, mPaint);
            canvas.drawCircle(460, 550, 40, mPaint);
            canvas.drawCircle(550, 550, 40, mPaint);
            canvas.drawCircle(640, 550, 40, mPaint);
            canvas.drawCircle(730, 550, 40, mPaint);
            canvas.drawCircle(820, 550, 40, mPaint);
            canvas.drawCircle(910, 550, 40, mPaint);

            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(Color.BLACK);
            canvas.drawCircle(100, 550, 40, mPaint);
            canvas.drawCircle(190, 550, 40, mPaint);
            canvas.drawCircle(280, 550, 40, mPaint);
            canvas.drawCircle(370, 550, 40, mPaint);
            canvas.drawCircle(460, 550, 40, mPaint);
            canvas.drawCircle(550, 550, 40, mPaint);
            canvas.drawCircle(640, 550, 40, mPaint);
            canvas.drawCircle(730, 550, 40, mPaint);
            canvas.drawCircle(820, 550, 40, mPaint);
            canvas.drawCircle(910, 550, 40, mPaint);

            mPaint.setTextSize(40);
            mPaint.setColor(Color.BLACK);
            mPaint.setStyle(Paint.Style.FILL);
            String res;
            if (!bEntersActive[0]) res = "0";
            else res = "1";
            canvas.drawText(res, 67, 60, mPaint);
            if (!bEntersActive[1]) res = "0";
            else res = "1";
            canvas.drawText(res, 127, 60, mPaint);
            if (!bEntersActive[2]) res = "0";
            else res = "1";
            canvas.drawText(res, 187, 60, mPaint);
            if (!bEntersActive[3]) res = "0";
            else res = "1";
            canvas.drawText(res, 247, 60, mPaint);
            if (!bEntersActive[4]) res = "0";
            else res = "1";
            canvas.drawText(res, 307, 60, mPaint);
            if (!bEntersActive[5]) res = "0";
            else res = "1";
            canvas.drawText(res, 367, 60, mPaint);
            if (!bEntersActive[6]) res = "0";
            else res = "1";
            canvas.drawText(res, 427, 60, mPaint);
            if (!bEntersActive[7]) res = "0";
            else res = "1";
            canvas.drawText(res, 487, 60, mPaint);
            if (!bEntersActive[8]) res = "0";
            else res = "1";
            canvas.drawText(res, 547, 60, mPaint);
            if (!bEntersActive[9]) res = "0";
            else res = "1";
            canvas.drawText(res, 607, 60, mPaint);
            if (!bEntersActive[10]) res = "0";
            else res = "1";
            canvas.drawText(res, 667, 60, mPaint);
            if (!bEntersActive[11]) res = "0";
            else res = "1";
            canvas.drawText(res, 727, 60, mPaint);
            if (!bEntersActive[12]) res = "0";
            else res = "1";
            canvas.drawText(res, 787, 60, mPaint);
            if (!bEntersActive[13]) res = "0";
            else res = "1";
            canvas.drawText(res, 847, 60, mPaint);
            if (!bEntersActive[14]) res = "0";
            else res = "1";
            canvas.drawText(res, 907, 60, mPaint);


            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[0]) mPaint.setColor(Color.RED);
            canvas.drawCircle(100, 700, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[1]) mPaint.setColor(Color.RED);
            canvas.drawCircle(190, 700, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[2]) mPaint.setColor(Color.RED);
            canvas.drawCircle(280, 700, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[3]) mPaint.setColor(Color.RED);
            canvas.drawCircle(370, 700, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[4]) mPaint.setColor(Color.RED);
            canvas.drawCircle(460, 700, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[5]) mPaint.setColor(Color.RED);
            canvas.drawCircle(550, 700, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[6]) mPaint.setColor(Color.RED);
            canvas.drawCircle(640, 700, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[7]) mPaint.setColor(Color.RED);
            canvas.drawCircle(730, 700, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[8]) mPaint.setColor(Color.RED);
            canvas.drawCircle(820, 700, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[9]) mPaint.setColor(Color.RED);
            canvas.drawCircle(910, 700, 40, mPaint);

            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.WHITE);
            canvas.drawCircle(500, 900, 60, mPaint);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(Color.BLACK);
            canvas.drawCircle(500, 900, 60, mPaint);

            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.BLACK);
            mPaint.setTextSize(38);
            //String value = Double.toString(dOutersValue[0]);
            String value = new DecimalFormat("#0.00").format(dOutersValue[0]);
            canvas.drawText(value, 62, 562, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[1]);
            canvas.drawText(value, 152, 562, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[2]);
            canvas.drawText(value, 242, 562, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[3]);
            canvas.drawText(value, 332, 562, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[4]);
            canvas.drawText(value, 422, 562, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[5]);
            canvas.drawText(value, 512, 562, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[6]);
            canvas.drawText(value, 602, 562, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[7]);
            canvas.drawText(value, 692, 562, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[8]);
            canvas.drawText(value, 782, 562, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[9]);
            canvas.drawText(value, 872, 562, mPaint);

            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.WHITE);
            mPaint.setTextSize(60);
            canvas.drawText("0", 82, 721, mPaint);
            canvas.drawText("1", 172, 721, mPaint);
            canvas.drawText("2", 262, 721, mPaint);
            canvas.drawText("3", 352, 721, mPaint);
            canvas.drawText("4", 442, 721, mPaint);
            canvas.drawText("5", 532, 721, mPaint);
            canvas.drawText("6", 622, 721, mPaint);
            canvas.drawText("7", 712, 721, mPaint);
            canvas.drawText("8", 802, 721, mPaint);
            canvas.drawText("9", 892, 721, mPaint);

            mPaint.setColor(Color.BLACK);
            mPaint.setTextSize(80);
            canvas.drawText(outerValue, 475, 930, mPaint);

        }
        else{
            mPaint.setAntiAlias(true);

            mPaint.setColor(Color.BLACK);
            canvas.drawLine(80, 100, 100, 450, mPaint);
            canvas.drawLine(80, 100, 200, 450, mPaint);
            canvas.drawLine(80, 100, 300, 450, mPaint);
            canvas.drawLine(80, 100, 400, 450, mPaint);
            canvas.drawLine(80, 100, 500, 450, mPaint);
            canvas.drawLine(80, 100, 600, 450, mPaint);
            canvas.drawLine(80, 100, 700, 450, mPaint);
            canvas.drawLine(80, 100, 800, 450, mPaint);
            canvas.drawLine(80, 100, 900, 450, mPaint);
            canvas.drawLine(80, 100, 1000, 450, mPaint);

            canvas.drawLine(150, 100, 100, 450, mPaint);
            canvas.drawLine(150, 100, 200, 450, mPaint);
            canvas.drawLine(150, 100, 300, 450, mPaint);
            canvas.drawLine(150, 100, 400, 450, mPaint);
            canvas.drawLine(150, 100, 500, 450, mPaint);
            canvas.drawLine(150, 100, 600, 450, mPaint);
            canvas.drawLine(150, 100, 700, 450, mPaint);
            canvas.drawLine(150, 100, 800, 450, mPaint);
            canvas.drawLine(150, 100, 900, 450, mPaint);
            canvas.drawLine(150, 100, 1000, 450, mPaint);

            canvas.drawLine(220, 100, 100, 450, mPaint);
            canvas.drawLine(220, 100, 200, 450, mPaint);
            canvas.drawLine(220, 100, 300, 450, mPaint);
            canvas.drawLine(220, 100, 400, 450, mPaint);
            canvas.drawLine(220, 100, 500, 450, mPaint);
            canvas.drawLine(220, 100, 600, 450, mPaint);
            canvas.drawLine(220, 100, 700, 450, mPaint);
            canvas.drawLine(220, 100, 800, 450, mPaint);
            canvas.drawLine(220, 100, 900, 450, mPaint);
            canvas.drawLine(220, 100, 1000, 450, mPaint);

            canvas.drawLine(290, 100, 100, 450, mPaint);
            canvas.drawLine(290, 100, 200, 450, mPaint);
            canvas.drawLine(290, 100, 300, 450, mPaint);
            canvas.drawLine(290, 100, 400, 450, mPaint);
            canvas.drawLine(290, 100, 500, 450, mPaint);
            canvas.drawLine(290, 100, 600, 450, mPaint);
            canvas.drawLine(290, 100, 700, 450, mPaint);
            canvas.drawLine(290, 100, 800, 450, mPaint);
            canvas.drawLine(290, 100, 900, 450, mPaint);
            canvas.drawLine(290, 100, 1000, 450, mPaint);

            canvas.drawLine(360, 100, 100, 450, mPaint);
            canvas.drawLine(360, 100, 200, 450, mPaint);
            canvas.drawLine(360, 100, 300, 450, mPaint);
            canvas.drawLine(360, 100, 400, 450, mPaint);
            canvas.drawLine(360, 100, 500, 450, mPaint);
            canvas.drawLine(360, 100, 600, 450, mPaint);
            canvas.drawLine(360, 100, 700, 450, mPaint);
            canvas.drawLine(360, 100, 800, 450, mPaint);
            canvas.drawLine(360, 100, 900, 450, mPaint);
            canvas.drawLine(360, 100, 1000, 450, mPaint);

            canvas.drawLine(430, 100, 100, 450, mPaint);
            canvas.drawLine(430, 100, 200, 450, mPaint);
            canvas.drawLine(430, 100, 300, 450, mPaint);
            canvas.drawLine(430, 100, 400, 450, mPaint);
            canvas.drawLine(430, 100, 500, 450, mPaint);
            canvas.drawLine(430, 100, 600, 450, mPaint);
            canvas.drawLine(430, 100, 700, 450, mPaint);
            canvas.drawLine(430, 100, 800, 450, mPaint);
            canvas.drawLine(430, 100, 900, 450, mPaint);
            canvas.drawLine(430, 100, 1000, 450, mPaint);

            canvas.drawLine(500, 100, 100, 450, mPaint);
            canvas.drawLine(500, 100, 200, 450, mPaint);
            canvas.drawLine(500, 100, 300, 450, mPaint);
            canvas.drawLine(500, 100, 400, 450, mPaint);
            canvas.drawLine(500, 100, 500, 450, mPaint);
            canvas.drawLine(500, 100, 600, 450, mPaint);
            canvas.drawLine(500, 100, 700, 450, mPaint);
            canvas.drawLine(500, 100, 800, 450, mPaint);
            canvas.drawLine(500, 100, 900, 450, mPaint);
            canvas.drawLine(500, 100, 1000, 450, mPaint);

            canvas.drawLine(570, 100, 100, 450, mPaint);
            canvas.drawLine(570, 100, 200, 450, mPaint);
            canvas.drawLine(570, 100, 300, 450, mPaint);
            canvas.drawLine(570, 100, 400, 450, mPaint);
            canvas.drawLine(570, 100, 500, 450, mPaint);
            canvas.drawLine(570, 100, 600, 450, mPaint);
            canvas.drawLine(570, 100, 700, 450, mPaint);
            canvas.drawLine(570, 100, 800, 450, mPaint);
            canvas.drawLine(570, 100, 900, 450, mPaint);
            canvas.drawLine(570, 100, 1000, 450, mPaint);

            canvas.drawLine(640, 100, 100, 450, mPaint);
            canvas.drawLine(640, 100, 200, 450, mPaint);
            canvas.drawLine(640, 100, 300, 450, mPaint);
            canvas.drawLine(640, 100, 400, 450, mPaint);
            canvas.drawLine(640, 100, 500, 450, mPaint);
            canvas.drawLine(640, 100, 600, 450, mPaint);
            canvas.drawLine(640, 100, 700, 450, mPaint);
            canvas.drawLine(640, 100, 800, 450, mPaint);
            canvas.drawLine(640, 100, 900, 450, mPaint);
            canvas.drawLine(640, 100, 1000, 450, mPaint);

            canvas.drawLine(710, 100, 100, 450, mPaint);
            canvas.drawLine(710, 100, 200, 450, mPaint);
            canvas.drawLine(710, 100, 300, 450, mPaint);
            canvas.drawLine(710, 100, 400, 450, mPaint);
            canvas.drawLine(710, 100, 500, 450, mPaint);
            canvas.drawLine(710, 100, 600, 450, mPaint);
            canvas.drawLine(710, 100, 700, 450, mPaint);
            canvas.drawLine(710, 100, 800, 450, mPaint);
            canvas.drawLine(710, 100, 900, 450, mPaint);
            canvas.drawLine(710, 100, 1000, 450, mPaint);

            canvas.drawLine(780, 100, 100, 450, mPaint);
            canvas.drawLine(780, 100, 200, 450, mPaint);
            canvas.drawLine(780, 100, 300, 450, mPaint);
            canvas.drawLine(780, 100, 400, 450, mPaint);
            canvas.drawLine(780, 100, 500, 450, mPaint);
            canvas.drawLine(780, 100, 600, 450, mPaint);
            canvas.drawLine(780, 100, 700, 450, mPaint);
            canvas.drawLine(780, 100, 800, 450, mPaint);
            canvas.drawLine(780, 100, 900, 450, mPaint);
            canvas.drawLine(780, 100, 1000, 450, mPaint);

            canvas.drawLine(850, 100, 100, 450, mPaint);
            canvas.drawLine(850, 100, 200, 450, mPaint);
            canvas.drawLine(850, 100, 300, 450, mPaint);
            canvas.drawLine(850, 100, 400, 450, mPaint);
            canvas.drawLine(850, 100, 500, 450, mPaint);
            canvas.drawLine(850, 100, 600, 450, mPaint);
            canvas.drawLine(850, 100, 700, 450, mPaint);
            canvas.drawLine(850, 100, 800, 450, mPaint);
            canvas.drawLine(850, 100, 900, 450, mPaint);
            canvas.drawLine(850, 100, 1000, 450, mPaint);

            canvas.drawLine(920, 100, 100, 450, mPaint);
            canvas.drawLine(920, 100, 200, 450, mPaint);
            canvas.drawLine(920, 100, 300, 450, mPaint);
            canvas.drawLine(920, 100, 400, 450, mPaint);
            canvas.drawLine(920, 100, 500, 450, mPaint);
            canvas.drawLine(920, 100, 600, 450, mPaint);
            canvas.drawLine(920, 100, 700, 450, mPaint);
            canvas.drawLine(920, 100, 800, 450, mPaint);
            canvas.drawLine(920, 100, 900, 450, mPaint);
            canvas.drawLine(920, 100, 1000, 450, mPaint);

            canvas.drawLine(990, 100, 100, 450, mPaint);
            canvas.drawLine(990, 100, 200, 450, mPaint);
            canvas.drawLine(990, 100, 300, 450, mPaint);
            canvas.drawLine(990, 100, 400, 450, mPaint);
            canvas.drawLine(990, 100, 500, 450, mPaint);
            canvas.drawLine(990, 100, 600, 450, mPaint);
            canvas.drawLine(990, 100, 700, 450, mPaint);
            canvas.drawLine(990, 100, 800, 450, mPaint);
            canvas.drawLine(990, 100, 900, 450, mPaint);
            canvas.drawLine(990, 100, 1000, 450, mPaint);

            canvas.drawLine(1060, 100, 100, 450, mPaint);
            canvas.drawLine(1060, 100, 200, 450, mPaint);
            canvas.drawLine(1060, 100, 300, 450, mPaint);
            canvas.drawLine(1060, 100, 400, 450, mPaint);
            canvas.drawLine(1060, 100, 500, 450, mPaint);
            canvas.drawLine(1060, 100, 600, 450, mPaint);
            canvas.drawLine(1060, 100, 700, 450, mPaint);
            canvas.drawLine(1060, 100, 800, 450, mPaint);
            canvas.drawLine(1060, 100, 900, 450, mPaint);
            canvas.drawLine(1060, 100, 1000, 450, mPaint);


            canvas.drawLine(100, 450, 100, 570, mPaint);
            canvas.drawLine(200, 450, 200, 570, mPaint);
            canvas.drawLine(300, 450, 300, 570, mPaint);
            canvas.drawLine(400, 450, 400, 570, mPaint);
            canvas.drawLine(500, 450, 500, 570, mPaint);
            canvas.drawLine(600, 450, 600, 570, mPaint);
            canvas.drawLine(700, 450, 700, 570, mPaint);
            canvas.drawLine(800, 450, 800, 570, mPaint);
            canvas.drawLine(900, 450, 900, 570, mPaint);
            canvas.drawLine(1000, 450, 1000, 570, mPaint);

            canvas.drawLine(570, 730, 100, 570, mPaint);
            canvas.drawLine(570, 730, 200, 570, mPaint);
            canvas.drawLine(570, 730, 300, 570, mPaint);
            canvas.drawLine(570, 730, 400, 570, mPaint);
            canvas.drawLine(570, 730, 500, 570, mPaint);
            canvas.drawLine(570, 730, 600, 570, mPaint);
            canvas.drawLine(570, 730, 700, 570, mPaint);
            canvas.drawLine(570, 730, 800, 570, mPaint);
            canvas.drawLine(570, 730, 900, 570, mPaint);
            canvas.drawLine(570, 730, 1000, 570, mPaint);


            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[0]) mPaint.setColor(Color.RED);
            canvas.drawCircle(80, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[1]) mPaint.setColor(Color.RED);
            canvas.drawCircle(150, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[2]) mPaint.setColor(Color.RED);
            canvas.drawCircle(220, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[3]) mPaint.setColor(Color.RED);
            canvas.drawCircle(290, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[4]) mPaint.setColor(Color.RED);
            canvas.drawCircle(360, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[5]) mPaint.setColor(Color.RED);
            canvas.drawCircle(430, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[6]) mPaint.setColor(Color.RED);
            canvas.drawCircle(500, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[7]) mPaint.setColor(Color.RED);
            canvas.drawCircle(570, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[8]) mPaint.setColor(Color.RED);
            canvas.drawCircle(640, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[9]) mPaint.setColor(Color.RED);
            canvas.drawCircle(710, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[10]) mPaint.setColor(Color.RED);
            canvas.drawCircle(780, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[11]) mPaint.setColor(Color.RED);
            canvas.drawCircle(850, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[12]) mPaint.setColor(Color.RED);
            canvas.drawCircle(920, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[13]) mPaint.setColor(Color.RED);
            canvas.drawCircle(990, 100, 20, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bEntersActive[14]) mPaint.setColor(Color.RED);
            canvas.drawCircle(1060, 100, 20, mPaint);

            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.WHITE);
            canvas.drawCircle(100, 450, 40, mPaint);
            canvas.drawCircle(200, 450, 40, mPaint);
            canvas.drawCircle(300, 450, 40, mPaint);
            canvas.drawCircle(400, 450, 40, mPaint);
            canvas.drawCircle(500, 450, 40, mPaint);
            canvas.drawCircle(600, 450, 40, mPaint);
            canvas.drawCircle(700, 450, 40, mPaint);
            canvas.drawCircle(800, 450, 40, mPaint);
            canvas.drawCircle(900, 450, 40, mPaint);
            canvas.drawCircle(1000, 450, 40, mPaint);

            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(Color.BLACK);
            canvas.drawCircle(100, 450, 40, mPaint);
            canvas.drawCircle(200, 450, 40, mPaint);
            canvas.drawCircle(300, 450, 40, mPaint);
            canvas.drawCircle(400, 450, 40, mPaint);
            canvas.drawCircle(500, 450, 40, mPaint);
            canvas.drawCircle(600, 450, 40, mPaint);
            canvas.drawCircle(700, 450, 40, mPaint);
            canvas.drawCircle(800, 450, 40, mPaint);
            canvas.drawCircle(900, 450, 40, mPaint);
            canvas.drawCircle(1000, 450, 40, mPaint);

            mPaint.setTextSize(40);
            mPaint.setColor(Color.BLACK);
            mPaint.setStyle(Paint.Style.FILL);
            String res;
            if (!bEntersActive[0]) res = "0";
            else res = "1";
            canvas.drawText(res, 67, 60, mPaint);
            if (!bEntersActive[1]) res = "0";
            else res = "1";
            canvas.drawText(res, 137, 60, mPaint);
            if (!bEntersActive[2]) res = "0";
            else res = "1";
            canvas.drawText(res, 207, 60, mPaint);
            if (!bEntersActive[3]) res = "0";
            else res = "1";
            canvas.drawText(res, 277, 60, mPaint);
            if (!bEntersActive[4]) res = "0";
            else res = "1";
            canvas.drawText(res, 347, 60, mPaint);
            if (!bEntersActive[5]) res = "0";
            else res = "1";
            canvas.drawText(res, 407, 60, mPaint);
            if (!bEntersActive[6]) res = "0";
            else res = "1";
            canvas.drawText(res, 487, 60, mPaint);
            if (!bEntersActive[7]) res = "0";
            else res = "1";
            canvas.drawText(res, 557, 60, mPaint);
            if (!bEntersActive[8]) res = "0";
            else res = "1";
            canvas.drawText(res, 627, 60, mPaint);
            if (!bEntersActive[9]) res = "0";
            else res = "1";
            canvas.drawText(res, 697, 60, mPaint);
            if (!bEntersActive[10]) res = "0";
            else res = "1";
            canvas.drawText(res, 767, 60, mPaint);
            if (!bEntersActive[11]) res = "0";
            else res = "1";
            canvas.drawText(res, 837, 60, mPaint);
            if (!bEntersActive[12]) res = "0";
            else res = "1";
            canvas.drawText(res, 907, 60, mPaint);
            if (!bEntersActive[13]) res = "0";
            else res = "1";
            canvas.drawText(res, 977, 60, mPaint);
            if (!bEntersActive[14]) res = "0";
            else res = "1";
            canvas.drawText(res, 1047, 60, mPaint);


            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[0]) mPaint.setColor(Color.RED);
            canvas.drawCircle(100, 570, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[1]) mPaint.setColor(Color.RED);
            canvas.drawCircle(200, 570, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[2]) mPaint.setColor(Color.RED);
            canvas.drawCircle(300, 570, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[3]) mPaint.setColor(Color.RED);
            canvas.drawCircle(400, 570, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[4]) mPaint.setColor(Color.RED);
            canvas.drawCircle(500, 570, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[5]) mPaint.setColor(Color.RED);
            canvas.drawCircle(600, 570, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[6]) mPaint.setColor(Color.RED);
            canvas.drawCircle(700, 570, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[7]) mPaint.setColor(Color.RED);
            canvas.drawCircle(800, 570, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[8]) mPaint.setColor(Color.RED);
            canvas.drawCircle(900, 570, 40, mPaint);
            mPaint.setColor(Color.BLUE);
            if (bOutersActive[9]) mPaint.setColor(Color.RED);
            canvas.drawCircle(1000, 570, 40, mPaint);

            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.WHITE);
            canvas.drawCircle(570, 730, 60, mPaint);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(Color.BLACK);
            canvas.drawCircle(570, 730, 60, mPaint);


            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.BLACK);
            mPaint.setTextSize(38);
            //String value = Double.toString(dOutersValue[0]);
            String value = new DecimalFormat("#0.00").format(dOutersValue[0]);
            canvas.drawText(value, 62, 462, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[1]);
            canvas.drawText(value, 162, 462, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[2]);
            canvas.drawText(value, 262, 462, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[3]);
            canvas.drawText(value, 362, 462, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[4]);
            canvas.drawText(value, 462, 462, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[5]);
            canvas.drawText(value, 562, 462, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[6]);
            canvas.drawText(value, 662, 462, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[7]);
            canvas.drawText(value, 762, 462, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[8]);
            canvas.drawText(value, 862, 462, mPaint);
            value = new DecimalFormat("#0.00").format(dOutersValue[9]);
            canvas.drawText(value, 962, 462, mPaint);

            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.WHITE);
            mPaint.setTextSize(60);
            canvas.drawText("0", 82, 591, mPaint);
            canvas.drawText("1", 182, 591, mPaint);
            canvas.drawText("2", 282, 591, mPaint);
            canvas.drawText("3", 382, 591, mPaint);
            canvas.drawText("4", 482, 591, mPaint);
            canvas.drawText("5", 582, 591, mPaint);
            canvas.drawText("6", 682, 591, mPaint);
            canvas.drawText("7", 782, 591, mPaint);
            canvas.drawText("8", 882, 591, mPaint);
            canvas.drawText("9", 982, 591, mPaint);

            mPaint.setColor(Color.BLACK);
            mPaint.setTextSize(80);
            canvas.drawText(outerValue, 545, 760, mPaint);

        }
        */
    }
}
