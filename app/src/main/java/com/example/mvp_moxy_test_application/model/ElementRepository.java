package com.example.mvp_moxy_test_application.model;

import java.util.ArrayList;
import java.util.List;

public class ElementRepository {
    private List<Element> elementList;
    private OnListUpdatedListener onListUpdatedListener;

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
        element.setIndex((elementList.size() != 0) ? (elementList.get(elementList.size()-1).getIndex()) + 1 : 0);
        elementList.add(element);
        if (onListUpdatedListener != null) {
            onListUpdatedListener.onElementAdded(elementList.indexOf(element));
        }
    }

    public void removeElement() {
        int index = elementList.size() - 1;
        if (index < 0) {
            return;
        }
        elementList.remove(index);
        if (onListUpdatedListener != null) {
            onListUpdatedListener.onElementRemoved(index);
        }
    }

    public void setOnListUpdatedListener(OnListUpdatedListener onListUpdatedListener) {
        this.onListUpdatedListener = onListUpdatedListener;
    }

    public interface OnListUpdatedListener {
        void onElementAdded(int position);
        void onElementRemoved(int position);
    }
}
