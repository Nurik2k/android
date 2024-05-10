package com.example.lesson_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class BoxAdapter extends BaseAdapter {

    Context ctx;
    LayoutInflater inflater;
    ArrayList<Product> products;

    public BoxAdapter(Context ctx, ArrayList<Product> products) {
        this.ctx = ctx;
        this.products = products;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.item, parent, false);
        }
        Product product = (Product) getItem(position);
        ((TextView) view.findViewById(R.id.tvDesc)).setText(product.name);
        CheckBox cbBox = (CheckBox) view.findViewById(R.id.cbBox);
        cbBox.setOnCheckedChangeListener(myListener);
        cbBox.setTag(position);
        cbBox.setChecked(product.isChecked);
        return view;
    }

    CompoundButton.OnCheckedChangeListener myListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            getProduct((Integer) buttonView.getTag()).isChecked = isChecked;
        }
    };

    Product getProduct(int position) {
        return ((Product) getItem(position));
    }

    ArrayList<Product> getBox() {
        ArrayList<Product> box = new ArrayList<>();
        for (Product product : products) {
            if (product.isChecked) {
                box.add(product);
            }
        }
        return box;
    }
}
