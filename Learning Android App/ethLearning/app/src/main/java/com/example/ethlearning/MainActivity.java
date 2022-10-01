package com.example.ethlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.http.HttpService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Web3j web3 = Web3j.build(new HttpService("ADD_YOUR_ETHEREUM_NODE_URL"));
        EthBlockNumber result = web3.ethBlockNumber().sendAsync().get();
        System.out.println(" The Block Number is: " + result.getBlockNumber().toString());
    }
}