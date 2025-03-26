package edu.trincoll.part3;

public class Tester {
    public static void main(String[] args) {
        // Test with string sequence
        LinkedList<Character> linkedList = new LinkedList<>();
        String inputString = "AAABBBCCCCXXYYDDDD";
        System.out.println("Input String: "+inputString);
        for (char c : inputString.toCharArray()) {
            linkedList.add(c);
        }

        RunLengthEncoder<Character> encoder = new RunLengthEncoder<>();
        LinkedList<Pair<Character, Integer>> encodedResult = encoder.encode(linkedList);
        System.out.println("Encoded Result:");

        Node<Pair<Character, Integer>> current = encodedResult.getHead();
        while (current != null) {
            Pair<Character, Integer> pair = current.data;
            System.out.print(pair.getKey() + "" + pair.getValue() + "");
            //System.out.print(pair.getKey() + pair.getValue() + "");

            current = current.next;
        }

        LinkedList<Character> decodedResult = encoder.decode(encodedResult);
        System.out.print("\nDecoded Result: ");
        Node<Character> currentData = decodedResult.getHead();
        while (currentData != null) {
            System.out.print(currentData.data );
            currentData = currentData.next;
        }
    }
}