package me.anccalculator;

import me.anccalculator.Commands.Commands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Main {

    public static void main(String[] args) throws Exception {
        JDA jda = JDABuilder.createDefault("token")
                .disableCache(CacheFlag.VOICE_STATE)
                .setActivity(Activity.watching("the money rain"))
                .addEventListeners(new Commands())
                .build();
    }
}
