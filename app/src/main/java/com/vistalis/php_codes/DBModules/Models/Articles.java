package com.vistalis.php_codes.DBModules.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "articles")
public class Articles {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int article_id;
    public String title;
    public String content;
    public boolean favorite = false;

    public Articles(int article_id, String title, String content, boolean favorite) {
        this.setArticle_id(article_id);
        this.setTitle(title);
        this.setContent(content);
        this.setFavorite(favorite);
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
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
