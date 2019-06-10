package com.vistalis.php_codes.Repositories;

import android.content.Context;

import com.vistalis.php_codes.DBModules.DB;
import com.vistalis.php_codes.DBModules.Models.Article;

public class ArticleRepository {

    public static void create(Context context, int article_id, String title, String content)
    {
        Article article = new Article(article_id,title,content,false);
        DB.getInstance(context).articlesDao().insert(article);
    }



}
