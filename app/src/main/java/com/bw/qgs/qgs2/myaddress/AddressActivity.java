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
import com.bw.qgs.qgs2.myaddress.presenter.MoPresenter;
import com.bw.qgs.qgs2.myaddress.view.AddressView;
import com.bw.qgs.qgs2.url.BaseRequest;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.bw.qgs.qgs2.wallet.WalletActivity;
import com.bw.qgs.qgs2.wallet.adapter.WalletAdapter;
import com.bw.qgs.qgs2.wallet.bean.WalletUser;
import com.bw.qgs.qgs2.xinzeng.UpdateAddressActivity;
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
    private MoPresenter mMoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ButterKnife.bind(this);
        mAddressPresenter = new AddressPresenter(this);
        mAddressPresenter.addre(UrlUtil.ADDRESS);
        mMoPresenter = new MoPresenter(this);
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
    public void onSuccess(final String result) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        addressrecycle.setLayoutManager(linearLayoutManager);
        Gson gson = new Gson();
        AddressUser addressUser = gson.fromJson(result, AddressUser.class);
        mResult1 = addressUser.getResult();
        final AddressAdapter walletAdapter = new AddressAdapter(getApplicationContext(), mResult1);
        /*walletAdapter.setHttpOnClick(new AddressAdapter.HttpOnClick() {
            @Override
            public void click(View view, int position) {
                walletAdapter.setHttpOnClick(new AddressAdapter.HttpOnClick() {
                    @Override
                    public void click(View view, int position) {
                        int id = mResult1.get(position).getId();
                        mMoPresenter.mo(UrlUtil.MOREN+id,new BaseRequest());
                    }
                });
            }
        });*/
        walletAdapter.setHttpXiuOnClick(new AddressAdapter.HttpXiuOnClick() {
            @Override
            public void click(View view, int position) {
                Intent intent = new Intent(AddressActivity.this,UpdateAddressActivity.class);
                int id = mResult1.get(position).getId();
                String realName = mResult1.get(position).getRealName();
                String phone = mResult1.get(position).getPhone();
                String address = mResult1.get(position).getAddress();
                String zipCode = mResult1.get(position).getZipCode();
                intent.putExtra("id",id);
                intent.putExtra("realName",realName);
                intent.putExtra("phone",phone);
                intent.putExtra("address",address);
                intent.putExtra("zipCode",zipCode);
                startActivity(intent);
            }
        });
        addressrecycle.setAdapter(walletAdapter);
        //Toast.makeText(getApplicationContext(), "" + mResult1, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMoSuccess(String result) {
        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailer(String msg) {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
}
