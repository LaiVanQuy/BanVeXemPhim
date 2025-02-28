package vn.quylang.movie_bookinh.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import vn.quylang.movie_bookinh.Adapter.MovieAdapter;
import vn.quylang.movie_bookinh.Const;
import vn.quylang.movie_bookinh.Models.Account;
import vn.quylang.movie_bookinh.R;
import vn.quylang.movie_bookinh.Retrofit.SharedPref.SharedPrefManager;
import vn.quylang.movie_bookinh.fragments.FragmentBooking;
import vn.quylang.movie_bookinh.fragments.FragmentChangePassword;
import vn.quylang.movie_bookinh.fragments.FragmentDetailMovie;
import vn.quylang.movie_bookinh.fragments.FragmentHome;
import vn.quylang.movie_bookinh.fragments.FragmentOrderHistory;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout=findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navi_drawer_open,
                R.string.navi_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView=findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        Account account= (Account) SharedPrefManager.getInstance(getApplicationContext()).getUser();
        View headerview =navigationView.getHeaderView(0);
        TextView tvTen=headerview.findViewById(R.id.tvUserName);
        TextView tvEmail=headerview.findViewById(R.id.tvEmail);
        tvTen.setText(account.getTen());
        tvEmail.setText(account.getEmail());

        replaceFragment(new FragmentHome());
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.nav_home){
            if(Const.CURRENT_FRAGMENT!=Const.FRAGMENT_HOME){
                replaceFragment(new FragmentHome());
                Const.CURRENT_FRAGMENT=Const.FRAGMENT_HOME;
            }
        }
        else if (id==R.id.nav_history) {
            if(Const.CURRENT_FRAGMENT!=Const.FRAGMENT_ORDER_HISTORY){
                replaceFragment(new FragmentOrderHistory());
                Const.CURRENT_FRAGMENT=Const.FRAGMENT_ORDER_HISTORY;
            }

        } else if (id==R.id.nav_change_password) {
            if(Const.CURRENT_FRAGMENT!=Const.FRAGMENT_CHANGE_PASSWORD){
                replaceFragment(new FragmentChangePassword());
                Const.CURRENT_FRAGMENT=Const.FRAGMENT_CHANGE_PASSWORD;
            }
        } else if (id==R.id.nav_logout) {
            SharedPrefManager.getInstance(getApplicationContext()).logout();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    public void replaceFragment(Fragment fragment){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame,fragment);
        transaction.commit();
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (Const.CURRENT_FRAGMENT==Const.FRAGMENT_DETAIL_MOVIE||
                Const.CURRENT_FRAGMENT==Const.FRAGMENT_ORDER_HISTORY||
                Const.CURRENT_FRAGMENT==Const.FRAGMENT_CHANGE_PASSWORD) {
            replaceFragment(new FragmentHome());
            Const.CURRENT_FRAGMENT=Const.FRAGMENT_HOME;
        }
        else if(Const.CURRENT_FRAGMENT==Const.FRAGMENT_BOOKING){
            replaceFragment(new FragmentDetailMovie());
            Const.CURRENT_FRAGMENT=Const.FRAGMENT_DETAIL_MOVIE;
        } else if (Const.CURRENT_FRAGMENT==Const.FRAGMENT_ORDER_DETAILS) {
            replaceFragment(new FragmentBooking());
            Const.CURRENT_FRAGMENT=Const.FRAGMENT_BOOKING;

        }  else
            super.onBackPressed();

    }

}