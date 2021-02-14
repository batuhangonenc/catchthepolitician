package com.batuhangonenc.catchthepolitician;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class SelectionActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        editText = findViewById( R.id.timersel);
    }

    public void startBiden ( View view )  {
        Intent intent = new Intent(SelectionActivity.this, GameActivity.class );
        intent.putExtra("politician", "biden");

        String data = editText.getText().toString();
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


        intent.putExtra("timer", time);
        startActivity ( intent );
    }

    public void startTredau ( View view ) {
        Intent intent = new Intent(SelectionActivity.this, GameActivity.class );
        intent.putExtra("politician", "tredau");

        String data = editText.getText().toString();
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

        intent.putExtra("timer", time);
        startActivity ( intent );
    }


    public void startMacron ( View view ) {
        Intent intent = new Intent(SelectionActivity.this, GameActivity.class );
        intent.putExtra("politician", "macron");

        String data = editText.getText().toString();
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

        intent.putExtra("timer", time);
        startActivity ( intent );
    }

    public void startMerkel ( View view )  {
        Intent intent = new Intent(SelectionActivity.this, GameActivity.class );
        intent.putExtra("politician", "merkel");

        String data = editText.getText().toString();
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

        intent.putExtra("timer", time);
        startActivity ( intent );
    }

    public void startCinping ( View view )  {
        Intent intent = new Intent(SelectionActivity.this, GameActivity.class );

        String data = editText.getText().toString();
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



        intent.putExtra("timer", time);
        intent.putExtra("politician", "cinping");

        startActivity ( intent );
    }
}