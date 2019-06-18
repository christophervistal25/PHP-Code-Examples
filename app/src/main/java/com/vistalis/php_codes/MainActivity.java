package com.vistalis.php_codes;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.vistalis.php_codes.Helpers.SharedPref;
import com.vistalis.php_codes.ViewPager.CustomPagerAdapter;



import hotchemi.android.rate.AppRate;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setSplashScreenAlreadyOpen();
        this.setActivityToFullScreen();
        this.displayAppRatingDialog();


        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new CustomPagerAdapter(this));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);

            switch (item.getItemId()) {
                case R.id.action_favorites:

                            if  ( this.isThisFragmentLoad("FAVORITE_FRAGMENT") ) {
                                    return false;
                            } else {
                                this.isFragmentContainerHasAChild(fragmentTransaction, new FavoritesFragment(),"FAVORITE_FRAGMENT");

                                fragmentTransaction.addToBackStack(null);

                                fragmentTransaction.commit();
                            }

                    break;

                case R.id.action_playground:
                        Intent intent = new Intent(MainActivity.this,PlayGroundActivity.class);
                        startActivity(intent);
                    break;

            }
            return true;
        });


    }

    private void setSplashScreenAlreadyOpen() {
        SharedPref.setSharedPreferenceBoolean(getApplicationContext(),"is_splash_already_open",true);
    }

    private void isFragmentContainerHasAChild(FragmentTransaction fragmentTransaction, Fragment fragment, String fragmentTag) {
        if ( getSupportFragmentManager().findFragmentById(R.id.fragmentContainer) != null ) {
            fragmentTransaction.replace(R.id.fragmentContainer, fragment, fragmentTag);
        } else {
            fragmentTransaction.add(R.id.fragmentContainer, fragment, fragmentTag);
        }
    }

    private boolean isThisFragmentLoad(String fragmentTag)
    {
        return getSupportFragmentManager().getFragments().contains( getSupportFragmentManager().findFragmentByTag(fragmentTag) );
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

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    private void setActivityToFullScreen() {

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

    }

}

