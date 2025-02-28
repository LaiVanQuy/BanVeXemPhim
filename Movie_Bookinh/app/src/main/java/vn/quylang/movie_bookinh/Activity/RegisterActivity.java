package vn.quylang.movie_bookinh.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.quylang.movie_bookinh.Models.LoginResponse;
import vn.quylang.movie_bookinh.R;
import vn.quylang.movie_bookinh.Retrofit.APIService;
import vn.quylang.movie_bookinh.Retrofit.RetrofitClient;

public class RegisterActivity extends AppCompatActivity {
    EditText edtEmail,edtPassword,edtConfirmPass,edtName;
    Button btnRegister;
    APIService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerAccount();
            }
        });
    }
    private void  init(){
        edtEmail=(EditText) findViewById(R.id.edtEmail);
        edtPassword=(EditText) findViewById(R.id.edtPassword);
        edtConfirmPass=(EditText) findViewById(R.id.edtConfirmPassword);
        edtName=(EditText) findViewById(R.id.edtUserName);
        btnRegister=(Button) findViewById(R.id.btnRegister);
    }
    public void registerAccount(){
        String email=edtEmail.getText().toString();
        String password=edtPassword.getText().toString();
        String confirmPass=edtConfirmPass.getText().toString();
        String name=edtName.getText().toString();
        if(TextUtils.isEmpty(email)){
            edtEmail.setError("Please enter your email");
            edtEmail.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(password)){
            edtPassword.setError("Please enter your password");
            edtPassword.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(name)){
            edtName.setError("Please enter your name");
            edtName.requestFocus();
            return;
        }
        if(!confirmPass.equals(password)){
            edtConfirmPass.setError("Confirm Password Failure!");
            edtConfirmPass.requestFocus();
            return;
        }
        apiService= RetrofitClient.getRetrofit().create(APIService.class);
        apiService.register(email,confirmPass, name).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    LoginResponse registerResponse=response.body();
                    if(registerResponse.isSuccess()){
                        Toast.makeText(RegisterActivity.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(RegisterActivity.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(RegisterActivity.this, "alooo", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}