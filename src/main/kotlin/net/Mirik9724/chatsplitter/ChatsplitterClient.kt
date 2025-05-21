package net.Mirik9724.chatsplitter

//import net.Mirik9724.chatsplitter.mixin.UseChatCallback
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import net.fabricmc.api.ClientModInitializer
import net.minecraft.text.LiteralText
import net.minecraft.util.ActionResult

class ChatsplitterClient : ClientModInitializer {
    val logger: Logger = LogManager.getLogger("ChatSplitter")

    override fun onInitializeClient() {
        logger.info("Mod ON")
//        UseChatCallback.EVENT.register(UseChatCallback { player, message ->
//            val modifiedMessage = "[split] ${message}"
//            player.sendMessage(LiteralText("Ты сказал: $modifiedMessage"))
//            ActionResult.FAIL // Не отправлять оригинальное сообщение
//        })
    }
}
