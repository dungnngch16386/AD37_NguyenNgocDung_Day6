package com.example.ad37_nguyenngocdung_day6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NoteActivity extends AppCompatActivity {

    EditText etTitle, etDescription;
    TextView tvTime, tvDate, tvTags, tvWeeks;
    Spinner spType;
    Button btnTune;

    ArrayList<String> listType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        setTitle("Create New Note");

        etTitle = findViewById(R.id.etTitle);
        etDescription = findViewById(R.id.etDescription);
        tvTime = findViewById(R.id.tvTime);
        tvDate = findViewById(R.id.tvDate);
        tvTags = findViewById(R.id.tvTags);
        tvWeeks = findViewById(R.id.tvWeeks);
        spType = findViewById(R.id.spType);
        btnTune = findViewById(R.id.btnTune);

        listType = new ArrayList<>();
        listType.add("Work");
        listType.add("House");
        listType.add("Remmeber");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, listType);
        spType.setAdapter(arrayAdapter);

        tvTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] group = {"Family", "Game", "Android", "VTC", "Friend"};
                boolean[] isChecks = {true, false, true, false, true};

                AlertDialog alertDialog = new AlertDialog.Builder(NoteActivity.this)
                        .setTitle("Choose tags")
                        .setMultiChoiceItems(group, isChecks, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();
                alertDialog.show();
            }
        });

        tvWeeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] group = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
                boolean[] isChecks = {true, true, false, false, false, true, false};

                AlertDialog alertDialog = new AlertDialog.Builder(NoteActivity.this)
                        .setTitle("Choose tags")
                        .setMultiChoiceItems(group, isChecks, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();
                alertDialog.show();
            }
        });

        btnTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(), view);
                popupMenu.getMenuInflater().inflate(R.menu.new_menu2,
                        popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.mnItemFromFile:
                                Toast.makeText(getBaseContext(), "Select file", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.mnItemFromDefault:
                                String[] tunes = {"Nexus Tune", "Winphone Tune", "Peep Tune", "Nokia tune"};
                                AlertDialog alertDialog = new AlertDialog.Builder(NoteActivity.this)
                                        .setTitle("Set RingTune")
                                        .setSingleChoiceItems(tunes, 0, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                            }
                                        })
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Toast.makeText(getBaseContext(), "OK", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Toast.makeText(getBaseContext(), "Cancel", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .create();

                                alertDialog.show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.new_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnItemSave:
                Toast.makeText(getBaseContext(), "Save", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnItemCancel:
                Toast.makeText(getBaseContext(), "Cancel", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
