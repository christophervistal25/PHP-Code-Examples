package com.vistalis.php_codes.Repositories;

import android.content.Context;

import com.vistalis.php_codes.DBModules.DB;
import com.vistalis.php_codes.DBModules.Models.Article;

import static com.vistalis.php_codes.Repositories.CategoryRepository.*;

public class ArticleRepository {

    private Context context;

    public ArticleRepository(Context context) {
        this.context = context;
    }

    private void create(int article_id, String title, String content)
    {
        Article article = new Article(article_id,title,content,false);
        DB.getInstance(this.context).articlesDao().insert(article);
    }


    public void insertAllArticles()
    {

        create(getIdByTitle(this.context,"Basics"),"Basic one","Sample content for basic one");
        create(getIdByTitle(this.context,"Basics"),"Basic two","Sample content for basic two");
        create(getIdByTitle(this.context,"Basics"),"Basic three","Sample content for basic three");

        create(getIdByTitle(this.context,"Arrays"),"Array one","Sample content for Array one");
        create(getIdByTitle(this.context,"Arrays"),"Array two","Sample content for Array two");
        create(getIdByTitle(this.context,"Arrays"),"Array three","Sample content for Array three");

        create(getIdByTitle(this.context,"Strings"),"Strings one","Sample content for Strings one");
        create(getIdByTitle(this.context,"Strings"),"Strings two","Sample content for Strings two");
        create(getIdByTitle(this.context,"Strings"),"Strings three","Sample content for Strings three");

        create(getIdByTitle(this.context,"Math"),"Math one","Sample content for Math one");
        create(getIdByTitle(this.context,"Math"),"Math two","Sample content for Math two");
        create(getIdByTitle(this.context,"Math"),"Math three","Sample content for Math three");

        create(getIdByTitle(this.context,"Functions"),"Functions one","Sample content for Functions one");
        create(getIdByTitle(this.context,"Functions"),"Functions two","Sample content for Functions two");
        create(getIdByTitle(this.context,"Functions"),"Functions three","Sample content for Functions three");

        create(getIdByTitle(this.context,"File Handling"),"File Handling one","Sample content for File Handling one");
        create(getIdByTitle(this.context,"File Handling"),"File Handling two","Sample content for File Handling two");
        create(getIdByTitle(this.context,"File Handling"),"File Handling three","Sample content for File Handling three");

        create(getIdByTitle(this.context,"Input & Output"),"Input & Output one","Sample content for Input & Output one");
        create(getIdByTitle(this.context,"Input & Output"),"Input & Output two","Sample content for Input & Output two");
        create(getIdByTitle(this.context,"Input & Output"),"Input & Output three","Sample content for Input & Output three");

        create(getIdByTitle(this.context,"Sample Programs"),"Sample Programs one","Sample content for Sample Programs one");
        create(getIdByTitle(this.context,"Sample Programs"),"Sample Programs two","Sample content for Sample Programs two");
        create(getIdByTitle(this.context,"Sample Programs"),"Sample Programs three","Sample content for Sample Programs three");

    }





}
