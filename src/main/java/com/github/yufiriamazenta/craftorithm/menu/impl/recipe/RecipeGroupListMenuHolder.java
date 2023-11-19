package com.github.yufiriamazenta.craftorithm.menu.impl.recipe;

import com.github.yufiriamazenta.craftorithm.menu.bukkit.BukkitMenuHandler;
import com.github.yufiriamazenta.craftorithm.menu.bukkit.ItemDisplayIcon;
import com.github.yufiriamazenta.craftorithm.recipe.RecipeManager;
import com.github.yufiriamazenta.craftorithm.util.LangUtil;
import crypticlib.util.TextUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeGroupListMenuHolder extends BukkitMenuHandler {

    private int page;
    private final int maxPage;
    private final List<Map.Entry<String, ItemStack>> recipeGroupResultList;

    public RecipeGroupListMenuHolder() {
        super();
        Map<String, ItemStack> recipeResultMap = new HashMap<>();
        RecipeManager.getRecipeGroupMap().forEach((recipeName, recipeKeys) -> {
            if (recipeKeys == null || recipeKeys.isEmpty())
                return;
            Recipe firstRecipe = Bukkit.getRecipe(recipeKeys.get(0));
            if (firstRecipe == null)
                return;
            recipeResultMap.put(recipeName, firstRecipe.getResult());
        });
        RecipeManager.getPotionMixGroupMap().forEach((recipeName, recipes) -> {
            if (recipes == null || recipes.isEmpty())
                return;
            recipeResultMap.put(recipeName, recipes.get(0).getResult());
        });
        recipeGroupResultList = new ArrayList<>(recipeResultMap.entrySet());
        page = 0;
        int recipeGroupNum = recipeResultMap.size();
        if (recipeGroupNum % 45 == 0) {
            maxPage = recipeGroupNum / 45;
        } else {
            maxPage = recipeGroupNum / 45 + 1;
        }
        recipeGroupResultList.sort((o1, o2) -> {
            int sortId = RecipeManager.getCraftorithmRecipeSortId(o1.getKey());
            int sortId2 = RecipeManager.getCraftorithmRecipeSortId(o2.getKey());
            return Integer.compare(sortId, sortId2);
        });
    }

    @NotNull
    @Override
    public Inventory getInventory() {
        resetIcons();
        Inventory inventory = Bukkit.createInventory(this, 54, TextUtil.color(LangUtil.langMsg("menu.new_recipe_list.title")));
        for (Integer slot : getMenuIconMap().keySet()) {
            inventory.setItem(slot, getMenuIconMap().get(slot).getDisplay());
        }
        return inventory;
    }

    public Inventory getNextPage() {
        return setPage(Math.min(page + 1, maxPage - 1)).getInventory();
    }

    public Inventory getPreviousPage() {
        return setPage(Math.max(page - 1, 0)).getInventory();
    }

    private void resetIcons() {
        getMenuIconMap().clear();
        int []frameSlots = {45, 47, 48, 49, 50, 51, 53};
        ItemDisplayIcon frameIcon = ItemDisplayIcon.icon(Material.BLACK_STAINED_GLASS_PANE, LangUtil.langMsg("menu.new_recipe_list.icon.frame"));
        for (int frameSlot : frameSlots) {
            getMenuIconMap().put(frameSlot, frameIcon);
        }
        ItemStack previousDisplay = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta previousMeta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.PLAYER_HEAD);
        previousMeta.setOwner("MHF_ArrowLeft");
        previousMeta.setDisplayName(TextUtil.color(LangUtil.langMsg("menu.new_recipe_list.icon.previous")));
        previousDisplay.setItemMeta(previousMeta);
        getMenuIconMap().put(46, ItemDisplayIcon.icon(previousDisplay, (event -> {
            event.setCancelled(true);
            event.getWhoClicked().openInventory(getPreviousPage());
        })));
        ItemStack nextDisplay = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta nextMeta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.PLAYER_HEAD);
        nextMeta.setOwner("MHF_ArrowRight");
        nextMeta.setDisplayName(TextUtil.color(LangUtil.langMsg("menu.new_recipe_list.icon.next")));
        nextDisplay.setItemMeta(nextMeta);
        getMenuIconMap().put(52, ItemDisplayIcon.icon(nextDisplay, (event -> {
            event.setCancelled(true);
            event.getWhoClicked().openInventory(getNextPage());
        })));
        int recipeSlot = page * 45;
        for (int invSlot = 0; invSlot < 45 && recipeSlot < recipeGroupResultList.size(); invSlot++, recipeSlot++) {
            getMenuIconMap().put(invSlot, wrapIcon(recipeSlot));
        }
    }

    @NotNull
    private ItemDisplayIcon wrapIcon(int recipeSlot) {
        ItemStack display = recipeGroupResultList.get(recipeSlot).getValue();
        String recipeGroupName = recipeGroupResultList.get(recipeSlot).getKey();
        if (RecipeManager.getRecipeGroupMap().containsKey(recipeGroupName)) {
            return ItemDisplayIcon.icon(display, event -> {
                event.setCancelled(true);
                event.getWhoClicked().openInventory(
                    new RecipeListMenuHolder(
                        (Player) event.getWhoClicked(),
                        RecipeManager.getRecipeGroupMap().get(recipeGroupName),
                        this
                    ).getInventory()
                );
            });
        } else {
            return ItemDisplayIcon.icon(display, event -> {
                event.setCancelled(true);
                event.getWhoClicked().openInventory(
                    new RecipeListMenuHolder(
                        (Player) event.getWhoClicked(),
                        RecipeManager.getPotionMixGroupMap(),
                        recipeGroupName,
                        this
                    ).getInventory()
                );
            });
        }
    }

    public int page() {
        return page;
    }

    public RecipeGroupListMenuHolder setPage(int page) {
        this.page = page;
        return this;
    }

}