import java.io.File;
import java.io.IOException;

public class CompressionMetrics {

    // Méthode pour obtenir la taille d'un fichier
    public static long getFileSize(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new IOException("Le fichier n'existe pas : " + path);
        }
        return file.length(); // Retourne la taille du fichier en octets
    }

    // Méthode pour calculer et obtenir le taux de compression
    public static double getCompressionRate(String compressedFilePath, String normalFilePath) throws IOException {
        long compressedFileSize = getFileSize(compressedFilePath);
        long normalFileSize = getFileSize(normalFilePath);

        // Assurez-vous que la taille du fichier normal n'est pas zéro pour éviter la division par zéro
        if (normalFileSize == 0) {
            throw new ArithmeticException("La taille du fichier original est zéro, ce qui rend le calcul du taux de compression impossible.");
        }

        return (double) compressedFileSize / normalFileSize;
    }
}
