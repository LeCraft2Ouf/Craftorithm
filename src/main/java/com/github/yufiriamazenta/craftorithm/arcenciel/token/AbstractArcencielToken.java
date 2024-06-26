package com.github.yufiriamazenta.craftorithm.arcenciel.token;

import com.github.yufiriamazenta.craftorithm.arcenciel.obj.ReturnObj;
import org.bukkit.entity.Player;

import java.util.List;

public abstract class AbstractArcencielToken<T> implements IArcencielToken<T> {

    private String tokenStr;

    protected AbstractArcencielToken(String tokenStr) {
        this.tokenStr = tokenStr;
    }


    @Override
    public abstract ReturnObj<T> exec(Player player, List<String> args);

    public void setTokenStr(String tokenStr) {
        this.tokenStr = tokenStr;
    }

    @Override
    public String tokenStr() {
        return tokenStr;
    }

}
