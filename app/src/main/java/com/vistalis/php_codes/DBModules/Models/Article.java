package com.vistalis.php_codes.DBModules.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "articles")
public class Article {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int category_id;
    public String title;
    public String content;
    public boolean favorite = false;

    public Article(int category_id, String title, String content, boolean favorite) {
        this.setCategory_id(category_id);
        this.setTitle(title);
        this.setContent(content);
        this.setFavorite(favorite);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
