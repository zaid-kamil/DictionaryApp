package com.zbk.dictionaryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.zbk.dictionaryapp.db.Word;

import java.util.List;


    public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

        class WordViewHolder extends RecyclerView.ViewHolder {
            private final TextView wordName,wordDef;

            private WordViewHolder(View itemView) {
                super(itemView);
                wordName = itemView.findViewById(R.id.textName);
                wordDef = itemView.findViewById(R.id.textDef);
            }
        }

        private final LayoutInflater mInflater;
        private List<Word> mWords; // Cached copy of words
        WordListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

        @Override
        public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = mInflater.inflate(R.layout.word_card, parent, false);
            return new WordViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(WordViewHolder holder, int position) {
            if (mWords != null) {
                Word current = mWords.get(position);
                holder.wordName.setText(current.getWord());
                holder.wordDef.setText(current.getDefinition());
            } else {
                // Covers the case of data not being ready yet.
                holder.wordName.setText("No Word");
                holder.wordDef.setText("No Definition");
            }
        }

        void setWords(List<Word> words){
            mWords = words;
            notifyDataSetChanged();
        }

        // getItemCount() is called many times, and when it is first called,
        // mWords has not been updated (means initially, it's null, and we can't return null).
        @Override
        public int getItemCount() {
            if (mWords != null)
                return mWords.size();
            else return 0;
        }
    }

