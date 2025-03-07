package edu.trincoll;
public class DLink {
    Job data;     // The data element is now of type Job
    DLink prev;
    DLink next;

    // Constructor to initialize data and links
    public DLink(Job data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    // Accessor and Mutator methods for data, prev, and next
    public Job getData() {
        return data;
    }

    public void setData(Job data) {
        this.data = data;
    }

    public DLink getPrev() {
        return prev;
    }

    public void setPrev(DLink prev) {
        this.prev = prev;
    }

    public DLink getNext() {
        return next;
    }

    public void setNext(DLink next) {
        this.next = next;
    }
}
