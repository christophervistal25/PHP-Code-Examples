package com.vistalis.php_codes;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.vistalis.php_codes.Adapters.ArticleAdapter;
import com.vistalis.php_codes.DBModules.DB;
import com.vistalis.php_codes.DBModules.Models.Article;
import com.vistalis.php_codes.Repositories.ArticleRepository;
import com.vistalis.php_codes.Repositories.CategoryRepository;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArticlesFragment extends Fragment implements ArticleAdapter.OnClickResponse {

    RecyclerView recyclerView;
    ArticleAdapter articleAdapter;
    LinearLayoutManager layoutManager;
    List<Article> article_list;

    public ArticlesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        if ( getArguments() != null ) {

            String selected_category = getArguments().getString("selected_category");


            int categoryId = CategoryRepository.getIdByTitle(getContext(),selected_category);

            this.buildRecyclerView(categoryId);

            EditText searchField = view.findViewById(R.id.searchField);

            searchField.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) { filter(s.toString()); }
            });

        }

        super.onViewCreated(view, savedInstanceState);
    }

    // Method for searching an article in Recycler View.
    private void filter(String text) {
        ArrayList<Article> filteredList = new ArrayList<>();

        for (Article item : article_list) {
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        articleAdapter.filterList(filteredList);
    }


    private void buildRecyclerView(int categoryId) {

        article_list = DB.getInstance(getContext()).articlesDao().getArticlesByCategoryId(categoryId);

        articleAdapter = new ArticleAdapter(article_list);
        articleAdapter.OnClickResponse = this;


        recyclerView = getActivity().findViewById(R.id.recycler_view);

        recyclerView.addItemDecoration( new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL) );

        layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(articleAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_articles, container, false);
    }

    @Override
    public void onSuccess(String articleContent) {

        Bundle bundle = new Bundle();
        bundle.putString("article_content", articleContent);

        ArticleContentFragment articleContentFragment = new ArticleContentFragment();
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();

        articleContentFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.fragmentContainer, articleContentFragment);

        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();

    }
}
