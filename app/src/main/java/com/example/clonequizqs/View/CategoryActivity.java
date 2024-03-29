package com.example.clonequizqs.View;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.clonequizqs.R;

public class CategoryActivity extends AppCompatActivity {
    private Button btnGame;
    private Button btnMusic;
    private Button btnGeneral;
    private Button btnEnglish;
    private Button btnSport;
    private Button btnComputer;
    private Button btnNormal;
    private Button btnInfinite;
    private Button btnPuzzle;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        btnGame = findViewById(R.id.b1);
        btnMusic = findViewById(R.id.b2);
        btnGeneral = findViewById(R.id.b3);
        btnEnglish = findViewById(R.id.b4);
        btnSport = findViewById(R.id.b5);
        btnComputer = findViewById(R.id.b6);

        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogModePickerGame();
            }
        });
        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogModePickerMusic();
            }
        });
        btnGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogModePickerGeneral();
            }
        });
        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogModePickerEnglish();
            }
        });
        btnSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogModePickerSport();
            }
        });
        btnComputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogModePickerComputer();
            }
        });
    }

    private void showDialogModePickerGame() {
        final android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_mode_picker, null);
        dialog.setView(dialogView);
        final Dialog dialog1 = dialog.show();
        btnNormal = dialogView.findViewById(R.id.normal);
        btnInfinite = dialogView.findViewById(R.id.infinite);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, GameNormalActivity.class);
                startActivity(intent);
                dialog1.dismiss();
            }
        });
        btnInfinite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, GameInfiniteActivity.class);
                startActivity(intent);
                dialog1.dismiss();
            }
        });
    }

    private void showDialogModePickerMusic() {
        final android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_mode_picker, null);
        dialog.setView(dialogView);
        final Dialog dialog1 = dialog.show();
        btnNormal = dialogView.findViewById(R.id.normal);
        btnInfinite = dialogView.findViewById(R.id.infinite);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, MusicNormalActivity.class);
                startActivity(intent);
                dialog1.dismiss();
            }
        });
        btnInfinite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, MusicInfiniteActivity.class);
                startActivity(intent);
                dialog1.dismiss();
            }
        });

    }

    private void showDialogModePickerGeneral() {
        final android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_mode_picker, null);
        dialog.setView(dialogView);
        final Dialog dialog1 = dialog.show();
        btnNormal = dialogView.findViewById(R.id.normal);
        btnInfinite = dialogView.findViewById(R.id.infinite);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, GeneralNormalActivity.class);
                startActivity(intent);
                dialog1.dismiss();
            }
        });
        btnInfinite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, GeneralInfiniteActivity.class);
                startActivity(intent);
                dialog1.dismiss();
            }
        });
    }

    private void showDialogModePickerEnglish() {
        final android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_mode_picker_english, null);
        dialog.setView(dialogView);
        final Dialog dialog1 = dialog.show();
        btnNormal = dialogView.findViewById(R.id.normal);
        btnPuzzle = dialogView.findViewById(R.id.puzzle);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, EnglishNormalActivity.class);
                startActivity(intent);
                dialog1.dismiss();
            }
        });
        btnPuzzle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, EnglishPuzzleActivity.class);
                startActivity(intent);
                dialog1.dismiss();
            }
        });
    }

    private void showDialogModePickerSport() {
        final android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_mode_picker, null);
        dialog.setView(dialogView);
        final Dialog dialog1 = dialog.show();
        btnNormal = dialogView.findViewById(R.id.normal);
        btnInfinite = dialogView.findViewById(R.id.infinite);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, SportNormalActivity.class);
                startActivity(intent);
                dialog1.dismiss();
            }
        });
        btnInfinite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, SportInfiniteActivity.class);
                startActivity(intent);
                dialog1.dismiss();
            }
        });
    }

    private void showDialogModePickerComputer() {
        final android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_mode_picker, null);
        dialog.setView(dialogView);
        final Dialog dialog1 = dialog.show();
        btnNormal = dialogView.findViewById(R.id.normal);
        btnInfinite = dialogView.findViewById(R.id.infinite);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, ComputerNormalActivity.class);
                startActivity(intent);
                dialog1.dismiss();
            }
        });
        btnInfinite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, ComputerInfiniteActivity.class);
                startActivity(intent);
                dialog1.dismiss();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CategoryActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
}

