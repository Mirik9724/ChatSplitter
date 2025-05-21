package net.Mirik9724.chatsplitter

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import net.fabricmc.api.ClientModInitializer

class ChatsplitterClient : ClientModInitializer {
    val logger: Logger = LogManager.getLogger("ChatSplitter")

    override fun onInitializeClient() {
        logger.info("Mod ON")
    }
}
