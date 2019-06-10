package com.vistalis.php_codes;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.widget.Toast;


import com.vistalis.php_codes.ViewPager.CustomPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setActivityToFullScreen();

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new CustomPagerAdapter(this));


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_favorites:
                    Toast.makeText(this, "You clicked the favorites button", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.action_feedback:
                    Toast.makeText(this, "You clicked the feedback button", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.action_playground:
                    Toast.makeText(this, "You clicked the playground button", Toast.LENGTH_SHORT).show();
                    break;

            }
            return true;
        });


    }


    private void setActivityToFullScreen() {
        Window window = getWindow();
        WindowManager.LayoutParams winParams = window.getAttributes();
        winParams.flags &= ~WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        window.setAttributes(winParams);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

}

