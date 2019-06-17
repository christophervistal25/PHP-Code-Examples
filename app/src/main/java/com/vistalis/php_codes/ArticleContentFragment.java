package com.vistalis.php_codes;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.androidessence.pinchzoomtextview.PinchZoomTextView;


public class ArticleContentFragment extends Fragment {

    TextView articleContent;


    public ArticleContentFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {



        articleContent = getActivity().findViewById(R.id.articleContent);
        articleContent.setText( getArguments().getString("article_content"));


        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_content, container, false);
    }



}
