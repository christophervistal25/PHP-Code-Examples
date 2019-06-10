package com.vistalis.php_codes.DBModules.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.vistalis.php_codes.DBModules.Models.Article;

import java.util.List;

@Dao
public interface ArticlesDao {

    @Insert
    void insert(Article articles);

    @Query("SELECT * FROM articles")
    List<Article> getAllArticles();
}
