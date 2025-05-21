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

    @Inject(method = ["keyPressed"], at = [At("HEAD")], cancellable = true)
    private fun onKeyPressed(keyCode: Int, scanCode: Int, modifiers: Int, cir: CallbackInfoReturnable<Boolean>) {
        // Проверяем, нажата ли клавиша Enter
        if (keyCode == 257 || keyCode == 335) { // 335 — numpad Enter
            val message = chatField.text
            if (message.isNotEmpty()) {
                val maxLength = 256  // стандартный лимит для одного сообщения
                var start = 0

                while (start < message.length) {
                    val end = (start + maxLength).coerceAtMost(message.length)
                    val part = message.substring(start, end)
                    // Отправляем часть сообщения
                    sendChatMessage(part)
                    start = end
                }

                // Очищаем поле после отправки
                chatField.text = ""

                cir.returnValue = true // отменяем дальнейшую обработку, т.к. сами отправили
            }
        }
    }

    // Здесь вызываем метод отправки сообщения в игру
    private fun sendChatMessage(message: String) {
        // Чтобы отправить сообщение, вызываем метод chatScreen.sendMessage(message, true)
        // Но у нас миксин, поэтому нужно получить референс к ChatScreen

        // Пример:
        (this as ChatScreen).sendMessage(message, true)
    }

    @Inject(method = ["init"], at = [At("TAIL")])
    private fun onInit(cir: CallbackInfo) {
        chatField.setMaxLength(1000000)
    }
}


