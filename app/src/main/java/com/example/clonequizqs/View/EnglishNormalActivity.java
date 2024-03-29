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
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.clonequizqs.Adapter.GridViewAnswerAdapter;
import com.example.clonequizqs.Adapter.GridViewSuggestAdapter;
import com.example.clonequizqs.Common;
import com.example.clonequizqs.Model.EnglishQuestion;
import com.example.clonequizqs.Model.MusicQuestion;
import com.example.clonequizqs.R;
import com.example.clonequizqs.SQLite.MusicOpenHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class EnglishNormalActivity extends AppCompatActivity {
    Button buttonA, buttonB, buttonC, buttonD;
    Button btnGameOver, btnTimeUp, btnNext;
    TextView questionText, triviaQuizText, timeText, resultText, coinText;
    EnglishQuestion englishQuestion = new EnglishQuestion();
    int qid = 0;
    int timeValue = 20;
    int coinValue = 1;
    ImageView img;
    CountDownTimer countDownTimer;
    MediaPlayer mediaPlayer;
    private int MyScore = 0;
    private int MyQuestionNumber = 0;
    private String MyAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);
        img = findViewById(R.id.img);
        triviaQuizText = findViewById(R.id.triviaQuizText);
        timeText = findViewById(R.id.timeText);
        resultText = findViewById(R.id.resultText);
        coinText = findViewById(R.id.coinText);

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
                        Intent intent = new Intent(EnglishNormalActivity.this, GameWonActivity.class);
                        intent.putExtra("Score", coinValue);
                        startActivity(intent);
                        finish();
                    }
                }, 1000);
            }
        }.start();

        updateQuestion();
    }
    private void updateScore(int point) {
        coinText.setText(String.valueOf(coinValue));
        coinValue++;
    }
    private void updateQuestion() {
        timeValue=20;
        countDownTimer.cancel();
        countDownTimer.start();
        if (MyQuestionNumber < englishQuestion.getLength()) {
            img.setImageResource(englishQuestion.getQuestion(MyQuestionNumber));
            buttonA.setText(englishQuestion.getChoice(MyQuestionNumber, 1));
            buttonB.setText(englishQuestion.getChoice(MyQuestionNumber, 2));
            buttonC.setText(englishQuestion.getChoice(MyQuestionNumber, 3));
            buttonD.setText(englishQuestion.getChoice(MyQuestionNumber, 4));
            MyAnswer = englishQuestion.getCorrectAnswer(MyQuestionNumber);
            MyQuestionNumber++;

        } else {
            gameWon();

        }
    }

    public void buttonA(View view) {
        countDownTimer.cancel();
        if (buttonA.getText() == MyAnswer) {
            disableButton();
            playSoundRight();
            correctDialog();
            updateScore(coinValue);
        } else {
            playSoundWrong();
            gameLost();
            Intent intent = new Intent(this, GameWonActivity.class);
            intent.putExtra("Score", coinValue);
            startActivity(intent);
        }
    }

    public void buttonB(View view) {
        countDownTimer.cancel();
        if (buttonB.getText() == MyAnswer) {
                disableButton();
                playSoundRight();
                correctDialog();
            updateScore(coinValue);
            } else {
                playSoundWrong();
                gameLost();
            Intent intent = new Intent(this, GameWonActivity.class);
            intent.putExtra("Score", coinValue);
            startActivity(intent);
            }
        }

    public void buttonC(View view) {
        countDownTimer.cancel();
        if (buttonC.getText() == MyAnswer) {
            disableButton();
            playSoundRight();
            correctDialog();
            updateScore(coinValue);
        } else {
            playSoundWrong();
            gameLost();
            Intent intent = new Intent(this, GameWonActivity.class);
            intent.putExtra("Score", coinValue);
            startActivity(intent);
        }
    }

    public void buttonD(View view) {
        countDownTimer.cancel();
        if (buttonD.getText() == MyAnswer) {
            disableButton();
            playSoundRight();
            correctDialog();
            updateScore(coinValue);
        } else {
            playSoundWrong();
            gameLost();
            Intent intent = new Intent(this, GameWonActivity.class);
            intent.putExtra("Score", coinValue);
            startActivity(intent);
        }
    }
    public void gameWon() {
        Intent intent = new Intent(this, GameWonActivity.class);
        intent.putExtra("Score", coinValue);
        startActivity(intent);

    }

    public void gameLost() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View dialogView = inflater.inflate(R.layout.dialog_wrong_normal, null);
        dialog.setView(dialogView);
        dialog.setCancelable(false);
        final Dialog dialog1 = dialog.show();
    }

    public void timeUp() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View dialogView = inflater.inflate(R.layout.dialog_timeup_normal, null);
        dialog.setView(dialogView);
        dialog.setCancelable(false);
        final Dialog dialog1 = dialog.show();
    }

    public void correctDialog() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View dialogView = inflater.inflate(R.layout.dialog_correct_normal, null);
        dialog.setView(dialogView);
        dialog.setCancelable(false);
        final Dialog dialog1 = dialog.show();
        btnNext = dialogView.findViewById(R.id.Next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
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
