package com.example.otrstattelecom.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.otrstattelecom.R;
import com.example.otrstattelecom.model.Ticket;
import com.example.otrstattelecom.view.ViewTask;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.ViewHolderTask> {

    List<Ticket> tickets;
    Context context;
    private int lastPosition = -1;

    public TicketAdapter(List<Ticket> tickets, Context context) {
        this.tickets = tickets;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderTask onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rowView = layoutInflater.inflate(R.layout.list_task, parent, false);

        return new ViewHolderTask(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTask holder, int position) {

        holder.textViewImportance.setText(tickets.get(position).getPriority());
        holder.textViewState.setText(tickets.get(position).getState());
        holder.textViewText.setText(tickets.get(position).getTitle());
        holder.textViewDate.setText(tickets.get(position).getCreated());
        holder.textViewLock.setText(tickets.get(position).getLock());
        holder.textViewName.setText(tickets.get(position).getOwner());

        holder.itemView.setOnClickListener(view -> {
            startActivity(tickets.get(position));
        });

        setAnimation(holder.itemView, position);

    }

    private void startActivity(Ticket tasks) {
        Intent intent = new Intent(context, ViewTask.class);
        intent.putExtra("TASK", tasks);
        context.startActivity(intent);
    }
    @Override
    public int getItemCount() {
        return tickets.size();
    }

    public void add(int i, List<Ticket> list) {

        //Collections.reverse(list);

        tickets.clear();
        tickets.addAll(i, list);
        notifyItemRangeChanged(i, list.size());
    }




    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }


    public class ViewHolderTask extends RecyclerView.ViewHolder{

        @BindView(R.id.textViewState)
        TextView textViewState;
        @BindView(R.id.textViewText)
        TextView textViewText;
        @BindView(R.id.textViewImportance)
        TextView textViewImportance;
        @BindView(R.id.textViewName)
        TextView textViewName;
        @BindView(R.id.textViewDate)
        TextView textViewDate;
        @BindView(R.id.textViewLock)
        TextView textViewLock;
        @BindView(R.id.card_view)
        CardView cardView;

        public ViewHolderTask(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

