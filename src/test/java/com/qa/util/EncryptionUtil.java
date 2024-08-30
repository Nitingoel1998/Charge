package com.qa.util;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionUtil {

    public static String encriptData(String value) {
       // String plaintext = "Hello World!";
        String encrypted = encryptParam(value);
        System.out.println(encrypted);
        return encrypted;
    }

    public static String encryptParam(String p) {
        try {
            String cipher = "AES/CBC/PKCS5Padding";
            String iv = "gqLOHUioQ0QjhuvI";
            String key = "bbC2H19lkVbQDfaa";

            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipherInstance = Cipher.getInstance(cipher);
            cipherInstance.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

            byte[] encryptedBytes = cipherInstance.doFinal(p.getBytes("UTF-8"));

            String encryptedString = Base64.getEncoder().encodeToString(encryptedBytes);
            encryptedString = encryptedString.replace("/", "-"); // Replace '/' with '-'

            return encryptedString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String dataForEncrypt(String date,String orderID,String paymentOption) {
    	String data="locationID=842564CF-2899-46E3-A191-599E941E8E1D,commChannel=C2461,connID=dev001,dateTime="+date+",enableConsumerChoice=1,enableCashDiscount=0,orderID="+orderID+",checkID=,enableCreditSurcharge=1,enableCreditSurcharge=1,isDepositPay=1,depositAmount=1100,linkID=ENGq58Tc,paymentOption="+paymentOption+"";
        return data;
        //locationID=842564CF-2899-46E3-A191-599E941E8E1D,commChannel=C2461,connID=dev001,dateTime=2024-08-27,enableConsumerChoice=1,enableCashDiscount=0,orderID=40BDE240-B48F-4280-9ECB-67BC3B804535,checkID=,enableCreditSurcharge=1,isDepositPay=1,depositAmount=1100,linkID=ENGq58Tc,paymentOption=BANK_TRANSFER
    }
}