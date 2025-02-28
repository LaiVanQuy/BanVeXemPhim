package vn.quylang.movie_bookinh.Retrofit;

import java.util.Date;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import vn.quylang.movie_bookinh.Models.LoginResponse;
import vn.quylang.movie_bookinh.Models.Movie;
import vn.quylang.movie_bookinh.Models.Order;
import vn.quylang.movie_bookinh.Models.OrderDetail;
import vn.quylang.movie_bookinh.Models.OrderResponse;
import vn.quylang.movie_bookinh.Models.Showtime;
import vn.quylang.movie_bookinh.Models.Ticket;


public interface APIService {

//    @POST("registrationapi.php?apicall=signup")
//    @FormUrlEncoded
//    Call<RegisterResponse> register(@Field("username") String username, @Field("email") String email,
//                                    @Field("password") String password, @Field("gender") String gender);
//    @GET("categories.php")
//    Call<List<Category>>getCategoryAll();

    @POST("login")
    @FormUrlEncoded
    Call<LoginResponse> login(@Field("email")String username, @Field("Pass")String password);

    @POST("register")
    @FormUrlEncoded
    Call<LoginResponse> register(@Field("email")String username, @Field("Pass")String password,@Field("name")String name);

    @POST("change_password")
    @FormUrlEncoded
    Call<LoginResponse>changPassword(@Field("email")String email,@Field("oldPass")String oldPass,@Field("newPass")String newPass);
    @POST("Order")
    @FormUrlEncoded
    Call<OrderResponse> orderTickets( @Field("email") String email,
                                     @Field("password") String password,@Field("listmaVe")List<Integer> listMaVe);
    @GET("movies")
    Call<List<Movie>> getAllMovies();
    @GET("movieDetail")
    Call <Movie> getMovieDetail(@Query("movieId") int id);
    @GET("movieByStatus")
    Call <List<Movie>> getMovieByStatus(@Query("status") int status);
    @GET("SuatChieuByPhim")
    Call<List<Showtime>> getShowTimesByMovie(@Query("movieId")int id);
    @GET("veBySuatChieu")
    Call<List<Ticket>> getTicketByShowTime(@Query("suatChieuId")int id);
    @POST("ordersByAccount")
    @FormUrlEncoded
    Call<List<Order>> getOrdersByAccount(@Field("email")String email,@Field("password")String password);

    @POST("orderDetailById")
    @FormUrlEncoded
    Call<List<OrderDetail>>getOrderDetailById(@Field("orderId")int orderId);
}
