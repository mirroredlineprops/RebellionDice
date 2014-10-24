package com.mirroredlineprops.alex.rebelliondice.contracts;

import android.provider.BaseColumns;

public final class WeaponContract {


    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public WeaponContract() {}

    /* Inner class that defines the table contents */
    public static abstract class WeaponEntry implements BaseColumns {
        public static final String TABLE_NAME = "weapons";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_MODEL = "model";
    }

}