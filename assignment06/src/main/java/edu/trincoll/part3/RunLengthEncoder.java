package edu.trincoll.part3;

// Note: You cannot use java.util package 

class RunLengthEncoder<E> {

    /**
     * Encodes a linked list using run-length encoding.
     * Consecutive elements that are the same are represented as a pair of the element
     * and the count of its occurrences.
     *
     * @param list The linked list to encode.
     * @return A linked list of pairs, where each pair contains an element and its count.
     *         If the input list is empty, an empty linked list is returned.
     */
    public LinkedList<Pair<E, Integer>> encode(LinkedList<E> list) {
        LinkedList<Pair<E, Integer>> encodedList = new LinkedList<>();
        
        // Return an empty list if the input list is empty
        if (list.size() == 0) {
            return encodedList;
        }

        // Initialize variables to track the current element and its count
        Node<E> current = list.getHead();
        E currentData = current.data;
        int count = 1;

        // Traverse the linked list to perform run-length encoding
        while (current.next != null) {
            current = current.next;
            if (current.data.equals(currentData)) {
                // Increment count if the current element matches the previous one
                count++;
            } else {
                // Add the current element and its count to the encoded list
                encodedList.add(new Pair<>(currentData, count));
                currentData = current.data; // Update to the new element
                count = 1; // Reset count
            }
        }

        // Add the last element and its count to the encoded list
        encodedList.add(new Pair<>(currentData, count));
        return encodedList;
    }

    /**
     * Decodes a run-length encoded linked list back to its original form.
     * Each pair in the encoded list is expanded into the original elements based on the count.
     *
     * @param encodedList The run-length encoded linked list to decode.
     * @return A linked list containing the original elements before encoding.
     */
    public LinkedList<E> decode(LinkedList<Pair<E, Integer>> encodedList) {
        LinkedList<E> decodedList = new LinkedList<>();
        
        // Traverse the encoded list to reconstruct the original list
        Node<Pair<E, Integer>> current = encodedList.getHead();
        while (current != null) {
            Pair<E, Integer> pair = current.data;

            // Add the element to the decoded list 'count' times
            for (int i = 0; i < pair.getValue(); i++) {
                decodedList.add(pair.getKey());
            }

            current = current.next; // Move to the next pair
        }

        return decodedList;
    }
}