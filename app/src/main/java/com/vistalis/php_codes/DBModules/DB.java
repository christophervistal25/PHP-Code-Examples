package com.vistalis.php_codes.DBModules;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.vistalis.php_codes.DBModules.Daos.ArticlesDao;
import com.vistalis.php_codes.DBModules.Models.Article;
import com.vistalis.php_codes.DBModules.Models.Categories;


@Database(entities = {Categories.class, Article.class},version = 1)
public abstract class DB extends RoomDatabase {

    private static DB appDatabase;
    public abstract ArticlesDao articlesDao();
    private Context context;



    public synchronized  static DB getInstance(Context context){
        if(appDatabase == null){
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), DB.class, "php_codes")
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }

    public void destroyInstance() {
        appDatabase = null;
    }
}

