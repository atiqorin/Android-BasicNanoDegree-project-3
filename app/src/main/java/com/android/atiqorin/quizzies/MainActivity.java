package com.android.atiqorin.quizzies;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayout options;
    TextView questionHolder;
    String[] questions,answers,Q_for_0,Q_for_1,Q_for_2,Q_for_3,Q_for_4,Q_for_5,Q_for_6;
    RadioGroup radioGroup;
    CheckBox ans_option_1, ans_option_2, ans_option_3, ans_option_4;
    ArrayList<String> checkedboxes=new ArrayList<>();
    EditText answer_0;
    Button score;
    int number=0,gameScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        options =(LinearLayout)findViewById(R.id.options);
        questions = getResources().getStringArray(R.array.Questions);
        answers = getResources().getStringArray(R.array.Answers);
        radioGroup =new RadioGroup(getApplicationContext());
        score=(Button)findViewById(R.id.Score);

        Q_for_0=getResources().getStringArray(R.array.Q_for_0);
        Q_for_1=getResources().getStringArray(R.array.Q_for_1);
        Q_for_2=getResources().getStringArray(R.array.Q_for_2);
        Q_for_3=getResources().getStringArray(R.array.Q_for_3);
        Q_for_4=getResources().getStringArray(R.array.Q_for_4);
        Q_for_5=getResources().getStringArray(R.array.Q_for_5);
        Q_for_6=getResources().getStringArray(R.array.Q_for_6);

        score.setText("Score: 0");
        updateView();
    }
    public void updateScore(Boolean proceed){

        if(proceed){
            gameScore++;
            score.setText("Score: "+gameScore);

        }else{
            gameScore--;
            score.setText("Score: "+gameScore);

        }


    }
    public void checkAnswers(View v){

        switch (number){
            case 0:
                String firstQuestionReply=answer_0.getText().toString();

                if(firstQuestionReply!=null) {
                    if (firstQuestionReply.equals(answers[0])) {
                        updateScore(true);
                    } else {
                        if (gameScore > 0) {
                            updateScore(false);
                        }
                    }
                }
                break;
            case 1:
                List<String> answer = new ArrayList<String>(Arrays.asList(answers[1].split(",")));
                if(checkedboxes.containsAll(answer)){
                    updateScore(true);
                }else{
                    if(gameScore>0) {
                        updateScore(false);
                    }
                }

                break;
            case 2:
                int thirdQuestionReply= radioGroup.getCheckedRadioButtonId();
                if(thirdQuestionReply == 0){
                    updateScore(true);
                }else{
                    if(gameScore>0) {
                        updateScore(false);
                    }
                }
                break;


            case 3:
                int fourthQuestionReply= radioGroup.getCheckedRadioButtonId();
                if(fourthQuestionReply==2){
                    updateScore(true);
                }else{
                    if(gameScore>0) {
                        updateScore(false);
                    }
                }
                break;

            case 4:
                int fifthQuestionReply= radioGroup.getCheckedRadioButtonId();
                if(fifthQuestionReply==0){
                    updateScore(true);
                }else{
                    if(gameScore>0) {

                        updateScore(false);
                    }
                }
                break;

            case 5:
                int sixthQuestionReply= radioGroup.getCheckedRadioButtonId();
                if(sixthQuestionReply==3){
                    updateScore(true);
                }else{
                    if(gameScore>0) {

                        updateScore(false);
                    }
                }
                break;
            case 6:
                int seventhQuestionReply= radioGroup.getCheckedRadioButtonId();
                if(seventhQuestionReply==6){
                    updateScore(true);
                }else{
                    if(gameScore>0) {
                        updateScore(false);
                    }
                }
                break;

        }
        number++;
        updateView();
    }
    public void nextQuestion(View v){
        number++;
        updateView();

    }
    public void updateView() {
        final int optionindex = 0;
        if (number < 7) {
            questionHolder = (TextView) findViewById(R.id.question);
            questionHolder.setText("Q." + number + ": " + questions[number]);
            switch (number) {
                case 0:
                    radioGroup.removeAllViews();
                    options.removeAllViews();
                    answer_0 = new EditText(getApplicationContext());
                    answer_0.setText("");
                    options.addView(answer_0);

                    break;

                case 1:
                    radioGroup.removeAllViews();
                    options.removeAllViews();


                    ans_option_1 = new CheckBox(getApplicationContext());
                    ans_option_1.setText(Q_for_1[optionindex]);
                    ans_option_1.setId(optionindex);
                    ans_option_1.setTextColor(Color.BLACK);
                    ans_option_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked) {
                                checkedboxes.add(ans_option_1.getText().toString());
                            } else {
                                checkedboxes.remove(optionindex);
                            }
                        }
                    });
                    options.addView(ans_option_1);

                    ans_option_2 = new CheckBox(getApplicationContext());
                    ans_option_2.setText(Q_for_1[optionindex + 1]);
                    ans_option_2.setId(optionindex + 1);
                    ans_option_2.setTextColor(Color.BLACK);
                    ans_option_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked) {
                                checkedboxes.add(ans_option_2.getText().toString());
                            } else {
                                checkedboxes.remove(optionindex + 1);
                            }
                        }
                    });
                    options.addView(ans_option_2);

                    ans_option_3 = new CheckBox(getApplicationContext());
                    ans_option_3.setText(Q_for_1[optionindex + 2]);
                    ans_option_3.setId(optionindex + 2);
                    ans_option_3.setTextColor(Color.BLACK);
                    ans_option_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked) {
                                checkedboxes.add(ans_option_3.getText().toString());
                            } else {
                                checkedboxes.remove(optionindex + 2);
                            }
                        }
                    });
                    options.addView(ans_option_3);

                    ans_option_4 = new CheckBox(getApplicationContext());
                    ans_option_4.setText(Q_for_1[optionindex + 3]);
                    ans_option_4.setId(optionindex + 3);
                    ans_option_4.setTextColor(Color.BLACK);
                    ans_option_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked) {
                                checkedboxes.add(ans_option_4.getText().toString());
                            } else {
                                checkedboxes.remove(optionindex + 3);
                            }
                        }
                    });
                    options.addView(ans_option_4);


                    break;


                case 2:

                    radioGroup.removeAllViews();
                    options.removeAllViews();

                    ImageView option_img = new ImageView(getApplicationContext());
                    option_img.setMaxHeight(200);
                    option_img.setImageResource(R.drawable.hodor);
                    RadioButton answer_2_option_1 = new RadioButton(getApplicationContext());
                    answer_2_option_1.setId(optionindex);
                    answer_2_option_1.setText("Hodor");
                    answer_2_option_1.setTextColor(Color.BLACK);

                    radioGroup.addView(answer_2_option_1);
                    RadioButton answer_2_option_2 = new RadioButton(getApplicationContext());
                    answer_2_option_2.setId(optionindex + 1);
                    answer_2_option_2.setText("Ramsey");
                    answer_2_option_2.setTextColor(Color.BLACK);

                    radioGroup.addView(answer_2_option_2);
                    options.addView(radioGroup);
                    options.addView(option_img);

                    break;
                case 3:
                    radioGroup.removeAllViews();
                    options.removeAllViews();


                    RadioButton answer_3_option_1 = new RadioButton(getApplicationContext());
                    answer_3_option_1.setText(Q_for_3[optionindex]);
                    answer_3_option_1.setId(optionindex);
                    answer_3_option_1.setTextColor(Color.BLACK);

                    radioGroup.addView(answer_3_option_1);


                    RadioButton answer_3_option_2 = new RadioButton(getApplicationContext());
                    answer_3_option_2.setText(Q_for_3[optionindex + 1]);
                    answer_3_option_2.setId(optionindex + 1);
                    answer_3_option_2.setTextColor(Color.BLACK);

                    radioGroup.addView(answer_3_option_2);


                    RadioButton answer_3_option_3 = new RadioButton(getApplicationContext());
                    answer_3_option_3.setText(Q_for_3[optionindex + 2]);
                    answer_3_option_3.setId(optionindex + 2);
                    answer_3_option_3.setTextColor(Color.BLACK);

                    radioGroup.addView(answer_3_option_3);


                    RadioButton answer_3_option_4 = new RadioButton(getApplicationContext());
                    answer_3_option_4.setText(Q_for_3[optionindex + 3]);
                    answer_3_option_4.setId(optionindex + 3);
                    answer_3_option_4.setTextColor(Color.BLACK);

                    radioGroup.addView(answer_3_option_4);
                    options.addView(radioGroup);
                    break;

                case 4:
                    radioGroup.removeAllViews();
                    options.removeAllViews();

                    RadioButton answer_4_option_1 = new RadioButton(getApplicationContext());
                    answer_4_option_1.setText(Q_for_4[optionindex]);
                    answer_4_option_1.setId(optionindex);
                    answer_4_option_1.setTextColor(Color.BLACK);

                    radioGroup.addView(answer_4_option_1);


                    RadioButton answer_4_option_2 = new RadioButton(getApplicationContext());
                    answer_4_option_2.setText(Q_for_4[optionindex + 1]);
                    answer_4_option_2.setId(optionindex + 1);
                    answer_4_option_2.setTextColor(Color.BLACK);

                    radioGroup.addView(answer_4_option_2);


                    RadioButton answer_4_option_3 = new RadioButton(getApplicationContext());
                    answer_4_option_3.setText(Q_for_4[optionindex + 2]);
                    answer_4_option_3.setId(optionindex + 2);
                    answer_4_option_3.setTextColor(Color.BLACK);

                    radioGroup.addView(answer_4_option_3);

                    options.addView(radioGroup);
                    break;

                case 5:
                    radioGroup.removeAllViews();
                    options.removeAllViews();

                    RadioButton answer_5_option_1 = new RadioButton(getApplicationContext());
                    answer_5_option_1.setText(Q_for_5[optionindex]);
                    answer_5_option_1.setTag(Q_for_5[optionindex]);
                    radioGroup.addView(answer_5_option_1);

                    RadioButton answer_5_option_2 = new RadioButton(getApplicationContext());
                    answer_5_option_2.setText(Q_for_5[optionindex + 1]);
                    answer_5_option_2.setTag(Q_for_5[optionindex + 1]);
                    radioGroup.addView(answer_5_option_2);

                    RadioButton answer_5_option_3 = new RadioButton(getApplicationContext());
                    answer_5_option_3.setText(Q_for_5[optionindex + 2]);
                    answer_5_option_3.setTag(Q_for_5[optionindex + 2]);
                    radioGroup.addView(answer_5_option_3);

                    RadioButton answer_5_option_4 = new RadioButton(getApplicationContext());
                    answer_5_option_4.setText(Q_for_5[optionindex + 3]);
                    answer_5_option_4.setTag(Q_for_5[optionindex + 3]);
                    radioGroup.addView(answer_5_option_4);
                    options.addView(radioGroup);


                    break;
                case 6:
                    radioGroup.removeAllViews();
                    options.removeAllViews();

                    RadioButton answer_6_option_1 = new RadioButton(getApplicationContext());
                    answer_6_option_1.setText(Q_for_6[optionindex]);
                    answer_6_option_1.setTag(Q_for_6[optionindex]);
                    radioGroup.addView(answer_6_option_1);

                    RadioButton answer_6_option_2 = new RadioButton(getApplicationContext());
                    answer_6_option_2.setText(Q_for_6[optionindex + 1]);
                    answer_6_option_2.setTag(Q_for_6[optionindex + 1]);
                    radioGroup.addView(answer_6_option_2);

                    RadioButton answer_6_option_3 = new RadioButton(getApplicationContext());
                    answer_6_option_3.setText(Q_for_6[optionindex + 2]);
                    answer_6_option_3.setTag(Q_for_6[optionindex + 2]);
                    radioGroup.addView(answer_6_option_3);

                    RadioButton answer_6_option_4 = new RadioButton(getApplicationContext());
                    answer_6_option_4.setText(Q_for_6[optionindex + 3]);
                    answer_6_option_4.setTag(Q_for_6[optionindex + 3]);
                    radioGroup.addView(answer_6_option_4);

                    options.addView(radioGroup);
                    break;

            }
        } else {
            number = 0;
            Toast.makeText(MainActivity.this, "Reached End. Restarting.", Toast.LENGTH_LONG).show();
            updateView();
        }
    }
}
