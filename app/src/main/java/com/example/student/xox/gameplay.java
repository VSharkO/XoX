package com.example.student.xox;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import javax.xml.datatype.Duration;

public class gameplay extends AppCompatActivity {
    int counterMoves = 0;
    int counterGames = 0;
    int score[] = new int[9];
    Player Player1, Player2, winner;
    Player playerX, playerO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        playerX = new Player(getIntent().getExtras().getString("NameX"), 'X');
        playerO = new Player(getIntent().getExtras().getString("NameO"), 'O');
        gameStart();
    }

    public void onClick(View view) {
        //ako je broj poteza manji od 10 i ako na mjesto na koje smo kliknuli u polju nema spremljen rezultat, onda stavljamo znak i spremamo rez.
        if (score[Integer.parseInt(view.getTag().toString())] == 0) {
            Random random = new Random();
            //logika za postavljanje znakova kao bck za gumb
            if (counterMoves % 2 == 0) {
                score[Integer.parseInt(view.getTag().toString())] = 1;
                if (Player1.getSign().equals('X')) {
                    view.setBackgroundResource(R.drawable.x + random.nextInt(11));
                    view.setAlpha(1);
                } else {
                    view.setBackgroundResource(R.drawable.o + random.nextInt(11));
                    view.setAlpha(1);
                }
            } else {
                score[Integer.parseInt(view.getTag().toString())] = 2;
                if (Player2.getSign().equals('X')) {
                    view.setBackgroundResource(R.drawable.x + random.nextInt(11));
                    view.setAlpha(1);
                } else {
                    view.setBackgroundResource(R.drawable.o + random.nextInt(11));
                    view.setAlpha(1);
                }
            }
            counterMoves++;
        }
        // krecemo sa provjerama
        if (counterMoves > 3) {
            //prvi red
            if (score[0] == score[1] && score[1] == score[2] && score[1] != 0) {
                isOver();
                if (score[0] == 1) {
                    winner = Player1;
                    Player1.setNumOfWins(Player1.getNumOfWins() + 1);
                } else if (score[0] == 2) {
                    winner = Player2;
                    Player2.setNumOfWins(Player2.getNumOfWins() + 1);
                }
                Button button1 = (Button) findViewById(R.id.button1);
                Button button2 = (Button) findViewById(R.id.button2);
                Button button3 = (Button) findViewById(R.id.button3);

                animation(button1, button2, button3);
            }
            //drugi red
            if (score[3] == score[4] && score[4] == score[5] && score[3] != 0) {
                isOver();
                if (score[3] == 1) {
                    winner = Player1;
                    Player1.setNumOfWins(Player1.getNumOfWins() + 1);
                } else if (score[3] == 2) {
                    winner = Player2;
                    Player2.setNumOfWins(Player2.getNumOfWins() + 1);
                }
                Button button1 = (Button) findViewById(R.id.button4);
                Button button2 = (Button) findViewById(R.id.button5);
                Button button3 = (Button) findViewById(R.id.button6);

                animation(button1, button2, button3);
            }
            //treci red
            if (score[6] == score[7] && score[7] == score[8] && score[6] != 0) {
                isOver();
                if (score[6] == 1) {
                    winner = Player1;
                    Player1.setNumOfWins(Player1.getNumOfWins() + 1);
                } else if (score[6] == 2) {
                    winner = Player2;
                    Player2.setNumOfWins(Player2.getNumOfWins() + 1);
                }
                Button button1 = (Button) findViewById(R.id.button7);
                Button button2 = (Button) findViewById(R.id.button8);
                Button button3 = (Button) findViewById(R.id.button9);

                animation(button1, button2, button3);
            }
            //prvi stupac
            if (score[0] == score[3] && score[3] == score[6] && score[0] != 0) {
                isOver();
                if (score[0] == 1) {
                    winner = Player1;
                    Player1.setNumOfWins(Player1.getNumOfWins() + 1);
                } else if (score[0] == 2) {
                    winner = Player2;
                    Player2.setNumOfWins(Player2.getNumOfWins() + 1);
                }
                Button button1 = (Button) findViewById(R.id.button1);
                Button button2 = (Button) findViewById(R.id.button4);
                Button button3 = (Button) findViewById(R.id.button7);

                animation(button1, button2, button3);
            }
            //drugi stupac
            if (score[1] == score[4] && score[4] == score[7] && score[4] != 0) {
                isOver();
                if (score[4] == 1) {
                    winner = Player1;
                    Player1.setNumOfWins(Player1.getNumOfWins() + 1);
                } else if (score[4] == 2) {
                    winner = Player2;
                    Player2.setNumOfWins(Player2.getNumOfWins() + 1);
                }
                Button button1 = (Button) findViewById(R.id.button2);
                Button button2 = (Button) findViewById(R.id.button5);
                Button button3 = (Button) findViewById(R.id.button8);

                animation(button1, button2, button3);
            }
            //treci stupac
            if (score[2] == score[5] && score[5] == score[8] && score[2] != 0) {
                isOver();
                if (score[2] == 1) {
                    winner = Player1;
                    Player1.setNumOfWins(Player1.getNumOfWins() + 1);
                } else if (score[2] == 2) {
                    winner = Player2;
                    Player2.setNumOfWins(Player2.getNumOfWins() + 1);
                }
                Button button1 = (Button) findViewById(R.id.button3);
                Button button2 = (Button) findViewById(R.id.button6);
                Button button3 = (Button) findViewById(R.id.button9);

                animation(button1, button2, button3);
            }
            //gl.diagonala
            if (score[0] == score[4] && score[4] == score[8] && score[0] != 0) {
                isOver();
                if (score[0] == 1) {
                    winner = Player1;
                    Player1.setNumOfWins(Player1.getNumOfWins() + 1);
                } else if (score[0] == 2) {
                    winner = Player2;
                    Player2.setNumOfWins(Player2.getNumOfWins() + 1);
                }
                Button button1 = (Button) findViewById(R.id.button1);
                Button button2 = (Button) findViewById(R.id.button5);
                Button button3 = (Button) findViewById(R.id.button9);

                animation(button1, button2, button3);
            }
            //spr.dagonala
            if (score[2] == score[4] && score[4] == score[6] && score[2] != 0) {
                isOver();
                if (score[2] == 1) {
                    winner = Player1;
                    Player1.setNumOfWins(Player1.getNumOfWins() + 1);
                } else if (score[2] == 2) {
                    winner = Player2;
                    Player2.setNumOfWins(Player2.getNumOfWins() + 1);
                }
                Button button1 = (Button) findViewById(R.id.button3);
                Button button2 = (Button) findViewById(R.id.button5);
                Button button3 = (Button) findViewById(R.id.button7);

                animation(button1, button2, button3);
            }
            if(counterMoves==9){
                isOver();
            }
        }

    }

    public void animation(Button button1, Button button2, Button button3) {
        final Animation myAnim1 = AnimationUtils.loadAnimation(this, R.anim.bounce);
        final Animation myAnim2 = AnimationUtils.loadAnimation(this, R.anim.bounce);
        final Animation myAnim3 = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.3, 12);
        myAnim1.setInterpolator(interpolator);
        myAnim2.setInterpolator(interpolator);
        myAnim3.setInterpolator(interpolator);
        button1.startAnimation(myAnim1);
        button2.startAnimation(myAnim2);
        button3.startAnimation(myAnim3);

    }

    public void isOver() {
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        final View result = findViewById(R.id.relativeLayout);
        final TextView xName = (TextView) findViewById(R.id.rezNameX);
        final TextView oName = (TextView) findViewById(R.id.rezNameO);
        final TextView xRez = (TextView) findViewById(R.id.rezX);
        final TextView oRez = (TextView) findViewById(R.id.rezO);

        Button[] polje = {button1, button2, button3, button4, button5, button6, button7, button8, button9};
        for (Button num : polje) {
            num.setClickable(false);
        }
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                result.setVisibility(View.VISIBLE);
                xName.setText(playerX.getName()+": ");
                oName.setText(playerO.getName()+": ");
                xRez.setText(Integer.toString(playerX.getNumOfWins()));
                oRez.setText(Integer.toString(playerO.getNumOfWins()));
            }
        }, 1500);

    }

    public void gameStart() {
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        final View result = findViewById(R.id.relativeLayout);


        Button[] polje = {button1, button2, button3, button4, button5, button6, button7, button8, button9};
        for (Button num : polje) {
            num.setAlpha(0);
            num.setClickable(true);
            num.clearAnimation();
        }

        for (int i = 0; i < score.length; i++) {
            score[i] = 0;
        }
        if (counterGames % 2 == 0) {
            Player1 = playerX;
            Player2 = playerO;
        } else {
            Player1 = playerO;
            Player2 = playerX;
        }
        Toast toast = Toast.makeText(this, Player1.getName()+" plays first!", Toast.LENGTH_SHORT);
        toast.show();

        counterMoves = 0;
        counterGames++;
        result.setVisibility(View.GONE);

    }

    public void playAgain(View view) {
        gameStart();
    }
}