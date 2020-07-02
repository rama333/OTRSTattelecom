package com.example.otrstattelecom.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.otrstattelecom.R;
import com.example.otrstattelecom.model.SessionData;
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
    @BindView(R.id.logo)
    ImageView _imageviewLogo;
    //@BindView(R.id.textViewCorp)
    TextView _imageviewCorp;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setTheme(R.style.AppThemeLogin);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

//        RotateAnimation anim = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//
//        anim.setInterpolator(new LinearInterpolator());
//        anim.setRepeatCount(Animation.INFINITE);
//        anim.setDuration(900);
//
//        _imageviewLogo.startAnimation(anim);

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

       // scaleDownC.start();



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


    public void onLoginSuccess(String token, String userID, String login, String password) {
        progressDialog.dismiss();
        _loginButton.setEnabled(true);

        //Toast.makeText(getBaseContext(), userModel.getPassword(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, Tasks.class);
        //intent.putIntegerArrayListExtra(Pref.EXTRA_USER, (ArrayList<Integer>) userModel.getList());
        Pref prefManager = Pref.getInstance(LoginActivity.this);
        prefManager.setUserLogin(token, userID, login, password);
        Log.d("TAG", token);
        startActivity(intent);
        finish();
          //finish();
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
