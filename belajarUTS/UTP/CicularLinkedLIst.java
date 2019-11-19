package belajarUTS.UTP;

import java.util.ArrayList;
import java.util.Scanner;

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
        int bTime = getBurstTime();
        if (bTime > quantumTime) {
            bTime = quantumTime;
        }
        int sisa = getBurstTime() - bTime;
        System.out.printf("| %-15s | %-26s | %-15s |\n", getName(), bTime, sisa);
        burstTime = sisa;
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
            head = tail = add;
            tail.next = head;
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
            if (temp.next == remove) {
                if (head == tail) {
                    head = tail = null;
                    size--;
                    break;
                } else if (temp.next == head) {
                    temp.next = temp.next.next;
                    size--;
                    head = temp.next;
                    break;
                } else if (temp.next == tail) {
                    temp.next = temp.next.next;
                    size--;
                    tail = temp.next;
                    break;
                } else {
                    temp.next = temp.next.next;
                    size--;
                    break;
                }
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
        Node temp = head;
        while (temp != null) {
            if (temp.checkBurstTIme() != 0) {
                temp.execute(quantumTime);
            } else {
                remove(temp);
            }
            temp = temp.next;
        }
    }
}

class Solution {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        ArrayList<Process> listofprocess = new ArrayList<Process>();
        int countProccess = sc.nextInt();
        int quantumTime = sc.nextInt();
        String namaProses = "";
        int burstTime;
        for (int i = 0; i < countProccess; i++) {
            namaProses = sc.next();
            burstTime = sc.nextInt();
            Process a = new Process(namaProses, burstTime);
            listofprocess.add(a);
        }
        CircularLinkedList listOfProcess = new CircularLinkedList(listofprocess, quantumTime);
        listOfProcess.run();
        sc.close();
    }
}
