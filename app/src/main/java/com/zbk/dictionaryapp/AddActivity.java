package com.zbk.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        EditText editWord= findViewById(R.id.editWord);
        EditText editDef= findViewById(R.id.editDef);

        Button button = findViewById(R.id.btnSave);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(editWord.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = editWord.getText().toString();
                    String def = editDef.getText().toString();
                    replyIntent.putExtra("word", word);
                    replyIntent.putExtra("definition", def);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}