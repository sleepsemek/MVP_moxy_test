package com.example.mvp_moxy_test_application.presenter;

import com.example.mvp_moxy_test_application.model.ElementRepository;
import com.example.mvp_moxy_test_application.view.MainView;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private ElementRepository elementRepository;

    public MainPresenter() {
        elementRepository = new ElementRepository();
        loadData();
        elementRepository.setOnListUpdatedListener(new ElementRepository.OnListUpdatedListener() {
            @Override
            public void onElementAdded(int position) {
                getViewState().addElementToAdapter(position);
                getViewState().showMesssage("added new element");
            }

            @Override
            public void onElementRemoved(int position) {
                getViewState().removeElementFromAdapter(position);
                getViewState().showMesssage("removed last element");
            }
        });
    }

    public void loadData() {
        getViewState().showData(elementRepository.getElementList());
        getViewState().showMesssage("loaded 5 elements");
    }

    public void onAddButtonClick() {
        elementRepository.addElement();
    }

    public void onRemoveButtonClick() {
        elementRepository.removeElement();
    }
}
