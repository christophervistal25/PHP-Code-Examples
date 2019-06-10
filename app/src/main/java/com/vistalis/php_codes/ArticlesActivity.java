package com.vistalis.php_codes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ArticlesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
        Intent intent = getIntent();
        String selectedCategory = intent.getExtras().getString("CATEGORY",null);
        Toast.makeText(this, selectedCategory, Toast.LENGTH_SHORT).show();
    }
}
