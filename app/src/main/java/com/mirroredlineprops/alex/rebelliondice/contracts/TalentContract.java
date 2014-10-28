package com.mirroredlineprops.alex.rebelliondice.contracts;

import android.provider.BaseColumns;

/**
 * Created by alex.costanzo on 10/27/2014.
 */
public class TalentContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public TalentContract() {}

    /* Inner class that defines the table contents */
    public static abstract class TalentEntry implements BaseColumns {
        public static final String TABLE_NAME = "weapons";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_ACTIVATION = "activation";
        public static final String COLUMN_NAME_ACTIVE_TYPE = "activeType";
        public static final String COLUMN_NAME_RANK = "rank";
        public static final String COLUMN_NAME_SPECIAL = "special";
    }
}
