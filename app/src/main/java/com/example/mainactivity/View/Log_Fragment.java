package com.example.mainactivity.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mainactivity.Adapter.LogAdapter;
import com.example.mainactivity.Model.Forecast;
import com.example.mainactivity.R;
import com.example.mainactivity.ViewModel.Log_ViewModel;

import java.util.List;


public class Log_Fragment extends Fragment {

    /**
     * @author Mathias Hansen
     * @author Jakob Hansen
     */


    RecyclerView recyclerView;
    LogAdapter adapter;
    Log_ViewModel log_viewModel;
    /**
     * onCreateView inflate the fragment xml file
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return return the view
     */

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.log_fragment, container, false);
        log_viewModel = new ViewModelProvider(this).get(Log_ViewModel.class);

        recyclerView = v.findViewById(R.id.logRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.hasFixedSize();
        adapter = new LogAdapter();
        log_viewModel.updateLog();
        recyclerView.setAdapter(adapter);




        log_viewModel.getLog().observe(getActivity(), new Observer<List<Forecast>>() {
            @Override
            public void onChanged(List<Forecast> forecasts) {
                adapter.setForecasts(forecasts);
                System.out.println("HELLO FROM LOG FRAGMENT");
            }
        });

        return v;
    }
}
