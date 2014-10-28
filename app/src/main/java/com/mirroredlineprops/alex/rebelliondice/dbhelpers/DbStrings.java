package com.mirroredlineprops.alex.rebelliondice.dbhelpers;

import com.mirroredlineprops.alex.rebelliondice.contracts.ArmorContract.*;
import com.mirroredlineprops.alex.rebelliondice.contracts.GearContract.*;
import com.mirroredlineprops.alex.rebelliondice.contracts.WeaponContract.*;
import com.mirroredlineprops.alex.rebelliondice.contracts.StateContract.*;
import com.mirroredlineprops.alex.rebelliondice.contracts.TalentContract.*;
import com.mirroredlineprops.alex.rebelliondice.contracts.TreeContract.*;
import com.mirroredlineprops.alex.rebelliondice.contracts.CharContract.*;
import com.mirroredlineprops.alex.rebelliondice.contracts.SkillsContract.*;

/**
 * Created by AJ on 10/27/2014.
 */
public class DbStrings {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "swStats.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_WEAPON_ENTRIES =
            "CREATE TABLE " + WeaponEntry.TABLE_NAME + " (" +
                    WeaponEntry._ID + " INTEGER PRIMARY KEY," +
                    WeaponEntry.COLUMN_NAME_ENTRY_ID + INT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_MODEL + TEXT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_SKILL + TEXT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_DAMAGE + INT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_CRIT + TEXT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_RANGE + TEXT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_ENCUM + INT_TYPE + COMMA_SEP +
                    WeaponEntry.COLUMN_NAME_HP + INT_TYPE + COMMA_SEP +
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
                    ArmorEntry.COLUMN_NAME_ENTRY_ID + INT_TYPE + COMMA_SEP +
                    ArmorEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    ArmorEntry.COLUMN_NAME_DEFENSE + INT_TYPE + COMMA_SEP +
                    ArmorEntry.COLUMN_NAME_SOAK + INT_TYPE + COMMA_SEP +
                    ArmorEntry.COLUMN_NAME_ENCUM + INT_TYPE + COMMA_SEP +
                    ArmorEntry.COLUMN_NAME_HP + INT_TYPE + COMMA_SEP +
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
                    StateEntry.COLUMN_NAME_ENTRY_ID + INT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_CHAR_ID + INT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_LIGHT + INT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_DARK + INT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_DUTY + INT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_OBLIGATION + INT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_GROUP_OBLIGATIONS + TEXT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_GROUP_DUTIES + TEXT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_CONTRIBUTION + INT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_GROUP_RESOURCES + TEXT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_GROUP_POSS + TEXT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_BASE + TEXT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_BASE_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_BASE_LOCATION + TEXT_TYPE + COMMA_SEP +
                    StateEntry.COLUMN_NAME_GROUP_CONTACTS + TEXT_TYPE +
                    " )";
    public static final String SQL_DELETE_STATE_ENTRIES =
            "DROP TABLE IF EXISTS " + StateEntry.TABLE_NAME;

    public static final String SQL_CREATE_TALENT_ENTRIES =
            "CREATE TABLE " + TalentEntry.TABLE_NAME + " (" +
                    TalentEntry._ID + " INTEGER PRIMARY KEY," +
                    TalentEntry.COLUMN_NAME_ENTRY_ID + INT_TYPE + COMMA_SEP +
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
                    TreeEntry.COLUMN_NAME_CAREER + TEXT_TYPE + COMMA_SEP +
                    TreeEntry.COLUMN_NAME_SPECIALIZATION + TEXT_TYPE + COMMA_SEP +
                    TreeEntry.COLUMN_NAME_CHECKED + TEXT_TYPE +
                    " )";
    public static final String SQL_DELETE_TREE_ENTRIES =
            "DROP TABLE IF EXISTS " + TreeEntry.TABLE_NAME;

    public static final String SQL_CREATE_CHAR_ENTRIES =
            "CREATE TABLE " + CharEntry.TABLE_NAME + " (" +
                    CharEntry._ID + " INTEGER PRIMARY KEY," +
                    CharEntry.COLUMN_NAME_ENTRY_ID + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_SPECIES + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_CAREER + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_TREES + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_SOAK + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_WOUNDS + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_MAX_WOUNDS + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_STRAIN + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_MAX_STRAIN + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_ENCUM + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_MAX_ENCUM + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_MELEE_DEFENSE + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_RANGED_DEFENSE + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_BRAWN + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_AGILITY + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_INTELLECT + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_CUNNING + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_WILLPOWER + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_PRESENCE + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_XP + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_TOTAL_XP + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_CREDITS + INT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_WEAPONS + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_TALENTS + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_GEAR + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_MOTIVATIONS + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_DUTIES + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_OBLIGATIONS + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_CRITS + TEXT_TYPE + COMMA_SEP +
                    CharEntry.COLUMN_NAME_SKILLSET + TEXT_TYPE +
                    " )";
    public static final String SQL_DELETE_CHAR_ENTRIES =
            "DROP TABLE IF EXISTS " + CharEntry.TABLE_NAME;

    public static final String SQL_CREATE_SKILLS_ENTRIES =
            "CREATE TABLE " + SkillsEntry.TABLE_NAME + " (" +
                    SkillsEntry._ID + " INTEGER PRIMARY KEY," +
                    SkillsEntry.COLUMN_NAME_ENTRY_ID + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_ASTROGATION + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_ATHLETICS + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_CHARM + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_COERCION + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_COMPUTERS + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_COOL + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_COORDINATION + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_DECEPTION + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_DISCIPLINE + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_LEADERSHIP + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_MECHANICS + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_MEDICINE + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_NEGOTIATION + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_PERCEPTION + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_PILOTING_PLANETARY + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_PILOTING_SPACE + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_RESILIENCE + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_SKULDUGGERY + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_STEALTH + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_STREETWISE + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_SURVIVAL + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_VIGILANCE + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_BRAWL + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_GUNNERY + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_MELEE + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_RANGED_LIGHT + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_RANGED_HEAVY + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_KNOWLEDGE + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_K_CORE_WORLDS + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_K_EDUCATION + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_K_LORE + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_K_OUTER_RIM + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_K_UNDERWORLD + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_K_WARFARE + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_K_XENOLOGY + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_K_OTHER + INT_TYPE + COMMA_SEP +
                    SkillsEntry.COLUMN_NAME_CUSTOM + INT_TYPE +
                    " )";
    public static final String SQL_DELETE_SKILLS_ENTRIES =
            "DROP TABLE IF EXISTS " + SkillsEntry.TABLE_NAME;
}
