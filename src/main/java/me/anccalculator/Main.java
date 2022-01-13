package me.anccalculator;

import me.anccalculator.Commands.Commands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        String token = null;

        try {
            File file = new File("token.txt");
            Scanner scanner = new Scanner(file);
            token = scanner.nextLine();
            scanner.close();
        } catch (FileNotFoundException e) {
            FileWriter writer = new FileWriter("token.txt");
            writer.write("[add bot token here] (then restart the bot and remove all text except for bot token)");
            writer.close();
        }

        JDA jda = JDABuilder.createDefault(token)
                .disableCache(CacheFlag.VOICE_STATE)
                .setActivity(Activity.watching("the money rain"))
                .addEventListeners(new Commands())
                .build();
    }
}
