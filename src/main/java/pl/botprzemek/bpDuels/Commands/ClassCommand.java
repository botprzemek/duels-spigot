package pl.botprzemek.bpDuels.Commands;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.botprzemek.bpDuels.Game.Class.Classs;
import pl.botprzemek.bpDuels.Game.GameManager;
import pl.botprzemek.bpDuels.Game.Profile.Profile;

public class ClassCommand implements CommandExecutor {

    private GameManager gameManager;

    public ClassCommand(GameManager gameManager) {

        this.gameManager = gameManager;

    }

    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {

        Player player = (Player) sender;

        Profile profile = gameManager.getProfileManager().getProfile(player);

        if (args.length == 0) {

            gameManager.getProfileManager().saveProfiles();

            gameManager.getConfigManager().saveConfigs();

            return true;

        }

        switch (args[0]) {

            case "nomad":
                profile.setClasss(Classs.NOMAD);
                break;
            case "netrunner":
                profile.setClasss(Classs.NETRUNNER);
                break;
            case "ronin":
                profile.setClasss(Classs.RONIN);
                break;
            case "fixer":
                profile.setClasss(Classs.FIXER);
                break;
            case "technik":
                profile.setClasss(Classs.TECHNIK);
                break;
            case "businessman":
                profile.setClasss(Classs.BUSINESSMAN);
                break;
            case "jugernaut":
                profile.setClasss(Classs.JUGERNAUT);
                break;

        }

        double playerHealth = profile.getClasss().getArmorLevel().getMaxHealth();

        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(playerHealth);
        player.setHealth(playerHealth);
        player.sendMessage("You choose " + profile.getClasss().getClassName());

        return true;

    }

}
