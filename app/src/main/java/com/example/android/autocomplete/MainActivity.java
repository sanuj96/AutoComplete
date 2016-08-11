package com.example.android.autocomplete;

import android.util.Log;
import android.view.Menu;



        import android.os.Bundle;
        import android.app.Activity;
        import android.graphics.Color;
        import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
        import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {
    String[] keys;
    String[] values;
    AutoCompleteTextView actv;
    TextView hex;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hex=(TextView)findViewById(R.id.textView2);

        keys=getResources().getStringArray(R.array.KeyArray);



        values=getResources().getStringArray(R.array.keypair);



        for(int i=0;i<keys.length;i++)
        {
            String[] Arr = keys[i].split(":");
            keys[i]=Arr[0];
            values[i]=Arr[1];
            //Log.v("abc",keys[i]+"lll"+values[i]);
        }


        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,language);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,keys);
        actv= (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        actv.setThreshold(1);
        actv.setAdapter(adapter);
        actv.setTextColor(Color.BLACK);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void onTap(View view)
    {
        String str=actv.getText().toString();
        actv.setText("");
        int flag=0;

        for(int i=0;i<keys.length;i++)
        {
           if(str.compareTo(keys[i])==0)
           {
               hex.setText(str+" : "+ values[i]);
               flag=1;
               //actv.setText("HEX [ "+str+"] = "+values[i]);
           }


               //Toast.makeText(MainActivity.this,values[i], Toast.LENGTH_SHORT).show();


        }

        if(flag==0)
        {
            hex.setText("Op-Code Not Found");
        }


    }

}