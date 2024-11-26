package com.example.myapplication.activities.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.activities.adapters.UserAdapter;

import java.util.ArrayList;

import models.Users;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link notes_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class notes_fragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Users> usersArrayList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public notes_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment notes_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static notes_fragment newInstance(String param1, String param2) {
        notes_fragment fragment = new notes_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notes_fragment, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        usersArrayList = new ArrayList<>();

        // set-up recycler View
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        usersArrayList.add(new Users("hitesh", "111"));
        usersArrayList.add(new Users("harsh", "222"));
        usersArrayList.add(new Users("rishav", "333"));
        usersArrayList.add(new Users("sahil", "444"));
        usersArrayList.add(new Users("patel", "555"));
        usersArrayList.add(new Users("shiv", "666"));
        usersArrayList.add(new Users("dhruv", "777"));
        usersArrayList.add(new Users("shivam", "888"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        usersArrayList.add(new Users("hitesh", "111"));
        usersArrayList.add(new Users("harsh", "222"));
        usersArrayList.add(new Users("rishav", "333"));
        usersArrayList.add(new Users("sahil", "444"));
        usersArrayList.add(new Users("patel", "555"));
        usersArrayList.add(new Users("shiv", "666"));
        usersArrayList.add(new Users("dhruv", "777"));
        usersArrayList.add(new Users("shivam", "888"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        usersArrayList.add(new Users("hitesh", "111"));
        usersArrayList.add(new Users("harsh", "222"));
        usersArrayList.add(new Users("rishav", "333"));
        usersArrayList.add(new Users("sahil", "444"));
        usersArrayList.add(new Users("patel", "555"));
        usersArrayList.add(new Users("shiv", "666"));
        usersArrayList.add(new Users("dhruv", "777"));
        usersArrayList.add(new Users("shivam", "888"));

        usersArrayList.add(new Users(" ", " "));
        usersArrayList.add(new Users(" ", " "));


        UserAdapter adapter = new UserAdapter(getContext(), usersArrayList);
        recyclerView.setAdapter(adapter);


        return view;
    }
}