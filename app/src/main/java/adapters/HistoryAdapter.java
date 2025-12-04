package com.tracetrail.mobile.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tracetrail.mobile.R;
import com.tracetrail.mobile.models.AnalyzeResult;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private List<AnalyzeResult> results;

    public HistoryAdapter(List<AnalyzeResult> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        AnalyzeResult result = results.get(position);
        holder.reportText.setText(result.getReport());
        holder.scoreText.setText("Score: " + result.getScore());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    static class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView reportText, scoreText;
        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            reportText = itemView.findViewById(R.id.item_report);
            scoreText = itemView.findViewById(R.id.item_score);
        }
    }
}
