package com.example.navigationdrawer.ui.register;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.navigationdrawer.R;
import com.example.navigationdrawer.UserInfo;

public class RegisterFragment extends Fragment {

    private RegisterViewModel mViewModel;

    private Button submit;
    public String FullName,Phone,Address,Gender,Sudlah1,Sudlah2,Sudlah3;
    private EditText fName,phone,address;
    private RadioButton rbFemale,rbMale;
    private CheckBox chWeb,chPython,chJava;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.register_fragment, container, false);

        rbMale = (RadioButton) root.findViewById(R.id.male);
        rbFemale = (RadioButton) root.findViewById(R.id.female);

        rbMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gender = "Male";
            }
        });
        rbFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gender = "Female";
            }
        });
//        CheckBox
        chWeb = (CheckBox) root.findViewById(R.id.chWeb);
        chJava = (CheckBox) root.findViewById(R.id.chJava);
        chPython = (CheckBox) root.findViewById(R.id.chPython);




//        EditText
        fName = (EditText) root.findViewById(R.id.eFname);
        phone = (EditText) root.findViewById(R.id.ePhone);
        address = (EditText) root.findViewById(R.id.eAddress);


//        Submit
        submit = (Button) root.findViewById(R.id.submitBtn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showInfo();
            }
        });
        return root;

    }

    public void showInfo(){

        if(chJava.isChecked()){
            Sudlah1="Java";
        }
        if(chWeb.isChecked()){
            Sudlah2="Web";
        }
        if(chPython.isChecked()){
            Sudlah3="Python";
        }
        FullName = fName.getText().toString();
        Phone = phone.getText().toString();
        Address = address.getText().toString();


        Intent intent = new Intent(getActivity(), UserInfo.class);
        intent.putExtra("ner",FullName);
        intent.putExtra("utas",Phone);
        intent.putExtra("hayg",Address);
        intent.putExtra("huis",Gender);
        intent.putExtra("sudlah1",Sudlah1);
        intent.putExtra("sudlah2",Sudlah2);
        intent.putExtra("sudlah3",Sudlah3);
        startActivity(intent);




    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
        // TODO: Use the ViewModel
    }

}