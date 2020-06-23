package com.example.otrstattelecom.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.otrstattelecom.R;
import com.example.otrstattelecom.model.Ticket;
import com.example.otrstattelecom.utils.Pref;
import com.example.otrstattelecom.view.adapters.MessageListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewTask extends AppCompatActivity {
    @BindView(R.id.textViewState)
    TextView textViewState;
    @BindView(R.id.textViewText)
    TextView textViewText;
    @BindView(R.id.textViewImportance)
    TextView textViewImportance;

    @BindView(R.id.rv)
    RecyclerView recyclerView;
    private MessageListAdapter mMessageAdapter;
    Ticket ticket;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        Pref prefManager = Pref.getInstance(ViewTask.this);
        if (getIntent().getSerializableExtra("TASK") != null) {
            ticket = (Ticket) getIntent().getSerializableExtra("TASK");
            Toast.makeText(getBaseContext(), String.valueOf(ticket.getAge()), Toast.LENGTH_LONG).show();
            setTitle(ticket.getService());

            textViewImportance.setText(ticket.getPriority());
            textViewState.setText(ticket.getState());
            textViewText.setText(ticket.getTitle());
            //textViewDate.setText(ticket.getCreated());

    }

        mMessageAdapter = new MessageListAdapter(this, ticket.getArticleList());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mMessageAdapter);

}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

}
