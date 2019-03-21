package br.com.wevs.bankapp.ui.recyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.wevs.bankapp.R;
import br.com.wevs.bankapp.model.Statement;

public class ListStatementsAdapter extends RecyclerView.Adapter<ListStatementsAdapter.StatementsViewHolder> {

    private final List<Statement> statements;
    private final Context context;

    public ListStatementsAdapter(Context context, List<Statement> statements) {
        this.context = context;
        this.statements = statements;
    }

    @NonNull
    @Override
    public StatementsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View createView = LayoutInflater.from(context)
                .inflate(R.layout.item_card_payment, viewGroup, false);
        return new StatementsViewHolder(createView);
    }

    @Override
    public void onBindViewHolder(@NonNull StatementsViewHolder notaViewHolder, int position) {
        Statement statement = statements.get(position);
    }

    @Override
    public int getItemCount() {
        return statements.size();
    }

    public class StatementsViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView description;
        private final TextView date;
        private final TextView value;


        public StatementsViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_payment_title);
            description = itemView.findViewById(R.id.item_payment_description);
            date = itemView.findViewById(R.id.item_payment_date);
            value = itemView.findViewById(R.id.item_payment_value);
        }
    }
}
