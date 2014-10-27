package com.mirroredlineprops.alex.rebelliondice.contracts;

import android.provider.BaseColumns;

/**
 * Created by alex.costanzo on 10/27/2014.
 */
public class CharContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public CharContract() {}

    /* Inner class that defines the table contents */
    public static abstract class CharEntry implements BaseColumns {
        public static final String TABLE_NAME = "armor";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_SPECIES = "species";
        public static final String COLUMN_NAME_CAREER = "career";
        public static final String COLUMN_NAME_TREES = "trees";
        public static final String COLUMN_NAME_SOAK = "soak";
        public static final String COLUMN_NAME_WOUNDS = "wounds";
        public static final String COLUMN_NAME_MAX_WOUNDS = "maxWounds";
        public static final String COLUMN_NAME_STRAIN = "strain";
        public static final String COLUMN_NAME_MAX_STRAIN = "maxStrain";
        public static final String COLUMN_NAME_DEFENSE = "defense";
        public static final String COLUMN_NAME_BRAWN = "brawn";
        public static final String COLUMN_NAME_AGILITY = "agility";
        public static final String COLUMN_NAME_INTELLECT = "intellect";
        public static final String COLUMN_NAME_CUNNING = "cunning";
        public static final String COLUMN_NAME_WILLPOWER = "willpower";
        public static final String COLUMN_NAME_PRESENCE = "presence";

    }
}
