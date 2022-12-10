package pl.botprzemek.bpDuels.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.botprzemek.bpDuels.Game.Class.Classs;
import pl.botprzemek.bpDuels.Game.GameManager;

public class GetClassCommand implements CommandExecutor {

    private GameManager gameManager;

    public GetClassCommand(GameManager gameManager) {

        this.gameManager = gameManager;

    }

    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {

        Player player = (Player) sender;

        if (args.length == 0) return false;

        Player target = Bukkit.getPlayer(args[0]);

        Classs classs = gameManager.getProfileManager().getProfile(target).getClasss();

        if (classs == null) return false;

        player.sendMessage(classs.getClassName());

        return true;

    }
}
