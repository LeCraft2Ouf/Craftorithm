package com.github.yufiriamazenta.craftorithm.cmd.sub;

import com.github.yufiriamazenta.craftorithm.config.Languages;
import com.github.yufiriamazenta.craftorithm.util.CollectionsUtil;
import com.github.yufiriamazenta.craftorithm.util.LangUtil;
import crypticlib.command.SubcommandHandler;
import crypticlib.perm.PermInfo;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public abstract class AbstractSubCommand extends SubcommandHandler {

    protected AbstractSubCommand(String command, PermInfo permInfo) {
        super(command, permInfo);
    }

    protected AbstractSubCommand(String command, String permission) {
        this(command, new PermInfo(permission));
    }

    protected AbstractSubCommand(String command) {
        super(command);
    }

    @Override
    public boolean execute(CommandSender sender, List<String> args) {
        if (args.isEmpty()) {
            sendNotEnoughCmdParamMsg(sender, 1);
            return true;
        }
        SubcommandHandler subCommand = subcommands().get(args.get(0));
        if (subCommand == null) {
            LangUtil.sendLang(sender, Languages.COMMAND_UNDEFINED_SUBCMD);
        } else {
            PermInfo perm = subCommand.permission();
            if (perm != null) {
                if (!sender.hasPermission(perm.permission())) {
                    LangUtil.sendLang(sender, Languages.COMMAND_NO_PERM);
                    return true;
                }
            }
            subCommand.onCommand(sender, args.subList(1, args.size()));
        }
        return true;
    }

    public void sendNotEnoughCmdParamMsg(CommandSender sender, int paramNum) {
        sendNotEnoughCmdParamMsg(sender, String.valueOf(paramNum));
    }

    public void sendNotEnoughCmdParamMsg(CommandSender sender, String paramStr) {
        LangUtil.sendLang(sender, Languages.COMMAND_NOT_ENOUGH_PARAM, CollectionsUtil.newStringHashMap("<number>", paramStr));
    }

    public boolean checkSenderIsPlayer(CommandSender sender) {
        if (sender instanceof Player) {
            return true;
        } else {
            LangUtil.sendLang(sender, Languages.COMMAND_PLAYER_ONLY);
            return false;
        }
    }

    public void filterTabList(List<String> tabList, String input) {
        tabList.removeIf(str -> !str.contains(input));
    }

}
