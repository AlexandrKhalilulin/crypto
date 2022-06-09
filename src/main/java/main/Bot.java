package main;

import main.currencyName.Bitcoin;
import main.currencyName.Doge;
import main.currencyName.Ether;
import main.currencyName.ETC;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    Bitcoin bitcoin = new Bitcoin("https://myfin.by/crypto-rates/bitcoin", "col-md-6 col-xs-12", "Bitcoin");
    Ether ether = new Ether("https://myfin.by/crypto-rates/ethereum", "col-md-6 col-xs-12", "Ethereum");
    ETC etc = new ETC("https://myfin.by/crypto-rates/ethereumclassic", "col-md-6 col-xs-12", "Ethereum Classic");
    Doge doge = new Doge("https://myfin.by/crypto-rates/dogecoin", "col-md-6 col-xs-12", "Doge");

    private String botName = "crypto_shekel_bot";
    private String botToken = "5200282202:AAFuDqotprQZEjaBE_iLw0FyvpV5svBoILQ";

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            long chat_Id = update.getMessage().getChatId();
            sendMsg(message, message.getText());

            switch (message.getText()) {
                case "bitcoin":
                    try {
                        execute(new SendMessage(chat_Id, bitcoin.getExchangeRate()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case "ethereum":
                    try {
                        execute(new SendMessage(chat_Id, ether.getExchangeRate()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;

                case "doge":
                    try {
                        execute(new SendMessage(chat_Id, doge.getExchangeRate()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;

                case "etc":
                    try {
                        execute(new SendMessage(chat_Id, etc.getExchangeRate()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    public void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add("ethereum");
        keyboardFirstRow.add("bitcoin");

        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add("doge");
        keyboardSecondRow.add("etc");

        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);

        replyKeyboardMarkup.setKeyboard(keyboard);

        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}