package com.example.mainactivity.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainactivity.Model.Forecast;
import com.example.mainactivity.R;
import com.example.mainactivity.ViewModel.Log_ViewModel;

import java.util.ArrayList;
import java.util.List;

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.ViewHolder> {
    /**
     * @author Mathias Hansen
     * @author Jakob Hansen
     *
     */


    private List<Forecast> forecasts = new ArrayList<>();

    /**
     *
     * @param parent Get the parent fragment to be inflated
     * @param viewType bind the XML file to the view
     * @return
     */

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.loglistitem, parent, false);
        return new ViewHolder(view);

    }

    /**
     * Method onBindViewHolder bind the layout to recyclerView
     * @param holder bind the layout to the holder
     * @param position get the position of the forecast list.
     */

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.tl8.setText(forecasts.get(position).getTemp_8()+"");
        holder.tl12.setText(forecasts.get(position).getTemp_12()+"");
        holder.tl16.setText(forecasts.get(position).getTemp_16()+"");
        holder.tl20.setText(forecasts.get(position).getTemp_20()+"");


        holder.cl8.setText(forecasts.get(position).getCo2_8()+"");
        holder.cl12.setText(forecasts.get(position).getCo2_12()+"");
        holder.cl16.setText(forecasts.get(position).getCo2_16()+"");
        holder.cl20.setText(forecasts.get(position).getCo2_20()+"");

        holder.hl8.setText(forecasts.get(position).getHumidity_8()+"");
        holder.hl12.setText(forecasts.get(position).getHumidity_12()+"");
        holder.hl16.setText(forecasts.get(position).getHumidity_16()+"");
        holder.hl20.setText(forecasts.get(position).getHumidity_20()+"");

        holder.pl8.setText(forecasts.get(position).getNumberOfPassengers_8()+"");
        holder.pl12.setText(forecasts.get(position).getNumberOfPassengers_12()+"");
        holder.pl16.setText(forecasts.get(position).getNumberOfPassengers_16()+"");
        holder.pl20.setText(forecasts.get(position).getNumberOfPassengers_20()+"");


    }

    /**
     *
     * @return returns the size of forecast list
     */

    @Override
    public int getItemCount() {
        return forecasts.size();
    }

    /**
     *
     * @param forecasts set the forecast list to the LiveData
     */

    public void setForecasts(List<Forecast>forecasts){
        this.forecasts = forecasts;
        notifyDataSetChanged();
    }

    /**
     *  ViewHolder class to for binding layout to xml file
     */

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tl8;
        TextView tl12;
        TextView tl16;
        TextView tl20;

        TextView cl8;
        TextView cl12;
        TextView cl16;
        TextView cl20;

        TextView hl8;
        TextView hl12;
        TextView hl16;
        TextView hl20;

        TextView pl8;
        TextView pl12;
        TextView pl16;
        TextView pl20;





        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            tl8 = itemView.findViewById(R.id.tl8);
            tl12 = itemView.findViewById(R.id.tl12);
            tl16 = itemView.findViewById(R.id.tl16);
            tl20 = itemView.findViewById(R.id.tl20);

            cl8 = itemView.findViewById(R.id.cl8);
            cl12 = itemView.findViewById(R.id.cl12);
            cl16 = itemView.findViewById(R.id.cl16);
            cl20 = itemView.findViewById(R.id.cl20);

            hl8 = itemView.findViewById(R.id.hl8);
            hl12 = itemView.findViewById(R.id.hl12);
            hl16 = itemView.findViewById(R.id.hl16);
            hl20 = itemView.findViewById(R.id.hl20);

            pl8 = itemView.findViewById(R.id.pl8);
            pl12 = itemView.findViewById(R.id.pl12);
            pl16 = itemView.findViewById(R.id.pl16);
            pl20 = itemView.findViewById(R.id.pl20);




        }


    }


}
