package com.example.otrstattelecom.view;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.otrstattelecom.R;
import com.example.otrstattelecom.model.Article;
import com.example.otrstattelecom.model.Ticket;
import com.example.otrstattelecom.presenter.TaksViewPresenter;
import com.example.otrstattelecom.utils.Pref;
import com.example.otrstattelecom.view.adapters.MessageListAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;
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
    @BindView(R.id.textViewName)
    TextView textViewName;
    @BindView(R.id.textViewDate)
    TextView textViewDate;
    @BindView(R.id.textViewLock)
    TextView textViewLock;
    @BindView(R.id.card_view)
    CardView cardView;
    @BindView(R.id.button_chatbox_send)
    Button button;
    @BindView(R.id.edittext_chatbox)
    EditText editText;
    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefresh_items)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.textViewInfo)
    TextView textViewInfo;
    @BindView(R.id.imageView)
    ImageView imageView;
    ListView listViewH;
    ListView listViewIn;
    boolean position;

    private MessageListAdapter mMessageAdapter;
    Ticket ticket;
    private TaksViewPresenter taksViewPresenter;
    List<Article> articleList;


    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);
        ButterKnife.bind(this);
        View headerLayout = navigationView.getHeaderView(0);
        position = false;

        listViewH = (ListView)  headerLayout.findViewById(R.id.listViewH);
        listViewIn = (ListView) headerLayout.findViewById(R.id.listViewIn);





        taksViewPresenter = new TaksViewPresenter(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        articleList = new ArrayList<>();


        textViewInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.END);
            }
        });




        Pref prefManager = Pref.getInstance(ViewTask.this);
        if (getIntent().getSerializableExtra("TASK") != null) {
            ticket = (Ticket) getIntent().getSerializableExtra("TASK");
            Toast.makeText(getBaseContext(), String.valueOf(ticket.getAge()), Toast.LENGTH_LONG).show();

            switch (Integer.valueOf(String.valueOf(ticket.getPriority().charAt(0)))){
                case 1: imageView.setImageDrawable(getResources().getDrawable(R.drawable.shape_low));
                    break;
                case 2: imageView.setImageDrawable(getResources().getDrawable(R.drawable.shape_very_high));
                    break;
                case 3: imageView.setImageDrawable(getResources().getDrawable(R.drawable.shape_high));
                    break;
                case 4: imageView.setImageDrawable(getResources().getDrawable(R.drawable.shape_normal));
                    break;
                case 5: imageView.setImageDrawable(getResources().getDrawable(R.drawable.shape_very_low));
                    break;
            }




            setTitle(ticket.getService());

            textViewImportance.setText(ticket.getPriority().split(" ")[1]);
            textViewState.setText(ticket.getState());
            textViewText.setText(ticket.getTitle());

            textViewImportance.setText(ticket.getPriority());
            textViewState.setText(ticket.getState());
            textViewText.setText(ticket.getTitle());
            textViewDate.setText(ticket.getCreated());
            textViewLock.setText(ticket.getLock());
            textViewName.setText(ticket.getOwner());
            //textViewDate.setText(ticket.getCreated());

    }


        mMessageAdapter = new MessageListAdapter(this, articleList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mMessageAdapter);

        onTaskFailed("start");
        taksViewPresenter.getTasks(new ArrayList<String>(Arrays.asList(ticket.getTicketID())), prefManager.getToken().getSessionID());
        onTaskFailed("finish");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taksViewPresenter.setMessage(editText.getText().toString(), ticket.getTicketID(), prefManager.getToken().getSessionID());
                position = true;
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                taksViewPresenter.getTasks(new ArrayList<String>(Arrays.asList(ticket.getTicketID())), prefManager.getToken().getSessionID());
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
        mSwipeRefreshLayout.setRefreshing(false);
        if(tickets.get(0).getArticleList() != null) {
            mMessageAdapter.add(0, tickets.get(0).getArticleList());

            if(!position)
                recyclerView.scrollToPosition(0);
            else
                recyclerView.scrollToPosition(tickets.get(0).getArticleList().size() - 1);
            editText.setText("");
            Toast.makeText(getBaseContext(), "succes", Toast.LENGTH_LONG).show();

            final String[] tempH = new String[]{"Number", "Type", "Age", "Created", "State", "Locked", "Queue", "Service", "Priority", "Customer",
            "Owner", "Update"};

            final String[] temp = new String[]{
                tickets.get(0).getTicketNumber(),
                tickets.get(0).getType(),
                tickets.get(0).getAge(),
                tickets.get(0).getCreated(),
                tickets.get(0).getState(),
                tickets.get(0).getLock(),
                tickets.get(0).getQueue(),
                tickets.get(0).getService(),
                tickets.get(0).getPriority(),
                tickets.get(0).getCustomerUserID(),
                tickets.get(0).getOwner(),
                tickets.get(0).getEscalationUpdateTime()
            };



            //String[] arr = tickets.get(0).getArticleList().toArray(new String[ tickets.get(0).getArticleList().size()]);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    R.layout.list_item_info, temp);

            ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,
                    R.layout.list_item_header, tempH);

           listViewH.setAdapter(adapter);
           listViewIn.setAdapter(adapter1);
        }
    }

    @Override
    public void onTaskFailed(String error) {
        mSwipeRefreshLayout.setRefreshing(false);
        Toast.makeText(getBaseContext(), error, Toast.LENGTH_LONG).show();

    }
}
