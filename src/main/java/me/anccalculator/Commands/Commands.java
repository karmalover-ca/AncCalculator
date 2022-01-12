package me.anccalculator.Commands;

import me.anccalculator.Functions.EmeraldConverter;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equals("c!ping")) {
            MessageChannel channel = event.getChannel();
            long time = System.currentTimeMillis();
            channel.sendMessage("Pong!")
                    .queue(response -> {
                            response.editMessageFormat("Pong: %d ms", System.currentTimeMillis() - time).queue();
                    });
        } else if (args[0].equals("c!cashout")) {
            if (args.length == 1) {
                event.getChannel().sendMessage("Usage: `c!cashout [chips] [calculateFees(optional)]").queue();
            } else if (args.length == 2) {
                event.getChannel().sendMessage("**Cash Out Total**\n" + EmeraldConverter.calculate(Double.parseDouble(args[1]), true)).queue();
            } else if (args.length == 3 ) {
                event.getChannel().sendMessage("**Cash Out Total**\n" + EmeraldConverter.calculate(Double.parseDouble(args[1]), Boolean.parseBoolean(args[2]))).queue();
            }
        } else if (args[0].equals("c!help")) {
            event.getChannel().sendMessage(
                    "**Commands** ^-^\n```" +
                    "c!cashout [chips] [calculateFees(optional)]\n" +
                    "c!ping```").queue();
        }
    }
}
