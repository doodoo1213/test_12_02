package com.example.cho.test_12_02;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Samsung on 2016-12-08.
 */

public class News extends Fragment {
    String[] m_names_1 = {"2016 Spring", "2016 Summer", "2016 Fall", "2016 Winter"};

    int[] m_flags_1 = {R.drawable.spring, R.drawable.summer, R.drawable.fall, R.drawable.winter};

    String[] m_text_1 = { "이건 2016 Spring이에요!!", "이건 2016 Summer에요!!", "이건 2016 Fall이에요!!", "이건 2016 Winter에요!!"};

    View view;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Magazine> arrayList = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.magazine_main, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        Context context = view.getContext();
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        int count = 0;
        for (String Name : m_names_1) {
            arrayList.add(new Magazine(Name, m_flags_1[count], m_text_1[count]));
            count++;
        }

        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        return view;
    }
}