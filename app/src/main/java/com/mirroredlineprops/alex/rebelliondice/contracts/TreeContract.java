package com.mirroredlineprops.alex.rebelliondice.contracts;

import android.provider.BaseColumns;

/**
 * Created by alex.costanzo on 10/27/2014.
 */
public class TreeContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public TreeContract() {}

    /* Inner class that defines the table contents */
    public static abstract class TreeEntry implements BaseColumns {
        public static final String TABLE_NAME = "tree";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_CAREER = "career";
        public static final String COLUMN_NAME_SPECIALIZATION = "specialization";
        public static final String COLUMN_NAME_SPECIALIZATION = "specialization";
        public static final String COLUMN_NAME_SPECIALIZATION = "specialization";

        public static final String COLUMN_NAME_1 = "1";
        public static final String COLUMN_NAME_2 = "2";
        public static final String COLUMN_NAME_3 = "3";
        public static final String COLUMN_NAME_4 = "4";

        public static final String COLUMN_NAME_5 = "5";
        public static final String COLUMN_NAME_6 = "6";
        public static final String COLUMN_NAME_7 = "7";
        public static final String COLUMN_NAME_8 = "8";

        public static final String COLUMN_NAME_9 = "9";
        public static final String COLUMN_NAME_10 = "10";
        public static final String COLUMN_NAME_11 = "11";
        public static final String COLUMN_NAME_12 = "12";

        public static final String COLUMN_NAME_13 = "13";
        public static final String COLUMN_NAME_14 = "14";
        public static final String COLUMN_NAME_15 = "15";
        public static final String COLUMN_NAME_16 = "16";

        public static final String COLUMN_NAME_17 = "17";
        public static final String COLUMN_NAME_18 = "18";
        public static final String COLUMN_NAME_19 = "19";
        public static final String COLUMN_NAME_20 = "20";
    }
}
