package main;

import main.currencyName.Bitcoin;
import main.currencyName.Doge;
import main.currencyName.Ether;
import main.currencyName.ShibaInu;

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
    Bitcoin bitcoin = new Bitcoin("https://ru.investing.com/crypto/shiba-inu", "pid-1057391-last", "Shiba Inu");
    Ether ether = new Ether("https://ru.investing.com/crypto/shiba-inu", "pid-1061443-last", "Shiba Inu");
    ShibaInu shibaInu = new ShibaInu("https://ru.investing.com/crypto/shiba-inu", "pid-1177506-last", "Shiba Inu");
    Doge doge = new Doge("https://ru.investing.com/crypto/shiba-inu", "pid-1061477-last", "Shiba Inu");
    private String botUsername = "crypto_shekel_bot";

    private String botToken = "5200282202:AAFuDqotprQZEjaBE_iLw0FyvpV5svBoILQ";

    @Override
    public String getBotUsername() {
        return botUsername;
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

                case "shiba":
                    try {
                        execute(new SendMessage(chat_Id, shibaInu.getExchangeRate()));
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
        keyboardSecondRow.add("shiba");

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