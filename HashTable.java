/**
 * A simple hasht table is an array of linked lists. In its simplest form, a
 * linked list is represented by its first node. Typically we label this node as
 * "head". Here, however, we'll know it's the first node of the list because it
 * will be placed in an array element. For example, if we have 4 linked lists,
 * we know that the "head" of the third one can be found in position [2] of the
 * underlying array.
 */
public class HashTable<E extends Comparable<E>> {

    /**
     * Underlying array of nodes. Each non empty element of this array is the first
     * node of a linked list.
     */
    private Node[] underlying;

    /**
     * Default size for the underlying array. Users may specify any size, but the
     * default constructor will use this size.
     */
    private static final int DEFAULT_SIZE = 4;

    /** Basic constructor with user-specified size */
    public HashTable(int size) {
        this.underlying = new Node[size];
    }

    /** Default constructor, passes defauilt size to basic constructor */
    public HashTable() {
        this(DEFAULT_SIZE);
    }

    /**
     * Adds a node, with the specified content, to a linked list in the underlying
     * array.
     * 
     * @param content E The content of a new node, to be placed in the array.
     */
    public void add(E content) {
        Node<E> newNode = new Node <>(content);  //Making a new node with current contents

        //taking hash code and converting to an index
        int hash = content.hashCode();
        int index = Math.abs(hash % this.underlying.length);

        //Making it so if index is empty then placing a new mode within
        if (underlying[index] == null) {
            underlying[index] = newNode;
        } else {
            //linking a current mode in front if already exist 
            newNode.setNext(underlying[index]);
            underlying[index] = newNode;
        }

        // COMPLETE THIS METHOD
    } public String toString() {
        String result = "";

        //Reviewing each position in the array
        for (int i = 0; i < this.underlying.length; i++) {
            result += i + ": ";

            Node<E> current = underlying[i];

            if (current == null) {
                result += "null\n";
            } else {
                while (current != null){
                    result += current.toString();
                    if (current.hasNext()) {
                        result += " -> ";
                    }
                    current = current.getNext();
                }
                result += "\n";
            }

        }
        return result;
    }

} // class HashTable
