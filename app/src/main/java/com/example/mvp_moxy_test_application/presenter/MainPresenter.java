package com.example.mvp_moxy_test_application.presenter;

import com.example.mvp_moxy_test_application.model.Element;
import com.example.mvp_moxy_test_application.model.ElementRepository;
import com.example.mvp_moxy_test_application.view.MainView;

import java.util.List;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private ElementRepository elementRepository;

    public MainPresenter() {
        elementRepository = new ElementRepository();
        loadData();
    }

    public void loadData() {
        getViewState().showData(elementRepository.getElementList());
    }

    public List<Element> fetchData() {
        return elementRepository.getElementList();
    }

    public void onAddButtonClick() {
        elementRepository.addElement();
        getViewState().showData(elementRepository.getElementList());
    }

}
