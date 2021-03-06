package me.fullpotato.badlandscaves.Commands;

import me.fullpotato.badlandscaves.BadlandsCaves;
import me.fullpotato.badlandscaves.Util.PlayerScore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class PowersCommand extends Commands implements CommandExecutor {
    private final BadlandsCaves plugin;
    public PowersCommand (BadlandsCaves bcav) {
        plugin = bcav;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args) {
        if (command.getName().equalsIgnoreCase("powers")) {
            if (sender.isOp()) {

                HashMap<String,PlayerScore> powers = new HashMap<>();
                powers.put("supernatural", PlayerScore.HAS_SUPERNATURAL_POWERS);
                powers.put("displace", PlayerScore.DISPLACE_LEVEL);
                powers.put("enhanced_eyes", PlayerScore.EYES_LEVEL);
                powers.put("withdraw", PlayerScore.WITHDRAW_LEVEL);
                powers.put("possession", PlayerScore.POSSESS_LEVEL);
                powers.put("endurance", PlayerScore.ENDURANCE_LEVEL);
                powers.put("agility", PlayerScore.AGILITY_LEVEL);

                HashMap<String, Integer> powers_max_levels = new HashMap<>();
                powers_max_levels.put("displace", 2);
                powers_max_levels.put("enhanced_eyes", 2);
                powers_max_levels.put("withdraw", 2);
                powers_max_levels.put("possession", 2);
                powers_max_levels.put("endurance", 2);
                powers_max_levels.put("agility", 2);

                if (args.length == 0) {
                    tooFewArgs(sender);
                    return true;
                }
                else if (args[0].equalsIgnoreCase("get")) {
                    if (args.length < 2) {
                        tooFewArgs(sender);
                    }
                    else {
                        for (Player target : plugin.getServer().getOnlinePlayers()) {
                            if (args[1].equalsIgnoreCase(target.getDisplayName()) || args[1].equalsIgnoreCase(target.getName()) || args[1].equalsIgnoreCase(target.getUniqueId().toString())) {
                                if (args.length < 3) {
                                    sender.sendMessage(ChatColor.GOLD + "Player " + ChatColor.RED + target.getDisplayName() + ChatColor.GOLD + " has the following values:");
                                    for (String str : powers.keySet()) {
                                        if (str.equals("supernatural")) {
                                            sender.sendMessage(ChatColor.GOLD + "The value of " + ChatColor.RED + str + ChatColor.GOLD + " is " + ChatColor.RED + ((byte) powers.get(str).getScore(plugin, target) == 1) + ChatColor.GOLD + ".");
                                        }
                                        else {
                                            sender.sendMessage(ChatColor.GOLD + "The value of " + ChatColor.RED + str + ChatColor.GOLD + " is " + ChatColor.RED + powers.get(str).getScore(plugin, target) + ChatColor.GOLD + ".");
                                        }
                                    }
                                }
                                else if (powers.containsKey(args[2])) {
                                    if (args[2].equals("supernatural")) {
                                        sender.sendMessage(ChatColor.GOLD + "The value of " + ChatColor.RED + args[2] + ChatColor.GOLD + " for Player " + ChatColor.RED + target.getDisplayName() + ChatColor.GOLD + " is " + ChatColor.RED + ((byte) powers.get(args[2]).getScore(plugin, target) == 1) + ChatColor.GOLD + ".");
                                    }
                                    else {
                                        sender.sendMessage(ChatColor.GOLD + "The value of " + ChatColor.RED + args[2] + ChatColor.GOLD + " for Player " + ChatColor.RED + target.getDisplayName() + ChatColor.GOLD + " is " + ChatColor.RED.toString() + powers.get(args[2]).getScore(plugin, target) + ChatColor.GOLD.toString() + ".");
                                    }
                                }
                                else {
                                    valueNotValid(sender);
                                }
                                return true;
                            }
                        }
                        playerNotValid(sender);
                    }
                    return true;
                }
                else if (args[0].equalsIgnoreCase("set")) {
                    if (args.length < 2) {
                        tooFewArgs(sender);
                    }
                    else {
                        for (Player target : plugin.getServer().getOnlinePlayers()) {
                            if (args[1].equalsIgnoreCase(target.getDisplayName()) || args[1].equalsIgnoreCase(target.getName()) || args[1].equalsIgnoreCase(target.getUniqueId().toString())) {
                                if (args.length < 3) {
                                    tooFewArgs(sender);
                                    return true;
                                }
                                else if (powers.containsKey(args[2])) {
                                    if (args.length < 4) {
                                        if (args[2].equals("supernatural")) {
                                            sender.sendMessage(ChatColor.RED + "Too few arguments. Possible values are TRUE or FALSE.");
                                        }
                                        else {
                                            sender.sendMessage(ChatColor.RED + "Too few arguments. You need to specify a level to set. The max level of " + args[2] + " is " + powers_max_levels.get(args[2]) + ".");
                                        }
                                    }
                                    else {
                                        if (args[2].equals("supernatural")) {
                                            if (args[3].equalsIgnoreCase("true") || args[3].equalsIgnoreCase("false")) {
                                                boolean input_value;
                                                input_value = Boolean.parseBoolean(args[3]);

                                                PlayerScore.HAS_SUPERNATURAL_POWERS.setScore(plugin, target, input_value ? 1 : 0);
                                                sender.sendMessage(ChatColor.GOLD + "The value of " + ChatColor.RED + args[2] + ChatColor.GOLD + " for Player " + ChatColor.RED + target.getDisplayName() + ChatColor.GOLD + " has been set to " + ChatColor.RED + input_value + ChatColor.GOLD + ".");
                                            }
                                            else {
                                                sender.sendMessage(ChatColor.RED + "Possible Parameters: TRUE or FALSE.");
                                                return true;
                                            }
                                        }
                                        else {
                                            int input_value;
                                            try {
                                                input_value = Integer.parseInt(args[3]);
                                            }
                                            catch (NumberFormatException exception) {
                                                sender.sendMessage(ChatColor.RED + "Please enter a valid integer.");
                                                return true;
                                            }

                                            if (input_value >= 0 && input_value <= powers_max_levels.get(args[2])) {
                                                powers.get(args[2]).setScore(plugin, target, input_value);
                                                sender.sendMessage(ChatColor.GOLD + "The value of " + ChatColor.RED + args[2] + ChatColor.GOLD + " for Player " + ChatColor.RED + target.getDisplayName() + ChatColor.GOLD + " has been set to " + ChatColor.RED + input_value + ChatColor.GOLD + ".");
                                                return true;
                                            }
                                            else {
                                                sender.sendMessage(ChatColor.RED + "Please make sure the level stays within bounds. The max level of " + args[2] + " is " + powers_max_levels.get(args[2]) + ".");
                                            }
                                        }
                                    }
                                    return true;
                                }
                                else {
                                    valueNotValid(sender);
                                    return true;
                                }
                            }
                        }
                        playerNotValid(sender);
                    }
                    return true;
                }
                else {
                    getOrSet(sender);
                    return true;
                }
            }
            else {
                notOp(sender);
                return true;
            }
        }
        return false;
    }
}
