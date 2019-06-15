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

        create(getIdByTitle(this.context,"Basics"),"PHP | Introduction","The term PHP is an acronym for PHP: Hypertext Preprocessor. PHP is a server-side scripting language designed specifically for web development. Websites like www.facebook.com, www.yahoo.com are also built on PHP.One of the main reason behind this is that PHP can be easily embedded in HTML files and HTML codes can also be written in a PHP file.The thing that differentiates PHP with client-side language like HTML is, PHP codes are executed on server whereas HTML codes are directly rendered on the browser. PHP codes are first executed on the server and then the result is returned to the browser.The only information that the client or browser knows is the result returned after executing the PHP script on the server and not the actual PHP codes present in the PHP file. Also, PHP files can support other client-side scripting languages like CSS and JavaScript.Why should we use PHP?PHP can actually do anything related to server-side scripting or more popularly known as the backend of a website. For example, PHP can receive data from forms, generate dynamic page content, can work with databases, create sessions, send and receive cookies, send emails etc. There are also many hash functions available in PHP to encrypt user’s data that makes PHP secure and reliable to be used as a server-side scripting language. So these are some of the abilities of PHP that makes it suitable to be used as server-side scripting language. You will get to know more of these abilities in further tutorials.Even if you are not convinced by the above abilities of PHP, there are some more features of PHP. PHP can run on all major operating systems like Windows, Linux, Unix, Mac OS X etc. Almost all of the major servers available today like Apache supports PHP. PHP allows using wide range of databases. And the most important factor is that it is free to use and download and anyone can download PHP from its official source : www.php.net.");

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

        create(getIdByTitle(this.context,"Programs"),"Sample Programs one","Sample content for Sample Programs one");
        create(getIdByTitle(this.context,"Programs"),"Sample Programs two","Sample content for Sample Programs two");
        create(getIdByTitle(this.context,"Programs"),"Sample Programs three","Sample content for Sample Programs three");

    }





}
