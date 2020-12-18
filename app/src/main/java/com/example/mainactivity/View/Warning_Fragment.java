package com.example.mainactivity.View;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mainactivity.R;

public class Warning_Fragment extends Fragment {

    /**
     * @author Jakob Hansen
     */

    EditText editTextTemp;
    EditText editTextCo2;
    EditText editTextHum;
    EditText editTextPeople;
    EditText editTextTime;

    Button buttonWarning;
    Button buttonTime;
    int finalValuePeople;
    int finalValueHum;
    int finalValueCo2;
    int finalValueTemp;


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
        View v = inflater.inflate(R.layout.warning_fragment,container,false);

        editTextTemp = v.findViewById(R.id.editTextNumber);
        editTextCo2 = v.findViewById(R.id.editTextNumber2);
        editTextHum = v.findViewById(R.id.editTextNumber4);
        editTextPeople = v.findViewById(R.id.editTextNumber5);
        editTextTime = v.findViewById(R.id.editTextTime);

        buttonWarning = v.findViewById(R.id.buttonAcceptWarning);
        buttonTime = v.findViewById(R.id.buttonAcceptTime);


        SharedPreferences preferences1 = this.getActivity().getSharedPreferences("temp", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor1 = preferences1.edit();


        String valueTemp= editTextTemp.getText().toString();
       try {
           finalValueTemp=Integer.parseInt(valueTemp);
       }catch (Exception e){
           e.printStackTrace();
       }


        SharedPreferences preferences2 = this.getActivity().getSharedPreferences("co2", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor2 = preferences2.edit();

        String valueCo2= editTextCo2.getText().toString();

        try {
            finalValueCo2=Integer.parseInt(valueCo2);
        }catch (Exception e){
            e.printStackTrace();
        }


        SharedPreferences preferences3 = this.getActivity().getSharedPreferences("hum", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor3 = preferences3.edit();

        String valueHum= editTextHum.getText().toString();

        try {
             finalValueHum=Integer.parseInt(valueHum);
        }catch (Exception e){
            e.printStackTrace();
        }


        SharedPreferences preferences4 = this.getActivity().getSharedPreferences("people", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor4 = preferences4.edit();
        String valuePeople= editTextPeople.getText().toString();
        try {
            finalValuePeople=Integer.parseInt(valuePeople);
        }catch (Exception e){
            e.printStackTrace();
        }
        buttonWarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor1.putInt("temp",finalValueTemp);
                editor1.commit();
                editor2.putInt("co2",finalValueCo2);
                editor2.commit();
                editor3.putInt("hum",finalValueHum);
                editor3.commit();
                editor4.putInt("people",finalValuePeople);
                editor4.commit();


            }
        });


        return v;
    }





}
