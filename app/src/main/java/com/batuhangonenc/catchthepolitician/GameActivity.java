package com.batuhangonenc.catchthepolitician;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView ImageArray[];


    Runnable runnable;
    Runnable runn2;

    Handler handler2;
    Handler handler;

    SharedPreferences sharedPreferences;
    int score, timer;

    TextView textView_1;
    TextView textView_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        Intent intent = getIntent();

        int data = intent.getIntExtra("timer", -1);
        if ( data != -1 )
            timer = data;

        else
            timer = 60;

        String polname = intent.getStringExtra("politician");

        imageView1 = findViewById(R.id.ImageView1);
        imageView2 = findViewById(R.id.ImageView2);
        imageView3 = findViewById(R.id.ImageView3);
        imageView4 = findViewById(R.id.ImageView4);
        imageView5 = findViewById(R.id.ImageView5);
        imageView6 = findViewById(R.id.ImageView6);
        imageView7 = findViewById(R.id.ImageView7);
        imageView8 = findViewById(R.id.ImageView8);
        imageView9 = findViewById(R.id.ImageView9);

        if ( !polname.matches("") ) {
            if ( polname.matches("biden")) {
                imageView1.setImageResource(R.drawable.biden);
                imageView2.setImageResource(R.drawable.biden);
                imageView3.setImageResource(R.drawable.biden);
                imageView4.setImageResource(R.drawable.biden);
                imageView5.setImageResource(R.drawable.biden);
                imageView6.setImageResource(R.drawable.biden);
                imageView7.setImageResource(R.drawable.biden);
                imageView8.setImageResource(R.drawable.biden);
                imageView9.setImageResource(R.drawable.biden);

            }

            else if ( polname.matches("tredau")) {
                imageView1.setImageResource(R.drawable.tredau);
                imageView2.setImageResource(R.drawable.tredau);
                imageView3.setImageResource(R.drawable.tredau);
                imageView4.setImageResource(R.drawable.tredau);
                imageView5.setImageResource(R.drawable.tredau);
                imageView6.setImageResource(R.drawable.tredau);
                imageView7.setImageResource(R.drawable.tredau);
                imageView8.setImageResource(R.drawable.tredau);
                imageView9.setImageResource(R.drawable.tredau);

            }
            else if ( polname.matches("macron")) {
                imageView1.setImageResource(R.drawable.macron);
                imageView2.setImageResource(R.drawable.macron);
                imageView3.setImageResource(R.drawable.macron);
                imageView4.setImageResource(R.drawable.macron);
                imageView5.setImageResource(R.drawable.macron);
                imageView6.setImageResource(R.drawable.macron);
                imageView7.setImageResource(R.drawable.macron);
                imageView8.setImageResource(R.drawable.macron);
                imageView9.setImageResource(R.drawable.macron);

            }

            else if ( polname.matches("merkel")) {
                imageView1.setImageResource(R.drawable.merkel);
                imageView2.setImageResource(R.drawable.merkel);
                imageView3.setImageResource(R.drawable.merkel);
                imageView4.setImageResource(R.drawable.merkel);
                imageView5.setImageResource(R.drawable.merkel);
                imageView6.setImageResource(R.drawable.merkel);
                imageView7.setImageResource(R.drawable.merkel);
                imageView8.setImageResource(R.drawable.merkel);
                imageView9.setImageResource(R.drawable.merkel);

            }

            else if ( polname.matches("cinping")) {
                imageView1.setImageResource(R.drawable.cinping);
                imageView2.setImageResource(R.drawable.cinping);
                imageView3.setImageResource(R.drawable.cinping);
                imageView4.setImageResource(R.drawable.cinping);
                imageView5.setImageResource(R.drawable.cinping);
                imageView6.setImageResource(R.drawable.cinping);
                imageView7.setImageResource(R.drawable.cinping);
                imageView8.setImageResource(R.drawable.cinping);
                imageView9.setImageResource(R.drawable.cinping);
            }
        }

        ImageArray = new ImageView[]{ imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9 };

        sharedPreferences = getSharedPreferences( "com.batuhangonenc.catchthepolitician", Context.MODE_PRIVATE );
        score = 0;

        textView_1 = findViewById( R.id.textView );
        textView_2 = findViewById( R.id.textView2 );



        handler2 = new Handler();
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                if ( timer == 0 ) {
                    handler.removeCallbacks( runnable );
                    handler2.removeCallbacks( runn2 );

                    int storedScore = sharedPreferences.getInt("best_score", -1);

                    if ( score > storedScore )
                        sharedPreferences.edit().putInt("best_score", score ).apply();

                    Toast.makeText(GameActivity.this, "Last Score : "+ score, Toast.LENGTH_LONG ).show();

                    Intent intent = new Intent( GameActivity.this, MainActivity.class );
                    startActivity( intent );

                }

                textView_1.setText( "Time : " + ( timer-- ));
                handler.postDelayed( runnable, 1000 );
            }
        };

        runn2 = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : ImageArray)
                    image.setVisibility(View.INVISIBLE);

                int randomint = (int) Math.floor(Math.random() * 9);

                ImageArray[randomint].setVisibility(View.VISIBLE);
                handler2.postDelayed( runn2, 300 );
            }
        };

        handler.post( runnable );
        handler2.post(runn2);
    }

    public void endGame ( View view ) {

        Toast.makeText(GameActivity.this, "Last Score : "+ score, Toast.LENGTH_LONG ).show();

        int storedScore = sharedPreferences.getInt("best_score", -1);

        if ( score > storedScore )
            sharedPreferences.edit().putInt("best_score", score ).apply();

        handler.removeCallbacks( runnable );
        handler2.removeCallbacks( runn2 );

        Intent intent = new Intent( GameActivity.this, MainActivity.class );
        startActivity( intent );
    }

    public void increaseScore ( View view ) {
        textView_2.setText( "Score : " + (++score));
    }


}
