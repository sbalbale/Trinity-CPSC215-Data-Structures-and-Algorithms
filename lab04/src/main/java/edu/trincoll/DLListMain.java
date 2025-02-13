package edu.trincoll;
/**
 * Main class to test the DLList implementation.
 */
public class DLListMain {
    public static void main(String[] args) {
        DLList<Integer> list = new DLList<>();

        System.out.println("### Testing DLList Implementation ###");

        // Test append()
        System.out.println("\nAppending elements: 10, 20, 30");
        list.append(10);
        list.append(20);
        list.append(30);
        displayList(list);

        // Test insert()
        System.out.println("\nInserting 15 at current position");
        list.moveToPos(1);
        list.insert(15);
        displayList(list);

        // Test remove()
        System.out.println("\nRemoving current element: " + list.getValue());
        list.remove();
        displayList(list);

        // Test moveToStart() and moveToEnd()
        System.out.println("\nMoving to start");
        list.moveToStart();
        System.out.println("Current element: " + list.getValue());

        System.out.println("\nMoving to end");
        list.moveToEnd();
        System.out.println("Current element: " + list.getValue());

        // Test prev() and next()
        System.out.println("\nMoving to previous");
        list.prev();
        System.out.println("Current element: " + list.getValue());

        System.out.println("\nMoving to next");
        list.next();
        System.out.println("Current element: " + list.getValue());

        // Test moveToPos()
        System.out.println("\nMoving to position 1");
        list.moveToPos(1);
        System.out.println("Current element: " + list.getValue());

        // Test clear()
        System.out.println("\nClearing list...");
        list.clear();
        displayList(list);


        // Checking new methods
        System.out.println("### Testing new methods in the DLList Implementation ###");

        // Test append()
        System.out.println("\nAppending elements: 10, 20, 30, 40, 50");
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);
        displayList(list);

        // Test removeFirst()
        System.out.println("\nRemoving first element");
        list.removeFirst();
        displayList(list);

        // Test removeLast()
        System.out.println("\nRemoving last element");
        list.removeLast();
        displayList(list);

        // Test insertAtPosition()
        System.out.println("\nInserting 25 at position 1");
        list.insertAtPosition(1, 25);
        // list.insertAtPosition(2, 27);
        displayList(list);

        // Test findMiddle()
        System.out.println("\nMiddle element: " + list.findMiddle());

        // Test displayEvenElements()
        System.out.println("\nDisplaying even-indexed elements:");
        list.displayEvenElements();

        // Test removeDuplicates()
        System.out.println("");
        System.out.println("\nAppending duplicate elements: 20, 30, 40");
        list.append(20);
        list.append(30);
        list.append(40);
        displayList(list);

        System.out.println("\nRemoving duplicates");
        list.removeDuplicates();
        displayList(list);

        // Test bubbleSort()
        System.out.println("\nSorting the list using bubble sort");
        list.bubbleSort();
        displayList(list);

        // Test reverse()
        System.out.println("\nReversing the list");
        list.reverse();
        displayList(list);

          }


    /**
     * Utility method to display the list elements.
     */
    private static void displayList(DLList<Integer> list) {
        System.out.print("List elements: ");
        list.moveToStart();
        for (int i = 0; i < list.length(); i++) {
            System.out.print(list.getValue() + " ");
            list.next();
        }
        System.out.println("\nCurrent length: " + list.length());
    }
}