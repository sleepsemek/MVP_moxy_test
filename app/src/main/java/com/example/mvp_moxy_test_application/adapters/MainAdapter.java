package com.example.mvp_moxy_test_application.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp_moxy_test_application.R;
import com.example.mvp_moxy_test_application.model.Element;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<Element> elementList = new ArrayList<>();

    public void setData(List<Element> elementList) {
        this.elementList = elementList;
        notifyDataSetChanged();
    }

    public void addElement(int position) {
        notifyItemInserted(position);
    }

    public void removeElement(int position) {
        notifyItemRemoved(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_view_holder, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(elementList.get(position));
    }

    @Override
    public int getItemCount() {
        return elementList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView elementNameView;
        private TextView elementIndexTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.elementNameView = itemView.findViewById(R.id.element_name_text_view);
            this.elementIndexTextView = itemView.findViewById(R.id.element_index_text_view);
        }

        public void bind(Element element) {
            elementNameView.setText(element.getName());
            elementIndexTextView.setText(String.valueOf(element.getIndex()));
        }
    }
}
