package me.lukasabbe.whitenametags.mixin;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.util.math.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityRenderer.class)
public class PlayerNameTagMixin {
    @Redirect(method = "renderLabelIfPresent", at= @At(value = "INVOKE", target = "Lnet/minecraft/client/font/TextRenderer;draw(Ljava/lang/String;FFIZLnet/minecraft/client/util/math/Matrix4f;Lnet/minecraft/client/render/VertexConsumerProvider;ZII)I"))
    private int injected(TextRenderer instance, String text, float x, float y, int color, boolean shadow, Matrix4f matrix, VertexConsumerProvider vertexConsumerProvider, boolean seeThrough, int backgroundColor, int light){
        return instance.draw(text,x,y,0xffffff,true,matrix,vertexConsumerProvider,false,0x0,light);
        //return instance.draw(text,x,y,0xFFFFFFFF,true,matrix,matrix, vertexConsumerProvider ,true,0x00FFFFFF);
    }
}
