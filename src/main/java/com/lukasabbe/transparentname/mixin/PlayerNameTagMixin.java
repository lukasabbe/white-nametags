package com.lukasabbe.transparentname.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

//? if >= 1.15 {
import net.minecraft.client.renderer.MultiBufferSource;
//?}
//?if >=1.15 <1.19.3{
/*import com.mojang.math.Matrix4f;
*///?} elif >= 1.19.3 {
import org.joml.Matrix4f;
//?}

@Mixin(EntityRenderer.class)
public class PlayerNameTagMixin {
    //? if = 1.14.4 {
    /*@WrapOperation(method = "renderNameTag", at= @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GameRenderer;renderNameTagInWorld(Lnet/minecraft/client/gui/Font;Ljava/lang/String;FFFIFFZ)V"))
    public void redirect(Font font, String s, float x, float y, float z, int i, float g, float light, boolean b, Operation<Void> original){
        original.call(font, s, x, y, z, 0xFFFFFFFF, g, light, b);
    }
    *///?} else if >= 1.15 && < 1.16 {
    /*@WrapOperation(method = "renderNameTag", at= @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Font;drawInBatch(Ljava/lang/String;FFIZLcom/mojang/math/Matrix4f;Lnet/minecraft/client/renderer/MultiBufferSource;ZII)I"))
    public int redirect(Font instance, String s, float x, float y, int color, boolean shadow, Matrix4f matrix4f, MultiBufferSource multiBufferSource, boolean seeThrough, int backgroundColor, int light, Operation<Integer> original){
        return original.call(instance, s, x, y, 0xFFFFFFFF, true, matrix4f, multiBufferSource, false, 0x0, light);
    }
    *///?}else if >= 1.16 && < 1.16.2 {
    /*@WrapOperation(method = "renderNameTag", at= @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Font;drawInBatch(Lnet/minecraft/network/chat/FormattedText;FFIZLcom/mojang/math/Matrix4f;Lnet/minecraft/client/renderer/MultiBufferSource;ZII)I"))
    public int redirect(Font instance, FormattedText formattedText, float x, float y, int color, boolean shadow, Matrix4f matrix4f, MultiBufferSource multiBufferSource, boolean seeThrough, int backgroundColor, int light, Operation<Integer> original){
        return original.call(instance, formattedText, x, y, 0xFFFFFFFF, true, matrix4f, multiBufferSource, false, 0x0, light);
    }
    *///?} else if >= 1.16.2 && <1.19.3{
    /*@WrapOperation(method = "renderNameTag", at= @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Font;drawInBatch(Lnet/minecraft/network/chat/Component;FFIZLcom/mojang/math/Matrix4f;Lnet/minecraft/client/renderer/MultiBufferSource;ZII)I"))
    public int redirect(Font instance, Component formattedText, float x, float y, int color, boolean shadow, Matrix4f matrix4f, MultiBufferSource multiBufferSource, boolean seeThrough, int backgroundColor, int light, Operation<Integer> original){
        return original.call(instance, formattedText, x, y, 0xFFFFFFFF, true, matrix4f, multiBufferSource, false, 0x0, light);
    }
    *///?} else if >= 1.19.3 <1.19.4 {
    /*@WrapOperation(method = "renderNameTag", at= @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Font;drawInBatch(Lnet/minecraft/network/chat/Component;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/renderer/MultiBufferSource;ZII)I"))
    public int redirect(Font instance, Component formattedText, float x, float y, int color, boolean shadow, Matrix4f matrix4f, MultiBufferSource multiBufferSource, boolean seeThrough, int backgroundColor, int light, Operation<Integer> original){
        return original.call(instance, formattedText, x, y, 0xFFFFFFFF, true, matrix4f, multiBufferSource, false, 0x00FFFFFF, light);
    }
    *///?} else if >=1.19.4 <1.21.6 {
    /*@WrapOperation(method = "renderNameTag", at= @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Font;drawInBatch(Lnet/minecraft/network/chat/Component;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/client/gui/Font$DisplayMode;II)I"))
    public int redirect(Font instance, Component formattedText, float x, float y, int color, boolean shadow, Matrix4f matrix4f, MultiBufferSource multiBufferSource, Font.DisplayMode mode, int backgroundColor, int light, Operation<Integer> original){
        return original.call(instance, formattedText, x, y, 0xFFFFFFFF, true, matrix4f, multiBufferSource, Font.DisplayMode.NORMAL, 0x00FFFFFF, light);
    }
    *///?} else if >=1.21.6 <1.21.9 {
    @WrapOperation(method = "renderNameTag", at= @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Font;drawInBatch(Lnet/minecraft/network/chat/Component;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/client/gui/Font$DisplayMode;II)V"))
    public void redirect(Font instance, Component formattedText, float x, float y, int color, boolean shadow, Matrix4f matrix4f, MultiBufferSource multiBufferSource, Font.DisplayMode mode, int backgroundColor, int light, Operation<Void> original){
        original.call(instance, formattedText, x, y, 0xFFFFFFFF, true, matrix4f, multiBufferSource, Font.DisplayMode.NORMAL, 0x00FFFFFF, light);
    }
    //?}
}