package com.example.otrstattelecom.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.example.otrstattelecom.R;
import com.example.otrstattelecom.model.Ticket;
import com.example.otrstattelecom.model.TicketIDs;
import com.example.otrstattelecom.model.TicketsModel;
import com.example.otrstattelecom.presenter.GetTaskPresenter;
import com.example.otrstattelecom.utils.Pref;

import com.example.otrstattelecom.view.adapters.TicketAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Tasks extends AppCompatActivity implements  GetTasksView {
    ProgressDialog progressDialog;
    GetTaskPresenter taskPresenter;
    List<Ticket> list;
    @Nullable
    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefresh_items)
    SwipeRefreshLayout mSwipeRefreshLayout;
    TicketAdapter tasksAdapter;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;
    Pref prefManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//          getSupportActionBar().setTitle("Заказы");
//        ((AppCompatActivity)this).getSupportActionBar().setTitle("Your Title");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("OTRS Tattelecom");
        prefManager = Pref.getInstance(this);


        taskPresenter = new GetTaskPresenter(this, prefManager);



        taskPresenter.getTickets(prefManager.getToken().getSessionID());

       // onTaskFailed(prefManager.getToken().getSessionID());
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        progressDialog = new ProgressDialog(Tasks.this,
                R.style.Theme_AppCompat_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Tasks...");
        progressDialog.show();

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.items, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        SwipeController swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
                progressDialog.show();
                taskPresenter.closeTask(prefManager.getToken().getSessionID(), list.get(position).getTicketID());
                //onTaskFailed(String.valueOf(position));

            }

            @Override
            public void onLeftClicked(int position){
                progressDialog.show();
                taskPresenter.lockTask(prefManager.getToken().getSessionID(), list.get(position).getTicketID(), list.get(position).getLock());
            }
        }, this);
        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), TaskAdd.class);
//                startActivity(intent);
//            }
//        });



        list = new ArrayList<>();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        tasksAdapter = new TicketAdapter(list, this);

        recyclerView.setAdapter(tasksAdapter);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                taskPresenter.getTickets(prefManager.getToken().getSessionID());
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item_1:
                        break;
                    case  R.id.item_2:
                        break;
                    case R.id.item_3:
                        Logged();
                        break;

                }
                return false;


            }
        });

    }

    private void Logged(){
        prefManager.logout();
        Intent intent = new Intent(this, LoginActivity.class);
        //intent.putIntegerArrayListExtra(Pref.EXTRA_USER, (ArrayList<Integer>) userModel.getList());
        startActivity(intent);
        finish();
    }



    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }




    public void onTaskSuccess(List<Ticket> tickets) {
        progressDialog.dismiss();
        mSwipeRefreshLayout.setRefreshing(false);
        Log.d("TAG", tickets.get(0).getTitle());

        Toast.makeText(getBaseContext(), tickets.get(0).getTitle(), Toast.LENGTH_LONG).show();

        if(!tickets.isEmpty()) {

            tasksAdapter.add(0, tickets);

            Toast.makeText(getBaseContext(), "success" + tickets.get(0).getTitle(), Toast.LENGTH_LONG).show();

        } else {

            Toast.makeText(getBaseContext(), "У вас отсутсвуют таски", Toast.LENGTH_LONG).show();
        }
        //finish();

    }

    public void onTaskFailed(String error) {
        mSwipeRefreshLayout.setRefreshing(false);
        progressDialog.dismiss();
        Toast.makeText(getBaseContext(), error, Toast.LENGTH_LONG).show();


    }
}
