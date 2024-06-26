package com.github.yufiriamazenta.craftorithm.arcenciel.token;

import com.github.yufiriamazenta.craftorithm.arcenciel.obj.ReturnObj;
import com.github.yufiriamazenta.craftorithm.util.PluginHookUtil;
import com.github.yufiriamazenta.craftorithm.util.ScriptValueUtil;
import org.black_ixx.playerpoints.PlayerPointsAPI;
import org.bukkit.entity.Player;

import java.util.List;

public class TokenPoints extends AbstractArcencielToken<Boolean> {

    public static final TokenPoints INSTANCE = new TokenPoints();

    protected TokenPoints() {
        super("points");
    }

    @Override
    public ReturnObj<Boolean> exec(Player player, List<String> args) {
        PlayerPointsAPI api = PluginHookUtil.getPlayerPoints().getAPI();
        boolean result;
        if (args.size() < 2)
            result = api.look(player.getUniqueId()) >= Integer.parseInt(args.get(0));
        else
            result = ScriptValueUtil.compare(api.look(player.getUniqueId()), Integer.parseInt(args.get(1)), args.get(0));
        return new ReturnObj<>(result);
    }

}
