package no.hvl.dat110.rpc;

import java.util.Arrays;


import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] strByte = str.getBytes();

		byte[] encoded = new byte[strByte.length+1];

		encoded[0] = rpcid;


		for (int i = 0; i < strByte.length; i++) {
			encoded[i+1] = strByte[i];
		}
		// TODO: marshall RPC identifier and string into byte array

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded;

		// TODO: unmarshall String contained in data into decoded
		
		decoded = new String(data, 1, data.length-1);

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		

		// TODO: marshall RPC identifier in case of void type

		byte[] encoded = new byte[1];
		encoded[0] = rpcid;

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		// TODO: marshall RPC identifier and string into byte array

		byte[] encoded = new byte[5];

		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.putInt(x);
		byte[] intByte = bb.array();

		for (int i = 0; i < 4; i++) {
			encoded[i+1] = intByte[i];
		}

		encoded[0] = rpcid;

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		byte[] bX = new byte[data.length - 1];
		
		for(int i = 0; i < bX.length; i++) {
			bX[i] = data[i+1];
		}
		
		decoded = ByteBuffer.wrap(bX).getInt();
		return decoded;

	}
}
