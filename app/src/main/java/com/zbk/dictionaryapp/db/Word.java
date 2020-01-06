package com.zbk.dictionaryapp.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    @ColumnInfo(name = "definition")
    private String mDefinition;

    public Word(String word, String definition) {
        this.mWord = word;
        this.mDefinition = definition;
    }

    public String getWord() {
        return mWord;
    }

    public String getDefinition() {
        return mDefinition;
    }
}
