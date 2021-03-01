package in.hbox.hboxtask.viewmodels;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import in.hbox.hboxtask.models.CountryAndCapital;
import in.hbox.hboxtask.repositories.CountryAndCapitalRepository;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<CountryAndCapital>> mNicePlaces;
    private CountryAndCapitalRepository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(){
        if(mNicePlaces != null){
            return;
        }
        mRepo = CountryAndCapitalRepository.getInstance();
        mNicePlaces = mRepo.getNicePlaces();
    }

    public LiveData<List<CountryAndCapital>> getNicePlaces(){
        return mNicePlaces;
    }

}
