package com.example.android.seven;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String names[]={"Great Wall of China", "Petra", "The Colosseum",
            "Chichen Itza", "Machu Picchu", "Taj Mahal", "Christ the Redeemer"};
    int details[]={R.string.greatText, R.string.petraText, R.string.colosseumtext,
            R.string.chichentext, R.string.machuText, R.string.tajtext,
            R.string.christtext};
    String locations[]={"China", "Jordan", "Italy", "Mexico", "Peru", "India", "Brazil"};
    int images[]={R.drawable.great, R.drawable.petra, R.drawable.colosseum,
            R.drawable.chichen, R.drawable.machu, R.drawable.taj, R.drawable.christ};
    ListView mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mylist= (ListView) findViewById(R.id.namelist);

        mylist.setAdapter(new MyAdapter(this,android.R.layout.simple_list_item_1,names));

        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long l) {
                Intent i = new Intent(MainActivity.this, details.class);
                i.putExtra("name", names[position]);
                i.putExtra("details+", details[position]);
                i.putExtra("image", images[position]);
                startActivity(i);
            }
        });

    }

    private class MyAdapter extends ArrayAdapter<String>
    {
        MyAdapter(Context mycontext, int layout1, String a[])
        {
            super(mycontext, layout1, a);
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater myinflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View myview=myinflater.inflate(R.layout.myview,parent,false);

            ImageView img= (ImageView) myview.findViewById(R.id.imageb);
            TextView t1,t2;
            t1= (TextView) myview.findViewById(R.id.name);
            t2= (TextView) myview.findViewById(R.id.place);

            img.setImageResource(images[position]);
            t1.setText(names[position]);
            t2.setText(locations[position]);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, onlyimage.class);
                    i.putExtra("imageonly", images[position]);
                    startActivity(i);
                }
            });

            return myview;
        }
    }
}
