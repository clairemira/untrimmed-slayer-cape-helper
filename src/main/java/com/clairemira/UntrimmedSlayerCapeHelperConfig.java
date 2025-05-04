package com.clairemira;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("untrimmedSlayerCapeHelper")
public interface UntrimmedSlayerCapeHelperConfig extends Config
{
	@ConfigItem(
		keyName = "showSlayerCannonExp",
		name = "Show Slayer Cannon XP",
		description = "Show the amount of cannon slayer experience required to obtain 99 Slayer at the same time as 99 Hitpoints."
	)
	default boolean showSlayerCannonExp()
	{
		return true;
	}
}
