package com.example.gamelannagakencana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;

import static com.example.gamelannagakencana.R.drawable.ic_arrow_down_24dp;

public class InstActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<TypesClass> alTypes;
    ArrayAdapter aaTypes;
    Button btnTypes, btnScales, btnInst;
    LinearLayout linearReveal;
    GridLayout gridLayout;
    FrameLayout frameLayout;
    ScrollView scrollViewGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inst);

        lv = findViewById(R.id.lvTypes);
        btnTypes = findViewById(R.id.buttonTypes);
        btnScales = findViewById(R.id.buttonScales);
        btnInst = findViewById(R.id.buttonInst);
        linearReveal = findViewById(R.id.linearReveal);
        gridLayout = findViewById(R.id.gridLayout);
        scrollViewGrid = findViewById(R.id.scrollViewGrid);
        alTypes = new ArrayList<TypesClass>();
        gamelanTypes();
        aaTypes = new CustomAdapterTypes(this, R.layout.custom_lv_types, alTypes);
        lv.setAdapter(aaTypes);
        lv.setVisibility(View.GONE);
        linearReveal.setVisibility(View.GONE);
        scrollViewGrid.setVisibility(View.GONE);
        aaTypes.notifyDataSetChanged();

        btnTypes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lv.getVisibility() == View.GONE){
                    lv.setVisibility(View.VISIBLE);
                    btnTypes.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.ic_arrow_up_24dp), null);
                }else{
                    lv.setVisibility(View.GONE);
                    btnTypes.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.ic_arrow_down_24dp), null);
                }
            }
        });

        btnScales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(linearReveal.getVisibility() == View.GONE){
                    linearReveal.setVisibility(View.VISIBLE);
                    btnScales.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.ic_arrow_up_24dp), null);

                }else{
                    linearReveal.setVisibility(View.GONE);
                    btnScales.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.ic_arrow_down_24dp), null);
                }
            }
        });

        btnInst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(scrollViewGrid.getVisibility() == View.GONE){
                    scrollViewGrid.setVisibility(View.VISIBLE);
                    btnInst.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.ic_arrow_up_24dp), null);

                }else{
                    scrollViewGrid.setVisibility(View.GONE);
                    btnInst.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.ic_arrow_down_24dp), null);
                }
            }
        });
    }

    void gamelanTypes(){
        alTypes.add(new TypesClass( String.valueOf(R.drawable.bali_gamelan),"Balinese Gamelan Set"));
        alTypes.add(new TypesClass( String.valueOf(R.drawable.sunda_gamelan), "Sundanese Gamelan Set"));
        alTypes.add(new TypesClass(String.valueOf(R.drawable.gamelan_java),"Javanese Gamelan Set"));

    }
}
