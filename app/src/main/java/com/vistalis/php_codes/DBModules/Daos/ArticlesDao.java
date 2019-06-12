package com.vistalis.php_codes.DBModules.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.vistalis.php_codes.DBModules.Models.Article;

import java.util.List;

@Dao
public interface ArticlesDao {

    @Insert
    void insert(Article article);

    @Update
    void update(Article article);

    @Query("SELECT * FROM articles")
    List<Article> getAllArticles();

    @Query("SELECT * FROM articles WHERE category_id = :category_id")
    List<Article> getArticlesByCategoryId(int category_id);

    @Query("SELECT * FROM articles WHERE favorite = 1 ")
    List<Article> getAllFavoriteArticles();
}
