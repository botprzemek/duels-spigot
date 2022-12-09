package pl.botprzemek.bpDuels.Config;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import pl.botprzemek.bpDuels.BpDuels;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public abstract class Config extends YamlConfiguration {

    protected BpDuels instance;

    protected String name;

    protected File file;

    public Config(BpDuels instance, String name) {

        this.instance = instance;

        this.name = name;

        file = new File(instance.getDataFolder(), name);

    }

    public Set<String> getSection(String path) {

        ConfigurationSection section = getConfigurationSection(path);

        if (section != null) return section.getKeys(false);

        return new HashSet<>();

    }

    private void checkConfig() {

        if (file.exists()) return;

        file.getParentFile().mkdirs();

        instance.saveResource(name, false);

    }

    public void loadConfig() {

        checkConfig();

        try {

            load(file);

        }

        catch (InvalidConfigurationException | IOException exception) {

            exception.printStackTrace();

        }

    }

    public void saveConfig() {

        try {

            save(file);

        }

        catch (IOException exception) {

            exception.printStackTrace();

        }

    }

}
