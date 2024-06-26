package com.github.yufiriamazenta.craftorithm.cmd.sub.item;

import com.github.yufiriamazenta.craftorithm.Craftorithm;
import com.github.yufiriamazenta.craftorithm.cmd.sub.AbstractSubCommand;
import com.github.yufiriamazenta.craftorithm.config.Languages;
import com.github.yufiriamazenta.craftorithm.item.impl.CraftorithmItemProvider;
import com.github.yufiriamazenta.craftorithm.util.CollectionsUtil;
import com.github.yufiriamazenta.craftorithm.util.LangUtil;
import crypticlib.CrypticLib;
import crypticlib.platform.IPlatform;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GiveItemCommand extends AbstractSubCommand {

    public static final GiveItemCommand INSTANCE = new GiveItemCommand();

    private GiveItemCommand() {
        super("give", "craftorithm.command.item.give");
    }

    @Override
    public boolean execute(CommandSender sender, List<String> args) {
        if (args.isEmpty()) {
            sendNotEnoughCmdParamMsg(sender, 1);
            return true;
        }

        Player player;
        if (args.size() >= 2) {
            player = Bukkit.getPlayer(args.get(1));
            if (player == null) {
                LangUtil.sendLang(sender, Languages.COMMAND_ITEM_GIVE_PLAYER_OFFLINE);
                return true;
            }
        } else {
            if (checkSenderIsPlayer(sender)) {
                player = (Player) sender;
            } else {
                return true;
            }
        }

        ItemStack itemStack = CraftorithmItemProvider.INSTANCE.getItem(args.get(0));
        if (itemStack == null) {
            LangUtil.sendLang(sender, Languages.COMMAND_ITEM_GIVE_NOT_EXIST_ITEM, CollectionsUtil.newStringHashMap("<item_name>", args.get(0)));
            return true;
        }

        HashMap<Integer, ItemStack> failedItems = player.getInventory().addItem(itemStack);
        if (!failedItems.isEmpty()) {
            if (!CrypticLib.platform().platform().equals(IPlatform.Platform.FOLIA)) {
                for (ItemStack stack : failedItems.values()) {
                    player.getWorld().dropItem(player.getLocation(), stack);
                }
            } else {
                Runnable dropTask = () -> {
                    for (ItemStack stack : failedItems.values()) {
                        player.getWorld().dropItem(player.getLocation(), stack);
                    }
                };
                CrypticLib.platform().scheduler().runTaskOnEntity(Craftorithm.instance(), player, dropTask, dropTask);
            }
        }
        LangUtil.sendLang(sender, Languages.COMMAND_ITEM_GIVE_SUCCESS);
        return true;
    }

    @Override
    public List<String> tab(CommandSender sender, List<String> args) {
        if (args.size() < 2) {
            return new ArrayList<>(CraftorithmItemProvider.INSTANCE.itemMap().keySet());
        }
        else
            return getOnlinePlayerNameList();
    }

    private List<String> getOnlinePlayerNameList() {
        List<String> onlinePlayerNameList = new ArrayList<>();
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayerNameList.add(onlinePlayer.getName());
        }
        return onlinePlayerNameList;
    }

}
