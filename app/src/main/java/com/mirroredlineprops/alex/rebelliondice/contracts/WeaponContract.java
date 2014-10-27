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
        public static final String COLUMN_NAME_SKILL= "skill";
        public static final String COLUMN_NAME_DAMAGE = "damage";
        public static final String COLUMN_NAME_CRIT = "crit";
        public static final String COLUMN_NAME_RANGE = "range";
        public static final String COLUMN_NAME_ENCUM = "encum";
        public static final String COLUMN_NAME_HP = "hp";
        public static final String COLUMN_NAME_CONDITION = "condition";
        public static final String COLUMN_NAME_MODS = "mods";
        public static final String COLUMN_NAME_SPECIAL = "special";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_EQUIPPED = "equipped";
    }

}