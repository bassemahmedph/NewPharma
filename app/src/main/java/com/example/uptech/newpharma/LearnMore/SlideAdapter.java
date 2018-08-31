package com.example.uptech.newpharma.LearnMore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.uptech.newpharma.R;

/**
 * Created by uptech on 23/08/2018.
 */

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;
    public int [] list_img ={
            R.drawable.book111,R.drawable.loc11,R.drawable.common11,R.drawable.alarm11,R.drawable.cart11
    };

    public String [] list_title={
            "Pharmacy Directory","Set Location","Common Disease","Alarm","Shopping Cart"
    };
    public String [] list_Description={
      "this feature help the user to recognize the different types of medicine and some details about the medicine","this feature help the user to show the nearest pharmacy and showing the best route on google maps to get it","this feature help the user to show the common diseases and her description and Syndrome of the disease","this feature help the user to set an alarm for each medicine and it has a notification to tell the use about the medicine time","this feature help the user to shopping and get his medicine from the nearest pharmacy and also if the pharmacy has a delivery system user can get it "
    };

    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
      inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide= (LinearLayout) view.findViewById(R.id.slidelinerlayout);
        ImageView imgslide = (ImageView)view.findViewById(R.id.slideimg);
        TextView  texttitle= (TextView) view.findViewById(R.id.slidetitle);
        TextView textdesc= (TextView) view.findViewById(R.id.slideDescription);
        imgslide.setImageResource(list_img[position]);
        texttitle.setText(list_title[position]);
        textdesc.setText(list_Description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
