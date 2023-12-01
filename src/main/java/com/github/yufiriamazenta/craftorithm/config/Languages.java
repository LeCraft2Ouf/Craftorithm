package com.github.yufiriamazenta.craftorithm.config;

import crypticlib.config.yaml.YamlConfigHandler;
import crypticlib.config.yaml.entry.StringConfigEntry;

@YamlConfigHandler(path = "lang.yml")
public class Languages {

    public static final StringConfigEntry prefix = new StringConfigEntry("prefix", "&8[&3Craftorithm&8]");
    public static final StringConfigEntry unsupportedVersion = new StringConfigEntry("unsupported_version", "<prefix> 不支持的版本");
    public static final StringConfigEntry newVersion = new StringConfigEntry("new_version", "<prefix> &a检测到有新版本<new_version>, 请及时更新到新版本");
    public static final StringConfigEntry commandNoPerm = new StringConfigEntry("command.no_perm", "<prefix> &c你没有使用此命令的权限");
    public static final StringConfigEntry commandPlayerOnly = new StringConfigEntry("command.player_only", "<prefix> &c只有玩家才能执行此命令");
    public static final StringConfigEntry commandNotEnoughParam = new StringConfigEntry("command.not_enough_param", "<prefix> &c命令缺少参数，缺少<number>个参数");
    public static final StringConfigEntry commandUndefinedSubcmd = new StringConfigEntry("command.undefined_subcmd", "<prefix> &c未定义的子命令");
    public static final StringConfigEntry commandItemSaveSuccess = new StringConfigEntry("command.item.save.success", "<prefix> &a物品保存成功");
    public static final StringConfigEntry commandItemSaveFailedSaveAir = new StringConfigEntry("command.item.save.failed_save_air", "<prefix> &c物品保存失败，原因：不能保存不存在的物品");
    public static final StringConfigEntry commandItemGiveSuccess = new StringConfigEntry("command.item.give.success", "<prefix> &a物品获取成功");
    public static final StringConfigEntry commandItemGiveNotExistItem = new StringConfigEntry("command.item.give.not_exist_item", "<prefix> &c不存在物品 <item_name>");
    public static final StringConfigEntry commandItemGivePlayerOffline = new StringConfigEntry("command.item.give.player_offline", "<prefix> &c该玩家不在线或不存在");
    public static final StringConfigEntry commandReloadSuccess = new StringConfigEntry("command.reload.success", "<prefix> &a插件重载成功");
    public static final StringConfigEntry commandReloadException = new StringConfigEntry("command.reload.exception", "<prefix> &c插件重载过程中发生错误，请查看控制台");
    public static final StringConfigEntry commandRemoveSuccess = new StringConfigEntry("command.remove.success", "<prefix> &a配方删除成功");
    public static final StringConfigEntry commandRemoveNotExist = new StringConfigEntry("command.remove.not_exist", "<prefix> &c配方不存在");
    public static final StringConfigEntry commandDisableSuccess = new StringConfigEntry("command.disable.success", "<prefix> &c禁用配方成功");
    public static final StringConfigEntry commandDisableNotExist = new StringConfigEntry("command.disable.not_exist", "<prefix> &c配方不存在或已经被禁用");
    public static final StringConfigEntry commandDisableFailed = new StringConfigEntry("command.disable.failed", "<prefix> &c配方禁用失败，可能已被禁用或不存在");
    public static final StringConfigEntry commandVersion = new StringConfigEntry("command.version", "<prefix> &a插件版本：<version>");
    public static final StringConfigEntry commandCreateUnsupportedRecipeType = new StringConfigEntry("command.create.unsupported_recipe_type", "<prefix> &c不支持的配方类型");
    public static final StringConfigEntry commandCreateUnsupportedRecipeName = new StringConfigEntry("command.create.unsupported_recipe_name", "<prefix> &c不支持的配方名字，只能使用[a-z0-9/._-]+允许的内容");
    public static final StringConfigEntry commandCreateNameUsed = new StringConfigEntry("command.create.name_used", "<prefix> &c配方ID已经被使用");
    public static final StringConfigEntry commandCreateNullResult = new StringConfigEntry("command.create.null_result", "<prefix> &c配方结果不允许为空！");
    public static final StringConfigEntry commandCreateNullSource = new StringConfigEntry("command.create.null_source", "<prefix> &c配方原料不允许为空！");
    public static final StringConfigEntry commandCreateSuccess = new StringConfigEntry("command.create.success", "<prefix> &a<recipe_type>类型配方<recipe_name>创建成功");
    public static final StringConfigEntry commandRunArcencielSuccess = new StringConfigEntry("command.run_arcenciel.success", "<prefix> &a运行成功，耗时<time>ms");
    public static final StringConfigEntry commandListUnsupportedVersion = new StringConfigEntry("list.unsupported_version", "<prefix> &c此功能只在1.16及以上版本可用");
    public static final StringConfigEntry menuRecipeListTitle = new StringConfigEntry("menu.recipe_list.title", "&3&l配方列表");
    public static final StringConfigEntry menuRecipeListIconFrame = new StringConfigEntry("menu.recipe_list.icon.frame", "&3&l配方列表");
    public static final StringConfigEntry menuRecipeListIconPrevious = new StringConfigEntry("menu.recipe_list.icon.previous", "&a上一页");
    public static final StringConfigEntry menuRecipeListIconNext = new StringConfigEntry("menu.recipe_list.icon.next", "&a下一页");
    public static final StringConfigEntry menuNewRecipeListTitle = new StringConfigEntry("menu.new_recipe_list.title", "&3&lCraftorithm新增配方列表");
    public static final StringConfigEntry menuNewRecipeListIconFrame = new StringConfigEntry("menu.new_recipe_list.icon.frame", "&3&l新增配方列表");
    public static final StringConfigEntry menuNewRecipeListIconPrevious = new StringConfigEntry("menu.new_recipe_list.icon.previous", "&a上一页");
    public static final StringConfigEntry menuNewRecipeListIconNext = new StringConfigEntry("menu.new_recipe_list.icon.next", "&a下一页");
    public static final StringConfigEntry menuRecipeDisplayTitleShaped = new StringConfigEntry("menu.recipe_display.title.shaped", "有序配方");
    public static final StringConfigEntry menuRecipeDisplayTitleShapeless = new StringConfigEntry("menu.recipe_display.title.shapeless", "无序配方");
    public static final StringConfigEntry menuRecipeDisplayTitleFurnace = new StringConfigEntry("menu.recipe_display.title.furnace", "熔炉配方");
    public static final StringConfigEntry menuRecipeDisplayTitleBlasting = new StringConfigEntry("menu.recipe_display.title.blasting", "高炉配方");
    public static final StringConfigEntry menuRecipeDisplayTitleSmoking = new StringConfigEntry("menu.recipe_display.title.smoking", "烟熏炉配方");
    public static final StringConfigEntry menuRecipeDisplayTitleCampfire = new StringConfigEntry("menu.recipe_display.title.campfire", "营火配方");
    public static final StringConfigEntry menuRecipeDisplayTitleSmithing = new StringConfigEntry("menu.recipe_display.title.smithing", "锻造配方");
    public static final StringConfigEntry menuRecipeDisplayTitleStoneCutting = new StringConfigEntry("menu.recipe_display.title.stone_cutting", "切石配方");
    public static final StringConfigEntry menuRecipeDisplayTitlePotion = new StringConfigEntry("menu.recipe_display.title.potion", "酿造配方");
    public static final StringConfigEntry menuRecipeCreatorTitle = new StringConfigEntry("menu.recipe_creator.title", "&3创建<recipe_type>配方: <recipe_name>");
    public static final StringConfigEntry menuRecipeCreatorIconFrame = new StringConfigEntry("menu.recipe_creator.icon.frame", "&a创建配方");
    public static final StringConfigEntry menuRecipeCreatorIconResultFrame = new StringConfigEntry("menu.recipe_creator.icon.result_frame", "&a配方结果");
    public static final StringConfigEntry menuRecipeCreatorIconConfirm = new StringConfigEntry("menu.recipe_creator.icon.confirm", "&3&l确认创建");
    public static final StringConfigEntry menuRecipeCreatorIconCookingFrame = new StringConfigEntry("menu.recipe_creator.icon.cooking_frame", "&a烧炼原料");
    public static final StringConfigEntry menuRecipeCreatorIconSmithingFrame = new StringConfigEntry("menu.recipe_creator.icon.smithing_frame", "&a锻造原料");
    public static final StringConfigEntry menuRecipeCreatorIconPotionFrame = new StringConfigEntry("menu.recipe_creator.icon.potion_frame", "&a酿造原料");
    public static final StringConfigEntry menuRecipeCreatorIconFurnaceToggle = new StringConfigEntry("menu.recipe_creator.icon.furnace_toggle", "&a熔炉配方");
    public static final StringConfigEntry menuRecipeCreatorIconBlastingToggle = new StringConfigEntry("menu.recipe_creator.icon.blasting_toggle", "&a高炉配方");
    public static final StringConfigEntry menuRecipeCreatorIconSmokingToggle = new StringConfigEntry("menu.recipe_creator.icon.smoking_toggle", "&a烟熏炉配方");
    public static final StringConfigEntry menuRecipeCreatorIconCampfireToggle = new StringConfigEntry("menu.recipe_creator.icon.campfire_toggle", "&a营火配方");
    public static final StringConfigEntry arcencielNotEnoughParam = new StringConfigEntry("arcenciel.not_enough_param", "<prefix> &c语句\"<statement>\"不完整");
    public static final StringConfigEntry arcencielUnknownToken = new StringConfigEntry("arcenciel.unknown_token", "<prefix> &c未定义的关键词或函数<token>");
    public static final StringConfigEntry loadFinish = new StringConfigEntry("load.finish", "<prefix> &a插件加载完毕");
    public static final StringConfigEntry loadRecipeLoadException = new StringConfigEntry("load.recipe_load_exception", "<prefix> &c加载配方<recipe_name>时出现错误");
    public static final StringConfigEntry loadItemLoadException = new StringConfigEntry("load.item_load_exception", "<prefix> &c加载物品<item_name>时出现错误");
    public static final StringConfigEntry loadVaultHook = new StringConfigEntry("load.vault_hook", "<prefix> &a发现经济插件,已挂钩");
    public static final StringConfigEntry loadVaultNotExist = new StringConfigEntry("load.vault_not_exist", "<prefix> &c未发现经济插件,金钱检查将不会生效");
    public static final StringConfigEntry loadPointsHook = new StringConfigEntry("load.points_hook", "<prefix> &a发现点券插件,已挂钩");
    public static final StringConfigEntry loadPointsNotExist = new StringConfigEntry("load.points_not_exist", "<prefix> &c未发现点券插件,点券检查将不会生效");
    public static final StringConfigEntry loadItemsAdderHook = new StringConfigEntry("load.items_adder_hook", "<prefix> &a发现ItemsAdder,已挂钩");
    public static final StringConfigEntry loadItemsAdderNotExist = new StringConfigEntry("load.items_adder_not_exist", "<prefix> &c未发现ItemsAdder");
    public static final StringConfigEntry loadOraxenHook = new StringConfigEntry("load.oraxen_hook", "<prefix> &a发现Oraxen,已挂钩");
    public static final StringConfigEntry loadOraxenNotExist = new StringConfigEntry("load.oraxen_not_exist", "<prefix> &c未发现Oraxen");
    public static final StringConfigEntry loadMythicMobsHook = new StringConfigEntry("load.mythic_mobs_hook", "<prefix> &a发现MythicMobs,已挂钩");
    public static final StringConfigEntry loadMythicMobsNotExist = new StringConfigEntry("load.mythic_mobs_exist", "<prefix> &c未发现MythicMobs");

}
