package com.github.holodar.jrtb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import com.github.holodar.jrtb.bot.JavaRushTelegramBot;
import static org.springframework.util.CollectionUtils.isEmpty;

import java.util.List;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService{
    private final JavaRushTelegramBot javarushBot;

    @Autowired
    public SendBotMessageServiceImpl(JavaRushTelegramBot javarushBot){
        this.javarushBot = javarushBot;
    }

    @Override
    public void sendMessage(Long chatId,String message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            javarushBot.execute(sendMessage);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
    @Override
    public void sendMessage(Long chatId, List<String> messages) {
        if (isEmpty(messages)) return;

        messages.forEach(m -> sendMessage(chatId, m));
    }
}
