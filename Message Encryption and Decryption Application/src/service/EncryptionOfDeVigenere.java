package service;

public class EncryptionOfDeVigenere {
	public static final String alphabet = new String("azertyuiopqsdfghjklmwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN0123456789+-*/=&�\"'(-�_��)^��������$��*�%�!�:/;.,? �~#{[|`\\@]}\t\n<>�" + "���������".toUpperCase());
	public static final int tailleAlphabet = alphabet.length();
	
	public static String encryptWithVigenere(String messageAEncrypt, String EncrpytionKey) {
		String messageEncrypt = new String();
		int i = 0;
		for (i = 0; i < messageAEncrypt.length(); i++) {
		      int j = alphabet.indexOf(messageAEncrypt.charAt(i));
		      if (j >= 0) {
		        j = (j + alphabet.indexOf(EncrpytionKey.charAt(i % EncrpytionKey.length())) + 1) % tailleAlphabet;
		        messageEncrypt = messageEncrypt + alphabet.charAt(j);
		      }
		      else {
		    	  messageEncrypt = messageEncrypt + messageAEncrypt.charAt(i);
		      }
		    }
		
		return messageEncrypt;
	}
	
	public static String deencryptWithVigenere(String messageADecrypt, String EncrpytionKey) {
		String messageEncrypt = new String();
		int i = 0;
		for (i = 0; i < messageADecrypt.length(); i++) {
		      int j = alphabet.indexOf(messageADecrypt.charAt(i));
		      if (j >= 0) {
		        j = (j - alphabet.indexOf(EncrpytionKey.charAt(i % EncrpytionKey.length())) - 1) % tailleAlphabet;
		        while (j < 0) {
		          j += tailleAlphabet;
		        }
		        messageEncrypt = messageEncrypt + alphabet.charAt(j);
		      }
		      else {
		    	messageEncrypt = messageEncrypt + messageADecrypt.charAt(i);
		      }
		    }
		return messageEncrypt;
	}
	
	public static boolean checkIfKeyOfCryptageIsInvalid(String EncrpytionKey) {
		for (int i = 0; i < EncrpytionKey.length(); i++) {
			if (alphabet.indexOf(EncrpytionKey.charAt(i)) == -1) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String EncrpytionKey = "lol";
		if (!checkIfKeyOfCryptageIsInvalid(EncrpytionKey)) {
			System.out.println(encryptWithVigenere("12345678", EncrpytionKey));
		}
		System.out.println(encryptWithVigenere("12345678", EncrpytionKey));
		System.out.println(deencryptWithVigenere("HUm�p�S�xHkSx|", EncrpytionKey));

	}

}
