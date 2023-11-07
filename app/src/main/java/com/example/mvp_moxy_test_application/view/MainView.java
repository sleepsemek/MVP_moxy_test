package com.example.mvp_moxy_test_application.view;

import com.example.mvp_moxy_test_application.model.Element;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface MainView extends MvpView {

    @StateStrategyType(AddToEndStrategy.class)
    void showData(List<Element> elementList);

}
