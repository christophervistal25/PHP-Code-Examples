package com.vistalis.php_codes.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
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

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoriteArticleHolder> {


    private List<Article> list_article;
    public OnClickResponse OnClickResponse;

    public FavoritesAdapter(List<Article> list_article) {
        this.list_article = list_article;
    }

    public interface OnClickResponse {
        void onSuccess(String articleContent);
    }

    @Override
    public FavoriteArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_layout, parent, false);
        return new FavoriteArticleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteArticleHolder holder, int position) {
        Article article = list_article.get(position);

        holder.articleTitle.setText(article.getTitle());

        holder.articleTitle.setOnClickListener(v -> {
             if ( OnClickResponse != null ) {
                    OnClickResponse.onSuccess( article.getContent() );
             }
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


    class FavoriteArticleHolder extends RecyclerView.ViewHolder {
        TextView articleTitle;

        public FavoriteArticleHolder(View itemView) {
            super(itemView);
            articleTitle = itemView.findViewById(R.id.articleTitle);
        }
    }
}
