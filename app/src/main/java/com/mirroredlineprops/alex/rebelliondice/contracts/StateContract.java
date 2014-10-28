package com.mirroredlineprops.alex.rebelliondice.contracts;

import android.provider.BaseColumns;

/**
 * Created by alex.costanzo on 10/27/2014.
 */
public class StateContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public StateContract() {}

    /* Inner class that defines the table contents */
    public static abstract class StateEntry implements BaseColumns {
        public static final String TABLE_NAME = "state";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_CHAR_ID = "charId";
        public static final String COLUMN_NAME_LIGHT = "light";
        public static final String COLUMN_NAME_DARK = "dark";
        public static final String COLUMN_NAME_DUTY = "duty";
        public static final String COLUMN_NAME_OBLIGATION = "obligation";
        public static final String COLUMN_NAME_GROUP_OBLIGATIONS = "groupObligations";
        public static final String COLUMN_NAME_GROUP_DUTIES = "groupDuties";
        public static final String COLUMN_NAME_CONTRIBUTION = "contribution";
        public static final String COLUMN_NAME_GROUP_RESOURCES = "groupResources";
        public static final String COLUMN_NAME_GROUP_POSS = "groupPoss";
        public static final String COLUMN_NAME_GROUP_CONTACTS = "groupContacts";
        public static final String COLUMN_NAME_BASE = "base";
        public static final String COLUMN_NAME_BASE_LOCATION = "baseLocation";
        public static final String COLUMN_NAME_BASE_DESCRIPTION = "baseDescription";
    }
}
