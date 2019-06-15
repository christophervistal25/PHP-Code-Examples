package com.vistalis.php_codes.DBModules.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.vistalis.php_codes.DBModules.Models.Category;

import java.util.ArrayList;
import java.util.List;


@Dao
public interface CategoriesDao {

    @Insert
    void insert(Category category);

    @Query("SELECT * FROM categories")
    List<Category> getAllCategories();

    @Query("SELECT id FROM categories WHERE title = :title")
    int getCategoryIdByTitle(String title);

    @Query("SELECT COUNT(id) FROM categories")
    int noOfCategories();

    @Query("SELECT description FROM categories")
    List<String> getAllDescription();

    @Query("SELECT title FROM categories")
    List<String> getAllTitle();






}
