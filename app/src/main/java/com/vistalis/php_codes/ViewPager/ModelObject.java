package com.vistalis.php_codes.ViewPager;

import com.vistalis.php_codes.R;

public enum ModelObject {


        BASICS(R.string.basics, R.layout.view_basics),
        ARRAYS(R.string.arrays, R.layout.view_arrays),
        MATH(R.string.math, R.layout.view_math);

        private int mTitleResId;
        private int mLayoutResId;

        ModelObject(int titleResId, int layoutResId) {
            mTitleResId = titleResId;
            mLayoutResId = layoutResId;
        }

        public int getTitleResId() {
            return mTitleResId;
        }

        public int getLayoutResId() {
            return mLayoutResId;
        }


}
