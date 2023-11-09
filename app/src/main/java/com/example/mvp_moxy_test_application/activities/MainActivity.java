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
    private AppCompatButton removeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elementsRecyclerView = findViewById(R.id.elements_recycler_view);
        elementsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter();
        elementsRecyclerView.setAdapter(adapter);
        addButton = findViewById(R.id.add_element);
        removeButton = findViewById(R.id.remove_element);

        addButton.setOnClickListener(view -> presenter.onAddButtonClick());
        removeButton.setOnClickListener(view -> presenter.onRemoveButtonClick());
    }

    @Override
    public void showData(List<Element> elementList) {
        adapter.setData(elementList);
    }

    @Override
    public void showMesssage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addElementToAdapter(int position) {
        adapter.addElement(position);
    }

    @Override
    public void removeElementFromAdapter(int position) {
        adapter.removeElement(position);
    }

}