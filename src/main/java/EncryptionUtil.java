import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionUtil {

    public static void main(String[] args) {
        String plaintext = "Hello World!";
        String encrypted = encryptParam(plaintext);
        System.out.println("Encrypted: " + encrypted);
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
}