package me.lukasabbe.whitenametags.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.command.LabelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueueImpl;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(targets = "net/minecraft/client/render/command/LabelCommandRenderer$Commands")
public class PlayerNameTagMixin {
    @Shadow @Final
    List<OrderedRenderCommandQueueImpl.LabelCommand> normalLabels;

    @Inject(method = "add", at= @At(value = "INVOKE", target = "Ljava/util/List;add(Ljava/lang/Object;)Z", shift = At.Shift.BEFORE), cancellable = true)
    public void injected(MatrixStack matrices, Vec3d pos, int y, Text label, boolean notSneaking, int light, double squaredDistanceToCamera, CameraRenderState cameraState, CallbackInfo ci, @Local float f, @Local(ordinal = 2) int k, @Local Matrix4f matrix4f){
        this.normalLabels.add(new OrderedRenderCommandQueueImpl.LabelCommand(matrix4f, f, (float)y, label, LightmapTextureManager.applyEmission(light, 2), 0xFFFFFFFF, 0, squaredDistanceToCamera));
        matrices.pop();
        ci.cancel();
    }
}
