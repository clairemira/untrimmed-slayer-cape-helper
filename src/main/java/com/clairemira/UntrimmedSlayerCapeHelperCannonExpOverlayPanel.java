package com.clairemira;

import java.awt.*;
import java.text.NumberFormat;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class UntrimmedSlayerCapeHelperCannonExpOverlayPanel extends OverlayPanel {
    private final UntrimmedSlayerCapeHelperPlugin plugin;
    private final UntrimmedSlayerCapeHelperConfig config;

    @Inject
    public UntrimmedSlayerCapeHelperCannonExpOverlayPanel(Client client, UntrimmedSlayerCapeHelperPlugin plugin, UntrimmedSlayerCapeHelperConfig config)
    {
        super(plugin);
        this.plugin = plugin;
        this.config = config;

        panelComponent.setPreferredSize(new Dimension(110,100));
        setPosition(OverlayPosition.TOP_LEFT);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (!config.showSlayerCannonExp()) {
            return null;
        }

        int cannonExpRemaining = plugin.getCannonExperienceRemaining();
        String expStr = NumberFormat.getInstance().format(cannonExpRemaining);
        Color expTextColor = cannonExpRemaining <= 0 ? Color.GREEN : Color.RED;

        panelComponent.getChildren().add(TitleComponent.builder()
                .text("Cannon Slayer XP")
                .color(Color.WHITE)
                .build());

        panelComponent.getChildren().add(TitleComponent.builder()
                .text(expStr)
                .color(expTextColor)
                .build());

        return super.render(graphics);
    }
}
