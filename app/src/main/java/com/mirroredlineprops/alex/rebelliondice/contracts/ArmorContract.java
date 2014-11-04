package com.mirroredlineprops.alex.rebelliondice.contracts;

import android.provider.BaseColumns;

/**
 * Created by alex.costanzo on 10/27/2014.
 */
public class ArmorContract {
        // To prevent someone from accidentally instantiating the contract class,
        // give it an empty constructor.
        public ArmorContract() {}

        /* Inner class that defines the table contents */
        public static abstract class ArmorEntry implements BaseColumns {
            public static final String TABLE_NAME = "armor";
            public static final String COLUMN_NAME_ENTRY_ID = "entryid";
            public static final String COLUMN_NAME_NAME = "name";
            public static final String COLUMN_NAME_DEFENSE = "defense";
            public static final String COLUMN_NAME_SOAK = "soak";
            public static final String COLUMN_NAME_ENCUM = "encum";
            public static final String COLUMN_NAME_HP = "hp";
            public static final String COLUMN_NAME_MODS = "mods";
            public static final String COLUMN_NAME_SPECIAL = "special";
            public static final String COLUMN_NAME_EQUIPPED = "equipped";
        }

}
