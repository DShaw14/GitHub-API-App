package com.example.githubapiapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.viewHolder>{
    private String[] viewDataset;

        public static class viewHolder extends RecyclerView.ViewHolder {
            public TextView textView;
            public viewHolder(TextView entry) {
                super(entry);
                textView = entry;
            }
        }

        //constructor for ViewAdapter
        public ViewAdapter(String[] textDataset) {
            viewDataset = textDataset;
        }

        @Override
        public ViewAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //Creates a view in the list for every entry in the dataset
            TextView entry = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.support_simple_spinner_dropdown_item, parent, false);

            viewHolder entryHolder = new viewHolder(entry);
            return entryHolder;
        }

        @Override
        public void onBindViewHolder(viewHolder holder, int position) {
            holder.textView.setText(viewDataset[position]);
        }

        @Override
        public int getItemCount() {
            return viewDataset.length;
        }
}
