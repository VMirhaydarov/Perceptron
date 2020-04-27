package com.example.perceptron;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.text.DecimalFormat;

public class Draw2D extends View {

    private Paint mPaint;
    boolean[] bEntersActive;
    boolean[] bOutersActive;
    String outerValue;
    double[] dOutersValue;

    public Draw2D(Context context) {
        super(context);
        init();
    }

    public Draw2D(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Draw2D(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setAntiAlias(true);

        mPaint.setColor(Color.BLACK);
        canvas.drawLine(80,100,100,550,mPaint);
        canvas.drawLine(80,100,190,550,mPaint);
        canvas.drawLine(80,100,280,550,mPaint);
        canvas.drawLine(80,100,370,550,mPaint);
        canvas.drawLine(80,100,460,550,mPaint);
        canvas.drawLine(80,100,550,550,mPaint);
        canvas.drawLine(80,100,640,550,mPaint);
        canvas.drawLine(80,100,730,550,mPaint);
        canvas.drawLine(80,100,820,550,mPaint);
        canvas.drawLine(80,100,910,550,mPaint);

        canvas.drawLine(140,100,100,550,mPaint);
        canvas.drawLine(140,100,190,550,mPaint);
        canvas.drawLine(140,100,280,550,mPaint);
        canvas.drawLine(140,100,370,550,mPaint);
        canvas.drawLine(140,100,460,550,mPaint);
        canvas.drawLine(140,100,550,550,mPaint);
        canvas.drawLine(140,100,640,550,mPaint);
        canvas.drawLine(140,100,730,550,mPaint);
        canvas.drawLine(140,100,820,550,mPaint);
        canvas.drawLine(140,100,910,550,mPaint);

        canvas.drawLine(200,100,100,550,mPaint);
        canvas.drawLine(200,100,190,550,mPaint);
        canvas.drawLine(200,100,280,550,mPaint);
        canvas.drawLine(200,100,370,550,mPaint);
        canvas.drawLine(200,100,460,550,mPaint);
        canvas.drawLine(200,100,550,550,mPaint);
        canvas.drawLine(200,100,640,550,mPaint);
        canvas.drawLine(200,100,730,550,mPaint);
        canvas.drawLine(200,100,820,550,mPaint);
        canvas.drawLine(200,100,910,550,mPaint);

        canvas.drawLine(260,100,100,550,mPaint);
        canvas.drawLine(260,100,190,550,mPaint);
        canvas.drawLine(260,100,280,550,mPaint);
        canvas.drawLine(260,100,370,550,mPaint);
        canvas.drawLine(260,100,460,550,mPaint);
        canvas.drawLine(260,100,550,550,mPaint);
        canvas.drawLine(260,100,640,550,mPaint);
        canvas.drawLine(260,100,730,550,mPaint);
        canvas.drawLine(260,100,820,550,mPaint);
        canvas.drawLine(260,100,910,550,mPaint);

        canvas.drawLine(320,100,100,550,mPaint);
        canvas.drawLine(320,100,190,550,mPaint);
        canvas.drawLine(320,100,280,550,mPaint);
        canvas.drawLine(320,100,370,550,mPaint);
        canvas.drawLine(320,100,460,550,mPaint);
        canvas.drawLine(320,100,550,550,mPaint);
        canvas.drawLine(320,100,640,550,mPaint);
        canvas.drawLine(320,100,730,550,mPaint);
        canvas.drawLine(320,100,820,550,mPaint);
        canvas.drawLine(320,100,910,550,mPaint);

        canvas.drawLine(380,100,100,550,mPaint);
        canvas.drawLine(380,100,190,550,mPaint);
        canvas.drawLine(380,100,280,550,mPaint);
        canvas.drawLine(380,100,370,550,mPaint);
        canvas.drawLine(380,100,460,550,mPaint);
        canvas.drawLine(380,100,550,550,mPaint);
        canvas.drawLine(380,100,640,550,mPaint);
        canvas.drawLine(380,100,730,550,mPaint);
        canvas.drawLine(380,100,820,550,mPaint);
        canvas.drawLine(380,100,910,550,mPaint);

        canvas.drawLine(440,100,100,550,mPaint);
        canvas.drawLine(440,100,190,550,mPaint);
        canvas.drawLine(440,100,280,550,mPaint);
        canvas.drawLine(440,100,370,550,mPaint);
        canvas.drawLine(440,100,460,550,mPaint);
        canvas.drawLine(440,100,550,550,mPaint);
        canvas.drawLine(440,100,640,550,mPaint);
        canvas.drawLine(440,100,730,550,mPaint);
        canvas.drawLine(440,100,820,550,mPaint);
        canvas.drawLine(440,100,910,550,mPaint);

        canvas.drawLine(500,100,100,550,mPaint);
        canvas.drawLine(500,100,190,550,mPaint);
        canvas.drawLine(500,100,280,550,mPaint);
        canvas.drawLine(500,100,370,550,mPaint);
        canvas.drawLine(500,100,460,550,mPaint);
        canvas.drawLine(500,100,550,550,mPaint);
        canvas.drawLine(500,100,640,550,mPaint);
        canvas.drawLine(500,100,730,550,mPaint);
        canvas.drawLine(500,100,820,550,mPaint);
        canvas.drawLine(500,100,910,550,mPaint);

        canvas.drawLine(560,100,100,550,mPaint);
        canvas.drawLine(560,100,190,550,mPaint);
        canvas.drawLine(560,100,280,550,mPaint);
        canvas.drawLine(560,100,370,550,mPaint);
        canvas.drawLine(560,100,460,550,mPaint);
        canvas.drawLine(560,100,550,550,mPaint);
        canvas.drawLine(560,100,640,550,mPaint);
        canvas.drawLine(560,100,730,550,mPaint);
        canvas.drawLine(560,100,820,550,mPaint);
        canvas.drawLine(560,100,910,550,mPaint);

        canvas.drawLine(620,100,100,550,mPaint);
        canvas.drawLine(620,100,190,550,mPaint);
        canvas.drawLine(620,100,280,550,mPaint);
        canvas.drawLine(620,100,370,550,mPaint);
        canvas.drawLine(620,100,460,550,mPaint);
        canvas.drawLine(620,100,550,550,mPaint);
        canvas.drawLine(620,100,640,550,mPaint);
        canvas.drawLine(620,100,730,550,mPaint);
        canvas.drawLine(620,100,820,550,mPaint);
        canvas.drawLine(620,100,910,550,mPaint);

        canvas.drawLine(680,100,100,550,mPaint);
        canvas.drawLine(680,100,190,550,mPaint);
        canvas.drawLine(680,100,280,550,mPaint);
        canvas.drawLine(680,100,370,550,mPaint);
        canvas.drawLine(680,100,460,550,mPaint);
        canvas.drawLine(680,100,550,550,mPaint);
        canvas.drawLine(680,100,640,550,mPaint);
        canvas.drawLine(680,100,730,550,mPaint);
        canvas.drawLine(680,100,820,550,mPaint);
        canvas.drawLine(680,100,910,550,mPaint);

        canvas.drawLine(740,100,100,550,mPaint);
        canvas.drawLine(740,100,190,550,mPaint);
        canvas.drawLine(740,100,280,550,mPaint);
        canvas.drawLine(740,100,370,550,mPaint);
        canvas.drawLine(740,100,460,550,mPaint);
        canvas.drawLine(740,100,550,550,mPaint);
        canvas.drawLine(740,100,640,550,mPaint);
        canvas.drawLine(740,100,730,550,mPaint);
        canvas.drawLine(740,100,820,550,mPaint);
        canvas.drawLine(740,100,910,550,mPaint);

        canvas.drawLine(800,100,100,550,mPaint);
        canvas.drawLine(800,100,190,550,mPaint);
        canvas.drawLine(800,100,280,550,mPaint);
        canvas.drawLine(800,100,370,550,mPaint);
        canvas.drawLine(800,100,460,550,mPaint);
        canvas.drawLine(800,100,550,550,mPaint);
        canvas.drawLine(800,100,640,550,mPaint);
        canvas.drawLine(800,100,730,550,mPaint);
        canvas.drawLine(800,100,820,550,mPaint);
        canvas.drawLine(800,100,910,550,mPaint);

        canvas.drawLine(860,100,100,550,mPaint);
        canvas.drawLine(860,100,190,550,mPaint);
        canvas.drawLine(860,100,280,550,mPaint);
        canvas.drawLine(860,100,370,550,mPaint);
        canvas.drawLine(860,100,460,550,mPaint);
        canvas.drawLine(860,100,550,550,mPaint);
        canvas.drawLine(860,100,640,550,mPaint);
        canvas.drawLine(860,100,730,550,mPaint);
        canvas.drawLine(860,100,820,550,mPaint);
        canvas.drawLine(860,100,910,550,mPaint);

        canvas.drawLine(920,100,100,550,mPaint);
        canvas.drawLine(920,100,190,550,mPaint);
        canvas.drawLine(920,100,280,550,mPaint);
        canvas.drawLine(920,100,370,550,mPaint);
        canvas.drawLine(920,100,460,550,mPaint);
        canvas.drawLine(920,100,550,550,mPaint);
        canvas.drawLine(920,100,640,550,mPaint);
        canvas.drawLine(920,100,730,550,mPaint);
        canvas.drawLine(920,100,820,550,mPaint);
        canvas.drawLine(920,100,910,550,mPaint);


        canvas.drawLine(100,550,100,700,mPaint);
        canvas.drawLine(190,550,190,700,mPaint);
        canvas.drawLine(280,550,280,700,mPaint);
        canvas.drawLine(370,550,370,700,mPaint);
        canvas.drawLine(460,550,460,700,mPaint);
        canvas.drawLine(550,550,550,700,mPaint);
        canvas.drawLine(640,550,640,700,mPaint);
        canvas.drawLine(730,550,730,700,mPaint);
        canvas.drawLine(820,550,820,700,mPaint);
        canvas.drawLine(910,550,910,700,mPaint);

        canvas.drawLine(500,900,100,700,mPaint);
        canvas.drawLine(500,900,190,700,mPaint);
        canvas.drawLine(500,900,280,700,mPaint);
        canvas.drawLine(500,900,370,700,mPaint);
        canvas.drawLine(500,900,460,700,mPaint);
        canvas.drawLine(500,900,550,700,mPaint);
        canvas.drawLine(500,900,640,700,mPaint);
        canvas.drawLine(500,900,730,700,mPaint);
        canvas.drawLine(500,900,820,700,mPaint);
        canvas.drawLine(500,900,910,700,mPaint);


        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        if (bEntersActive[0]) mPaint.setColor(Color.RED);
        canvas.drawCircle(80,100,20,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bEntersActive[1]) mPaint.setColor(Color.RED);
        canvas.drawCircle(140,100,20,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bEntersActive[2]) mPaint.setColor(Color.RED);
        canvas.drawCircle(200,100,20,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bEntersActive[3]) mPaint.setColor(Color.RED);
        canvas.drawCircle(260,100,20,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bEntersActive[4]) mPaint.setColor(Color.RED);
        canvas.drawCircle(320,100,20,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bEntersActive[5]) mPaint.setColor(Color.RED);
        canvas.drawCircle(380,100,20,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bEntersActive[6]) mPaint.setColor(Color.RED);
        canvas.drawCircle(440,100,20,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bEntersActive[7]) mPaint.setColor(Color.RED);
        canvas.drawCircle(500,100,20,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bEntersActive[8]) mPaint.setColor(Color.RED);
        canvas.drawCircle(560,100,20,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bEntersActive[9]) mPaint.setColor(Color.RED);
        canvas.drawCircle(620,100,20,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bEntersActive[10]) mPaint.setColor(Color.RED);
        canvas.drawCircle(680,100,20,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bEntersActive[11]) mPaint.setColor(Color.RED);
        canvas.drawCircle(740,100,20,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bEntersActive[12]) mPaint.setColor(Color.RED);
        canvas.drawCircle(800,100,20,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bEntersActive[13]) mPaint.setColor(Color.RED);
        canvas.drawCircle(860,100,20,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bEntersActive[14]) mPaint.setColor(Color.RED);
        canvas.drawCircle(920,100,20,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(100,550,40,mPaint);
        canvas.drawCircle(190,550,40,mPaint);
        canvas.drawCircle(280,550,40,mPaint);
        canvas.drawCircle(370,550,40,mPaint);
        canvas.drawCircle(460,550,40,mPaint);
        canvas.drawCircle(550,550,40,mPaint);
        canvas.drawCircle(640,550,40,mPaint);
        canvas.drawCircle(730,550,40,mPaint);
        canvas.drawCircle(820,550,40,mPaint);
        canvas.drawCircle(910,550,40,mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(100,550,40,mPaint);
        canvas.drawCircle(190,550,40,mPaint);
        canvas.drawCircle(280,550,40,mPaint);
        canvas.drawCircle(370,550,40,mPaint);
        canvas.drawCircle(460,550,40,mPaint);
        canvas.drawCircle(550,550,40,mPaint);
        canvas.drawCircle(640,550,40,mPaint);
        canvas.drawCircle(730,550,40,mPaint);
        canvas.drawCircle(820,550,40,mPaint);
        canvas.drawCircle(910,550,40,mPaint);

        mPaint.setTextSize(40);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        String res;
        if (!bEntersActive[0]) res = "0";
        else res = "1";
        canvas.drawText(res,67,60,mPaint);
        if (!bEntersActive[1]) res = "0";
        else res = "1";
        canvas.drawText(res,127,60,mPaint);
        if (!bEntersActive[2]) res = "0";
        else res = "1";
        canvas.drawText(res,187,60,mPaint);
        if (!bEntersActive[3]) res = "0";
        else res = "1";
        canvas.drawText(res,247,60,mPaint);
        if (!bEntersActive[4]) res = "0";
        else res = "1";
        canvas.drawText(res,307,60,mPaint);
        if (!bEntersActive[5]) res = "0";
        else res = "1";
        canvas.drawText(res,367,60,mPaint);
        if (!bEntersActive[6]) res = "0";
        else res = "1";
        canvas.drawText(res,427,60,mPaint);
        if (!bEntersActive[7]) res = "0";
        else res = "1";
        canvas.drawText(res,487,60,mPaint);
        if (!bEntersActive[8]) res = "0";
        else res = "1";
        canvas.drawText(res,547,60,mPaint);
        if (!bEntersActive[9]) res = "0";
        else res = "1";
        canvas.drawText(res,607,60,mPaint);
        if (!bEntersActive[10]) res = "0";
        else res = "1";
        canvas.drawText(res,667,60,mPaint);
        if (!bEntersActive[11]) res = "0";
        else res = "1";
        canvas.drawText(res,727,60,mPaint);
        if (!bEntersActive[12]) res = "0";
        else res = "1";
        canvas.drawText(res,787,60,mPaint);
        if (!bEntersActive[13]) res = "0";
        else res = "1";
        canvas.drawText(res,847,60,mPaint);
        if (!bEntersActive[14]) res = "0";
        else res = "1";
        canvas.drawText(res,907,60,mPaint);


        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        if (bOutersActive[0]) mPaint.setColor(Color.RED);
        canvas.drawCircle(100,700,40,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bOutersActive[1]) mPaint.setColor(Color.RED);
        canvas.drawCircle(190,700,40,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bOutersActive[2]) mPaint.setColor(Color.RED);
        canvas.drawCircle(280,700,40,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bOutersActive[3]) mPaint.setColor(Color.RED);
        canvas.drawCircle(370,700,40,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bOutersActive[4]) mPaint.setColor(Color.RED);
        canvas.drawCircle(460,700,40,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bOutersActive[5]) mPaint.setColor(Color.RED);
        canvas.drawCircle(550,700,40,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bOutersActive[6]) mPaint.setColor(Color.RED);
        canvas.drawCircle(640,700,40,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bOutersActive[7]) mPaint.setColor(Color.RED);
        canvas.drawCircle(730,700,40,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bOutersActive[8]) mPaint.setColor(Color.RED);
        canvas.drawCircle(820,700,40,mPaint);
        mPaint.setColor(Color.BLUE);
        if (bOutersActive[9]) mPaint.setColor(Color.RED);
        canvas.drawCircle(910,700,40,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(500,900,60,mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(500,900,60,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(38);
        //String value = Double.toString(dOutersValue[0]);
        String value = new DecimalFormat("#0.00").format(dOutersValue[0]);
        canvas.drawText(value,62,562,mPaint);
        value = new DecimalFormat("#0.00").format(dOutersValue[1]);
        canvas.drawText(value,152,562,mPaint);
        value = new DecimalFormat("#0.00").format(dOutersValue[2]);
        canvas.drawText(value,242,562,mPaint);
        value = new DecimalFormat("#0.00").format(dOutersValue[3]);
        canvas.drawText(value,332,562,mPaint);
        value = new DecimalFormat("#0.00").format(dOutersValue[4]);
        canvas.drawText(value,422,562,mPaint);
        value = new DecimalFormat("#0.00").format(dOutersValue[5]);
        canvas.drawText(value,512,562,mPaint);
        value = new DecimalFormat("#0.00").format(dOutersValue[6]);
        canvas.drawText(value,602,562,mPaint);
        value = new DecimalFormat("#0.00").format(dOutersValue[7]);
        canvas.drawText(value,692,562,mPaint);
        value = new DecimalFormat("#0.00").format(dOutersValue[8]);
        canvas.drawText(value,782,562,mPaint);
        value = new DecimalFormat("#0.00").format(dOutersValue[9]);
        canvas.drawText(value,872,562,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(60);
        canvas.drawText("0",82,721,mPaint);
        canvas.drawText("1",172,721,mPaint);
        canvas.drawText("2",262,721,mPaint);
        canvas.drawText("3",352,721,mPaint);
        canvas.drawText("4",442,721,mPaint);
        canvas.drawText("5",532,721,mPaint);
        canvas.drawText("6",622,721,mPaint);
        canvas.drawText("7",712,721,mPaint);
        canvas.drawText("8",802,721,mPaint);
        canvas.drawText("9",892,721,mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(80);
        canvas.drawText(outerValue,475,930,mPaint);
    }
}
