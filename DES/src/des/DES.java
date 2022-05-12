
package des;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.util.*;
public class DES {
 Scanner scan =new Scanner(System.in);
    String key;
    public DES(String key){
        
        this.key=key;
        
    }
   public  void encrypt(String key) throws Throwable {
	           System.out.println("enter the path of the plainfile");
                   String x =scan.nextLine();
                   System.out.println("enter the path of the encryptedfile");
                   String y =scan.nextLine();
                   File is=new File(x);
                   File os =new File(y);
            encryptOrDecrypt(key, Cipher.ENCRYPT_MODE, is, os);
	}

	public  void decrypt(String key) throws Throwable {
		System.out.println("enter the path of the encryptedFile");
                   String x =scan.nextLine();
                   System.out.println("enter the path of the decryptedfile");
                   String y =scan.nextLine();
                   File is=new File(x);
                   File os =new File(y);
            encryptOrDecrypt(key, Cipher.DECRYPT_MODE, is, os);
	}

	public static void encryptOrDecrypt(String key, int mode, File is, File os) throws Throwable {

	FileInputStream fis = new FileInputStream(is);
			FileOutputStream fos = new FileOutputStream(os);	
            DESKeySpec dks = new DESKeySpec(key.getBytes());
		SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
		SecretKey desKey = skf.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES"); 

		if (mode == Cipher.ENCRYPT_MODE) {
			cipher.init(Cipher.ENCRYPT_MODE, desKey,SecureRandom.getInstance("SHA1PRNG"));
			CipherInputStream cis = new CipherInputStream(fis, cipher);
			doCopy(cis, fos);
                        System.out.println("encryption done");
		} else if (mode == Cipher.DECRYPT_MODE) {
			cipher.init(Cipher.DECRYPT_MODE, desKey,SecureRandom.getInstance("SHA1PRNG"));
			CipherOutputStream cos = new CipherOutputStream(fos, cipher);
			doCopy(fis, cos);
                        System.out.println("decryption done");
		}
	}

	public static void doCopy(InputStream is, OutputStream os) throws IOException {
		byte[] bytes = new byte[64];
		int numBytes;
		while ((numBytes = is.read(bytes)) != -1) {
			os.write(bytes, 0, numBytes);
		}
		
		os.close();
		is.close();
	}

    
}
