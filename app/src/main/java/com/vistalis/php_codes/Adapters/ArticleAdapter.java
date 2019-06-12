package com.vistalis.php_codes.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.vistalis.php_codes.DBModules.DB;
import com.vistalis.php_codes.DBModules.Models.Article;
import com.vistalis.php_codes.R;

import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleHolder> {


    private List<Article> list_article;
    public OnClickResponse OnClickResponse;

    public ArticleAdapter(List<Article> list_article) {
        this.list_article = list_article;
    }

    public interface OnClickResponse {
        void onSuccess(String articleContent);
    }


    @Override
    public ArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_layout, parent, false);
        return new ArticleHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleHolder holder, int position) {
        Article article = list_article.get(position);
        Context context = holder.articleTitle.getContext();

        holder.articleTitle.setText(article.getTitle());

        holder.btnAddToFavorite.setOnClickListener(v -> {
            String message = "";
            if ( article.isFavorite() ) {
                article.setFavorite(false);
                message  = article.getTitle() + " successfully remove to your favorites.";
            } else {
                article.setFavorite(true);
                message  = article.getTitle() + " successfully add to your favorites.";
            }

            DB.getInstance(context).articlesDao().update(article);

            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

            notifyDataSetChanged();
        });

        if ( article.isFavorite() ) {
            holder.btnAddToFavorite.setBackgroundResource(R.drawable.ic_favorite_2_black_24dp);
        } else {
            holder.btnAddToFavorite.setBackgroundResource(R.drawable.ic_favorite_border_black_24dp);
        }

        holder.articleTitle.setOnClickListener(view -> {
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


    class ArticleHolder extends RecyclerView.ViewHolder {
        TextView articleTitle;
        ImageButton btnAddToFavorite;

        public ArticleHolder(View itemView) {
            super(itemView);
            articleTitle = itemView.findViewById(R.id.articleTitle);
            btnAddToFavorite = itemView.findViewById(R.id.btnAddToFavorite);
        }
    }
}