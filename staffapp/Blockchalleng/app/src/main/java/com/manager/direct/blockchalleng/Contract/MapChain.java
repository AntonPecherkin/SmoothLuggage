package com.manager.direct.blockchalleng.Contract;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class MapChain extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516109f03803806109f0833981016040908152815160208084015192840151606085015160006003818155600482905560018054600160a860020a03191633600160a060020a031617905560028690556005558052600a8352938501805193959094918101939101916100aa917f13da86008ba1c6922daee3e07db95305ef49ebced9f5467a0b8613fcc6b343e39186019061013b565b506001600052600a602090815282516100e8917fbbc70db1b6c7afd11e79c0fb0051300458f1a3acb8ee9789d9b6b26c61ad9bc7919085019061013b565b506002600052600a60209081528151610126917fbff4442b8ed600beeb8e26b1279a0f0d14c6edfaec26d968ee13c86f7d4c2ba8919084019061013b565b505060006006819055600755506101d6915050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061017c57805160ff19168380011785556101a9565b828001600101855582156101a9579182015b828111156101a957825182559160200191906001019061018e565b506101b59291506101b9565b5090565b6101d391905b808211156101b557600081556001016101bf565b90565b61080b806101e56000396000f3006080604052600436106100cf5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632b0579df81146100d45780632d4c5ab9146100fb57806349613c171461011057806349d5540f146101255780634ec0bcf41461018057806383bd72ba146101955780638d98d69d146101aa57806390278ea3146101b25780639e5ef270146101c7578063a7ded5d2146101dc578063b94e0505146101f1578063c92499c61461027b578063d4f77b1c14610290578063e3c057fa14610298575b600080fd5b3480156100e057600080fd5b506100e96102c1565b60408051918252519081900360200190f35b34801561010757600080fd5b506100e96102c8565b34801561011c57600080fd5b506100e96102ce565b34801561013157600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261017e9436949293602493928401919081908401838280828437509497506102d49650505050505050565b005b34801561018c57600080fd5b5061017e610335565b3480156101a157600080fd5b5061017e6103a8565b61017e610438565b3480156101be57600080fd5b5061017e6104ac565b3480156101d357600080fd5b506100e9610502565b3480156101e857600080fd5b506100e961052c565b3480156101fd57600080fd5b50610206610532565b6040805160208082528351818301528351919283929083019185019080838360005b83811015610240578181015183820152602001610228565b50505050905090810190601f16801561026d5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561028757600080fd5b5061017e6105f0565b61017e61065e565b3480156102a457600080fd5b506102ad610707565b604080519115158252519081900360200190f35b6007545b90565b60035490565b60065490565b60015433600160a060020a039081169116146102ef57600080fd5b60015460a060020a900460ff161561030657600080fd5b6005546000908152600a60209081526040909120825161032892840190610747565b5050600580546001019055565b60005433600160a060020a0390811691161461035057600080fd5b60015460a060020a900460ff16151561036857600080fd5b6005546006541061037857600080fd5b6002546003541161038857600080fd5b600254600480548201905560038054919091039055600680546001019055565b6000805433600160a060020a039081169116146103c457600080fd5b60015460a060020a900460ff1615156103dc57600080fd5b6000600354111561040e575060008054600160a060020a03168152600b60205260408120600380548254018255919091555b504260095560006006556001805474ff000000000000000000000000000000000000000019169055565b60005433600160a060020a0390811691161461045357600080fd5b6001805460a060020a900460ff1615151461046d57600080fd5b6000341161047a57600080fd5b6000805473ffffffffffffffffffffffffffffffffffffffff191633600160a060020a03161790556003805434019055565b60006104b733610717565b905060008111156104ff57604051600160a060020a0333169082156108fc029083906000818181858888f193505050501580156104f8573d6000803e3d6000fd5b5060006003555b50565b6001805460009160a060020a90910460ff161515141561052157426009555b506008546009540390565b60045490565b6001805460609160a060020a90910460ff1615151461055057600080fd5b6006546000908152600a602090815260409182902080548351601f6002600019610100600186161502019093169290920491820184900484028101840190945280845290918301828280156105e65780601f106105bb576101008083540402835291602001916105e6565b820191906000526020600020905b8154815290600101906020018083116105c957829003601f168201915b5050505050905090565b60015433600160a060020a0390811691161461060b57600080fd5b60045460001061061a57600080fd5b600154600454604051600160a060020a039092169181156108fc0291906000818181858888f19350505050158015610656573d6000803e3d6000fd5b506000600455565b600254341161066c57600080fd5b60015460a060020a900460ff161561068357600080fd5b60008054600160a060020a0333811673ffffffffffffffffffffffffffffffffffffffff19909216919091178083556001805474ff0000000000000000000000000000000000000000191660a060020a178155346003556006849055600780549091019055426008556009929092556106fc9116610717565b600380549091019055565b60015460a060020a900460ff1690565b600160a060020a0381166000908152600b6020526040812080548210156107415780546000825591505b50919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061078857805160ff19168380011785556107b5565b828001600101855582156107b5579182015b828111156107b557825182559160200191906001019061079a565b506107c19291506107c5565b5090565b6102c591905b808211156107c157600081556001016107cb5600a165627a7a72305820bd79cdefce40706b3f62b5087d0f70e234ae14e4630a2816922ac653da14389a0029";

    protected MapChain(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MapChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<BigInteger> Rating_game() {
        final Function function = new Function("Rating_game",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> current_balance_player() {
        final Function function = new Function("current_balance_player",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> current_step() {
        final Function function = new Function("current_step",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> AddTask(String _task) {
        final Function function = new Function(
                "AddTask",
                Arrays.<Type>asList(new Utf8String(_task)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> update_step() {
        final Function function = new Function(
                "update_step",
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> stopGame() {
        final Function function = new Function(
                "stopGame",
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> add_balance(BigInteger weiValue) {
        final Function function = new Function(
                "add_balance",
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> take_deposit_player() {
        final Function function = new Function(
                "take_deposit_player",
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> Game_time() {
        final Function function = new Function("Game_time",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> current_amount_owner() {
        final Function function = new Function("current_amount_owner",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> Task() {
        final Function function = new Function("Task",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> take_amount_owner() {
        final Function function = new Function(
                "take_amount_owner",
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> joinGame(BigInteger weiValue) {
        final Function function = new Function(
                "joinGame",
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<Boolean> status_game() {
        final Function function = new Function("status_game",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public static RemoteCall<MapChain> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger _price, String _task1, String _task2, String _task3) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Uint256(_price),
                new Utf8String(_task1),
                new Utf8String(_task2),
                new Utf8String(_task3)));
        return deployRemoteCall(MapChain.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<MapChain> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger _price, String _task1, String _task2, String _task3) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Uint256(_price),
                new Utf8String(_task1),
                new Utf8String(_task2),
                new Utf8String(_task3)));
        return deployRemoteCall(MapChain.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static MapChain load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MapChain(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static MapChain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MapChain(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}

