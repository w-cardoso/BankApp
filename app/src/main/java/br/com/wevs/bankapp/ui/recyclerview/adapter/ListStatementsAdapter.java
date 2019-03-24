package br.com.wevs.bankapp.ui.recyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import br.com.wevs.bankapp.R;
import br.com.wevs.bankapp.model.Statement;

public class ListStatementsAdapter extends RecyclerView.Adapter<ListStatementsAdapter.StatementsViewHolder> {

    private final List<Statement> statements;
    private final Context context;

    public ListStatementsAdapter(List<Statement> statements, Context context) {
        this.context = context;
        this.statements = statements;
    }


    @Override
    public StatementsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View createView = LayoutInflater.from(context)
                .inflate(R.layout.item_card_payment, viewGroup, false);
        return new StatementsViewHolder(createView);
    }

    @Override
    public void onBindViewHolder(@NonNull StatementsViewHolder statementsItem, int position) {
        statementsItem.title.setText(statements.get(position).getTitle());
        String dateFormated = transformDateBr(position);
        statementsItem.date.setText(dateFormated);
        statementsItem.description.setText(statements.get(position).getDescription());
        String valueFormated = transformInCoin(position);
        statementsItem.value.setText(String.valueOf(valueFormated));
    }

    private String transformDateBr(int position) {
        DateFormat formatUS = new SimpleDateFormat("yyyy-mm-dd");
        Date date = null;
        try {
            date = formatUS.parse(statements.get(position).getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }


        DateFormat formatBR = new SimpleDateFormat("dd/mm/yyyy");
        return formatBR.format(date);
    }

    private String transformInCoin(int position) {
        Double value = statements.get(position).getValue();
        Locale coinBr = new Locale("pt", "BR");
        return NumberFormat.getCurrencyInstance(coinBr).format(value);
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
