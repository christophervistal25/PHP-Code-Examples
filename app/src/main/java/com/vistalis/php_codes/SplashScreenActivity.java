package com.vistalis.php_codes;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vistalis.php_codes.Helpers.SharedPref;
import com.vistalis.php_codes.Repositories.ArticleRepository;
import com.vistalis.php_codes.Repositories.CategoryRepository;

import java.lang.ref.WeakReference;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if ( SharedPref.getSharedPreferenceBoolean(getApplicationContext(),"is_splash_already_open",false) ) {
            Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            new insertAllData(SplashScreenActivity.this).execute();
        }
    }

    private class insertAllData extends AsyncTask<Void , Integer , Void> {
        private WeakReference<SplashScreenActivity> activityReference;


        insertAllData(SplashScreenActivity context) {
            activityReference = new WeakReference<>(context);
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected Void doInBackground(Void... voids) {
            CategoryRepository categoryRepo = new CategoryRepository(getApplicationContext());
            ArticleRepository articleRepo = new ArticleRepository(getApplicationContext());

            categoryRepo.insertAllCategories();
            articleRepo.insertAllArticles();

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            finish();
        }

    }
}
