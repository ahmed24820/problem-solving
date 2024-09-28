package Stack_Queues;

import java.util.Arrays;

public class MyCircularDeque {
    int [] arr;
    int back , front , size , capacity;
    public MyCircularDeque(int k){
        arr = new int[k];
        Arrays.fill(arr,-1);
        size = 0;
        front = 0;
        back = 0 ;
        capacity = k;
    }
    public boolean insertFront(int value){
        if (isFull()){
            return false;
        }
        if (front == 0){
            front = capacity -1 ;
        }else {
            front --;
        }
        arr[front] = value;
        size++;
        return true;
    }
    public boolean insertLast(int value){
        if (isFull()){
            return false;
        }
        arr[back] = value;

        if (back == capacity - 1){
            back = 0;
        }else {
            back++;
        }

        size++;
        return true;
    }
    public boolean deleteFront(){
        if (isEmpty()){
            return false;
        }
        arr[front] = -1 ;

        if (front == capacity -1 ){
            front = 0;
        }else {
            front ++;
        }
        size--;
        return true;
    }
    public boolean deleteLast(){
        if (isEmpty()){
            return false;
        }

        if (back == 0){
            back = capacity - 1;
        }else {
            back --;
        }

        arr[back] = -1 ;

        size--;
        return true;
    }
    public int getRear(){
        if (isEmpty()){
            return -1;
        }
        if (back == 0){
            return arr[capacity - 1];
        }else {
            return arr[back - 1];
        }
    }
    public int getFront(){
        if (isEmpty()){
            return -1;
        }
        return arr[front];
    }


    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == capacity;
    }


}



