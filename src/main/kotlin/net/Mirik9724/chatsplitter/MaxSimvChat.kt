package net.Mirik9724.chatsplitter

import net.minecraft.client.gui.GuiChat
import net.minecraft.client.gui.GuiTextField
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.Shadow
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Mixin(GuiChat::class)
class MixinGuiChat {

    @Shadow
    lateinit var inputField: GuiTextField  // поле из GuiChat, которое надо изменить

    @Inject(method = ["initGui"], at = [At("TAIL")])
    private fun onInitGui(ci: CallbackInfo) {
        inputField.maxStringLength = 1000000
    }
}
