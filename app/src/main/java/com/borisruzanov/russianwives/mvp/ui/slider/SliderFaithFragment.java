package com.borisruzanov.russianwives.mvp.ui.slider;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.borisruzanov.russianwives.R;
import com.borisruzanov.russianwives.mvp.model.repository.slider.SliderRepository;
import com.borisruzanov.russianwives.utils.Consts;
import com.borisruzanov.russianwives.utils.UpdateCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class SliderFaithFragment extends Fragment {
    Button btnSave;
    RadioGroup radioGroup;
    RadioButton radioButton;

    public SliderFaithFragment() {
        // Required empty public constructor
    }

    public static SliderFaithFragment newInstance() {
        SliderFaithFragment fragment = new SliderFaithFragment();
        Bundle args = new Bundle();
        args.putString(Consts.NEED_BACK, Consts.BACK);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slider_faith, container, false);
        radioGroup = (RadioGroup) view.findViewById(R.id.fragment_slider_faith_radiogroup);
        btnSave = (Button) view.findViewById(R.id.fragment_slider_faith_btn_save);

        new SliderRepository().getFieldFromCurrentUser("faith", value -> {
            if (value != null && value.equals("Christian")){
                radioGroup.check(R.id.fragment_slider_faith_rbtn_christian);
            } else if (value != null && value.equals("Black / African descent")){
                radioGroup.check(R.id.fragment_slider_faith_rbtn_black);
            } else if (value != null && value.equals("Muslim")){
                radioGroup.check(R.id.fragment_slider_faith_rbtn_muslim);
            }else if (value != null && value.equals("Atheist")){
                radioGroup.check(R.id.fragment_slider_faith_rbtn_atheist);
            }else if (value != null && value.equals("Buddist")){
                radioGroup.check(R.id.fragment_slider_faith_rbtn_buddist);
            }else if (value != null && value.equals("Other")){
                radioGroup.check(R.id.fragment_slider_faith_rbtn_other);
            }else if (value != null && value.equals("Adventist")){
                radioGroup.check(R.id.fragment_slider_faith_rbtn_adventist);
            }
        });

        btnSave.setOnClickListener(v -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            radioButton = (RadioButton) view.findViewById(selectedId);
            if(radioButton.getText() != null){
                Map<String, Object> map = new HashMap<>();
                map.put("faith", radioButton.getText());
                new SliderRepository().updateFieldFromCurrentUser(map, () -> {
                    if (getArguments() != null && getArguments().getString(Consts.NEED_BACK) != null) {
                        getActivity().onBackPressed();
                    }
                    Toast.makeText(getActivity(), R.string.faith_updated, Toast.LENGTH_LONG).show();
                });
            }
        });
        return view;
    }

}
