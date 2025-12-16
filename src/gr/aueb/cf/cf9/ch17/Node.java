package gr.aueb.cf.cf9.ch17;

/**
 * Οριζει μια κλαση {@link Node}
 * με ενα μονο πεδιο int
 */
public class Node {

    private int value;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
