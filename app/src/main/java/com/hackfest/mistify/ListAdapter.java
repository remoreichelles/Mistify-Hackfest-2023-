package com.hackfest.mistify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> arrayList;
    LayoutInflater inflater;

    public ListAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        String position = (String) getItem(i);
        view = inflater.inflate(R.layout.list_items_batch_in_monitoring, null);
        TextView batchNo = view.findViewById(R.id.txtBatchNumberMonitoring);
        batchNo.setText("Batch " + arrayList.get(i));


        return view;
    }
}
