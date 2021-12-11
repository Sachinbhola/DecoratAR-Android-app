package com.example.decoratar.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.decoratar.R;
import com.example.decoratar.adapter.RvAdapter;
import com.example.decoratar.databinding.FragmentHomeBinding;
import com.example.decoratar.model.FurnitureData;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private List<FurnitureData> furnitureDataList = new ArrayList<>();
    RecyclerView recyclerView;
    RvAdapter furnitureAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = binding.rvButtons;
        Button btnChair = binding.btnChair;
        Button btnDecor = binding.btnDecor;
        Button btnOffice = binding.btnOffice;
        Button btnSofa = binding.btnSofa;
        Button btnTable = binding.btnTable;

        furnitureDataList = new ArrayList<>();
        furnitureDataList.add(new FurnitureData("Velvet Sofa",R.drawable.sofa1,"https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/GlamVelvetSofa/glTF/GlamVelvetSofa.gltf"));
        furnitureDataList.add(new FurnitureData("Leather Sofa",R.drawable.sofa2,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/sofas/sofa_game_ready__2k_pbr/scene.gltf"));
        furnitureDataList.add(new FurnitureData("Victorian Sofa",R.drawable.sofa3,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/victorian_lounge_sofa/scene.gltf"));
        furnitureDataList.add(new FurnitureData("Chesterfield Sofa",R.drawable.sofa5,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/sofa_02_4k.gltf/sofa_02_4k.gltf"));
        furnitureDataList.add(new FurnitureData("Modern Sofa",R.drawable.sofa6,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/sofa_6/scene.gltf"));
        furnitureDataList.add(new FurnitureData("Lawson Sofa",R.drawable.sofa8,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/sofas/sofa/scene.gltf"));

        setRv(furnitureDataList);

        //sofa
        btnSofa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call rv and create list
                furnitureDataList.clear();
                furnitureDataList.add(new FurnitureData("Velvet Sofa",R.drawable.sofa1,"https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/GlamVelvetSofa/glTF/GlamVelvetSofa.gltf"));
                furnitureDataList.add(new FurnitureData("Leather Sofa",R.drawable.sofa2,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/sofas/sofa_game_ready__2k_pbr/scene.gltf"));
                furnitureDataList.add(new FurnitureData("Victorian Sofa",R.drawable.sofa3,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/victorian_lounge_sofa/scene.gltf"));
                furnitureDataList.add(new FurnitureData("Chesterfield Sofa",R.drawable.sofa5,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/sofa_02_4k.gltf/sofa_02_4k.gltf"));
                furnitureDataList.add(new FurnitureData("Modern Sofa",R.drawable.sofa6,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/sofa_6/scene.gltf"));
                furnitureDataList.add(new FurnitureData("Lawson Sofa",R.drawable.sofa8,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/sofas/sofa/scene.gltf"));

                setRv(furnitureDataList);


                btnSofa.setBackgroundColor(Color.parseColor("#E18771"));
                btnChair.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
                btnDecor.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
                btnOffice.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
                btnTable.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));

            }

        });

        btnChair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call rv and create list
                furnitureDataList.clear();
                furnitureDataList.add(new FurnitureData("Modern Chair",R.drawable.chair_grey,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/chair/arm_chair__furniture/scene.gltf"));
                furnitureDataList.add(new FurnitureData("Manchester Chair",R.drawable.chair_old,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/the_matrix_red_chesterfield_chair/scene.gltf"));
                furnitureDataList.add(new FurnitureData("Orange Sheen Chair",R.drawable.chair_orange,"https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/SheenChair/glTF/SheenChair.gltf"));
                furnitureDataList.add(new FurnitureData("Classic Chair",R.drawable.chair_wood,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/chair/furniture_for_real-time_visualization_engine/scene.gltf"));
                setRv(furnitureDataList);

                btnSofa.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
                btnChair.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.orange));
                btnDecor.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
                btnOffice.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
                btnTable.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
            }
        });

        btnDecor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call rv and create list
                furnitureDataList.clear();
                furnitureDataList.add(new FurnitureData("Modern Pot",R.drawable.dec1,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/decor/lavender_vase/scene.gltf"));
                furnitureDataList.add(new FurnitureData("Lamp",R.drawable.dec2,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/decor/lamp/scene.gltf"));
                furnitureDataList.add(new FurnitureData("Flowers",R.drawable.dec3,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/decor/flower_vase%20(1)/scene.gltf"));
                setRv(furnitureDataList);

                btnSofa.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
                btnChair.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
                btnDecor.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.orange));
                btnOffice.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
                btnTable.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
            }
        });

        btnOffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call rv and create list
                furnitureDataList.clear();

                furnitureDataList.add(new FurnitureData("Gaming Chair",R.drawable.office,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/office%20essentials%20and%20cabinets/gaming_chair_1-_black/scene.gltf"));
                furnitureDataList.add(new FurnitureData("Classic chair ",R.drawable.office_chair,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/office%20essentials%20and%20cabinets/office_chair%20(1)/scene.gltf"));
                furnitureDataList.add(new FurnitureData("Desk",R.drawable.office_desk,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/office%20essentials%20and%20cabinets/modern_table_set/scene.gltf"));
                setRv(furnitureDataList);

                btnSofa.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
                btnChair.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
                btnDecor.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
                btnOffice.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.orange));
                btnTable.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
            }
        });

        btnTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call rv and create list
                furnitureDataList.clear();
                furnitureDataList.add(new FurnitureData("Table",R.drawable.table1,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/table/mahogany_table/scene.gltf"));
                furnitureDataList.add(new FurnitureData("Wooden Table",R.drawable.table2,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/office%20essentials%20and%20cabinets/simple_desk_free/scene.gltf"));
                furnitureDataList.add(new FurnitureData("Metal Table",R.drawable.table3,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/table/industrial_table/scene.gltf"));
                furnitureDataList.add(new FurnitureData("Classic Table",R.drawable.table4,"https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/table/victorian_coffee_table/scene.gltf"));
                setRv(furnitureDataList);

                btnSofa.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
                btnChair.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
                btnDecor.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
                btnOffice.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.white));
                btnTable.setBackgroundColor(btnSofa.getContext().getResources().getColor(R.color.orange));
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private void setRv(List<FurnitureData> furnitureList){

        furnitureAdapter = new RvAdapter(getActivity(),furnitureList);
        LinearLayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(furnitureAdapter);
    }

}