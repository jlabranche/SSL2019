package com.mayhem.rs2.content.skill.cooking;

import java.util.HashMap;
import java.util.Map;

public enum CookingData {
	//           RAW, Lv, BLv, Cook, Burn, XP
	//BEEF
    SINEW(        2124, 1,  0, 9436, 9436, 3.0D),
	RAW_BEEF(     2132, 1, 32, 2124, 2146, 30.0D),
	RAW_RAT(      2134, 1, 32, 2124, 2146, 30.0D),
	RAW_BEAR(     2136, 1, 32, 2124, 2146, 30.0D),
	RAW_CHICKEN(  2138, 1, 32, 2140, 2144, 30.0D),
	RAW_UGTHANKI( 1859, 1, 70, 1861, 2146, 40.0D),
	RAW_RABBIT(   3226, 1, 32, 3228, 7222, 30.0D),
	
	//PIE
	REDBERRY_PIE( 2321, 10, 70,  2325,  2329, 78.0D),
	MEAT_PIE(     2317, 20, 70,  2327,  2329, 135.0D),
	MUD_PIE(      7168, 29, 70,  7170,  2329, 128.0D),
	APPLE_PIE(    2317, 30, 70,  2323,  2329, 130.0D),
	GARDEN_PIE(   7176, 34, 70,  7178,  2329, 138.0D),
	FISH_PIE(     7186, 47, 70,  7188,  2329, 164.0D),
	ADMIRAL_PIE(  7196, 70, 80,  7198,  2329, 201.0D),
	WILD_PIE(     7206, 85, 95,  7208,  2329, 240.0D),
	SUMMER_PIE(   7216, 95, 100, 7208,  2329, 260.0D),
	BOTANICAL_PIE(19656, 52, 70, 19662, 2329, 180.0D),
	MUSHROOM_PIE( 21684, 60, 70, 21690, 2329, 200.0D),

	//FISH
	RAW_SHRIMP(   317,   1,  34,  315,   323,   30.0D),
	SARDINE(      327,   1,  38,  325,   369,   40.0D),
	ANCHOVIES(    321,   1,  34,  319,   323,   30.0D),
	HERRING(      345,   5,  41,  347,   353,   50.0D),
	MACKEREL(     353,   10, 45,  355,   353,   60.0D),
	TROUT(        335,   15, 50,  333,   343,   70.0D),
	COD(          341,   18, 52,  339,   343,   75.0D),
	PIKE(         349,   20, 53,  351,   343,   80.0D),
	SALMON(       331,   25, 58,  329,   343,   90.0D),
	SLIMY_EEL(    3379,  28, 58,  3381,  3383,  95.0D),
	TUNA(         359,   30, 65,  361,   367,   100.0D),
	KARAMBWAN(    3142,  30, 200, 3144,  3148,  190.0D),
	RAINBOW_FISH( 10138, 35, 60,  10136, 10140, 110.0D),
	CAVE_EEL(     5001,  38, 40,  4003,  5002,  115.0D),
	LOBSTER(      377,   40, 74,  379,   381,   120.0D),
	BASS(         363,   43, 80,  365,   367,   130.0D),
	SWORDFISH(    371,   45, 86,  373,   375,   140.0D),
	LAVA_EEL(     2148,  53, 53,  2149,  3383,  30.0D),
	MONKFISH(     7944,  62, 92,  7946,  7948,  150.0D),
	SHARK(        383,   80, 99,  385,   387,   210.0D),
	SEA_TURTLE(   395,   82, 150, 397,   399,   212.0D),
	CAVEFISH(     15264, 88, 150, 15266, 15268, 214.0D),
	MANTA_RAY(    389,   91, 150, 391,   393,   216.0D),
	ANGLERFISH(   13439, 84, 99,  13441, 13443, 230.0D),
	DARK_CRAB(    11934, 90, 185, 11936, 11938, 215.0D);

	public static final void declare() {
		for (CookingData data : values())
			food.put(Integer.valueOf(data.getFoodId()), data);
	}

	int foodId;
	int levelRequired;
	int noBurnLevel;
	int replacement;
	int burnt;
	double experience;

	private static Map<Integer, CookingData> food = new HashMap<Integer, CookingData>();

	public static CookingData forId(int id) {
		return food.get(Integer.valueOf(id));
	}

	private CookingData(int food, int level, int noBurn, int replacement, int burnt, double exp) {
		foodId = food;
		levelRequired = level;
		noBurnLevel = noBurn;
		experience = exp;
		this.replacement = replacement;
		this.burnt = burnt;
	}

	public int getBurnt() {
		return burnt;
	}

	public double getExperience() {
		return experience;
	}

	public int getFoodId() {
		return foodId;
	}

	public int getLevelRequired() {
		return levelRequired;
	}

	public int getNoBurnLevel() {
		return noBurnLevel;
	}

	public int getReplacement() {
		return replacement;
	}
}
