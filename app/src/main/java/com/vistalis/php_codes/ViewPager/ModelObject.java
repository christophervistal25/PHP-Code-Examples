package com.vistalis.php_codes.ViewPager;

import com.vistalis.php_codes.R;

public enum ModelObject {


        BASICS(R.string.basics, R.layout.view_basics),
        ARRAYS(R.string.arrays, R.layout.view_arrays),
        STRINGS(R.string.strings, R.layout.view_strings),
        MATH(R.string.math, R.layout.view_math),
        FUNCTIONS(R.string.functions, R.layout.view_functions),
        FILE_HANDLING(R.string.file_handling, R.layout.view_file_handling),
        INPUT_AND_OUTPUT(R.string.input_and_output, R.layout.view_input_output),
        SAMPLE_PROGRAMS(R.string.sample_programs, R.layout.view_sample_programs);

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
