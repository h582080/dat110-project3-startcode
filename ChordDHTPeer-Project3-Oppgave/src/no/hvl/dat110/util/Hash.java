package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity) throws NoSuchAlgorithmException{		
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
		
		MessageDigest md = MessageDigest.getInstance("MD5");	
			
		// compute the hash of the input 'entity'
		
		byte[] bytesOfEntity = entity.getBytes();
		
		byte[] digest = md.digest(bytesOfEntity);
		
		
		// convert the hash into hex format
		String hashHex = toHex(digest);
		
		// convert the hex into BigInteger
		hashint = new BigInteger(hashHex, 16);
		
		// return the BigInteger
		
		return hashint;
	}
	
	public static BigInteger addressSize() throws NoSuchAlgorithmException{
		
		// Task: compute the address size of MD5

	    MessageDigest md = MessageDigest.getInstance("MD5");	
		
		byte[] digest = md.digest();
		
		// get the digest length
		int digestLength = digest.length;
		
		// compute the number of bits = digest length * 8
		int bits = digestLength*8;
		
		// compute the address size = 2 ^ number of bits
		int adresseSize = 2^bits;
		
		// return the address size		
		BigInteger adresseSizeB = BigInteger.valueOf(adresseSize);
		
		return adresseSizeB;

	}
	
	public static int bitSize() throws NoSuchAlgorithmException{
		
		// find the digest length	
		MessageDigest md = MessageDigest.getInstance("MD5");
	 
		byte [] digest = md.digest();
		
		int digestlen = digest.length;
			
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
