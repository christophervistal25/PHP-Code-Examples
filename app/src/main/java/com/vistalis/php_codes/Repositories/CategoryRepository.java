package com.vistalis.php_codes.Repositories;

import android.content.Context;

import com.vistalis.php_codes.DBModules.DB;
import com.vistalis.php_codes.DBModules.Models.Category;

public class CategoryRepository {

    public static void create(Context context, String title, String description)
    {
        Category article = new Category(title,description);
        DB.getInstance(context).categoriesDao().insert(article);
    }

}
