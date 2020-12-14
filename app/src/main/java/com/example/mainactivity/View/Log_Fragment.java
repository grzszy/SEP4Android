package com.example.mainactivity.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainactivity.Model.LogAdapter;
import com.example.mainactivity.R;

import java.util.List;


public class Log_Fragment extends Fragment {

    EditText editText;
    RecyclerView recyclerView;
    LogAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.log_fragment,container,false);

        editText = v.findViewById(R.id.dateedit);
        recyclerView = v.findViewById(R.id.logRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.hasFixedSize();
        adapter = new LogAdapter();


        recyclerView.setAdapter(adapter);

        return v;
    }
}
