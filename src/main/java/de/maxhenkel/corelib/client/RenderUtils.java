package de.maxhenkel.corelib.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.util.math.Vec2f;

public class RenderUtils {

    public static int getArgb(int a, int red, int green, int blue) {
        return a << 24 | red << 16 | green << 8 | blue;
    }

    public static int getAlpha(int argb) {
        return (argb >> 24) & 0xFF;
    }

    public static int getRed(int argb) {
        return (argb >> 16) & 0xFF;
    }

    public static int getGreen(int argb) {
        return (argb >> 8) & 0xFF;
    }

    public static int getBlue(int argb) {
        return argb & 0xFF;
    }

    public static void vertex(IVertexBuilder builder, MatrixStack matrixStack, Vector3f position, Vec2f texCoord, Vector3f normal, int light, int overlay) {
        vertex(builder, matrixStack, position.getX(), position.getY(), position.getZ(), texCoord.x, texCoord.y, normal.getX(), normal.getY(), normal.getZ(), 255, 255, 255, light, overlay);
    }

    public static void vertex(IVertexBuilder builder, MatrixStack matrixStack, float posX, float posY, float posZ, float texX, float texY, int red, int green, int blue, int light, int overlay) {
        vertex(builder, matrixStack, posX, posY, posZ, texX, texY, 0F, 0F, -1F, red, green, blue, light, overlay);
    }

    public static void vertex(IVertexBuilder builder, MatrixStack matrixStack, float posX, float posY, float posZ, float texX, float texY, int light, int overlay) {
        vertex(builder, matrixStack, posX, posY, posZ, texX, texY, 0F, 0F, -1F, 255, 255, 255, light, overlay);
    }

    public static void vertex(IVertexBuilder builder, MatrixStack matrixStack, float posX, float posY, float posZ, float texX, float texY, float norX, float norY, float norZ, int red, int green, int blue, int light, int overlay) {
        MatrixStack.Entry entry = matrixStack.getLast();
        builder.pos(entry.getMatrix(), posX, posY, posZ)
                .color(red, green, blue, 255)
                .tex(texX, texY)
                .overlay(overlay)
                .lightmap(light)
                .normal(entry.getNormal(), norX, norY, norZ)
                .endVertex();
    }

}
