package com.mirroredlineprops.alex.rebelliondice.dbhelpers;

import com.mirroredlineprops.alex.rebelliondice.contracts.ArmorContract.*;
import com.mirroredlineprops.alex.rebelliondice.contracts.GearContract.*;
import com.mirroredlineprops.alex.rebelliondice.contracts.WeaponContract.*;
import com.mirroredlineprops.alex.rebelliondice.contracts.StateContract.*;
import com.mirroredlineprops.alex.rebelliondice.contracts.TalentContract.*;
import com.mirroredlineprops.alex.rebelliondice.contracts.TreeContract.*;
import com.mirroredlineprops.alex.rebelliondice.contracts.CharContract.*;

/**
 * Created by AJ on 10/27/2014.
 */
public class DbStrings {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "swStats.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_WEAPON_ENTRIES =
            "CREATE TABLE " + WeaponEntry.TABLE_NAME + " (" +
                    WeaponEntry._ID + " INTEGER PRIMARY KEY," +
                    WeaponEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_MODEL + TEXT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_SKILL + TEXT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_DAMAGE + TEXT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_CRIT + TEXT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_RANGE + TEXT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_ENCUM + TEXT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_HP + TEXT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_CONDITION + TEXT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_MODS + TEXT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_SPECIAL + TEXT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_TYPE + TEXT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_EQUIPPED + TEXT_TYPE +
                    " )";
    public static final String SQL_DELETE_WEAPON_ENTRIES =
            "DROP TABLE IF EXISTS " + WeaponEntry.TABLE_NAME;

    public static final String SQL_CREATE_ARMOR_ENTRIES =
            "CREATE TABLE " + ArmorEntry.TABLE_NAME + " (" +
                    ArmorEntry._ID + " INTEGER PRIMARY KEY," +
                    ArmorEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    ArmorEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    ArmorEntry.COLUMN_NAME_DEFENSE + TEXT_TYPE + COMMA_SEP +
                    ArmorEntry.COLUMN_NAME_SOAK + TEXT_TYPE + COMMA_SEP +
                    ArmorEntry.COLUMN_NAME_ENCUM + TEXT_TYPE + COMMA_SEP +
                    ArmorEntry.COLUMN_NAME_HP + TEXT_TYPE + COMMA_SEP +
                    ArmorEntry.COLUMN_NAME_MODS + TEXT_TYPE + COMMA_SEP +
                    ArmorEntry.COLUMN_NAME_SPECIAL + TEXT_TYPE + COMMA_SEP +
                    ArmorEntry.COLUMN_NAME_EQUIPPED + TEXT_TYPE +
                    " )";
    public static final String SQL_DELETE_ARMOR_ENTRIES =
            "DROP TABLE IF EXISTS " + ArmorEntry.TABLE_NAME;

    public static final String SQL_CREATE_GEAR_ENTRIES =
            "CREATE TABLE " + GearEntry.TABLE_NAME + " (" +
                    GearEntry._ID + " INTEGER PRIMARY KEY," +
                    GearEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    GearEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    GearEntry.COLUMN_NAME_MODEL + TEXT_TYPE + COMMA_SEP +
                    GearEntry.COLUMN_NAME_ENCUM + TEXT_TYPE + COMMA_SEP +
                    GearEntry.COLUMN_NAME_SPECIAL + TEXT_TYPE + COMMA_SEP +
                    GearEntry.COLUMN_NAME_TYPE + TEXT_TYPE +
                    " )";
    public static final String SQL_DELETE_GEAR_ENTRIES =
            "DROP TABLE IF EXISTS " + GearEntry.TABLE_NAME;

    public static final String SQL_CREATE_STATE_ENTRIES =
            "CREATE TABLE " + StateEntry.TABLE_NAME + " (" +
                    StateEntry._ID + " INTEGER PRIMARY KEY," +
                    StateEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_CHARD_ID + TEXT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_LIGHT + TEXT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_DARK + TEXT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_DUTY + TEXT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_DEFENSE + TEXT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_CONTRIBUTION + TEXT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_GROUP_RESOURCES + TEXT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_GROUP_POSS + TEXT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_GROUP_CONTACTS + TEXT_TYPE +
                    " )";
    public static final String SQL_DELETE_STATE_ENTRIES =
            "DROP TABLE IF EXISTS " + StateEntry.TABLE_NAME;

    public static final String SQL_CREATE_TALENT_ENTRIES =
            "CREATE TABLE " + TalentEntry.TABLE_NAME + " (" +
                    TalentEntry._ID + " INTEGER PRIMARY KEY," +
                    TalentEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    TalentEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    TalentEntry.COLUMN_NAME_ACTIVATION + TEXT_TYPE + COMMA_SEP +
                    TalentEntry.COLUMN_NAME_ACTIVE_TYPE + TEXT_TYPE + COMMA_SEP +
                    TalentEntry.COLUMN_NAME_RANK + TEXT_TYPE + COMMA_SEP +
                    TalentEntry.COLUMN_NAME_SPECIAL + TEXT_TYPE +
                    " )";
    public static final String SQL_DELETE_TALENT_ENTRIES =
            "DROP TABLE IF EXISTS " + TalentEntry.TABLE_NAME;

    public static final String SQL_CREATE_TREE_ENTRIES =
            "CREATE TABLE " + TreeEntry.TABLE_NAME + " (" +
                    TreeEntry._ID + " INTEGER PRIMARY KEY," +
                    TreeEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    TreeEntry.COLUMN_NAME_NAME + TEXT_TYPE +
                    " )";
    public static final String SQL_DELETE_TREE_ENTRIES =
            "DROP TABLE IF EXISTS " + TreeEntry.TABLE_NAME;

    public static final String SQL_CREATE_CHAR_ENTRIES =
            "CREATE TABLE " + CharEntry.TABLE_NAME + " (" +
                    CharEntry._ID + " INTEGER PRIMARY KEY," +
                    CharEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_SPECIES + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_CAREER + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_TREES + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_SOAK + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_WOUNDS + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_MAX_WOUNDS + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_STRAIN + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_MAX_STRAIN + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_ENCUM + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_MAX_ENCUM + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_DEFENSE + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_BRAWN + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_AGILITY + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_INTELLECT + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_CUNNING + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_WILLPOWER + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_PRESENCE + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_SKILLSET + TEXT_TYPE +
                    " )";
    public static final String SQL_DELETE_CHAR_ENTRIES =
            "DROP TABLE IF EXISTS " + CharEntry.TABLE_NAME;
}
