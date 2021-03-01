package in.hbox.hboxtask.models;

public class CountryAndCapital {

    private String country;
    private String capital;
    private String currency;
    private String imageUrl;


    public CountryAndCapital(String country, String capital, String currency, String imageUrl) {
        this.country = country;
        this.capital = capital;
        this.currency = currency;
        this.imageUrl = imageUrl;
    }


    public CountryAndCapital() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String title) {
        this.country = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
