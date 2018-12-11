package com.bw.qgs.qgs2.myaddress;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.myaddress.adapter.AddressAdapter;
import com.bw.qgs.qgs2.myaddress.bean.AddressUser;
import com.bw.qgs.qgs2.myaddress.presenter.AddressPresenter;
import com.bw.qgs.qgs2.myaddress.view.AddressView;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.bw.qgs.qgs2.wallet.WalletActivity;
import com.bw.qgs.qgs2.wallet.adapter.WalletAdapter;
import com.bw.qgs.qgs2.wallet.bean.WalletUser;
import com.bw.qgs.qgs2.xinzeng.XinZengActivity;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressActivity extends AppCompatActivity implements AddressView {

    @BindView(R.id.finishaddress)
    TextView finishaddress;
    @BindView(R.id.addressrecycle)
    RecyclerView addressrecycle;
    @BindView(R.id.insertaddress)
    Button insertaddress;
    private AddressPresenter mAddressPresenter;
    private List<AddressUser.ResultBean> mResult1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ButterKnife.bind(this);
        mAddressPresenter = new AddressPresenter(this);
        mAddressPresenter.addre(UrlUtil.ADDRESS);
    }

    @OnClick({R.id.finishaddress, R.id.insertaddress})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.finishaddress:
                break;
            case R.id.insertaddress:
                startActivity(new Intent(AddressActivity.this,XinZengActivity.class));
                break;
        }
    }

    @Override
    public void onSuccess(String result) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        addressrecycle.setLayoutManager(linearLayoutManager);
        Gson gson = new Gson();
        AddressUser addressUser = gson.fromJson(result, AddressUser.class);
        mResult1 = addressUser.getResult();
        AddressAdapter walletAdapter = new AddressAdapter(getApplicationContext(), mResult1);
        walletAdapter.setHttpOnClick(new AddressAdapter.HttpOnClick() {
            @Override
            public void click(View view, int position) {

            }
        });
        addressrecycle.setAdapter(walletAdapter);
        //Toast.makeText(getApplicationContext(), "" + mResult1, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailer(String msg) {

    }
}
