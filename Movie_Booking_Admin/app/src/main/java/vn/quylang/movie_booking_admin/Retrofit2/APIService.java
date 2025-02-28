package vn.quylang.movie_booking_admin.Retrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import vn.quylang.movie_booking_admin.Model.LoginResponse;


public interface APIService {
    @POST("login")
    @FormUrlEncoded
    Call<LoginResponse> login(@Field("email")String email,@Field("Pass")String pass);
}
