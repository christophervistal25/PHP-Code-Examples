package com.vistalis.php_codes.ViewPager;

import com.vistalis.php_codes.R;

public enum ModelObject {


        BLUE(R.string.blue, R.layout.view_blue),
        RED(R.string.red, R.layout.view_red),
        GREEN(R.string.green, R.layout.view_green);

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
