package me.lukasabbe.whitenametags.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_12075;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.command.LabelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.command.OrderedRenderCommandQueueImpl;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(targets = "net/minecraft/client/render/command/LabelCommandRenderer$class_12050")
public class PlayerNameTagMixin {
    @Shadow @Final
    List<OrderedRenderCommandQueueImpl.LabelCommand> field_62988;

    @Inject(method = "method_74829", at= @At(value = "INVOKE", target = "Ljava/util/List;add(Ljava/lang/Object;)Z", shift = At.Shift.BEFORE), cancellable = true)
    public void injected(MatrixStack matrixStack, Vec3d vec3d, Text text, boolean bl, int i, double d, class_12075 arg, CallbackInfo ci, @Local float f, @Local(ordinal = 1) int j, @Local(ordinal = 2) int k, @Local Matrix4f matrix4f){
        this.field_62988.add(new OrderedRenderCommandQueueImpl.LabelCommand(matrix4f, f, (float)j, text, i, 0xFFFFFFFF, 0, d));
        matrixStack.pop();
        ci.cancel();
    }
}
