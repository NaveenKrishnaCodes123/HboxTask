package in.hbox.hboxtask.repositories;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import in.hbox.hboxtask.models.CountryAndCapital;


/**
 * Singleton pattern
 */
public class CountryAndCapitalRepository {

    private static CountryAndCapitalRepository instance;
    private ArrayList<CountryAndCapital> dataSet = new ArrayList<>();

    public static CountryAndCapitalRepository getInstance() {
        if (instance == null) {
            instance = new CountryAndCapitalRepository();
        }
        return instance;
    }


    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<CountryAndCapital>> getNicePlaces() {
        setNicePlaces();
        MutableLiveData<List<CountryAndCapital>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setNicePlaces() {
        dataSet.add(new CountryAndCapital("Afghanistan ", "kabul", "Afghani", "")
        );
        dataSet.add(new CountryAndCapital("Australia", "Canberra", "Australian Dollar", ""));
        dataSet.add(
                new CountryAndCapital("Bahrain",
                        "manama", "Bahrani Dinar", "")
        );
        dataSet.add(
                new CountryAndCapital("Bangladesh",
                        "Dhaka", " Taka", "")
        );
        dataSet.add(
                new CountryAndCapital("Belgium",
                        "Brusseis", "Euro", "")
        );
        dataSet.add(
                new CountryAndCapital("China",
                        "Beijing", "Chinese Yuan", "")
        );
        dataSet.add(
                new CountryAndCapital("Greece",
                        "Athens", "Euro", "")
        );
        dataSet.add(
                new CountryAndCapital("India",
                        "New Delhi", "Indian Rupee", "")
        );

        dataSet.add(
                new CountryAndCapital("Japan",
                        "Tokyo", "Yen", "")
        );
        dataSet.add(
                new CountryAndCapital("United States of America",
                        "Washington Dc", "United States Dollar", "")
        );
    }
}











