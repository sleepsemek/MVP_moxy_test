package com.example.mvp_moxy_test_application.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp_moxy_test_application.R;
import com.example.mvp_moxy_test_application.adapters.MainAdapter;
import com.example.mvp_moxy_test_application.model.Element;
import com.example.mvp_moxy_test_application.presenter.MainPresenter;
import com.example.mvp_moxy_test_application.view.MainView;

import java.util.List;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    public MainPresenter presenter;

    private RecyclerView elementsRecyclerView;
    private MainAdapter adapter;
    private AppCompatButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elementsRecyclerView = findViewById(R.id.elements_recycler_view);
        elementsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter();
        elementsRecyclerView.setAdapter(adapter);
        addButton = findViewById(R.id.add_element);

        addButton.setOnClickListener(view -> presenter.onAddButtonClick());
    }

    @Override
    public void showData(List<Element> elementList) {
        Toast.makeText(this, "loaded new data", Toast.LENGTH_LONG).show();
        adapter.setData(elementList);
    }

}