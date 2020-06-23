package com.example.otrstattelecom.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.otrstattelecom.R;
import com.example.otrstattelecom.model.TicketIDs;
import com.example.otrstattelecom.model.Token;
import com.example.otrstattelecom.model.UserModel;
import com.example.otrstattelecom.presenter.LoginPresenter;
import com.example.otrstattelecom.utils.Pref;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginActivity extends AppCompatActivity implements LoginView{

    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    private LoginPresenter loginPresenter;
    ProgressDialog progressDialog;

    @BindView(R.id.input_email)
    EditText _emailText;
    @BindView(R.id.input_password)
    EditText _passwordText;
    @BindView(R.id.btn_login)
    Button _loginButton;
    @BindView(R.id.link_signup)
    TextView _signupLink;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        Pref prefManager = Pref.getInstance(LoginActivity.this);

        if(prefManager.isLoggedIn()) {
            Intent intent = new Intent(this, Tasks.class);
//            intent.putExtra(Pref.EXTRA_USER, prefManager.getUser());
            startActivity(intent);
            finish();
        }

        loginPresenter = new LoginPresenter(this);
        progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed("e");
            return;
        }

        _loginButton.setEnabled(false);


        progressDialog.show();

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.

       loginPresenter.login(email, password);


    }


    public void onLoginSuccess(Token token) {
        progressDialog.dismiss();
        _loginButton.setEnabled(true);

        //Toast.makeText(getBaseContext(), userModel.getPassword(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, Tasks.class);
        //intent.putIntegerArrayListExtra(Pref.EXTRA_USER, (ArrayList<Integer>) userModel.getList());
        Pref prefManager = Pref.getInstance(LoginActivity.this);
        prefManager.setUserLogin(token);
        startActivity(intent);
        finish();
          //finish();
    }

    public void onLoginFailed(String error) {
        progressDialog.dismiss();
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty()) {
            _emailText.setError("enter a valid login");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
