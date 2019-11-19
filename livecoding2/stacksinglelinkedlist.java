package livecoding2;

import java.util.EmptyStackException;

class node {
    String data;
    node next;

    node() {
    }

    node(String data) {
        this.data = data;
    }

    node(String data, node next) {
        this.data = data;
        this.next = next;
    }
}

public class stacksinglelinkedlist {
    node head, tail, top;

    void inisialisasi() {
        this.head = this.tail = this.top = null;
    }

    boolean isEmpty() {
        return (top == null);
    }

    String popStack() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            String tampungData = top.data;
            removeLast();
            top = tail;
            return tampungData;
        }
    }

    void pushStack (node baru){
        addLast (baru);
        top = tail ;
    }

    String peek (){
        return top.data ;
    }

    void addLast (node input){
        if (isEmpty()){
            head = tail = input ;
        } else {
            tail.next = input ;
            tail = input ;
        }
    }

    void removeLast() {
        node temp = head;
        if (head == tail) {
            head = tail = null;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            temp = null;
        }
    }

    String undo (){
        return popStack();
    }
}
