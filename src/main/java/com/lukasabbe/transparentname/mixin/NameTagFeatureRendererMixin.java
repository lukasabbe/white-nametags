package com.lukasabbe.transparentname.mixin;
//?if >= 1.21.9 {
/*import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.feature.NameTagFeatureRenderer;
import net.minecraft.network.chat.Component;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(NameTagFeatureRenderer.class)
public class NameTagFeatureRendererMixin {
    //?if >=1.21.9 <26.1{
    /^@WrapOperation(method = "render", at= @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Font;drawInBatch(Lnet/minecraft/network/chat/Component;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/client/gui/Font$DisplayMode;II)V", ordinal = 0))
    public void redirect(Font instance, Component component, float x, float y, int color, boolean shadow, Matrix4f matrix4f, MultiBufferSource multiBufferSource, Font.DisplayMode displayMode, int backgroundColor, int light, Operation<Void> original){
        original.call(instance, component, x, y, 0xFFFFFFFF, true, matrix4f, multiBufferSource, Font.DisplayMode.NORMAL, 0x00FFFFFF, light);
    }
    @WrapOperation(method = "render", at= @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Font;drawInBatch(Lnet/minecraft/network/chat/Component;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/client/gui/Font$DisplayMode;II)V", ordinal = 1))
    public void redirect2(Font instance, Component component, float x, float y, int color, boolean shadow, Matrix4f matrix4f, MultiBufferSource multiBufferSource, Font.DisplayMode displayMode, int backgroundColor, int light, Operation<Void> original){
        original.call(instance, component, x, y, 0xFFFFFFFF, true, matrix4f, multiBufferSource, Font.DisplayMode.NORMAL, 0x00FFFFFF, light);
    }
    ^///?} else if >=26.1 {
    /^@WrapOperation(method = "renderTranslucent", at= @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Font;drawInBatch(Lnet/minecraft/network/chat/Component;FFIZLorg/joml/Matrix4fc;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/client/gui/Font$DisplayMode;II)V", ordinal = 0))
    public void redirect(Font instance, Component component, float x, float y, int color, boolean shadow, Matrix4fc matrix4fc, MultiBufferSource multiBufferSource, Font.DisplayMode displayMode, int backgroundColor, int light, Operation<Void> original){
        original.call(instance, component, x, y, 0xFFFFFFFF, true, matrix4fc, multiBufferSource, Font.DisplayMode.NORMAL, 0x00FFFFFF, light);
    }
    @WrapOperation(method = "renderTranslucent", at= @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Font;drawInBatch(Lnet/minecraft/network/chat/Component;FFIZLorg/joml/Matrix4fc;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/client/gui/Font$DisplayMode;II)V", ordinal = 1))
    public void redirect2(Font instance, Component component, float x, float y, int color, boolean shadow, Matrix4fc matrix4fc, MultiBufferSource multiBufferSource, Font.DisplayMode displayMode, int backgroundColor, int light, Operation<Void> original){
        original.call(instance, component, x, y, 0xFFFFFFFF, true, matrix4fc, multiBufferSource, Font.DisplayMode.NORMAL, 0x00FFFFFF, light);
    }
    ^///?}
}
*///?}
