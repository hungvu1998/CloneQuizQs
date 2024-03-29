package com.example.clonequizqs.View;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.clonequizqs.Model.GeneralQuestion;
import com.example.clonequizqs.Model.MusicQuestion;
import com.example.clonequizqs.R;
import com.example.clonequizqs.SQLite.GeneralOpenHelper;
import com.example.clonequizqs.SQLite.MusicOpenHelper;
import java.util.Collections;
import java.util.List;

public class GeneralNormalActivity extends AppCompatActivity {
    Button buttonA, buttonB, buttonC, buttonD;
    Button btnGameOver, btnTimeUp, btnNext;
    TextView questionText, triviaQuizText, timeText, resultText, coinText;
    GeneralOpenHelper generalQuiz;
    GeneralQuestion generalQuestion;
    List<GeneralQuestion> generalList;
    int qid = 0;
    int timeValue = 20;
    int coinValue = 0;
    CountDownTimer countDownTimer;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        questionText = findViewById(R.id.triviaQuestion);
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);
        triviaQuizText = findViewById(R.id.triviaQuizText);
        timeText = findViewById(R.id.timeText);
        resultText = findViewById(R.id.resultText);
        coinText = findViewById(R.id.coinText);
        generalQuiz = new GeneralOpenHelper(this);
        generalQuiz.getWritableDatabase();
        if (generalQuiz.getAllOfTheQuestions().size() == 0) {
            generalQuiz.allQuestion();

        }
        generalList = generalQuiz.getAllOfTheQuestions();
        Collections.shuffle(generalList);
        generalQuestion = generalList.get(qid);
        countDownTimer = new CountDownTimer(22000, 1000) {
            public void onTick(long millisUntilFinished) {

                timeText.setText(String.valueOf(timeValue) + "\"");

                timeValue -= 1;

                if (timeValue == -1) {

                    disableButton();
                }
            }

            public void onFinish() {
                timeUp();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(GeneralNormalActivity.this, GameWonActivity.class);
                        intent.putExtra("Score", coinValue);
                        startActivity(intent);
                        finish();
                    }
                }, 1000);
            }
        }.start();

        updateQuestion();


    }

    public void updateQuestion() {
        questionText.setText(generalQuestion.getQuestion());
        buttonA.setText(generalQuestion.getOptionA());
        buttonB.setText(generalQuestion.getOptionB());
        buttonC.setText(generalQuestion.getOptionC());
        buttonD.setText(generalQuestion.getOptionD());
        timeValue = 20;

        countDownTimer.cancel();
        countDownTimer.start();

        coinText.setText(String.valueOf(coinValue));

        coinValue++;
    }

    public void buttonA(View view) {
        countDownTimer.cancel();
        if (generalQuestion.getOptionA().equals(generalQuestion.getAnswer())) {
            if (qid < generalList.size() - 1) {
                disableButton();
                playSoundRight();
                correctDialog();
            } else {
                gameWon();
            }
        } else {
            playSoundWrong();
            gameLost();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(GeneralNormalActivity.this, GameWonActivity.class);
                    intent.putExtra("Score", coinValue);
                    startActivity(intent);
                    finish();
                }
            },1000);
        }
        if (generalQuestion.getOptionA().equals(generalQuestion.getAnswer())) {
            if (qid == generalList.size() - 1) {
                playSoundRight();
                coinText.setText(String.valueOf(coinValue));
                coinValue++;
                gameWon();
            }
        }
    }

    public void buttonB(View view) {
        countDownTimer.cancel();
        if (generalQuestion.getOptionB().equals(generalQuestion.getAnswer())) {
            if (qid < generalList.size() - 1) {
                disableButton();
                playSoundRight();
                correctDialog();
            } else {
                gameWon();
            }
        } else {
            playSoundWrong();
            gameLost();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(GeneralNormalActivity.this, GameWonActivity.class);
                    intent.putExtra("Score", coinValue);
                    startActivity(intent);
                    finish();
                }
            }, 1000);
        }
        if (generalQuestion.getOptionB().equals(generalQuestion.getAnswer())) {
            if (qid == generalList.size() - 1) {
                playSoundRight();
                coinText.setText(String.valueOf(coinValue));
                coinValue++;
                gameWon();
            }
        }
    }
    public void buttonC(View view) {
        countDownTimer.cancel();
        if (generalQuestion.getOptionC().equals(generalQuestion.getAnswer())) {
            if (qid < generalList.size() - 1) {
                disableButton();
                playSoundRight();
                correctDialog();
            } else {
                gameWon();
            }
        } else {
            playSoundWrong();
            gameLost();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(GeneralNormalActivity.this, GameWonActivity.class);
                    intent.putExtra("Score", coinValue);
                    startActivity(intent);
                    finish();
                }
            },1000);
        }
        if (generalQuestion.getOptionC().equals(generalQuestion.getAnswer())) {
            if (qid == generalList.size() - 1) {
                playSoundRight();
                coinText.setText(String.valueOf(coinValue));
                coinValue++;
                gameWon();
            }
        }
    }

    public void buttonD(View view) {
        countDownTimer.cancel();
        if (generalQuestion.getOptionD().equals(generalQuestion.getAnswer())) {
            if (qid < generalList.size() - 1) {
                disableButton();
                playSoundRight();
                correctDialog();
            } else {
                gameWon();
            }
        } else {
            playSoundWrong();
            gameLost();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(GeneralNormalActivity.this, GameWonActivity.class);
                    intent.putExtra("Score", coinValue);
                    startActivity(intent);
                    finish();
                }
            },1000);
        }
        if (generalQuestion.getOptionD().equals(generalQuestion.getAnswer())) {
            if (qid == generalList.size() - 1) {
                playSoundRight();
                coinText.setText(String.valueOf(coinValue));
                coinValue++;
                gameWon();
            }
        }
    }

    public void gameWon() {
        Intent intent = new Intent(this, GameWonActivity.class);
        intent.putExtra("Score",coinValue);
        startActivity(intent);

    }

    public void gameLost() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View dialogView =inflater.inflate(R.layout.dialog_wrong_normal, null);
        dialog.setView(dialogView);
        dialog.setCancelable(false);
        final Dialog dialog1 = dialog.show();
    }
    public void timeUp(){
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View dialogView =inflater.inflate(R.layout.dialog_timeup_normal, null);
        dialog.setView(dialogView);
        dialog.setCancelable(false);
        final Dialog dialog1 = dialog.show();
    }
    public void correctDialog(){
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View dialogView =inflater.inflate(R.layout.dialog_correct_normal, null);
        dialog.setView(dialogView);
        dialog.setCancelable(false);
        final Dialog dialog1 = dialog.show();
        btnNext = dialogView.findViewById(R.id.Next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
                qid++;
                generalQuestion=generalList.get(qid);
                updateQuestion();
                enableButton();
            }
        });
    }

    public void disableButton() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
    }

    public void enableButton() {
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        countDownTimer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
    public void playSoundRight() {
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0) {
            mediaPlayer = MediaPlayer.create(this, R.raw.rightsound);
            mediaPlayer.start();
            mediaPlayer.setLooping(false);
        }
    }

    public void playSoundWrong() {
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0) {
            mediaPlayer = MediaPlayer.create(this, R.raw.wrongsound);
            mediaPlayer.start();
            mediaPlayer.setLooping(false);
        }
    }
}

