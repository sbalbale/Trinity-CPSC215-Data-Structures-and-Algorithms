package edu.trincoll.part4;
class Link {
    private char element;        // Value for this node
    private Link next;     // Pointer to next node in list

    // Constructors
    Link(char c, Link nextval) {
        element = c;
        next = nextval;
    }

    Link(Link nextval) {
        next = nextval;
    }

    Link next() {
        return next;
    }

    void setNext(Link nextval) {
        next = nextval;
    }

    char element() {
        return element;
    }

    void setElement(char it) {
        element = it;
    }
}
