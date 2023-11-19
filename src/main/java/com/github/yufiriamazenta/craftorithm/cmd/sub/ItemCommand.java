package com.github.yufiriamazenta.craftorithm.cmd.sub;

import com.github.yufiriamazenta.craftorithm.cmd.sub.item.ItemGiveCommand;
import com.github.yufiriamazenta.craftorithm.cmd.sub.item.ItemSaveCommand;
import crypticlib.command.api.ISubcmdExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public final class ItemCommand extends AbstractSubCommand {

    public static final ISubcmdExecutor INSTANCE = new ItemCommand();

    private ItemCommand() {
        super("item", "craftorithm.command.item");
        regSub(ItemSaveCommand.INSTANCE).regSub(ItemGiveCommand.INSTANCE);
    }

    @Override
    public boolean onCommand(CommandSender sender, List<String> args) {
        if (args.size() < 2) {
            sendNotEnoughCmdParamMsg(sender, 2 - args.size());
            return true;
        }
        return super.onCommand(sender, args);
    }
}