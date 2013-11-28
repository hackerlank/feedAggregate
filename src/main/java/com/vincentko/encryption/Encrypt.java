package com.vincentko.encryption;
 
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
 
public class Encrypt {

	public Encrypt() {};

    public void encryptPass() throws Exception {
    	StrongPasswordEncryptor encryptor2 = new StrongPasswordEncryptor();
    	String password2 = encryptor2.encryptPassword("linda");
    	System.out.println("Password encrypted by String password encryptor: "
    	+ password2);
    }

}