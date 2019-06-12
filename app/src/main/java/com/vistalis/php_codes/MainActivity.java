package com.vistalis.php_codes;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.widget.Toast;


import com.vistalis.php_codes.DBModules.DB;
import com.vistalis.php_codes.Repositories.ArticleRepository;
import com.vistalis.php_codes.Repositories.CategoryRepository;
import com.vistalis.php_codes.ViewPager.CustomPagerAdapter;

import hotchemi.android.rate.AppRate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setActivityToFullScreen();

        this.displayAppRatingDialog();

        // this is for development purpose
        // this.sampleData();

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new CustomPagerAdapter(this));


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.action_favorites:
                        FavoritesFragment favoritesFragment = new FavoritesFragment();

                        // Checking if there's a fragment that attach to a container.
                            if ( getSupportFragmentManager().findFragmentById(R.id.fragmentContainer) != null ) {
                                fragmentTransaction.replace(R.id.fragmentContainer, favoritesFragment);
                            } else {
                                fragmentTransaction.add(R.id.fragmentContainer, favoritesFragment);
                            }

                        fragmentTransaction.addToBackStack(null);

                        fragmentTransaction.commit();

                    break;

                case R.id.action_playground:
                        Intent intent = new Intent(MainActivity.this,PlayGroundActivity.class);
                        startActivity(intent);
                    break;

                case R.id.action_feedback:
                        FeedBackFragment feedBackFragment = new FeedBackFragment();

                        // Checking if there's a fragment that attach to a container.
                        if ( getSupportFragmentManager().findFragmentById(R.id.fragmentContainer) != null ) {
                            fragmentTransaction.replace(R.id.fragmentContainer, feedBackFragment);
                        } else {
                            fragmentTransaction.add(R.id.fragmentContainer, feedBackFragment);
                        }

                        fragmentTransaction.addToBackStack(null);

                        fragmentTransaction.commit();
                    break;

            }
            return true;
        });


    }

    private void displayAppRatingDialog() {
        // callback listener.
        AppRate.with(this)
                .setInstallDays(0) // default 10, 0 means install day.
                .setLaunchTimes(3) // default 10
                .setRemindInterval(2) // default 1
                .setShowLaterButton(true) // default true
                .setDebug(false) // default false
                .setOnClickButtonListener(which -> Log.d(MainActivity.class.getName(), Integer.toString(which)))
                .monitor();


        // Show a dialog if meets conditions
        AppRate.showRateDialogIfMeetsConditions(this);
    }



    private void sampleData() {
        CategoryRepository.create(this,"Basics","This is a sample for php basics");
        CategoryRepository.create(this,"Arrays","This is a sample for array");
        CategoryRepository.create(this,"Math","This is a sample for math functions");

        ArticleRepository.create(this,1,"Basic one","This is a sample content for basic one");
        ArticleRepository.create(this,1,"Basic two","This is a sample content for basic two");
        ArticleRepository.create(this,1,"Basic three","This is a sample content for basic three");

        ArticleRepository.create(this,2,"Array one","This is a sample content for array one");
        ArticleRepository.create(this,2,"Array two","This is a sample content for array two");
        ArticleRepository.create(this,2,"Array three","This is a sample content for array three");

        ArticleRepository.create(this,3,"Math one","This is a sample content for math one");
        ArticleRepository.create(this,3,"Math two","This is a sample content for math two");
        ArticleRepository.create(this,3,"Math three","This is a sample content for math three");
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

