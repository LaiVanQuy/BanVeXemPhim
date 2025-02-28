package vn.quylang.movie_booking_admin.Retrofit2.SharedPref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import vn.quylang.movie_booking_admin.Activity.LoginActivity;
import vn.quylang.movie_booking_admin.Model.Account;


public class SharedPrefManager {
    public static final String SHARED_PREF_NAME="retrofitregisterlogin";
    private static final String KEY_USERNAME="keyusername";
    private static final String KEY_EMAIL="keyemail";
    private static final String KEY_PASS="keypass";
    private static final String KEY_ROLE="keyrole";
    private static SharedPrefManager mInstance;
    private static Context ctx;
    private SharedPrefManager(Context context){
        ctx=context;
    }
    public static synchronized SharedPrefManager getInstance(Context context){
        if(mInstance==null){
            mInstance=new SharedPrefManager(context);
        }
        return mInstance;
    }
    public void userLogin(Account user){
        SharedPreferences sharedPreferences=  ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(KEY_USERNAME, user.getTen());
        editor.putString(KEY_EMAIL,user.getEmail());
        editor.putString(KEY_PASS,user.getPass());
        editor.putInt(KEY_ROLE,user.getRolee());
        editor.apply();
    }
    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences=ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_EMAIL,null)!=null;
    }
    public Account getUser(){
        SharedPreferences sharedPreferences=ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return new Account(
                sharedPreferences.getString(KEY_EMAIL,null),
                sharedPreferences.getString(KEY_PASS,null),
                sharedPreferences.getInt(KEY_ROLE,-1),
                sharedPreferences.getString(KEY_USERNAME,null)
        );
    }
    public void logout(){

        SharedPreferences sharedPreferences=ctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
        ctx.startActivity(new Intent(ctx, LoginActivity.class));
    }
}
