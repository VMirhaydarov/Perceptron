package com.example.perceptron;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //PerceptronOne perceptron;
    PerceptronTwo perceptron;

    TextView tvStatusValue ;
    TextView tvIterationsValue;
    Button btnStudyRight;
    Button btnStudyWrong;
    Draw2D draw2D;

    Integer Num;
    Integer iterations;
    Button btnClear;
    Button btn11;
    boolean btn11pressed;
    Button btn12;
    boolean btn12pressed;
    Button btn13;
    boolean btn13pressed;
    Button btn21;
    boolean btn21pressed;
    Button btn22;
    boolean btn22pressed;
    Button btn23;
    boolean btn23pressed;
    Button btn31;
    boolean btn31pressed;
    Button btn32;
    boolean btn32pressed;
    Button btn33;
    boolean btn33pressed;
    Button btn41;
    boolean btn41pressed;
    Button btn42;
    boolean btn42pressed;
    Button btn43;
    boolean btn43pressed;
    Button btn51;
    boolean btn51pressed;
    Button btn52;
    boolean btn52pressed;
    Button btn53;
    boolean btn53pressed;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_about:
                Intent intent = new Intent(this, ActivityAbout.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //perceptron = new PerceptronOne();
        perceptron = new PerceptronTwo();

        tvStatusValue = findViewById(R.id.tv_status_value);
        tvIterationsValue = findViewById(R.id.tv_iterations_value);
        draw2D = findViewById(R.id.draw2D);

        btnClear = findViewById(R.id.btn_clear);
        btnStudyRight = findViewById(R.id.btn_study_right);
        btnStudyRight.setEnabled(false);
        btnStudyWrong = findViewById(R.id.btn_study_wrong);
        btnStudyWrong.setEnabled(false);

        tvStatusValue.setText(R.string.tv_status_value_studying);

        //Calculation obj = new Calculation();
        //obj.start();
        iterations = perceptron.study();

        tvStatusValue.setText(R.string.tv_status_value_study_ok);
        String temp = iterations.toString();
        tvIterationsValue.setText(temp);


        btn11 = findViewById(R.id.btn_1_1);
        btn11pressed = false;
        btn12 = findViewById(R.id.btn_1_2);
        btn12pressed = false;
        btn13 = findViewById(R.id.btn_1_3);
        btn13pressed = false;
        btn21 = findViewById(R.id.btn_2_1);
        btn21pressed = false;
        btn22 = findViewById(R.id.btn_2_2);
        btn22pressed = false;
        btn23 = findViewById(R.id.btn_2_3);
        btn23pressed = false;
        btn31 = findViewById(R.id.btn_3_1);
        btn31pressed = false;
        btn32 = findViewById(R.id.btn_3_2);
        btn32pressed = false;
        btn33 = findViewById(R.id.btn_3_3);
        btn33pressed = false;
        btn41 = findViewById(R.id.btn_4_1);
        btn41pressed = false;
        btn42 = findViewById(R.id.btn_4_2);
        btn42pressed = false;
        btn43 = findViewById(R.id.btn_4_3);
        btn43pressed = false;
        btn51 = findViewById(R.id.btn_5_1);
        btn51pressed = false;
        btn52 = findViewById(R.id.btn_5_2);
        btn52pressed = false;
        btn53 = findViewById(R.id.btn_5_3);
        btn53pressed = false;


        //if(btn11.isEnabled())
        //    btn11.setBackgroundColor(getResources().getColor(R.color.black));
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btn11pressed){
                    v.setBackgroundColor(getResources().getColor(R.color.black));
                    perceptron.enters[0] = 1;
                    btn11pressed = true;
                    draw2D.bEntersActive[0] = true;
                    draw2D.invalidate();
                }
                else {
                    v.setBackgroundColor(getResources().getColor(R.color.white));
                    perceptron.enters[0] = 0;
                    btn11pressed = false;
                    draw2D.bEntersActive[0] = false;
                    draw2D.invalidate();
                }
            }
        });
        /*btn11.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Toast.makeText(getApplicationContext(),
                            "Молодой человек, не прикасайтесь ко мне!",
                            Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });*/
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btn12pressed){
                    v.setBackgroundColor(getResources().getColor(R.color.black));
                    perceptron.enters[1] = 1;
                    btn12pressed = true;
                    draw2D.bEntersActive[1] = true;
                    draw2D.invalidate();
                }
                else {
                    v.setBackgroundColor(getResources().getColor(R.color.white));
                    perceptron.enters[1] = 0;
                    btn12pressed = false;
                    draw2D.bEntersActive[1] = false;
                    draw2D.invalidate();
                }
            }
        });
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btn13pressed){
                    v.setBackgroundColor(getResources().getColor(R.color.black));
                    perceptron.enters[2] = 1;
                    btn13pressed = true;
                    draw2D.bEntersActive[2] = true;
                    draw2D.invalidate();
                }
                else {
                    v.setBackgroundColor(getResources().getColor(R.color.white));
                    perceptron.enters[2] = 0;
                    btn13pressed = false;
                    draw2D.bEntersActive[2] = false;
                    draw2D.invalidate();
                }
            }
        });
        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btn21pressed){
                    v.setBackgroundColor(getResources().getColor(R.color.black));
                    perceptron.enters[3] = 1;
                    btn21pressed = true;
                    draw2D.bEntersActive[3] = true;
                    draw2D.invalidate();
                }
                else {
                    v.setBackgroundColor(getResources().getColor(R.color.white));
                    perceptron.enters[3] = 0;
                    btn21pressed = false;
                    draw2D.bEntersActive[3] = false;
                    draw2D.invalidate();
                }
            }
        });
        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btn22pressed){
                    v.setBackgroundColor(getResources().getColor(R.color.black));
                    perceptron.enters[4] = 1;
                    btn22pressed = true;
                    draw2D.bEntersActive[4] = true;
                    draw2D.invalidate();
                }
                else {
                    v.setBackgroundColor(getResources().getColor(R.color.white));
                    perceptron.enters[4] = 0;
                    btn22pressed = false;
                    draw2D.bEntersActive[4] = false;
                    draw2D.invalidate();
                }
            }
        });
        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btn23pressed){
                    v.setBackgroundColor(getResources().getColor(R.color.black));
                    perceptron.enters[5] = 1;
                    btn23pressed = true;
                    draw2D.bEntersActive[5] = true;
                    draw2D.invalidate();
                }
                else {
                    v.setBackgroundColor(getResources().getColor(R.color.white));
                    perceptron.enters[5] = 0;
                    btn23pressed = false;
                    draw2D.bEntersActive[5] = false;
                    draw2D.invalidate();
                }
            }
        });
        btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btn31pressed){
                    v.setBackgroundColor(getResources().getColor(R.color.black));
                    perceptron.enters[6] = 1;
                    btn31pressed = true;
                    draw2D.bEntersActive[6] = true;
                    draw2D.invalidate();
                }
                else {
                    v.setBackgroundColor(getResources().getColor(R.color.white));
                    perceptron.enters[6] = 0;
                    btn31pressed = false;
                    draw2D.bEntersActive[6] = false;
                    draw2D.invalidate();
                }
            }
        });
        btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btn32pressed){
                    v.setBackgroundColor(getResources().getColor(R.color.black));
                    perceptron.enters[7] = 1;
                    btn32pressed = true;
                    draw2D.bEntersActive[7] = true;
                    draw2D.invalidate();
                }
                else {
                    v.setBackgroundColor(getResources().getColor(R.color.white));
                    perceptron.enters[7] = 0;
                    btn32pressed = false;
                    draw2D.bEntersActive[7] = false;
                    draw2D.invalidate();
                }
            }
        });
        btn33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btn33pressed){
                    v.setBackgroundColor(getResources().getColor(R.color.black));
                    perceptron.enters[8] = 1;
                    btn33pressed = true;
                    draw2D.bEntersActive[8] = true;
                    draw2D.invalidate();
                }
                else {
                    v.setBackgroundColor(getResources().getColor(R.color.white));
                    perceptron.enters[8] = 0;
                    btn33pressed = false;
                    draw2D.bEntersActive[8] = false;
                    draw2D.invalidate();
                }
            }
        });
        btn41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btn41pressed){
                    v.setBackgroundColor(getResources().getColor(R.color.black));
                    perceptron.enters[9] = 1;
                    btn41pressed = true;
                    draw2D.bEntersActive[9] = true;
                    draw2D.invalidate();
                }
                else {
                    v.setBackgroundColor(getResources().getColor(R.color.white));
                    perceptron.enters[9] = 0;
                    btn41pressed = false;
                    draw2D.bEntersActive[9] = false;
                    draw2D.invalidate();
                }
            }
        });
        btn42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btn42pressed){
                    v.setBackgroundColor(getResources().getColor(R.color.black));
                    perceptron.enters[10] = 1;
                    btn42pressed = true;
                    draw2D.bEntersActive[10] = true;
                    draw2D.invalidate();
                }
                else {
                    v.setBackgroundColor(getResources().getColor(R.color.white));
                    perceptron.enters[10] = 0;
                    btn42pressed = false;
                    draw2D.bEntersActive[10] = false;
                    draw2D.invalidate();
                }
            }
        });
        btn43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btn43pressed){
                    v.setBackgroundColor(getResources().getColor(R.color.black));
                    perceptron.enters[11] = 1;
                    btn43pressed = true;
                    draw2D.bEntersActive[11] = true;
                    draw2D.invalidate();
                }
                else {
                    v.setBackgroundColor(getResources().getColor(R.color.white));
                    perceptron.enters[11] = 0;
                    btn43pressed = false;
                    draw2D.bEntersActive[11] = false;
                    draw2D.invalidate();
                }
            }
        });
        btn51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btn51pressed){
                    v.setBackgroundColor(getResources().getColor(R.color.black));
                    perceptron.enters[12] = 1;
                    btn51pressed = true;
                    draw2D.bEntersActive[12] = true;
                    draw2D.invalidate();
                }
                else {
                    v.setBackgroundColor(getResources().getColor(R.color.white));
                    perceptron.enters[12] = 0;
                    btn51pressed = false;
                    draw2D.bEntersActive[12] = false;
                    draw2D.invalidate();
                }
            }
        });
        btn52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btn52pressed){
                    v.setBackgroundColor(getResources().getColor(R.color.black));
                    perceptron.enters[13] = 1;
                    btn52pressed = true;
                    draw2D.bEntersActive[13] = true;
                    draw2D.invalidate();
                }
                else {
                    v.setBackgroundColor(getResources().getColor(R.color.white));
                    perceptron.enters[13] = 0;
                    btn52pressed = false;
                    draw2D.bEntersActive[13] = false;
                    draw2D.invalidate();
                }
            }
        });
        btn53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btn53pressed){
                    v.setBackgroundColor(getResources().getColor(R.color.black));
                    perceptron.enters[14] = 1;
                    btn53pressed = true;
                    draw2D.bEntersActive[14] = true;
                    draw2D.invalidate();
                }
                else {
                    v.setBackgroundColor(getResources().getColor(R.color.white));
                    perceptron.enters[14] = 0;
                    btn53pressed = false;
                    draw2D.bEntersActive[14] = false;
                    draw2D.invalidate();
                }
            }
        });
    }

    /*class Calculation extends Thread{
        public void run(){
            iterations = perceptron.study();
        }
    }*/

    public void btnGetResultOnclick(View view) {
        perceptron.countOuter();
        for(int i=0;i<10;i++) {
            draw2D.bOutersActive[i] = false;
            if(perceptron.outer[i] == 1) draw2D.bOutersActive[i] = true;
        }
        Num = -1;
        double outer_max = 0;
        for(int num=0;num<perceptron.NUM_VALUE;num++){
            draw2D.dOutersValue[num] = perceptron.outer_max[num];
            if ((perceptron.outer[num] == 1)&&(perceptron.outer_max[num]>outer_max)) {
                outer_max = perceptron.outer_max[num];
                Num = num;
            }
        }
        if (Num == -1) {
            tvStatusValue.setText(R.string.tv_status_value_not_found);
            draw2D.outerValue = "";
        }
        else {
            tvStatusValue.setText("Number = " + Num.toString());
            draw2D.outerValue = Num.toString();
        }
        btnStudyWrong.setEnabled(true);
        btnStudyRight.setEnabled(true);
        draw2D.invalidate();
    }

    public void btnClearClick(View view) {
        for(int i=0;i<15;i++)
            draw2D.bEntersActive[i] = false;
        for(int i=0;i<10;i++) {
            draw2D.bOutersActive[i] = false;
            draw2D.dOutersValue[i] = 0;
        }
        draw2D.invalidate();

        btn11.setBackgroundColor(getResources().getColor(R.color.white));
        btn11pressed = false;
        perceptron.enters[0] = 0;

        btn12.setBackgroundColor(getResources().getColor(R.color.white));
        btn12pressed = false;
        perceptron.enters[1] = 0;

        btn13.setBackgroundColor(getResources().getColor(R.color.white));
        btn13pressed = false;
        perceptron.enters[2] = 0;

        btn21.setBackgroundColor(getResources().getColor(R.color.white));
        btn21pressed = false;
        perceptron.enters[3] = 0;

        btn22.setBackgroundColor(getResources().getColor(R.color.white));
        btn22pressed = false;
        perceptron.enters[4] = 0;

        btn23.setBackgroundColor(getResources().getColor(R.color.white));
        btn23pressed = false;
        perceptron.enters[5] = 0;

        btn31.setBackgroundColor(getResources().getColor(R.color.white));
        btn31pressed = false;
        perceptron.enters[6] = 0;

        btn32.setBackgroundColor(getResources().getColor(R.color.white));
        btn32pressed = false;
        perceptron.enters[7] = 0;

        btn33.setBackgroundColor(getResources().getColor(R.color.white));
        btn33pressed = false;
        perceptron.enters[8] = 0;

        btn41.setBackgroundColor(getResources().getColor(R.color.white));
        btn41pressed = false;
        perceptron.enters[9] = 0;

        btn42.setBackgroundColor(getResources().getColor(R.color.white));
        btn42pressed = false;
        perceptron.enters[10] = 0;

        btn43.setBackgroundColor(getResources().getColor(R.color.white));
        btn43pressed = false;
        perceptron.enters[11] = 0;

        btn51.setBackgroundColor(getResources().getColor(R.color.white));
        btn51pressed = false;
        perceptron.enters[12] = 0;

        btn52.setBackgroundColor(getResources().getColor(R.color.white));
        btn52pressed = false;
        perceptron.enters[13] = 0;

        btn53.setBackgroundColor(getResources().getColor(R.color.white));
        btn53pressed = false;
        perceptron.enters[14] = 0;

        tvStatusValue.setText("");
    }

    public void btnStudyWrongClick(View view) {
        final String[] numbers = {"0","1","2","3","4","5","6","7","8","9","Мало данных"};
        final String[] num = new String[1];
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Выберите правильную цифру").
                setItems(numbers, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //num[0] = numbers[which];
                        //tvStatusValue.setText(numbers[which]);
                        int numOld = Num;
                        if (numbers[which] == "Мало данных") {
                            Num = -1;
                            tvStatusValue.setText(R.string.tv_status_value_not_found);
                        }
                        else {
                            Num = Integer.parseInt(numbers[which]);
                            tvStatusValue.setText("Number = " + Num.toString());
                        }
                        perceptron.studyWrong(numOld);
                        perceptron.studyWright(Num);
                        for(int num=0;num<perceptron.NUM_VALUE;num++)
                            draw2D.dOutersValue[num] = perceptron.outer_max[num];
                        draw2D.invalidate();
                        Toast.makeText(getApplicationContext(),"Весовые коэффициенты пересчитаны",Toast.LENGTH_LONG).show();
                        iterations++;
                        tvIterationsValue.setText(iterations.toString());
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void btnStudyRightClick(View view) {
        perceptron.studyWright(Num);
        Toast.makeText(this,"Весовые коэффициенты пересчитаны",Toast.LENGTH_LONG).show();
        iterations++;
        tvIterationsValue.setText(iterations.toString());
        for(int num=0;num<perceptron.NUM_VALUE;num++)
            draw2D.dOutersValue[num] = perceptron.outer_max[num];
        draw2D.invalidate();
    }
}
