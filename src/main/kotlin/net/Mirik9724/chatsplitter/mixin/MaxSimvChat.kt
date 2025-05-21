//package net.mirik9724.chatsplitter.mixin
//
//import net.minecraft.client.gui.screen.ChatScreen
//import net.minecraft.client.gui.widget.TextFieldWidget
//import org.spongepowered.asm.mixin.Mixin
//import org.spongepowered.asm.mixin.Shadow
//import org.spongepowered.asm.mixin.injection.At
//import org.spongepowered.asm.mixin.injection.Inject
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo
//
//@Mixin(ChatScreen::class)
//class MaxSimvChat {
//
//    @Shadow
//    lateinit var chatField: TextFieldWidget
//
//    @Inject(method = ["init"], at = [At("TAIL")])
//    private fun onInit(ci: CallbackInfo) {
//        chatField.setMaxLength(10000)
//    }
//}
