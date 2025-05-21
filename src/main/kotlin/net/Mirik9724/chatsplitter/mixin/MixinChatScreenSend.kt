package net.Mirik9724.chatsplitter.mixin

import net.minecraft.client.gui.screen.ChatScreen
import net.minecraft.client.gui.widget.TextFieldWidget
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.Shadow
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable

@Mixin(ChatScreen::class)
abstract class MixinChatScreenSend {

    @Shadow
    protected lateinit var chatField: TextFieldWidget

    // keyPressed возвращает boolean — значит, CallbackInfoReturnable<Boolean>
    @Inject(method = ["keyPressed"], at = [At("HEAD")], cancellable = true)
    private fun onKeyPressed(keyCode: Int, scanCode: Int, modifiers: Int, cir: CallbackInfoReturnable<Boolean>) {
        // не блокируем отправку, не отменяем
    }

    // init() — void, значит, CallbackInfo без Returnable
    @Inject(method = ["init"], at = [At("TAIL")])
    private fun onInit(cir: CallbackInfo) {
        chatField.setMaxLength(1000000)
    }
}

