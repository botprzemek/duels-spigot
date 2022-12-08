package pl.botprzemek.bplobby.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;
import pl.botprzemek.bpDuels.BpDuels;

import java.util.ArrayList;
import java.util.List;

public class StringSerializer {

    private final MiniMessage mm = BpDuels.getMiniMessage();

    public String serializeString(String string) {

        Component prefixComponent = mm.deserialize(string);

        return  LegacyComponentSerializer.legacySection().serialize(prefixComponent);

    }

    public String serializeString(String string, String prefix) {

        Component prefixComponent = mm.deserialize(string
                .replace("%prefix%", prefix));

        return  LegacyComponentSerializer.legacySection().serialize(prefixComponent);

    }

    public String serializeString(Player player, String string) {

        String stringPlaceholders = PlaceholderAPI.setPlaceholders(player, string);

        Component prefixComponent = mm.deserialize(stringPlaceholders);

        return  LegacyComponentSerializer.legacySection().serialize(prefixComponent);

    }

    public String serializeString(Player player, String string, String prefix) {

        String stringPlaceholders = PlaceholderAPI.setPlaceholders(player, string
                .replace("%prefix%", prefix));

        Component prefixComponent = mm.deserialize(stringPlaceholders);

        return  LegacyComponentSerializer.legacySection().serialize(prefixComponent);

    }

    public List<String> serializeListOfStrings(List<String> stringList) {

        List<String> serializedStringList = new ArrayList<>();

        for (String string : stringList) {

            Component component = mm.deserialize(string);

            String stringSerialized = LegacyComponentSerializer.legacySection().serialize(component);

            serializedStringList.add(stringSerialized);

        }

        return serializedStringList;

    }

}
