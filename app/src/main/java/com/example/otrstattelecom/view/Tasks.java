package com.example.otrstattelecom.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.example.otrstattelecom.R;
import com.example.otrstattelecom.model.response.Ticket;
import com.example.otrstattelecom.presenter.GetTaskPresenter;
import com.example.otrstattelecom.utils.Pref;

import com.example.otrstattelecom.view.adapters.TicketAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;


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
    private List<String> stateType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        stateType = new ArrayList<>();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("OTRS Tattelecom");
        prefManager = Pref.getInstance(this);

        taskPresenter = new GetTaskPresenter(this, prefManager);

        progressDialog = new ProgressDialog(Tasks.this,
                R.style.Theme_AppCompat_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Tasks...");
        progressDialog.show();

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.items, android.R.layout.simple_spinner_item);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                              @Override
                                              public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                  switch (position){
                                                      case 0:
                                                          tasksAdapter.Clear();
                                                          stateType.clear();
                                                          stateType.add("open");
                                                          stateType.add("closed successful");
                                                          taskPresenter.getTickets(prefManager.getToken(), stateType);
                                                          break;

                                                      case 1:
                                                          tasksAdapter.Clear();
                                                          stateType.clear();
                                                          stateType.add("open");
                                                          progressDialog.show();
                                                          taskPresenter.getTickets(prefManager.getToken(), stateType);
                                                          break;
                                                      case 2:
                                                          tasksAdapter.Clear();
                                                          stateType.clear();
                                                          stateType.add("closed successful");
                                                          progressDialog.show();
                                                          taskPresenter.getTickets(prefManager.getToken(), stateType);
                                                          break;
                                                  }
                                              }

                                              @Override
                                              public void onNothingSelected(AdapterView<?> parent) {

                                              }
                                          }
        );

        SwipeController swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
                progressDialog.show();
                taskPresenter.closeTask(prefManager.getToken(), list.get(position).getTicketID(), stateType);

            }

            @Override
            public void onLeftClicked(int position){
                progressDialog.show();
                taskPresenter.lockTask(prefManager.getToken(), list.get(position).getTicketID(), list.get(position).getLock(), stateType);
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

        mSwipeRefreshLayout.setOnRefreshListener(() -> taskPresenter.getTickets(prefManager.getToken(), stateType));

        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
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
        });

    }

    private void Logged(){
        prefManager.logout();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }



    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }




    public void onTaskSuccess(List<Ticket> tickets) {
        progressDialog.dismiss();
        mSwipeRefreshLayout.setRefreshing(false);
        Toast.makeText(getBaseContext(), tickets.get(0).getTitle(), Toast.LENGTH_LONG).show();

        if(!tickets.isEmpty()) {

            tasksAdapter.add(0, tickets);
            Toast.makeText(getBaseContext(), "success" + tickets.get(0).getTitle(), Toast.LENGTH_LONG).show();

        } else
            Toast.makeText(getBaseContext(), "У вас отсутсвуют таски", Toast.LENGTH_LONG).show();

    }

    public void onTaskFailed(String error) {
        mSwipeRefreshLayout.setRefreshing(false);
        progressDialog.dismiss();
        Toast.makeText(getBaseContext(), error, Toast.LENGTH_LONG).show();
    }
}
