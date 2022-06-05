package main.currencyName;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Currency {
    private Document document;
    public final String path;
    public final String className;
    public final String currencyName;

    public Currency(String path, String className, String currencyName) {
        this.path = path;
        this.className = className;
        this.currencyName = currencyName;
        connect();
    }

    private void connect() {
        try {
            document = Jsoup.connect(path).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getExchangeRate() {
        Elements elements1 = document.getElementsByClass(className);
        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        return elements1.text() + " руб. - курс " + currencyName + " на: " + timeStamp;
    }

}
