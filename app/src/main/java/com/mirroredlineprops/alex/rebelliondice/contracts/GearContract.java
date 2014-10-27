package com.mirroredlineprops.alex.rebelliondice.contracts;

import android.provider.BaseColumns;

/**
 * Created by alex.costanzo on 10/27/2014.
 */
public class GearContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public GearContract() {}

    /* Inner class that defines the table contents */
    public static abstract class GearEntry implements BaseColumns {
        public static final String TABLE_NAME = "gear";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_MODEL = "model";
        public static final String COLUMN_NAME_ENCUM = "encum";
        public static final String COLUMN_NAME_SPECIAL = "special";
        public static final String COLUMN_NAME_TYPE = "type";
    }
}
