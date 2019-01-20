package com.example.jeneska.gamewishlist;

import android.app.AlertDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {

    private final LayoutInflater mInflater;
    private List<Game> mGames;

    //added
    private OnGameItemClickListener onGameItemClickListener;

    //interface so that adapter can handle clicks in the MainActivity
    public interface OnGameItemClickListener {
        void onGameItemClick(int position);
    }

    GameAdapter(Context mContext) {
        mInflater = LayoutInflater.from(mContext);
        this.onGameItemClickListener = (OnGameItemClickListener) mContext;
    }

    //added implements view.onclicklistener
    class GameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView titleTextView, platformTextView, genreTextView, costRangeTextView, interestTextView, releaseDateTextView;

        //added
        private OnGameItemClickListener onGameItemClickListener;

        private GameViewHolder(View itemView, OnGameItemClickListener onGameItemClickListener) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textViewTitle);
            platformTextView = itemView.findViewById(R.id.textViewPlatform);
            genreTextView = itemView.findViewById(R.id.textViewGenre);
            costRangeTextView = itemView.findViewById(R.id.textViewCostRange);
            interestTextView = itemView.findViewById(R.id.textViewInterest);
            releaseDateTextView = itemView.findViewById(R.id.textViewReleaseDate);

            //added
            this.onGameItemClickListener = onGameItemClickListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onGameItemClickListener.onGameItemClick(getAdapterPosition());
        }
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new GameViewHolder(itemView, onGameItemClickListener);
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, int position) {
        if(mGames != null) {
            Game current = mGames.get(position);
            holder.titleTextView.setText(current.getTitle());
            holder.platformTextView.setText(current.getPlatform());
            holder.genreTextView.setText(current.getGenre());
            holder.costRangeTextView.setText(current.getCostRange());
            holder.interestTextView.setText(current.getInterest());
            holder.releaseDateTextView.setText(current.getReleaseDate());
        }
    }

    void setGames(List<Game> games) {
        mGames = games;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mGames != null)
            return mGames.size();
        else return 0;
    }

    public Game getGameAtPosition(int position) {
        return mGames.get(position);
    }


}
