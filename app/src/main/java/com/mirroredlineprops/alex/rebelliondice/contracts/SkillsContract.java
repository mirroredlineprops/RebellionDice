package com.mirroredlineprops.alex.rebelliondice.contracts;

import android.provider.BaseColumns;

/**
 * Created by alex.costanzo on 10/28/2014.
 */
public class SkillsContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public SkillsContract() {}

    /* Inner class that defines the table contents */
    public static abstract class SkillsEntry implements BaseColumns {
        public static final String TABLE_NAME = "skills";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_ASTROGATION = "astrogation";
        public static final String COLUMN_NAME_ATHLETICS = "athletics";
        public static final String COLUMN_NAME_CHARM = "charm";
        public static final String COLUMN_NAME_COERCION = "coercion";
        public static final String COLUMN_NAME_COMPUTERS = "computers";
        public static final String COLUMN_NAME_COOL = "cool";
        public static final String COLUMN_NAME_COORDINATION = "coordination";
        public static final String COLUMN_NAME_DECEPTION = "deception";
        public static final String COLUMN_NAME_DISCIPLINE = "discipline";
        public static final String COLUMN_NAME_LEADERSHIP = "leadership";
        public static final String COLUMN_NAME_MECHANICS = "mechanics";
        public static final String COLUMN_NAME_MEDICINE = "medicine";
        public static final String COLUMN_NAME_NEGOTIATION = "negotiation";
        public static final String COLUMN_NAME_PERCEPTION = "perception";
        public static final String COLUMN_NAME_PILOTING_PLANETARY = "pilotingPlanetary";
        public static final String COLUMN_NAME_PILOTING_SPACE = "pilotingSpace";
        public static final String COLUMN_NAME_RESILIENCE = "resilience";
        public static final String COLUMN_NAME_SKULDUGGERY = "skulduggery";
        public static final String COLUMN_NAME_STEALTH = "stealth";
        public static final String COLUMN_NAME_STREETWISE = "streetwise";
        public static final String COLUMN_NAME_SURVIVAL = "survival";
        public static final String COLUMN_NAME_VIGILANCE = "vigilance";
        public static final String COLUMN_NAME_BRAWL = "brawl";
        public static final String COLUMN_NAME_GUNNERY = "gunnery";
        public static final String COLUMN_NAME_MELEE = "melee";
        public static final String COLUMN_NAME_RANGED_LIGHT = "rangedLight";
        public static final String COLUMN_NAME_RANGED_HEAVY = "rangedHeavy";
        public static final String COLUMN_NAME_KNOWLEDGE = "knowledge";
        public static final String COLUMN_NAME_K_CORE_WORLDS = "kCoreWorlds";
        public static final String COLUMN_NAME_K_EDUCATION = "kEducation";
        public static final String COLUMN_NAME_K_LORE = "kLore";
        public static final String COLUMN_NAME_K_OUTER_RIM = "kOuterRim";
        public static final String COLUMN_NAME_K_UNDERWORLD = "kUnderworld";
        public static final String COLUMN_NAME_K_WARFARE = "kWarfare";
        public static final String COLUMN_NAME_K_XENOLOGY = "kXenology";
        public static final String COLUMN_NAME_K_OTHER = "kOther";
        public static final String COLUMN_NAME_CUSTOM = "custom";
    }
}
