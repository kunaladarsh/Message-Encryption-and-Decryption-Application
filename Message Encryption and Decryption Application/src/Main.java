import service.EncryptionService;

public class Main {
	
	public static void main(String[] args) {
		EncryptionService service = new EncryptionService();
		System.out.println("Le texte chiffr� est : " + service.algoEncryptionText("open campus"));
		System.out.println("Le texte chiffr� est : " + service.algoDecryptionText("ayoh4jtdyuc"));
	}
	
}
