
package des;

import java.util.Scanner;
public class DesDriver {
    public static void main(String[] args) {
        /* plainfile path C:\\Users\\OMAR TAMER\\OneDrive\\Desktop\\plain.txt
           encryptedFile path  C:\\Users\\OMAR TAMER\\OneDrive\\Desktop\\encrypted.txt
           decryptedFile path   C:\\Users\\OMAR TAMER\\OneDrive\\Desktop\\decrypted.txt
         */
        Scanner scan =new Scanner(System.in);
	 System.out.println("enter the key you want\" minimum length of 8 character \"");
                         String key=scan.nextLine();
                         if(key.length()<8){
                             System.out.println("the key length cant be less than 8 characters");
                             System.exit(0);
                         }
    
        DES DesAlgorithm=new DES(key);
        try {
			  			DesAlgorithm.encrypt(key);
                                                DesAlgorithm.decrypt(key);
	
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
