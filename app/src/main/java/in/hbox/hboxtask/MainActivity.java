package in.hbox.hboxtask;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import in.hbox.hboxtask.adapters.RecyclerAdapter;
import in.hbox.hboxtask.viewmodels.MainActivityViewModel;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.countryDataList {

    private RecyclerView mRecyclerView;
    private MainActivityViewModel mMainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);

        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mMainActivityViewModel.init();


        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerAdapter mAdapter = new RecyclerAdapter(this, mMainActivityViewModel.getNicePlaces().getValue(), MainActivity.this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }



    @Override
    public void countryDataList(String country, String capital, String currency) {
        Intent intent = new Intent(getApplicationContext(), CountryDetails.class);
        intent.putExtra("country", country);
        intent.putExtra("capital", capital);
        intent.putExtra("currency", currency);
        startActivity(intent);
    }
}




















