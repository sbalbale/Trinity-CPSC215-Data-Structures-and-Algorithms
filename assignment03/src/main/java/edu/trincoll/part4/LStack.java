package edu.trincoll.part4;
class LStack implements Stack {
    private Link top;          // Pointer to first element
    private int size;        // Number of elements

    // Constructors
    public LStack() {
        top = null;
        size = 0;
    }

    public LStack(int size) {
        top = null;
        this.size = 0;
    }

    // Reinitialize stack
    public void clear() {
        top = null;
        size = 0;
    }

    // Put "it" on stack
    public void push(char it) {
        top = new Link(it, top);
        size++;
    }

    // Remove "it" from stack
    public char pop() {
    if (top == null) {
        throw new RuntimeException("Stack is empty");
    }
    char it = top.element();
    top = top.next();
    size--;
    return it;
}


    // Return top value
    public char topValue() {
        assert top != null : "Stack is empty";
        return top.element();
    }

    // Return stack length
    public int length() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Generate a human-readable representation of this stack's contents
    // that looks something like this: < 1 2 3 >.
    // This method uses toString() on the individual elements.
    public String toString() {
        StringBuilder out = new StringBuilder((length() + 1) * 4);
        out.append("< ");
        Link temp = top;
        while (temp != null) {
            out.append(temp.element());
            out.append(" ");
            temp = temp.next();
        }
        out.append(">");
        return out.toString();
    }
}
