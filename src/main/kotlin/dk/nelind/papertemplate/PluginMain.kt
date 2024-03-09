package dk.nelind.papertemplate

import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused")
class PluginMain : JavaPlugin() {
    override fun onEnable() {
        this.logger.info("Plugin Template")
    }
}
