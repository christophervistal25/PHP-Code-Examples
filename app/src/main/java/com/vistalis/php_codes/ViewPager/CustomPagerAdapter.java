package com.vistalis.php_codes.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.vistalis.php_codes.ArticlesFragment;
import com.vistalis.php_codes.DBModules.DB;
import com.vistalis.php_codes.R;

import java.util.ArrayList;
import java.util.List;

public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<String> pageDescription;
    public CustomPagerAdapter(Context context)
    {
        mContext = context;
        pageDescription = DB.getInstance(context).categoriesDao().getAllDescription();
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        ModelObject modelObject = ModelObject.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(modelObject.getLayoutResId(), collection, false);
        collection.addView(layout);

        TextView itemDescription = layout.findViewById(R.id.categoryDescription);
        itemDescription.setText(pageDescription.get(position));

        layout.findViewById(R.id.btnGoto).setOnClickListener(view -> {

            Bundle bundle = new Bundle();
            bundle.putString("selected_category", String.valueOf( view.getTag()) );

            ArticlesFragment fragmentArticles = new ArticlesFragment();
            FragmentTransaction fragmentTransaction = ((AppCompatActivity)mContext).getSupportFragmentManager().beginTransaction();

            fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);

            fragmentArticles.setArguments(bundle);

            fragmentTransaction.add(R.id.fragmentContainer, fragmentArticles);

            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();

        });

        return layout;
    }



    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return ModelObject.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        ModelObject customPagerEnum = ModelObject.values()[position];
        return mContext.getString(customPagerEnum.getTitleResId());
    }

}
