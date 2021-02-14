package com.batuhangonenc.catchthepolitician;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById( R.id.bestScoreView );
        editText = findViewById( R.id.editTextMain );

        sharedPreferences = this.getSharedPreferences("com.batuhangonenc.catchthepolitician", Context.MODE_PRIVATE);

        int storedScore = sharedPreferences.getInt( "best_score", -1);
        int best_score;

        if ( storedScore != -1 )
            best_score = storedScore;

        else
            best_score = 0;

        textView.setText( "Best Score : " + best_score );
    }

    public void startGame ( View view ) {
        Intent intent = new Intent(MainActivity.this, GameActivity.class );

        String data =  editText.getText().toString() ;

        boolean flag = true;

        int time = 60;

        for ( char val : data.toCharArray() ) {

            if ( ! ( val == '0' ||
                    val == '1' ||
                    val == '2' ||
                    val == '3' ||
                    val == '4' ||
                    val == '5' ||
                    val == '6' ||
                    val == '7' ||
                    val == '8' ||
                    val == '9' ) ) {

                flag = false;
                break;
            }
        }

        if ( data.matches("") )
            flag = false;

        if ( flag )
            time = Integer.parseInt( data );

        else
            time = 60;


        intent.putExtra( "timer", time);

        String polname;
        int rnd = (int ) Math.floor ( Math.random() * 6 );

        if ( rnd == 1 )
            polname = "cinping";

        else if ( rnd == 2 )
            polname = "macron";

        else if ( rnd == 3 )
            polname = "merkel";

        else if ( rnd == 4 )
            polname = "tredau";

        else if ( rnd == 5 )
            polname = "biden";

        else
            polname = "cinping";


        intent.putExtra( "politician", polname);
        startActivity ( intent );
    }


    public void resetScore ( View view ) {
        sharedPreferences.edit().remove("best_score").apply();
        textView.setText("Best Score : 0");
    }

    public void selectPolitician ( View view ) {
        Intent intent= new Intent ( MainActivity.this, SelectionActivity.class );
        startActivity( intent );
    }

}