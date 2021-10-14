package challenge;

// https://evandromurilo.com/2016/04/08/codigo-da-cifra-de-cesar-em-java/
public class CriptografiaCesariana implements Criptografia {

    public static String encrypt(String text, int key) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("\n" + "Text cannot be empty");
        }
        String lowerCase = text.toLowerCase();
        String cipherText = "";
        for (int i = 0; i < lowerCase.length(); i++) {
            cipherText += encrypt(lowerCase.charAt(i), key);
        }
        return cipherText;
    }

    public static char encrypt(char originalChar, int key) {
        char cipherChar;
        if (originalChar >= 97 && originalChar <= 122) {
            cipherChar = (char) ((originalChar - 97 + key) % 26 + 97);
        }
        else {
            cipherChar = originalChar;
        }
        return cipherChar;
    }

    @Override
    public String criptografar(String texto) {
        return encrypt(texto, 3);
    }

    @Override
    public String descriptografar(String texto) {
        return encrypt(texto, -3);
    }
}
