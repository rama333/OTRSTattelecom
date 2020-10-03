package com.example.otrstattelecom.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.otrstattelecom.R;
import com.example.otrstattelecom.presenter.LoginPresenter;
import com.example.otrstattelecom.utils.Pref;

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
    @BindView(R.id.logo)
    ImageView _imageviewLogo;
    //@BindView(R.id.textViewCorp)
    TextView _imageviewCorp;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppThemeLogin);

        super.onCreate(savedInstanceState);

        //Toast.makeText(this, test, Toast.LENGTH_LONG).show();



        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(_imageviewLogo, View.ALPHA, 0, 1);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(_imageviewLogo, View.ALPHA, 0, 1);
        scaleDownX.setDuration(5000);
        scaleDownY.setDuration(5000);

        AnimatorSet scaleDown = new AnimatorSet();
        scaleDown.play(scaleDownX).with(scaleDownY);

        scaleDown.start();

        ObjectAnimator scaleDownXC = ObjectAnimator.ofFloat(_imageviewCorp, View.ALPHA, 0, 1);
        ObjectAnimator scaleDownYC = ObjectAnimator.ofFloat(_imageviewCorp, View.ALPHA, 0, 1);
        scaleDownXC.setDuration(50000);
        scaleDownYC.setDuration(50000);

        AnimatorSet scaleDownC = new AnimatorSet();
        scaleDown.play(scaleDownX).with(scaleDownY);

        Pref prefManager = Pref.getInstance(LoginActivity.this);

        if(prefManager.isLoggedIn()) {
            Intent intent = new Intent(this, Tasks.class);
            startActivity(intent);
            finish();
        }

        loginPresenter = new LoginPresenter(this);
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Authenticating...");
        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login() {
        Log.d(TAG, "Login");
        if (!validate()) {
            return;
        }

        _loginButton.setEnabled(false);
        progressDialog.show();

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

       loginPresenter.login(email, password);
    }


    public void onLoginSuccess(String token, String userID, String login, String password) {
        progressDialog.dismiss();
        _loginButton.setEnabled(true);

        Intent intent = new Intent(this, Test.class);
        Pref prefManager = Pref.getInstance(LoginActivity.this);
        prefManager.setUserLogin(token, userID, login, password);
        startActivity(intent);
        finish();
    }

    public void onLoginFailed(String error) {
        progressDialog.dismiss();
        Toast.makeText(getBaseContext(), error, Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty()) {
            _emailText.setError("Введите логин");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 30) {
            _passwordText.setError("Пароль должен содержать от 4 до 30 символов ");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

}
