package com.example.unlimitedvillagertrades;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnlimitedVillagerTrades implements ModInitializer {
    public static final String MOD_ID = "unlimitedvillagertrades";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Unlimited Villager Trades mod initialized!");
        LOGGER.info("All villager trades will now have unlimited uses thanks to mixins.");
        LOGGER.info("No more restocking needed - trade as much as you want!");
    }
}