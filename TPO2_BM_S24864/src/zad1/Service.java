package zad1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Service {
    private String country;
    private String key;
    private String iso;
    private String currency;

    public Service(String country) {
        this.country = country;
        key = "2867373a2d746742247a6ad1755c8376";
        Map<String, String> countries = new HashMap<>();
        for (String iso : Locale.getISOCountries()) {
            Locale l = new Locale("", iso);
            countries.put(l.getDisplayCountry(), iso);
        }
        iso = countries.get(country);

        try {
            currency = Currency.getInstance(new Locale("", iso)).getCurrencyCode();
        } catch (Exception e) {
            System.err.println("Invalid country specified!");
            System.exit(0);
        }
    }

    public double getRateFor(String code) {
        if (currency.equals(code)) {
            return 1.0;
        }
        String urlString = "https://api.exchangeratesapi.io/latest?symbols=" + code + "&base=" + currency;
        JsonObject json = JsonParser.parseString(connect(urlString)).getAsJsonObject();
        double rate = json.getAsJsonObject("rates").get(code).getAsDouble();
        return rate;
    }

    public String getWeather(String city) {
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + iso + "&APPID=" + key + "&units=metric";
        return connect(urlString);
    }

    public double getNBPRate() {
        // This method implementation needs to be more robust in handling HTML parsing or finding a reliable NBP API
        return 1.0;
    }

    private String connect(String urlString) {
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(urlString).openConnection();
            con.setRequestMethod("GET");
            con.connect();
            StringBuffer buffer = new StringBuffer();
            InputStream is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = br.readLine()) != null) {
                buffer.append(line).append("\r\n");
            }

            is.close();
            con.disconnect();
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
