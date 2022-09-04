package com.example.giftsapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.giftsapp.R;
import com.example.giftsapp.models.Mall;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class MyInfowindowAdapter implements GoogleMap.InfoWindowAdapter {
    Context context;
    public MyInfowindowAdapter(Context context){
        this.context=context;
    }
    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {

        Mall mall= (Mall) marker.getTag();
       View view=LayoutInflater.from(context).inflate(R.layout.marker,null);
       ImageView imageView=view.findViewById(R.id.imageView);
       TextView textView=view.findViewById(R.id.textView);

       imageView.setImageResource(mall.getImage());
        Log.d(mall.getName(),"sss");
       textView.setText(mall.getName());
       view.setLayoutParams(new LinearLayout.LayoutParams(500,500));
       imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(Intent.ACTION_VIEW);
               intent.setData(Uri.parse(mall.getUri()));
               context.startActivity(intent);
           }
       });
       return view;
    }
}
