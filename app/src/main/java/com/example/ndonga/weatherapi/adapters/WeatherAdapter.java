package com.example.ndonga.weatherapi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ndonga.weatherapi.R;
import com.example.ndonga.weatherapi.models.Weather;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    private List<Weather> mLocationWeather = new ArrayList<>();
    private Context mContext;

    public WeatherAdapter(Context context, List<Weather> locationWeather) {
        mContext = context;
        mLocationWeather = locationWeather;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_list_item, parent, false);
        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        holder.bindWeather(mLocationWeather.get(position));
    }



    @Override
    public int getItemCount() {
        return mLocationWeather.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.temperatureTextView)
        TextView mTemperatureTextView;
        @BindView(R.id.conditionTextView)
        TextView mConditionTextView;
        @BindView(R.id.locationTextView)
        TextView mLocationTextView;
        @BindView(R.id.iconsImageView)
        ImageView mIconsImageView;

        private Context mContext;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindWeather(Weather locationWeather) {
            mTemperatureTextView.setText(locationWeather.getName());
            mConditionTextView.setText(locationWeather.getId());
            mLocationTextView.setText(locationWeather.getWeather().get(0));
//            Picasso.with(mContext).load(locationWeather.getWeather().getIcon()).into(mIconsImageView);
        }
    }
}
