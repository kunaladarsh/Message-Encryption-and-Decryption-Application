package service;

public class EncryptionService {
	
	/*
	 * Pour le chiffrement des dix caract�res sp�ciaux que j'ai choisie � � � � � - . � , espace, '
	 * Je les chiffre en entier de 0 � 9 mais de fa�on invers� sans logique
	 * 0123456789 => 9180726354 dont � est 9 et � est 1 ainsi de suite...
	 * le caract�re ' est �
	 */
	private char lettreAlphabetTable[] = {'a','b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '�', '�', '�', '�', '�', '-', '.', '�', ',', ' ', '\''};
    private char lettreAlphabetTablePermuter[] = {'t', 'g', 'j', 'p', 'o', 'i', 'z', 's', 'k', 'b', 'v', 'm', 'd', 'h', 'a', 'y', 'w', 'f', 'c', 'q', 'u', 'x', 'n', 'r', 'l', 'e', '9', '1', '8', '0', '7', '2', '6', '3', '5', '4', '�'};
    private char wordEncryptTab[];
    
    public String algoEncryptionText(String textAEncrypt) {
    	
    	wordEncryptTab = textAEncrypt.toCharArray();
    	StringBuilder myWordEncryptBuilder = new StringBuilder();
    	
        for (char l : wordEncryptTab){
            char a = charISPresentEncryption(l,lettreAlphabetTable,lettreAlphabetTablePermuter);
            myWordEncryptBuilder.append(a);
        }
        System.out.println(myWordEncryptBuilder.toString());
        
    	return myWordEncryptBuilder.toString();
    }
    
    public String algoDecryptionText(String textADecrypt) {
    	wordEncryptTab = textADecrypt.toCharArray();
    	StringBuilder mywordDecryptBuilder = new StringBuilder();
    	
        for (char l : wordEncryptTab){
            char a = charISPresentDecryption(l,lettreAlphabetTablePermuter,lettreAlphabetTable);
            mywordDecryptBuilder.append(a);
        }
        System.out.println(mywordDecryptBuilder.toString());
        
    	return mywordDecryptBuilder.toString();
    }
	
	private char charISPresentEncryption(char letter,char letterTab[],char letterPermuteTab[]){
        char myChar = 0;
        for (int i = 0; i < letterTab.length; i++) {
            if (letterTab[i] == letter) {
                for (int j = 0;j < letterPermuteTab.length; j++){
                    j = i;
                    myChar = letterPermuteTab[j];
                    System.out.println("My char est " + myChar);
                    System.out.println(letterTab[i] + " permuter donne " + letterPermuteTab[j]);
                    break;
                }
                break;
            }
        }
        return myChar;
    } 
	
	private char charISPresentDecryption(char letter,char letterPermuteTab[],char letterTab[]){
        char myChar = 0;
        for (int i = 0; i < letterPermuteTab.length; i++) {
            if (letterPermuteTab[i] == letter) {
                for (int j = 0;j < letterTab.length;j++){
                    j = i;
                    myChar = letterTab[j];
                    System.out.println("My char est " + myChar);
                    System.out.println(letterPermuteTab[i] + " dechiffrer donne " + letterTab[j]);
                    break;
                }
                break;
            }
        }
        return myChar;
    }
}
