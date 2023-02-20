package com.example.web3java;

import android.util.Log;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

public class Helper {

    Web3j provider = Web3j.build(new HttpService("https://goerli.infura.io/v3/5779b2fe79084d7ebb06f386bb970e26"));

    public String getBalance(String address) {
        EthGetBalance ethGetBalance;
        String strTokenAmount = "";
        try {
            ethGetBalance = provider.ethGetBalance(address, DefaultBlockParameterName.LATEST).sendAsync().get();
            BigDecimal tokenValue = Convert.fromWei(String.valueOf(ethGetBalance.getBalance()), Convert.Unit.ETHER);
            strTokenAmount = String.valueOf(tokenValue);
            Log.d("exception", "none");
        } catch (ExecutionException e) {
            Log.d("exception", e.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.d("exception", e.toString());
        }
        return strTokenAmount;
    }
}
