import java.util.Scanner;

public class xor_encryption {
    public static void main(String[] args) {
            try (Scanner input = new Scanner(System.in)) {
                System.out.print("password to encrypt or decrypt: ");
                String password = input.nextLine();
                
                System.out.print("Cryptography key (interger value from 1 to 2147483647): ");
                int chave = input.nextInt();


                char[] chars = password.toCharArray();
                String crypto = "";
                for(char c: chars){
                    int ascii = (int) c;
                    int new_code = ascii ^ chave;
                    if(new_code == 127 || new_code < 33 || ascii < 33){
                        crypto = crypto + c;
                    }
                    else{
                        crypto = crypto + (char) new_code;
                    }
                }
                System.out.println("Your encrypted password is:" + crypto);
                System.out.println("Remember you key, it will be necessary to decrypt the password later");
            }
        }
    }

