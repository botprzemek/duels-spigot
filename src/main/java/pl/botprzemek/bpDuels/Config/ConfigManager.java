package pl.botprzemek.bpDuels.Config;

import pl.botprzemek.bpDuels.BpDuels;

import java.util.ArrayList;
import java.util.List;

public class ConfigManager {

    private BpDuels instance;

    private List<Config> configs = new ArrayList<>();

    private ProfileConfig profileConfig;

    public ConfigManager(BpDuels instance) {

        this.instance = instance;

        configs.add(this.profileConfig = new ProfileConfig(instance));

    }

    public void loadConfigs() {

        instance.getLogger().info("Loading configs...");

        for (Config config : configs) {

            config.loadConfig();

        }

    }

    public void saveConfigs() {

        instance.getLogger().info("Saving configs...");

        for (Config config : configs) {

            config.saveConfig();

        }

    }

    public ProfileConfig getProfileConfig() {

        return profileConfig;

    }

}
