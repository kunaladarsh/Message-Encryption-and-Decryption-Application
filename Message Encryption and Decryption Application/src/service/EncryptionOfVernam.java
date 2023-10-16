package service;

import java.util.Random;

public class EncryptionOfVernam {
	static char lettreAlphabetTableau[] = {'a','b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '�', '�', '�', '�', '�', '-', '.', '�', ',', ' '};
	static char letterMaskArray[]   = {'a','b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
	static char messageAEncryptTab[];
	static char maskDeEncryptionMessage[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Le chiffrement donne " + calculationEncryptionVernam('d', 'o', lettreAlphabetTableau, letterMaskArray));
		System.out.println("Le chiffrement du mot entier donne " + encryptionMessageAvecVernam("HELLO"));
		
		displayAlphabetWithIndiceInArray(lettreAlphabetTableau);
		System.out.println("\n");
		displayAlphabetWithIndiceInArray(letterMaskArray);
		
	}
	
	static String encryptionMessageAvecVernam(String messageEncrpt) {
		messageAEncryptTab = messageEncrpt.toLowerCase().toCharArray();
		StringBuilder encryptionMessageBuilder = new StringBuilder();
		String maskDeEncryptionGenerator = getSaltString(messageEncrpt.length());
		System.out.println("Le masque de chiffrement generer est : " + maskDeEncryptionGenerator);
		maskDeEncryptionMessage = maskDeEncryptionGenerator.toCharArray();
		for (char l : messageAEncryptTab){
			for (char c : maskDeEncryptionMessage) {
				char a = calculationEncryptionVernam(l, c, lettreAlphabetTableau, letterMaskArray);
				encryptionMessageBuilder.append(a);
			}
        }
        System.out.println(encryptionMessageBuilder.toString());
        
    	return encryptionMessageBuilder.toString();
	}
	
	static String getSaltString(int sizeMessageAEncrypt) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        System.out.println("Taille SALTCHARS " + SALTCHARS.length());
        //String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < sizeMessageAEncrypt) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
	
	static char calculationEncryptionVernam(char letterMessageEncrypt,char letterMask,char letterTab[],char letterMaskTab[]) {
		char myChar = 0;
		int resultat = 0, indiceI, indiceJ;
		if (searchCharInCharArrayAndReturnIndice(letterMessageEncrypt, letterTab) >= 0) {
			if (searchCharInCharArrayAndReturnIndice(letterMask, letterMaskTab) >= 0) {
				indiceI = searchCharInCharArrayAndReturnIndice(letterMessageEncrypt, letterTab);
				indiceJ = searchCharInCharArrayAndReturnIndice(letterMask, letterMaskTab);
				
				System.out.println("Indice I " + indiceI);
				System.out.println("Indice J " + indiceJ);
				
				resultat = indiceI + indiceJ;
				if (resultat > letterMaskTab.length) {
					resultat = resultat - (letterMaskTab.length + 1);
					myChar = letterMaskTab[resultat];
				}else {
					myChar = letterMaskTab[resultat];
				}
			}
		}
        
        return myChar;
	}
	
	static char calculationEncryptionVernam2(char letterMessageEncrypt,char letterMask,char letterTab[],char letterMaskTab[]) {
		char myChar = 0;
		int resultat = 0;
        for (int i = 0; i < letterTab.length; i++) {
        	System.out.println(letterMessageEncrypt);
			if (letterMessageEncrypt == letterTab[i] ) {
				System.out.println(i + " , " + letterTab[i]);
				System.out.println(letterMessageEncrypt);
				for (int j = 0; j < letterMaskTab.length; j++) {
					if (letterMask == letterMaskTab[j]) {
						System.out.println(i + " , " + letterMaskTab[j]);
						resultat = i + j;
						if (resultat > letterMaskTab.length) {
							resultat = resultat - (letterMaskTab.length + 1);
							myChar = letterMaskTab[resultat];
						}else {
							myChar = letterMaskTab[resultat];
						}
						break;
					}
				}
				break;
			}
		}
        return myChar;
	}
	
	static String encryptionMessageAvecVernamOLD(String messageAEncrypt) {
		char lettreAlphabetTableau[] = {'a','b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '�', '�', '�', '�', '�', '-', '.', '�', ',', ' ', '\''};
		char messageAEncryptTab[];
		messageAEncryptTab = messageAEncrypt.toCharArray();
		for (int i = 0; i < lettreAlphabetTableau.length; i++) {
			System.out.println(i);
		}
		System.out.println("Random characters based on size " + messageAEncrypt.length());
		String messageGenerer = getSaltString(messageAEncrypt.length());
		System.out.println("Message generate " + messageGenerer);
		System.out.println("Generate message size " + messageGenerer.length());
		return null;
	}
	
	static int searchCharInCharArrayAndReturnIndice(char c, char letterTab[]) {
		boolean contains = false;
		int indice = -1;
		for (int i = 0; i < letterTab.length; i++) {
			if (letterTab[i] == c) {
		        contains = true;
		        indice = i;
		        break;
		    }
		}
		return indice;
	}
	
	static void displayAlphabetWithIndiceInArray(char alphabetArray[]) {
		for (int i = 0; i < alphabetArray.length; i++) {
			System.out.print(i + "(" + alphabetArray[i] + ") , ");
		}
	}

}
