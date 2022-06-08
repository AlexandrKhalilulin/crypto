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
    Bitcoin bitcoin = new Bitcoin("https://www.google.com/search?q=%D0%BA%D1%83%D1%80%D1%81+%D0%B1%D0%B8%D1%82%D0%BA%D0%BE%D0%B8%D0%BD%D0%B0+%D0%B2+%D0%B4%D0%BE%D0%BB%D0%BB%D0%B0%D1%80%D0%B0%D1%85&ei=q8OgYrClOYvsrgTO7IT4BA&oq=%D0%BA%D1%83%D1%80%D1%81+%D0%B1%D0%B8%D1%82%D0%BA%D0%BE%D0%B8%D0%BD%D0%B0+%D0%B2+&gs_lcp=Cgdnd3Mtd2l6EAMYADIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQ6BwgAEEcQsAM6CggAEEcQsAMQyQM6BwgAELADEEM6EgguEMcBENEDEMgDELADEEMYAToSCC4QxwEQowIQyAMQsAMQQxgBOgsIABCABBCxAxCDAUoFCDwSATFKBAhBGABKBAhGGABQVljJA2DXDmgBcAF4AIABZogBoAKSAQMyLjGYAQCgAQHIAQ3AAQHaAQQIARgI&sclient=gws-wiz", "pclqee", "Bitcoin");
    Ether ether = new Ether("https://www.google.com/search?q=%D0%BA%D1%83%D1%80%D1%81+%D1%8D%D1%84%D0%B8%D1%80%D0%B0+%D0%B2+%D0%B4%D0%BE%D0%BB%D0%BB%D0%B0%D1%80%D0%B0%D1%85&ei=VcagYv7XIuXyqwHqhaqgAw&oq=%D0%BA%D1%83%D1%80%D1%81+%27abh%D0%B2+%D0%B4%D0%BE%D0%BB%D0%BB%D0%B0%D1%80%D0%B0%D1%85&gs_lcp=Cgdnd3Mtd2l6EAMYADIECAAQDTIECAAQDTIECAAQDTIECAAQDTIICAAQHhAIEA06BwgAEEcQsAM6CggAEEcQsAMQyQM6BwgAELADEEM6EgguEMcBENEDEMgDELADEEMYAToSCC4QxwEQowIQyAMQsAMQQxgBOgYIABAeEA06CAgAEB4QDxANOggIABAeEA0QBToKCAAQHhAHEAoQKkoFCDwSATJKBAhBGABKBAhGGAFQjgpYgw9ggxpoAnABeACAAYUBiAHpA5IBAzAuNJgBAKABAcgBEcABAdoBBggBEAEYCA&sclient=gws-wiz", "pclqee", "Ethereum");
    ShibaInu shibaInu = new ShibaInu("https://www.google.com/search?q=%D0%BA%D1%83%D1%80%D1%81+%D1%88%D0%B8%D0%B1%D0%B0+%D0%B2+%D0%B4%D0%BE%D0%BB%D0%BB%D0%B0%D1%80%D0%B0%D1%85&ei=rsagYt-qAoPurgTdh5LQCA&ved=0ahUKEwjfufT8m574AhUDt4sKHd2DBIoQ4dUDCA4&uact=5&oq=%D0%BA%D1%83%D1%80%D1%81+%D1%88%D0%B8%D0%B1%D0%B0+%D0%B2+%D0%B4%D0%BE%D0%BB%D0%BB%D0%B0%D1%80%D0%B0%D1%85&gs_lcp=Cgdnd3Mtd2l6EAMyBQgAEIAEOgcIABBHELADOgQIABANOgYIABAeEAc6CAgAEB4QCBAHOgYIABAeEA06CAgAEB4QDxANOgkIABANEEYQggJKBQg8EgE1SgQIQRgASgQIRhgAULkJWOkZYOgbaAVwAXgAgAHZAYgBngmSAQUzLjYuMZgBAKABAcgBCMABAQ&sclient=gws-wiz", "IZ6rdc", "Shiba Inu");
    Doge doge = new Doge("https://www.google.com/search?q=%D0%BA%D1%83%D1%80%D1%81+%D0%B4%D0%BE%D0%B3%D0%B8+%D0%B2+%D0%B4%D0%BE%D0%BB%D0%BB%D0%B0%D1%80%D0%B0%D1%85&ei=bMagYrlCo7KuBMSXkPAL&ved=0ahUKEwi5qLbdm574AhUjmYsKHcQLBL4Q4dUDCA4&uact=5&oq=%D0%BA%D1%83%D1%80%D1%81+%D0%B4%D0%BE%D0%B3%D0%B8+%D0%B2+%D0%B4%D0%BE%D0%BB%D0%BB%D0%B0%D1%80%D0%B0%D1%85&gs_lcp=Cgdnd3Mtd2l6EAMyBQgAEIAEOgcIABBHELADOgcIABCwAxBDOhIILhDHARDRAxDIAxCwAxBDGAE6EgguEMcBEKMCEMgDELADEEMYAToGCAAQHhAHOgQIABANOgYIABAeEA06CAgAEB4QDxANOgkIABANEEYQggI6CAgAEB4QBxAKOggIABAeEAgQB0oGCDwSAjEwSgQIQRgASgQIRhgAULwKWOM8YPk-aApwAXgAgAF4iAH5CZIBAzMuOZgBAKABAcgBDcABAdoBBAgBGAg&sclient=gws-wiz", "pclqee", "Doge");

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