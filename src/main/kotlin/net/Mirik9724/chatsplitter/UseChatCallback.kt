package net.Mirik9724.chatsplitter

import net.fabricmc.fabric.api.event.Event
import net.fabricmc.fabric.api.event.EventFactory
import net.minecraft.client.network.ClientPlayerEntity
import net.minecraft.util.ActionResult

fun interface UseChatCallback {
    fun interact(player: ClientPlayerEntity, message: String): ActionResult

    companion object {
        val EVENT: Event<UseChatCallback> = EventFactory.createArrayBacked(
            UseChatCallback::class.java
        ) { listeners ->
            UseChatCallback { player, message ->
                for (listener in listeners) {
                    val result = listener.interact(player, message)
                    if (result != ActionResult.PASS) return@UseChatCallback result
                }
                ActionResult.PASS
            }
        }
    }
}
