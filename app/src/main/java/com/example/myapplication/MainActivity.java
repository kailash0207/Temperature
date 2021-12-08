package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText) findViewById(R.id.chirps_editText);
        Button button = (Button) findViewById(R.id.button);



        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String text = editText.getText().toString();
                        if(text.equals("")){
                            String message = "Please enter a number";
                            display_toast(message);
                            return;
                        }
                        int numberOfChirps = Integer.parseInt(text);
                        double temperature = calculate_temperature(numberOfChirps);
                        display_result(temperature);
                    }
                }
        );
    }

    private double calculate_temperature(int number){
        return Math.round((number/3.0 + 4) * 100 )/ 100.0;
    }
    public void display_result(double temp){
        String message = "The approximate temperature outside is " + temp + " degrees celsius.";
        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setText(message);

    }
    public void display_toast(String message){
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();

    }
}