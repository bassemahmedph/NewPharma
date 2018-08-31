package com.example.uptech.newpharma.pharmacy_directory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uptech.newpharma.R;

import java.util.ArrayList;

/**
 * Created by uptech on 05/08/2018.
 */


public class MyCustomListAdapter2 extends BaseAdapter {

    private Context context;
    private ArrayList<String> datalist;
    private ArrayList<String> datalist2;
    private ArrayList<String> num;
//    private ArrayList<String> pic_list;
    private TextView name_textView;
    private TextView  description_imageView;
    private TextView Num;
//    private ImageView imageView;




    public MyCustomListAdapter2(Context context1, ArrayList<String> list, ArrayList<String> datalist2)
    {
        context=context1;
        datalist=list;
        this.datalist2=datalist2;



    }
    public MyCustomListAdapter2 (Context context1, ArrayList<String> list, ArrayList<String> datalist2, ArrayList<String> num)
    {
        context=context1;
        datalist=list;
        this.datalist2=datalist2;
        this.num=num;

    }

    @Override
    public int getCount() {
        return datalist.size();

    }

    @Override
    public Object getItem(int position) {
        return datalist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 =inflater.inflate(R.layout.list_item_pharma_directory, parent,false);
        //  imageView=(ImageView) view1.findViewById(R.id.packageImage);
        name_textView=(TextView) view1.findViewById(R.id.list_name);
        description_imageView=(TextView) view1.findViewById(R.id.list_address);
        Num = (TextView) view1.findViewById(R.id.list_phone);


        description_imageView.setText(datalist2.get(position));
        name_textView.setText(datalist.get(position));
        Num.setText(num.get(position));




        return view1;
    }
}
