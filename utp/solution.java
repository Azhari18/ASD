package utp;

import java.util.*;
class Node {

    private Process process;
    Node next;

    public Node(Process process) {
        this.process = process;
    }

    public void execute(int quantumTime) {
        this.process.execute(quantumTime);
    }

    public int checkBurstTIme() {
        return this.process.getBurstTime();
    }

}

class Process {

    private String name;
    private int burstTime;
    private int sisaBurstTime;

    public Process(String name, int burstTime) {
        this.name = name;
        this.burstTime = burstTime;
    }

    public String getName() {
        return name;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void execute(int quantumTime) {
        sisaBurstTime = burstTime - quantumTime;
    }

}

class CircularLinkedList {

    private Node head = null;
    private Node tail = null;
    private int size;
    private int quantumTime;

    public CircularLinkedList(ArrayList<Process> processes, int quantumTime) {
        this.quantumTime = quantumTime;
        this.size = 0;
        this.initialization(processes);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void add(Node add) {
        if (isEmpty()) {
            head = add;
            tail = add;
            add.next = add;
        } else {
            tail.next = add;
            tail = add;
            tail.next = head;
        }
        size++;

    }

    public void remove(Node remove) {
        Node temp = head;
        while (temp != null){
            if (temp.next.equals(remove)){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

    public void initialization(ArrayList<Process> processes) {
        processes.forEach(process -> {
            Node add = new Node(process);
            this.add(add);
        });
    }

    public void run() {
        System.out.printf("| %-15s | %-26s | %-15s |\n", "Nama Proses", "Burst Time yang Dieksekusi",
                "Sisa Burst Time");
        System.out.println("------------------------------------------------------------------");


    }

}

class Solution{

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        ArrayList<Process> listofprocess = new ArrayList<Process>();

        String[] A = sc.nextLine().split(" ");
        int countProccess = Integer.parseInt(A[0]);
        int quantumTime = Integer.parseInt(A[1]);

        CircularLinkedList listOfProcess = new CircularLinkedList(listofprocess, quantumTime);

        String[] B = sc.nextLine().split(" ");

        for (int i = 0; i < countProccess; i++){

        }

        listOfProcess.run();
        sc.close();
    }

}
