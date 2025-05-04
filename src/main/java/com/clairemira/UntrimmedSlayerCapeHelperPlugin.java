package com.clairemira;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Untrimmed Slayer Cape Helper",
	description = "Provides helpful information to obtain an untrimmed 99 Slayer cape.",
	tags = {"untrimmed","slayer","cape","helper","cannon"}
)
public class UntrimmedSlayerCapeHelperPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private UntrimmedSlayerCapeHelperConfig config;

	@Inject
	private UntrimmedSlayerCapeHelperCannonExpOverlayPanel cannonExpOverlay;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(cannonExpOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(cannonExpOverlay);
	}

	@Provides
	UntrimmedSlayerCapeHelperConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(UntrimmedSlayerCapeHelperConfig.class);
	}

	public int getCannonExperienceRemaining()
    {
        int exp99 = Experience.getXpForLevel(99);
        int slayerExp = client.getSkillExperience(Skill.SLAYER);
        int hpExp = client.getSkillExperience(Skill.HITPOINTS);

        double cannonExpRemaining = (((exp99 - slayerExp) * 1.3) + hpExp - exp99) / 1.3;

        return (int) Math.round(cannonExpRemaining);
    }
}
