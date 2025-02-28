package vn.quylang.movie_bookinh.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.quylang.movie_bookinh.Models.Account;
import vn.quylang.movie_bookinh.Models.LoginResponse;
import vn.quylang.movie_bookinh.R;
import vn.quylang.movie_bookinh.Retrofit.APIService;
import vn.quylang.movie_bookinh.Retrofit.RetrofitClient;
import vn.quylang.movie_bookinh.Retrofit.SharedPref.SharedPrefManager;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail,edtPass;
    Button btnLogin;
    TextView tvRegister;
    APIService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    public void init(){
        edtEmail=(EditText) findViewById(R.id.edtEmail);
        edtPass=(EditText) findViewById(R.id.edtPassword);
        btnLogin=(Button) findViewById(R.id.btnLogin);
        tvRegister=(TextView) findViewById(R.id.tvRegister);
    }
    private void userLogin(){
        String email=edtEmail.getText().toString();
        String password=edtPass.getText().toString();
        if(TextUtils.isEmpty(email)){
            edtEmail.setError("Please enter your email");
            edtEmail.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(password)){
            edtPass.setError("Please enter your password");
            edtPass.requestFocus();
            return;
        }

        apiService= RetrofitClient.getRetrofit().create(APIService.class);
        apiService.login(email,password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    LoginResponse loginResponse=response.body();
                    if(loginResponse.isSuccess()){
                        Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        Account account=loginResponse.getAccountModel();
                        SharedPrefManager.getInstance(getApplicationContext()).userLogin(account);
                        finish();
                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    int statusCode=response.code();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}