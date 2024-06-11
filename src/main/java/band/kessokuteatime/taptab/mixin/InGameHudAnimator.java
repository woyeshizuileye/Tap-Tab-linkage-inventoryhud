package band.kessokuteatime.taptab.mixin;

import band.kessokuteatime.taptab.InventorySwapper;
import band.kessokuteatime.taptab.ModLinkAge;
import band.kessokuteatime.taptab.TapTab;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(InGameHud.class)
public abstract class InGameHudAnimator {

	@Shadow private int scaledWidth;

    @ModifyArgs(
			method = "renderHotbar",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/gui/hud/InGameHud;renderHotbarItem(Lnet/minecraft/client/gui/DrawContext;IIFLnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/item/ItemStack;I)V",
					ordinal = 0
			)
	)
	private void renderHotbarItem(Args args /* DrawContext *, int x, int y, float tickDelta, PlayerEntity *, ItemStack *, int seed */ ) {
		int x = args.get(1), y = args.get(2), slot = (x - 2 + 90 - scaledWidth / 2) / 20, ANIMATION_AMOUNT = ModLinkAge.y() - 73;
		long start = InventorySwapper.HOTBAR_SLOTS_ANIMATION_START[slot];
		double progress = (double) Math.max((System.currentTimeMillis() - start), 0) / TapTab.ANIMATION_DURATION;

		if (start == -1 || progress > 1) return;

		boolean reversed = InventorySwapper.HOTBAR_SLOTS_ANIMATION_REVERSED[slot];
        double offset = TapTab.easeOutBounce(progress, reversed) * ANIMATION_AMOUNT;
		if (ModLinkAge.Inventoryhud()) {
			if (slot == 0) {
				int TESTY = y + (int) (offset * Math.sin(ModLinkAge.radain08()));
				int TESTX = x - (int) (offset * Math.cos(ModLinkAge.radain08()));
				args.set(2, TESTY);
				args.set(1, TESTX);
			}
			if (slot == 1) {
				int TESTY = y + (int) (offset * Math.sin(ModLinkAge.radain17()));
				int TESTX = x - (int) (offset * Math.cos(ModLinkAge.radain17()));
				args.set(2, TESTY);
				args.set(1, TESTX);
			}
			if (slot == 2) {
				int TESTY = y + (int) (offset * Math.sin(ModLinkAge.radain26()));
				int TESTX = x - (int) (offset * Math.cos(ModLinkAge.radain26()));
				args.set(2, TESTY);
				args.set(1, TESTX);
			}
			if (slot == 3) {
				int TESTY = y + (int) (offset * Math.sin(ModLinkAge.radain35()));
				int TESTX = x - (int) (offset * Math.cos(ModLinkAge.radain35()));
				args.set(2, TESTY);
				args.set(1, TESTX);
			}
			if (slot == 4) {
				args.set(2, y + (int) offset);
			}
			if (slot == 5) {
				int TESTY = y + (int) (offset * Math.sin(ModLinkAge.radain35()));
				int TESTX = x + (int) (offset * Math.cos(ModLinkAge.radain35()));
				args.set(2, TESTY);
				args.set(1, TESTX);
			}
			if (slot == 6) {
				int TESTY = y + (int) (offset * Math.sin(ModLinkAge.radain26()));
				int TESTX = x + (int) (offset * Math.cos(ModLinkAge.radain26()));
				args.set(2, TESTY);
				args.set(1, TESTX);
			}
			if (slot == 7) {
				int TESTY = y + (int) (offset * Math.sin(ModLinkAge.radain17()));
				int TESTX = x + (int) (offset * Math.cos(ModLinkAge.radain17()));
				args.set(2, TESTY);
				args.set(1, TESTX);
			}
			if (slot == 8) {
				int TESTY = y + (int) (offset * Math.sin(ModLinkAge.radain08()));
				int TESTX = x + (int) (offset * Math.cos(ModLinkAge.radain08()));
				args.set(2, TESTY);
				args.set(1, TESTX);
			}
		}else {
			args.set(2, y + (int) offset);
		}
	}
}
