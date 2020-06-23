package com.example.otrstattelecom.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.otrstattelecom.presenter.TaksViewPresenter;
import com.example.otrstattelecom.utils.Pref;
import com.example.otrstattelecom.view.adapters.MessageListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewTask extends AppCompatActivity implements TaskView{
    @BindView(R.id.textViewState)
    TextView textViewState;
    @BindView(R.id.textViewText)
    TextView textViewText;
    @BindView(R.id.textViewImportance)
    TextView textViewImportance;
    @BindView(R.id.button_chatbox_send)
    Button button;
    @BindView(R.id.edittext_chatbox)
    EditText editText;
    @BindView(R.id.rv)
    RecyclerView recyclerView;
    private MessageListAdapter mMessageAdapter;
    Ticket ticket;
    private TaksViewPresenter taksViewPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);
        ButterKnife.bind(this);
        taksViewPresenter = new TaksViewPresenter(this);

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


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taksViewPresenter.setMessage(editText.getText().toString(), ticket.getTicketID(), prefManager.getToken().getSessionID());
            }
        });

}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTaskSuccess(List<Ticket> tickets) {
        mMessageAdapter.add(0, tickets.get(0).getArticleList());
        Toast.makeText(getBaseContext(), "succes", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onTaskFailed(String error) {
        Toast.makeText(getBaseContext(), error, Toast.LENGTH_LONG).show();

    }
}
