package com.example.unlimitedvillagertrades.mixin;

import net.minecraft.village.TradeOffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TradeOffer.class)
public class TradeOfferMixin {
    @Shadow private int uses;
    
    // Always return a very large number for max uses
    @Inject(method = "getMaxUses", at = @At("HEAD"), cancellable = true)
    private void getMaxUses(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(Integer.MAX_VALUE);
    }
    
    // Always return true for hasUsesLeft
    @Unique
    private void hasUsesLeft(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
    
    // Reset uses to 0 whenever they increase
    @Inject(method = "use", at = @At("RETURN"))
    private void onUse(CallbackInfo ci) {
        this.uses = 0;
    }
}
