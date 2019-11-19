package bab1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayID<E> {
    private int size;
    private int[] data;

    public ArrayID(int n) {
        buatLarik(n);
    }

    public void buatLarik(int n) {
        this.size = n;
        this.data = new int[n];

    }

    public void setItem(int index, int value) {
        this.data[index] = value;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.data);
    }

    public int getSize() {
        return this.size;
    }

    public int getPost(int value) {
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int getMax() {
        int max = this.data[0];
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] > max) {
                max = this.data[i];
            }
        }
        return max;
    }
    public int getMin() {
        int min = this.data[0];
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] < min) {
                min = this.data[i];
            }
        }
        return min;
    }



    public static void main(String[] args) {
        ArrayID arrayID = new ArrayID(4);
        arrayID.setItem(3, 10);
        arrayID.setItem(2, 15);
        arrayID.setItem(1, 15);
        arrayID.setItem(0, 5);
        System.out.println(arrayID);
    }
}
