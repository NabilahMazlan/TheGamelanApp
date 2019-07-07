package com.example.gamelannagakencana;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.content.Intent;


public class AboutFragment extends Fragment{
    GridLayout gridLayout;
    CardView cvOrigin, cvInst, cvOtherGamelan, cvGNK;
    String[] stringDesc = new String[]{
            "Gamelan is a traditional music ensemble which originates from Indonesia. Gamelan is mostly made out of percussive instruments. The common instruments" +
                    "are generally made out of metallaphones and a set of hand played drums. Gamelan plays a huge role in Indonesia when it comes to their performing arts. Gamelan is almost seen everywhere in Indonesia. ",
            "There many types of Gamelan sets in Indonesia. Every race in Indonesia has it's own Gamelan sets. For example, the Javanese Gamelan and Balinese Gamelan varies in sound and in visual.",
            "Earlier, we know that Gamelan has two kind of scales. The scales are called Slendro and Pelog. Slendro is the older scales out of the two. In Pelog, there are seven notes. " +
                    "While in Slendro, there are also seven notes in Slendro, however, notes 4 and 7 are being replaced by a higher 1(7) and a lower 6.",
            "In Gamelan, there are a variety of instruments. Here are some of the instruments that can be found in a typical Gamelan ensemble.",
            "Gamelan Naga Kencana is the only Gamelan ensemble among the Polytechnic school in Singapore. It consists of a group of Republic Polytechnic students that have passion in learning Indonesian traditional music. " +
                    "There are both scales (Slendro & Pelog) in Gamelan Naga Kencana. "
    };


    DatabaseHelper myDB;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {        View view = inflater.inflate(R.layout.fragment_about, container, false);

        // Inflate the layout for this fragment

        cvOrigin = view.findViewById(R.id.cardViewOrigin);
        cvInst = view.findViewById(R.id.cardViewInstruments);
        cvOtherGamelan = view.findViewById(R.id.cardViewOtherGamelan);
        cvGNK = view.findViewById(R.id.cardViewGNK);
        cvOrigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), OriginActivity.class);
                startActivity(intent);
            }
        });

        cvInst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), InstActivity.class);
                startActivity(intent);
            }
        });

        cvOtherGamelan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), OtherGamelanActivity.class);
                startActivity(intent);
            }
        });

        cvGNK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), OtherGamelanDetailsActivity.class);
                startActivity(intent);
            }
        });
//
//        final MediaPlayer mPelog = MediaPlayer.create(getContext(), R.raw.pelog_saron_1_7_7_1);
//        final MediaPlayer mSlendro = MediaPlayer.create(getContext(), R.raw.slendro_saron);






        return view;

    }


//    @Override
//    public void onClick(View view) {
////       Fragment fragment = null;
//       switch (view.getId()){
//           case R.id.cardViewOrigin:
//               Intent i = new Intent(getContext(), OriginActivity.class);
//               startActivity(i);
//
//       }
//    }
}
