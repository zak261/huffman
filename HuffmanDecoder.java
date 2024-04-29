import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.BitSet;

public class HuffmanDecoder {

    // Convertir le fichier compressé en une chaîne de caractères binaires
    public static String getBinaryCode(String compressedFilePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(compressedFilePath));
        StringBuilder binaryStr = new StringBuilder();
        for (byte b : bytes) {
            String binary = Integer.toBinaryString(b & 0xFF);
            while (binary.length() < 8) { // Assurez-vous que chaque byte est représenté par 8 bits
                binary = "0" + binary;
            }
            binaryStr.append(binary);
        }
        return binaryStr.toString();
    }

    // Décode le code binaire en utilisant l'arbre de Huffman
    public static String translateBinaryCode(String binaryCode, Node root, int length) {
        StringBuilder decodedText = new StringBuilder();
        Node currentNode = root;
        for (char bit : binaryCode.toCharArray()) {
            currentNode = bit == '0' ? currentNode.left : currentNode.right;
            if (currentNode.isLeaf()) { // Vérifier si le noeud actuel est une feuille
                decodedText.append(currentNode.character);
                currentNode = root; // Retour à la racine pour le prochain caractère
                if (decodedText.length() == length) break; // Arrêter si la longueur du texte atteint la longueur spécifiée
            }
        }
        return decodedText.toString();
    }

    // Vous pourriez appeler ces méthodes dans votre classe principale ou là où c'est nécessaire.
}
