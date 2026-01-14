package com.example.simplenotes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    EditText editNote;
    Button btnSave;
    TextView txtNote;
    ArrayList<String> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNote = findViewById(R.id.editNote);
        btnSave = findViewById(R.id.btnSave);
        txtNote = findViewById(R.id.txtNote);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = editNote.getText().toString().trim();

                if (note.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Please write a note",
                            Toast.LENGTH_SHORT).show();
                } else {
                    notes.add(note);
                    String allNotes = "";
                    for (String n : notes) {
                        allNotes += "• " + n + "\n";
                    }

                    txtNote.setText(allNotes);
                    editNote.setText("");
                }
            }
        });
    }
}