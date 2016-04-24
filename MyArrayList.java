/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

/**
 *
 * @author Oyla
 */
class MyArrayList {

    private int[] data;
    private int size = 0;
    private int capacity = 10;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int capacity) {
        setCapacity(capacity);
    }

    /**
     * @return the data
     */
    public int[] getData() {
        int[] newData = new int[size];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        return newData;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param data the data to set
     */
    public void setData(int... data) {
        ensureCapacity(data.length);
        for (int i = 0; i < data.length; i++) {
            this.data[i] = data[i];
        }
        size = data.length;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        if (isEmpty()) {
            if (capacity <= size) {
                capacity = 10;
            }
            data = new int[capacity];
            this.capacity = capacity;

        } else if (capacity <= size) {
            trimToSize();
        } else {
            this.capacity = capacity;
            overwriteData(capacity);
        }
    }

    /**
     * print array
     */
    public String print() {
        String s = "";
        if (isEmpty()) {
            s += "Collection is empty.";
        } else {
            for (int i = 0; i < size; i++) {
                s += data[i] + " ";
            }
            s += "\n";
        }
        return s;
    }

    private void ensureCapacity(int arrLength) {
        if (arrLength > capacity) {
            int newLength = (arrLength * 3) / 2 + 1;
            setCapacity(newLength);
        }
    }

    public void pushBack(int value) {
        insert(size, value);
    }

    public void pushFront(int value) {
        insert(0, value);
    }

    public void insert(int index, int value) {
        ensureCapacity(size + 1);
        if (index < size) {
            for (int i = size; i > index; i--) {
                data[i] = data[i - 1];
            }
        }
        data[index] = value;
        size++;
    }

    public boolean removeAt(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            size--;
            return true;
        }
        return false;
    }

    public boolean remove(int value) {
        boolean removeValue = false;
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                removeAt(i);
                removeValue = true;
            }
        }
        return removeValue;
    }

    public boolean popFront() {
        return removeAt(0);
    }

    public boolean popBack() {
        return removeAt(size - 1);
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = 0;
        }
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void trimToSize() {
        capacity = size;
        overwriteData(size);
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int value) {
        for (int i = size - 1; i >= 0; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void reverse() {
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[size - 1 - i] = data[i];
        }
        data = temp;
    }

    public void sortAsc() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (data[i] > data[j]) {
                    data[i] += data[j];
                    data[j] = data[i] - data[j];
                    data[i] -= data[j];
                }
            }
        }
    }

    public void sortDesc() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (data[i] < data[j]) {
                    data[i] += data[j];
                    data[j] = data[i] - data[j];
                    data[i] -= data[j];
                }
            }
        }
    }

    public void shuffle() {
        int rand;
        for (int i = 0; i < size; i++) {
            rand = (int) (Math.random() * (size - i) + i);
            if (rand != i) {
                data[i] += data[rand];
                data[rand] = data[i] - data[rand];
                data[i] -= data[rand];
            }
        }
    }

    public void randomFill() {
        randomFill(0, 100);
    }

    public void randomFill(int min, int max) {
        if (min > max) {
            min += max;
            max = min - max;
            min -= max;
        }
        for (int i = 0; i < size; i++) {
            data[i] = (int) (Math.random() * (max - min + 1) + min);
        }
    }

    public boolean equals(MyArrayList list) {
        if (size == list.getSize()) {
            for (int i = 0; i < size; i++) {
                if (data[i] != list.getElementAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getElementAt(int index) {
        if (index >= 0 && index < size) {
            int value = data[index];
            return value;
        }
        return -1;
    }

    public MyArrayList clone() {
        MyArrayList newList = new MyArrayList(capacity);
        newList.setData(getData());
        return newList;
    }

    public void overwriteData(int newLength) {
        int[] temp = new int[newLength];
        for (int i = 0; i < size; i++) {
            temp[i] = getElementAt(i);
        }
        data = temp;
    }
}
