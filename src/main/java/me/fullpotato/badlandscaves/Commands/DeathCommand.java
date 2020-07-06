package me.fullpotato.badlandscaves.Commands;

import me.fullpotato.badlandscaves.BadlandsCaves;
import me.fullpotato.badlandscaves.Util.PlayerScore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeathCommand extends Commands implements CommandExecutor {

    private BadlandsCaves plugin;

    public DeathCommand(BadlandsCaves bcav) {
        plugin = bcav;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("deaths")) {
            if (sender.isOp()) {
                if (args.length == 0) {
                    tooFewArgs(sender);
                    return true;
                } else if (args[0].equalsIgnoreCase("get")) {
                    if (args.length < 2) {
                        if (sender instanceof Player) {
                            Player player = (Player) sender;
                            player.sendMessage(ChatColor.GOLD + "Your Deaths count is " + ChatColor.RED + PlayerScore.DEATHS.getScore(plugin, player) + ChatColor.GOLD + ".");
                        } else {
                            playerNotValid(sender);
                        }
                    } else {
                        for (Player targets : plugin.getServer().getOnlinePlayers()) {
                            if (args[1].equalsIgnoreCase(targets.getDisplayName()) || args[1].equalsIgnoreCase(targets.getName()) || args[1].equalsIgnoreCase(targets.getUniqueId().toString())) {
                                sender.sendMessage(ChatColor.GOLD + "The Deaths count of " + ChatColor.RED + targets.getDisplayName() + ChatColor.GOLD + " is " + ChatColor.RED + ((int) PlayerScore.DEATHS.getScore(plugin, targets)) + ChatColor.GOLD + ".");
                                return true;
                            }
                        }
                        playerNotValid(sender);
                    }
                    return true;
                } else if (args[0].equalsIgnoreCase("set")) {
                    if (args.length < 2) {
                        sender.sendMessage(ChatColor.RED + "Please specify a player.");
                    }
                    else {
                        for (Player targets : plugin.getServer().getOnlinePlayers()) {
                            if (args[1].equalsIgnoreCase(targets.getDisplayName()) || args[1].equalsIgnoreCase(targets.getName()) || args[1].equalsIgnoreCase(targets.getUniqueId().toString())) {
                                if (args.length > 2) {
                                    try {
                                        int change = Integer.parseInt(args[2]);
                                        PlayerScore.DEATHS.setScore(plugin, targets, change);
                                        plugin.saveConfig();
                                        sender.sendMessage(ChatColor.GOLD + "The Deaths count of " + ChatColor.RED + targets.getDisplayName() + ChatColor.GOLD + " has been set to " + ChatColor.RED + change + ChatColor.GOLD + ".");
                                        return true;
                                    } catch (NumberFormatException e) {
                                        sender.sendMessage(ChatColor.RED + "You must set the Deaths count to an integer.");
                                        return true;
                                    }
                                }
                                else {
                                    mustSpecifyValue(sender);
                                    return true;
                                }
                            }
                        }
                        playerNotValid(sender);
                    }
                    return true;
                } else {
                    getOrSet(sender);
                    return true;
                }
            } else {
                notOp(sender);
                return true;
            }
        }
        return false;
    }
}