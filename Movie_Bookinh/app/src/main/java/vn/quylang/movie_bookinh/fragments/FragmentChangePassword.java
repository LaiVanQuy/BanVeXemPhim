package vn.quylang.movie_bookinh.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.quylang.movie_bookinh.Models.Account;
import vn.quylang.movie_bookinh.Models.LoginResponse;
import vn.quylang.movie_bookinh.R;
import vn.quylang.movie_bookinh.Retrofit.APIService;
import vn.quylang.movie_bookinh.Retrofit.RetrofitClient;
import vn.quylang.movie_bookinh.Retrofit.SharedPref.SharedPrefManager;

public class FragmentChangePassword extends Fragment {
    Button btnChangePass;
    EditText edtOldPass,edtNewPass,edtConfirmPass;
    APIService apiService;
    Account account;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_change_password,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Account oldAccount= SharedPrefManager.getInstance(getContext()).getUser();
                changePassword(oldAccount.getEmail());
            }
        });
    }
    private void init(View view){
        btnChangePass=view.findViewById(R.id.btnChangePass);
        edtNewPass=view.findViewById(R.id.edtNewPass);
        edtOldPass=view.findViewById(R.id.edtOldPassword);
        edtConfirmPass=view.findViewById(R.id.edtConfirmPassword);
    }
    private void changePassword(String email){
        String oldPass=edtOldPass.getText().toString();
        String newPass=edtNewPass.getText().toString();
        String confirmPass=edtConfirmPass.getText().toString();
        if(TextUtils.isEmpty(oldPass)){
            edtOldPass.setError("Please enter your old password");
            edtOldPass.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(newPass)){
            edtNewPass.setError("Please enter your new password");
            edtNewPass.requestFocus();
            return;
        }
        if(!confirmPass.equals(newPass)){
            edtConfirmPass.setError("Confirm new password incorrect!");
            edtConfirmPass.requestFocus();
            return;
        }
        apiService= RetrofitClient.getRetrofit().create(APIService.class);
        apiService.changPassword(email,oldPass,newPass).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    LoginResponse loginResponse=response.body();
                    if(loginResponse.isSuccess()){
                        Toast.makeText(getContext(), loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        edtConfirmPass.setText("");
                        edtNewPass.setText("");
                        edtOldPass.setText("");
                        account=loginResponse.getAccountModel();
                        SharedPrefManager.getInstance(getContext()).userLogin(account);
                    }
                    else
                        Toast.makeText(getContext(), loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
