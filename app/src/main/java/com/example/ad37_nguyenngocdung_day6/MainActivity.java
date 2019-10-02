package com.example.ad37_nguyenngocdung_day6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;
    int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Note App");

        final User user = new User("admin","Admin123*","Admin");

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(user);
            }
        });
    }

    public void validate(User user){
        Pattern ps = Pattern.compile("^" +
                "(?=.*[0-9])" +
                //"(?=.*[a-z])" +
                //"(?=.*[A-Z])" +
                "(?=.*[a-zA-Z])" +
                "(?=.*[*@#$%^&+=])" +
                "(?=\\S+$)" +
                ".{6,}" +
                "$");

        if ((user.getUserName().equals(etUsername.getText().toString()))
                && (user.getPassword().equals(etPassword.getText().toString()))){
            Toast.makeText(getBaseContext(), "Successful! Hello " + user.getName(), Toast.LENGTH_LONG).show();

            Intent intent = new Intent(getBaseContext(), NoteActivity.class);
            startActivity(intent);

        } else if ((etPassword.length() == 0) || (etUsername.length() == 0)) {
            Toast.makeText(getBaseContext(), "Username or password is empty", Toast.LENGTH_LONG).show();
            counter--;

            if(counter==0){
                btnLogin.setEnabled(false);
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Error")
                        .setMessage("You tried the password too many time")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();
                alertDialog.show();
            }
        } else if (etPassword.length() < 6) {
            Toast.makeText(getBaseContext(), "No less than 6 characters", Toast.LENGTH_LONG).show();
            counter--;

            if(counter==0){
                btnLogin.setEnabled(false);
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Error")
                        .setMessage("You tried the password too many time")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();
                alertDialog.show();
            }
        } else if (!ps.matcher(etPassword.getText().toString()).matches()) {
            Toast.makeText(getBaseContext(), "Need upper, lower, number, special character", Toast.LENGTH_LONG).show();
            counter--;

            if(counter==0){
                btnLogin.setEnabled(false);
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Error")
                        .setMessage("You tried the password too many time")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();
                alertDialog.show();
            }
        } else {
            Toast.makeText(getBaseContext(), "Failed", Toast.LENGTH_LONG).show();
            counter--;

            if(counter==0){
                btnLogin.setEnabled(false);
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Error")
                        .setMessage("You tried the password too many time")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();
                alertDialog.show();
            }
        }
    }
}
