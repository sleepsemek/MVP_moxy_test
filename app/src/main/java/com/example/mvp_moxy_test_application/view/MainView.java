package com.example.mvp_moxy_test_application.view;

import com.example.mvp_moxy_test_application.model.Element;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndStrategy.class)
public interface MainView extends MvpView {

    void showData(List<Element> elementList);
    void addElementToAdapter(int position);
    void removeElementFromAdapter(int position);
    @StateStrategyType(OneExecutionStateStrategy.class)
    void showMesssage(String msg);
}
