package com.lukasabbe.transparentname.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    //? if = 1.14.4 {
    /*@ModifyArg(method = "renderNameTagInWorld", at= @At(value = "INVOKE", target = "Lnet/minecraft/client/Options;getBackgroundOpacity(F)F"))
    private static float modifyValue(float value){
        return 0;
    }

    @WrapOperation(method = "renderNameTagInWorld", at= @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Font;draw(Ljava/lang/String;FFI)I", ordinal = 0))
    private static int changeDraw(Font instance, String s, float x, float y, int i, Operation<Integer> original){
        return instance.drawShadow(s, x, y, i);
    }
    *///?}
}
