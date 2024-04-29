public class Main {

    public static void main(String[] args) {
        try {
            String alphabetFilePath = "chemin/vers/le/fichier/alphabet.txt";
            String compressedFilePath = "chemin/vers/le/fichier/comprime.bin";
            String decompressedFilePath = "chemin/vers/le/fichier/decomprime.txt";
            
            // Obtention de l'arbre de Huffman à partir du fichier de l'alphabet
            BinaryTree huffmanTree = HuffmanTreeBuilder.createHuffmanTreeFromFile(alphabetFilePath);
            
            // Décompression du texte
            String finalText = HuffmanDecoder.decodeCompressedFile(compressedFilePath, huffmanTree);
            
            // Écriture du texte décompressé dans un fichier
            writeDecompressedFile(finalText, decompressedFilePath);
            
            // Calcul et affichage du taux de compression
            double compressionRate = CompressionMetrics.getCompressionRate(compressedFilePath, decompressedFilePath);
            System.out.println("Le fichier compressé contient " + (1.0 / compressionRate) + " caractères/octets.");
            System.out.println("Le taux de compression est de " + (compressionRate * 100) + "%.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeDecompressedFile(String text, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(text);
        writer.close();
    }
}
