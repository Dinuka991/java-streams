package LinkedList;

public class LinkedList {

    Node head;

    // Method to add a new node to the end of the linked list
    public void add(int data) {
        Node newNode = new Node(data); // Create a new node with the given data

        // If the list is empty, set the new node as the head
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse to the end of the list
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Link the last node to the new node
        temp.next = newNode;
    }

    // Optional: Method to print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);

        // Print the linked list to verify
        list.printList(); // Output: 10 -> 20 -> 30 -> null
    }
}
