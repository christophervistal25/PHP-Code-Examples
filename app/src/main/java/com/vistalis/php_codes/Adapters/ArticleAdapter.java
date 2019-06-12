package com.vistalis.php_codes.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.vistalis.php_codes.DBModules.Models.Article;
import com.vistalis.php_codes.R;

import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleHolder> {

    private List<Article> list_article;


    public ArticleAdapter(List<Article> list_article) {
        this.list_article = list_article;
    }

    @Override
    public ArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_layout, parent, false);
        return new ArticleHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleHolder holder, int position) {
        Article article = list_article.get(position);


        holder.articleTitle.setText(article.getTitle());

        holder.articleTitle.setOnClickListener(v -> {
            // Open new fragment

        });

    }

    @Override
    public int getItemCount() {
        return list_article.size();
    }

    public void filterList(ArrayList<Article> filteredList) {
        list_article = filteredList;
        notifyDataSetChanged();
    }


    class ArticleHolder extends RecyclerView.ViewHolder {
        TextView articleTitle;

        public ArticleHolder(View itemView) {
            super(itemView);

            articleTitle = itemView.findViewById(R.id.articleTitle);

        }
    }
}