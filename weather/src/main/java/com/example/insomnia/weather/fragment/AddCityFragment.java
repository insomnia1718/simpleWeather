package com.example.insomnia.weather.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.insomnia.weather.R;
import com.example.insomnia.weather.source.ProvincesData;
import com.rengwuxian.materialedittext.MaterialAutoCompleteTextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddCityFragment extends DialogFragment {

    @Bind(R.id.add_city_input)
    MaterialAutoCompleteTextView addCityInput;
    @Bind(R.id.cities_list)
    ExpandableListView citiesList;
    @Bind(R.id.add_city_negative_bn)
    Button addCityNegativeBn;
    OnCityClickListener listener;
    private static AddCityFragment sFragment;
    ProvincesData data = new ProvincesData();
    @Bind(R.id.add_city_positive_bn)
    Button addCityPositiveBn;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    public void setOnClickListener(OnCityClickListener listener) {
        this.listener = listener;
    }

    public static AddCityFragment newInstance() {
        return (sFragment == null) ? (sFragment = new AddCityFragment()) : sFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_city, container, false);
        ButterKnife.bind(this, v);
        setButton();
        BaseExpandableListAdapter expandableListAdapter = new BaseExpandableListAdapter() {

            @Override
            public int getGroupCount() {
                return data.getProNum();
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                if (groupPosition < 4) {
                    return 0;
                }
                return data.getCitiesNum(groupPosition);
            }

            @Override
            public Object getGroup(int groupPosition) {
                return data.getProName(groupPosition);
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return data.getCityName(groupPosition, childPosition);
            }

            @Override
            public long getGroupId(int groupPosition) {
                return 0;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                convertView = inflater.inflate(R.layout.add_city_list_group, null);
                TextView view = (TextView) convertView.findViewById(R.id.add_city_group_text);
                view.setText(data.getProName(groupPosition));
                return convertView;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                convertView = inflater.inflate(R.layout.add_city_list_group, null);
                TextView view = (TextView) convertView.findViewById(R.id.add_city_group_text);
                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
                view.setText(data.getCityName(groupPosition, childPosition));
                return convertView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };
        citiesList.setAdapter(expandableListAdapter);
        citiesList.setOnGroupClickListener((parent, v1, groupPosition, id) -> {
            if (groupPosition < 4) {
                listener.onClickCity(data.getProName(groupPosition));
                getDialog().dismiss();
                return true;
            }
            return false;
        });
        citiesList.setOnChildClickListener(((parent, v1, groupPosition, childPosition, id) -> {
            listener.onClickCity(data.getCityName(groupPosition, childPosition));
            getDialog().dismiss();
            return true;
        }));
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        ArrayAdapter listAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data.getAllCitiesName());
        addCityInput.setAdapter(listAdapter);

        return v;
    }

    private void setButton(){
        addCityNegativeBn.setOnClickListener(view -> getDialog().dismiss());
        addCityPositiveBn.setOnClickListener(v -> {
            String input = addCityInput.getText().toString();
            if (TextUtils.isEmpty(input)) addCityInput.setError("输入不能为空");
            else if (input.length()<2||input.length()>8)
                addCityInput.setError("城市名不合法");
            else {
                listener.onClickCity(input);
                getDialog().dismiss();
            }
        });
    }

    public interface OnCityClickListener {
        void onClickCity(String name);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
