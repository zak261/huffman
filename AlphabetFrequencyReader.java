import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AlphabetReader {

    // Méthode pour extraire la fréquence à partir d'une ligne du fichier
    public static int extractFrequency(String line) {
        String frequencyPart = line.substring(2);
        return Integer.parseInt(frequencyPart.trim());
    }

    // Méthode pour créer un dictionnaire avec l'alphabet et les fréquences
    public static Map<String, Integer> createAlphabetDictionary(List<String> fileLines) {
        Map<String, Integer> dictionary = new HashMap<>();
        int length = 0;

        // On commence à l'indice 1 car l'indice 0 contient la taille de l'alphabet
        for (int i = 1; i < fileLines.size(); i++) {
            int frequency = extractFrequency(fileLines.get(i));
            length += frequency;
            dictionary.put(Character.toString(fileLines.get(i).charAt(0)), frequency);
        }

        return dictionary;
    }

    // Méthode pour lire le fichier et obtenir l'alphabet et les fréquences
    public static Map<String, Integer> readAlphabetFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<String> fileLines = reader.lines().collect(Collectors.toList());
        reader.close();

        return createAlphabetDictionary(fileLines);
    }

    // Méthode pour obtenir la longueur totale des fréquences, ce qui représente la longueur du texte décodé
    public static int getTotalLength(Map<String, Integer> dictionary) {
        return dictionary.values().stream().mapToInt(Integer::intValue).sum();
    }
}
