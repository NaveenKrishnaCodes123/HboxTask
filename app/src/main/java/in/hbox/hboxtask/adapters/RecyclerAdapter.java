package in.hbox.hboxtask.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import in.hbox.hboxtask.R;
import in.hbox.hboxtask.models.CountryAndCapital;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CountryAndCapital> mCountryAndCapitals = new ArrayList<>();
    private Context mContext;
    private final countryDataList countryData;

    public RecyclerAdapter(Context context, List<CountryAndCapital> countryAndCapitals, countryDataList countryDataList) {
        mCountryAndCapitals = countryAndCapitals;
        mContext = context;
        countryData = countryDataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        // Set the name of the 'Country Name'
        ((ViewHolder) viewHolder).mName.setText(mCountryAndCapitals.get(i).getCountry());

        // Set the image
        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.country);
        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(mCountryAndCapitals.get(i).getImageUrl())
                .into(((ViewHolder) viewHolder).mImage);
        ((ViewHolder) viewHolder).parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryData.countryDataList(mCountryAndCapitals.get(i).getCountry(),mCountryAndCapitals.get(i).getCapital(),mCountryAndCapitals.get(i).getCurrency());
            }
        });

    }


    @Override
    public int getItemCount() {
        return mCountryAndCapitals.size();
    }

    public interface countryDataList {

        void countryDataList(String country, String capital, String currency);
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView mImage;
        private TextView mName;
        private RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
