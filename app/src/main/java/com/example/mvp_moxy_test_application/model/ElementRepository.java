package com.example.mvp_moxy_test_application.model;

import java.util.ArrayList;
import java.util.List;

public class ElementRepository {
    private List<Element> elementList;

    public ElementRepository() {
        elementList = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            Element element = new Element();
            element.setName("nameTest");
            element.setIndex(i);
            elementList.add(element);
        }
    }

    public List<Element> getElementList() {
        return elementList;
    }

    public void addElement() {
        Element element = new Element();
        element.setName("nameTest");
        element.setIndex((elementList.get(elementList.size()-1).getIndex()) + 1);
        elementList.add(element);
    }
}
