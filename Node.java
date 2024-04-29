public class Node {

    // Déclaration des propriétés du Node
    char label; // Le label est un caractère
    int frequency; // La fréquence est un entier
    Node leftChild; // Le fils gauche peut être un autre Node ou null
    Node rightChild; // Le fils droit peut être un autre Node ou null

    /**
     * Constructeur pour créer un nouveau noeud.
     *
     * @param label Le label du noeud.
     * @param frequency La fréquence du label.
     * @param leftChild Le fils gauche du noeud.
     * @param rightChild Le fils droit du noeud.
     */
    public Node(char label, int frequency, Node leftChild, Node rightChild) {
        this.label = label;
        this.frequency = frequency;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /**
     * Méthode pour afficher le noeud sous forme de chaîne de caractères.
     *
     * @return La représentation en chaîne de caractères du noeud.
     */
    @Override
    public String toString() {
        return Character.toString(label);
    }

    /**
     * Méthode pour déterminer si le noeud est une feuille.
     *
     * @return true si le noeud est une feuille, sinon false.
     */
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }
}
