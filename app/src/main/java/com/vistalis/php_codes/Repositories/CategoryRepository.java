package com.vistalis.php_codes.Repositories;

import android.content.Context;

import com.vistalis.php_codes.DBModules.DB;
import com.vistalis.php_codes.DBModules.Models.Category;


public class CategoryRepository {

    private Context context;

    public CategoryRepository(Context context)
    {
        this.context = context;
    }

    private void create(String title, String description)
    {
        Category article = new Category(title,description);
        DB.getInstance(this.context).categoriesDao().insert(article);
    }

    private boolean isAllCategoriesInserted()
    {
        return DB.getInstance(this.context).categoriesDao().noOfCategories() == 8;
    }

    public static int getIdByTitle(Context context, String title)
    {
        return DB.getInstance(context).categoriesDao().getCategoryIdByTitle(title);
    }

    public void insertAllCategories()
    {
        if ( !this.isAllCategoriesInserted() ) {
            this.create("Basics","Learn more about Basics");
            this.create("Arrays", "Learn more about Arrays");
            this.create("Strings", "Learn more about Strings");
            this.create("Math", "Learn more about Math");
            this.create("Functions", "Learn more about different Functions");
            this.create("File Handling", "Learn more about different File Handling");
            this.create("Input & Output", "Learn more about different Input & Output");
            this.create("Sample Programs", "Learn more about different Sample Programs");
        }
    }

}
