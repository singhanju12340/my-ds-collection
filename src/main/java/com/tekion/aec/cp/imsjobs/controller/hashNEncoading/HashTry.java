package com.tekion.aec.cp.imsjobs.controller.hashNEncoading;

//import org.apache.tomcat.util.security.MD5Encoder;
//import sun.security.provider.MD5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author anju
 * @created on 23/10/24 and 7:13 PM
 */
public class HashTry {

    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0]=1;
        int[] suffix = new int[nums.length];
        suffix[nums.length-1]=1;

        for(int i=1;i<nums.length;i++){
            prefix[i] = prefix[i-1]* nums[i-1];
            suffix[nums.length-1-i] = suffix[nums.length-i] * nums[nums.length-i];
        }

        for(int i=0;i<nums.length;i++){
            prefix[i] = prefix[i]*suffix[i];
        }

        return prefix;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = "Hello, World!";
        String a = "anjum";
        a.substring(0,3);
        String b = "a";
        System.out.println(b.charAt(0)-0);

        MessageDigest md = MessageDigest.getInstance("MD5");
        MessageDigest md1 = MessageDigest.getInstance("SHA-1");
        MessageDigest md2 = MessageDigest.getInstance("MD5");

        //[72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100, 33]
        //[101, -88, -30, 125, -120, 121, 40, 56, 49, -74, 100, -67, -117, 127, 10, -44]

        // Compute the MD5 hash
        byte[] messageDigest = md1.digest(input.getBytes());

        // Convert the byte array into a hexadecimal format
        BigInteger no = new BigInteger(1, messageDigest);
        String hashText = no.toString(16);

        // Add leading zeros to make the hash 32 characters long (if necessary)
        while (hashText.length() < 32) {
            hashText = "0" + hashText;
        }
//        65a8e27d8879283831b664bd8b7f0ad4
//        65a8e27d8879283831b664bd8b7f0ad4
        //a0a9f2a6772942557ab5355d76af442f8f65e01

        System.out.println("MD5 hash of '" + input + "' is: " + hashText);

    }
}
