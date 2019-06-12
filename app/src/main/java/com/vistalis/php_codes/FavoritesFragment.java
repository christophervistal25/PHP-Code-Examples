package com.vistalis.php_codes;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.vistalis.php_codes.Adapters.ArticleAdapter;
import com.vistalis.php_codes.Adapters.FavoritesAdapter;
import com.vistalis.php_codes.DBModules.DB;
import com.vistalis.php_codes.DBModules.Models.Article;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment implements FavoritesAdapter.OnClickResponse {


    RecyclerView recyclerView;
    FavoritesAdapter favoriteAdapter;
    LinearLayoutManager layoutManager;
    List<Article> article_list;


    public FavoritesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.buildRecyclerView();
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

        super.onViewCreated(view, savedInstanceState);
    }

    private void buildRecyclerView() {

        article_list = DB.getInstance(getContext()).articlesDao().getAllFavoriteArticles();

        favoriteAdapter = new FavoritesAdapter(article_list);
        favoriteAdapter.OnClickResponse = this;

        recyclerView = getActivity().findViewById(R.id.recycler_view);

        recyclerView.addItemDecoration( new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL) );

        layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(favoriteAdapter);

    }

    // Method for searching an article in Recycler View.
    private void filter(String text) {
        ArrayList<Article> filteredList = new ArrayList<>();

        for (Article item : article_list) {
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        favoriteAdapter.filterList(filteredList);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false);
    }

    @Override
    public void onSuccess(String articleContent) {
        Bundle bundle = new Bundle();
        bundle.putString("article_content", articleContent);

        ArticleContentFragment articleContentFragment = new ArticleContentFragment();
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();

        articleContentFragment.setArguments(bundle);

        if ( getActivity().getSupportFragmentManager().findFragmentById(R.id.fragmentContainer) != null ) {
            fragmentTransaction.replace(R.id.fragmentContainer, articleContentFragment);
        } else {
            fragmentTransaction.add(R.id.fragmentContainer, articleContentFragment);
        }
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }
}
