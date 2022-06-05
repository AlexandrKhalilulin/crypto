package main.currencyName;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Doge extends Currency {
    private Document document;


    public Doge(String path, String className, String currencyName) {
        super(path, className, currencyName);
        connect();
    }

    public void connect() {
        try {
            document = Jsoup.connect(path).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getExchangeRate() {
        Elements elements1 = document.getElementsByClass(className);
        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        return elements1.text() + " руб. - курс " + currencyName + " на: " + timeStamp;
    }
}

