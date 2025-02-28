package vn.quylang.movie_bookinh.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vn.quylang.movie_bookinh.R;

public class ThankyouActivity extends AppCompatActivity {
    Button btngoHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);
        btngoHome=(Button) findViewById(R.id.btnGoToDashboard);
        btngoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ThankyouActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}