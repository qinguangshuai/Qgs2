package com.bw.qgs.qgs2.homepage.fragment.fivefragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.qgs.qgs2.MainActivity;
import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.circle.CircleActivity;
import com.bw.qgs.qgs2.footer.FooterActivity;
import com.bw.qgs.qgs2.myaddress.AddressActivity;
import com.bw.qgs.qgs2.wallet.WalletActivity;
import com.facebook.drawee.view.SimpleDraweeView;

public class FiveFragment extends Fragment {

    private TextView address,datum,sistem,qianbaofive,footprints,circletext;
    private SimpleDraweeView mypleasureimage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_five, container, false);
        address = view.findViewById(R.id.address);
        mypleasureimage = view.findViewById(R.id.mypleasureimage);
        datum = view.findViewById(R.id.datum);
        sistem = view.findViewById(R.id.sistem);
        footprints = view.findViewById(R.id.footprints);
        qianbaofive = view.findViewById(R.id.qianbaofive);
        circletext = view.findViewById(R.id.circletext);
        SharedPreferences sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        String headPic = sp.getString("headPic", "");
        String nickName = sp.getString("nickName", "");
        Uri uri = Uri.parse(headPic);
        mypleasureimage.setImageURI(uri);
        sistem.setText(nickName);
        initData();
        return view;
    }

    private void initData() {
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AddressActivity.class);
                startActivity(intent);
            }
        });
        datum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                String s = sistem.getText().toString();
                intent.putExtra("sistem",s);
                startActivity(intent);
            }
        });
        qianbaofive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),WalletActivity.class);
                startActivity(intent);
            }
        });
        footprints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),FooterActivity.class);
                startActivity(intent);
            }
        });
        circletext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),CircleActivity.class);
                startActivity(intent);
            }
        });
    }
}
