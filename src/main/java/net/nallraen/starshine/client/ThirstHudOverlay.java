package net.nallraen.starshine.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.nallraen.starshine.StarshineMod;

public class ThirstHudOverlay {

    private static final ResourceLocation FILLED_BOTTLE = new ResourceLocation(StarshineMod.MOD_ID,
            "textures/thirst/filled_bottle.png");
    private static final ResourceLocation EMPTY_BOTTLE = new ResourceLocation(StarshineMod.MOD_ID,
            "textures/thirst/empty_bottle.png");

    public static final IGuiOverlay HUD_THIRST = ((gui, poseStack, partialTick, width, height) -> {
        int x = width / 2;
        int y = height;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0F, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, EMPTY_BOTTLE);
        for(int i = 0; i<10;i++) {
            GuiComponent.blit(poseStack, x+(i*9), y-50, 0, 0, 10,
                    10, 10, 10);
        }

        RenderSystem.setShaderTexture(0, FILLED_BOTTLE);
        for(int i = 0; i < 10; i++) {
            if(ClientThirstData.getPlayerThirst() > i) {
                GuiComponent.blit(poseStack, x+(i*9), y-50, 0, 0, 10,
                        10, 10, 10);
            } else {
                break;
            }
        }
    });
}
