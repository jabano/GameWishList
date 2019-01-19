package com.example.jeneska.gamewishlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {

    class GameViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTextView, platformTextView, genreTextView, costRangeTextView, interestTextView, releaseDateTextView;

        private GameViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textViewTitle);
            platformTextView = itemView.findViewById(R.id.textViewPlatform);
            genreTextView = itemView.findViewById(R.id.textViewGenre);
            costRangeTextView = itemView.findViewById(R.id.textViewCostRange);
            interestTextView = itemView.findViewById(R.id.textViewInterest);
            releaseDateTextView = itemView.findViewById(R.id.textViewReleaseDate);
        }
    }

    private final LayoutInflater mInflater;
    private List<Game> mGames;

    GameAdapter(Context mContext) { mInflater = LayoutInflater.from(mContext); }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new GameViewHolder(itemView);
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
        else{
            holder.titleTextView.setText("No Word");
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

    public interface OnGameItemClick{
        void onGameClick(int pos);
    }
}
