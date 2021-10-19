import java.util.Scanner;

/**
 * PACKAGE_NAME
 * Created by Nguyen Thanh Kien 19127456
 * Date 18/10/2021 - 11:49 SA
 * Description: ...
 */
public class Exercise01 {
    public static void main(String[] args) {
        Array1D arr = new Array1D();
        Array1D arr1 = new Array1D(1,2,3,4,5);
        Array1D arr2 = new Array1D(arr1);
        arr.inputArr("input arr: ");
        arr.outputArr("output arr");
        arr1.outputArr("output arr1");
        arr2.outputArr("output arr2");
        arr.setArr(-1,2,-3,4,-5);
        int[]temp = arr.getArr();
        arr.outputArr("set Arr: ");
        System.out.println(temp.toString());
        arr.sortIncrease();
        arr.outputArr("arr sort increase");
        arr.sortDecrease();
        arr.outputArr("arr sort Decrease");
        System.out.println("Sum arr: "+arr.SumArr());
        System.out.println("product arr: "+arr.productArr());
        System.out.println("find max num of arr: "+arr.findMax());
        System.out.println("find max negative arr: "+arr.findMaxNegative());
        System.out.println("find min positive arr: "+arr.findMinPositive());
        arr.addHead(99);
        arr.outputArr("add 99 to head of arr");
        arr.addTail(11);
        arr.outputArr("add 11 to tail of arr");
        arr.addByIndex(2,99);
        arr.outputArr("add 99 to index 2 of arr");
        arr.removeByIndex(3);
        arr.outputArr("remove element has index 2 of arr");
        arr.removeByValue(99);
        arr.outputArr("remove elements have value is 99 of arr");
        arr.updateByIndex(1,11);
        arr.outputArr("update value 11 for index 1");
        arr.updateByVal(11,1);
        arr.outputArr("update form value 11 to value 1");
        Array1D arr0 = Array1D.parseArr1D("1 2 3 4 5 6 7"," ");
        arr0.outputArr("parse arr0");
    }
}
class Array1D {
    //Attributes
    private int[] arr;

    //Methods
    public Array1D() {
        this.arr = null;
    }

    public Array1D(int ... _arr) {
        this.arr = new int[_arr.length];
        for(int i = 0; i < _arr.length; i++)
            this.arr[i] = _arr[i];
    }

    public Array1D(Array1D Arr) {
        if(Arr == null) {
            this.arr = null;
            return;
        }
        this.arr = new int[Arr.arr.length];
        for(int i = 0; i < Arr.arr.length; i++)
            this.arr[i] = Arr.arr[i];
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int..._arr) {
        this.arr = new int[_arr.length];
        for (int i = 0; i < _arr.length;i++)
            this.arr[i] = _arr[i];
    }
    public void setArr(int id, int val) {
        if( id >= 0 && id < this.arr.length)
            this.arr[id] = val;
    }
    public Integer getArr(int id) {
        Integer val = null;
        if( id >= 0 && id < this.arr.length)
            val = this.arr[id];
        return val;
    }

    public void inputArr(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        System.out.print("Enter number of elements: ");
        int n=Integer.parseInt(scanner.nextLine());
        this.arr=new int[n];
        for(int i=0; i<this.arr.length; i++){
            System.out.print("Arr["+ i + "] :");
            this.arr[i]=Integer.parseInt(scanner.nextLine());
        }
    }

    public void outputArr(String title){
        System.out.println();
        System.out.println(title);
        System.out.println("Number of elements: " + this.arr.length);
        for(int i=0; i<this.arr.length; i++)
            System.out.println("Arr["+ i + "] = " + this.arr[i]);
    }

    public void sortIncrease() {
       for (int i = 0; i < this.arr.length - 1; i++){
           for(int j = i + 1; j < this.arr.length; j++)
               if (this.arr[i] > this.arr[j]){
                   int temp = this.arr[i];
                   this.arr[i] = this.arr[j];
                   this.arr[j] = temp;
               }
       }
    }
    public void sortDecrease() {
        for (int i = 0; i < this.arr.length - 1; i++){
            for(int j = i + 1; j < this.arr.length; j++)
                if (this.arr[i] < this.arr[j]){
                    int temp = this.arr[i];
                    this.arr[i] = this.arr[j];
                    this.arr[j] = temp;
                }
        }
    }
    public int SumArr() {
        int sum = 0;
        for (int item : this.arr)
            sum += item;
        return sum;
    }
    public int productArr() {
        int prod = 1;
        for (int item : this.arr)
            prod *= item;
        return prod;
    }
    public int findMax() {
        int max = this.arr[0];
        for(int item : this.arr)
            if (max < item)
                max = item;
        return max;
    }
    public int findMinPositive() {
        int min = 9999999; // define max int positive
        for(int item : this.arr)
            if (min > item && item > 0)
                min = item;
        return min;
    }
    public int findMaxNegative() {
        int max = -99999999; // define min int negative
        for(int item : this.arr)
            if (max < item && item < 0)
                max = item;
        return max;
    }
    public void addHead(int val) {
        int[] newArr = new int [this.arr.length + 1];
        newArr[0] = val;
        for (int i = 1; i < newArr.length; i++)
            newArr[i] = this.arr[i-1];
        this.arr = newArr;
    }
    public void addTail(int val) {
        int[] newArr = new int [this.arr.length + 1];
        newArr[newArr.length - 1] = val;
        for (int i = 0; i < newArr.length - 1; i++)
            newArr[i] = this.arr[i];
        this.arr = newArr;
    }
    public void addByIndex(int id, int val) {
        int[] newArr = new int [this.arr.length + 1];
        newArr[id] = val;
        int j = 0;
        for (int i = 0; i < newArr.length; i++){
            if(i == id)
                i++;
            newArr[i] = this.arr[j];
            j++;
        }
        this.arr = newArr;
    }
    public void removeByIndex(int id) {
        int[] newArr = new int [this.arr.length - 1];
        for (int i = 0; i < newArr.length; i++){
            if(i < id){
                newArr[i] = this.arr[i];
            }else {
                newArr[i] = this.arr[i + 1];
            }
        }
        this.arr = newArr;
    }
    public void removeByValue(int val) {
        for (int i = 0; i < this.arr.length; i++)
            if(this.arr[i] == val)
                this.removeByIndex(i);
    }
    public void updateByIndex(int id, int val) {
        setArr(id,val);
    }
    public void updateByVal(int x, int y) {
        for (int i = 0; i < this.arr.length; i++)
            if(this.arr[i] == x)
                setArr(i,y);
    }
    public static Array1D parseArr1D(String str,String ch){
        String[] arrStr = str.split(ch);
        int[] arrInt = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++)
            arrInt[i] = Integer.parseInt(arrStr[i]);
        return new Array1D(arrInt);
    }
}
