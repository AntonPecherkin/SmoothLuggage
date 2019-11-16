
package com.manager.direct.blockchalleng;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import com.manager.direct.blockchalleng.Contract.CryptoAnchors;
import com.manager.direct.blockchalleng.Contract.MapChain;

import org.spongycastle.util.encoders.Hex;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.utils.Convert;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class EtheriumRunner extends AsyncTask<String, Void, Void> {
    private String TAG = "ETHERIUM";
    private Handler h;
    private ProgressDialog pd;
    private String contractAddress = "0xae8af0c25c45c2ff5d077b86c8f6cb39fffbabda";
    public static String jsonClient =
            "{\"address\":\"09a5dacb427cc8fd596e5b1640fa539dac1a5d6d\",\"id\":\"0f633608-267f-4e94-b4ef-4f4ba635ef89\",\"version\":3,\"crypto\":{\"cipher\":\"aes-128-ctr\",\"ciphertext\":\"4fc75a27ac790c3308f11c02a356e46cfab8796c866812a5dea9c368c19f6b56\",\"cipherparams\":{\"iv\":\"137a3d2c8c934f1afd108bea643a9ce7\"},\"kdf\":\"scrypt\",\"kdfparams\":{\"dklen\":32,\"n\":262144,\"p\":1,\"r\":8,\"salt\":\"e07cbff898dfc8db886058435d6409d32c11c247b3a9d7544ccb85894ed370e0\"},\"mac\":\"94c0986542d05b14aa481a46752d59c77ebf8443103678c44e2aa8899c326ccb\"}}";



    public static String jsonUTC =
            "{\"version\":3,\"id\":\"c9590b3f-e2eb-4a3f-96d1-0e5dcd304f7c\",\"address\":\"20cf3a494baacae2a74bf81b0e55970b756baa70\",\"Crypto\":{\"ciphertext\":\"650c7e4f2f80ae80426a8e3ea4d1cab891beea3854f010e816d9e2e7d4396984\",\"cipherparams\":{\"iv\":\"110a91cc184227022877ed6b0931cfd1\"},\"cipher\":\"aes-128-ctr\",\"kdf\":\"scrypt\",\"kdfparams\":{\"dklen\":32,\"salt\":\"ee158b8d1c315b6c6a777bd114896051e4e06e68e506f3df9ba4b556ce89e730\",\"n\":8192,\"r\":8,\"p\":1},\"mac\":\"2cec2b9449980cca057a62cdcd284d499f96a533093c559eb60132af61483747\"}}";



        @Override
        protected void onPreExecute() {

            super.onPreExecute();

            Log.d("ETHR", "ok pre exec");

        }

        @Override
        protected Void doInBackground(String... params) {

            try {
                try {
                    Web3j web3j = Web3jFactory.build(new HttpService("https://rinkeby.infura.io/1p6X1Vby9WW11tNcTTg0"));
                    BigInteger _price = BigInteger.ONE;
                    _price = BigInteger.valueOf(10);
                    String address = "0xa7d467b39cbb18bd9558037610fdb603c5844d8e";
                    BigInteger _steps = BigInteger.ONE;
                    _steps = BigInteger.valueOf(3);
                    // We then need to load our Ethereum wallet file
                    // FIXME: Generate a new wallet file using the web3j command line tools https://docs.web3j.io/command_line.html
                    Credentials credentials1 = Credentials.create("9c215ede75b688ce2f30372140068c815b78b2eedfe8bd9af04d8d7fddd8ef2e");
//                    CryptoAnchors contract1 =
//                            CryptoAnchors.load(address, web3j, credentials1, CryptoAnchors.GAS_PRICE, CryptoAnchors.GAS_LIMIT);

                    //Log.d("dw", contract1.TypeName().send());

                    BigInteger _latitude = new BigInteger("123");
                    BigInteger _longitude = new BigInteger("123");
                    BigInteger _v = new BigInteger("1c", 16);
                    byte[] _r = StringHexToByteArray("0xf444a383acba466a2aed2582895c614323bb97aa6b74e04f97922b176bc1aa2c");
                    byte[] _s = StringHexToByteArray("0x4f23d377cb19cc04f408a2ea4fb219d69e3bcb0a5585d06561a34712185a0e77");
                    byte[] _signedHash = StringHexToByteArray("0x8dfe9be33ccb1c830e048219729e8c01f54c768004d8dc035105629515feb38e");

                    MapChain contract = MapChain.load(
                            contractAddress,
                            web3j, credentials1,
                            MapChain.GAS_PRICE, MapChain.GAS_LIMIT
                    );

                    contract.stopGame().send();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        public byte[] StringHexToByteArray(String x) throws Exception {
            if (x.startsWith("0x")) {
                x = x.substring(2);
            }
            if (x.length() % 2 != 0) x = "0" + x;
            return Hex.decode(x);
        }


}

