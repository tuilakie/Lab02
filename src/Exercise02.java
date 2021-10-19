import java.util.Scanner;

/**
 * PACKAGE_NAME
 * Created by Nguyen Thanh Kien 19127456
 * Date 18/10/2021 - 11:10 CH
 * Description: ...
 */
public class Exercise02 {
    public static void main(String[] args) {
        int [][] a = {
                {1,2},
                {3,4}
        };
        Array2D matrix = new Array2D();
        Array2D matrix1 = new Array2D(
                new int[] {1,2,3,4},
                new int[] {5,6,7,8},
                new int[] {9,8,7,5}
        );
        Array2D matrix2 = new Array2D(matrix1);
        Array2D matrix3 = new Array2D();
        matrix3.setData(a);
        matrix.inputArr2D("input matrix:");
        matrix.outputArr2D("output matrix:");
        matrix1.outputArr2D("output matrix 1:");
        matrix2.outputArr2D("output matrix 2:");
        matrix3.outputArr2D("output matrix 3");
        matrix.SortRow();
        matrix.outputArr2D("increase sorted matrix by row");
        matrix1.SortCol();
        matrix1.outputArr2D("decrease sorted matrix1 by col");
        System.out.println("Sum of matrix: "+matrix.sumArr2D());
        System.out.println("Product of matrix "+matrix.productArr2D());
        System.out.println("Max number of matrix: "+matrix.findMax());
        System.out.println("Min positive number of matrix: "+matrix.findMinPositive());
        System.out.println("Max negative number of matrix: "+matrix.findMaxNegative());
        System.out.println("row has max sum of matrix: "+matrix.findMaxRow());
        System.out.println("col has max sum of matrix: "+matrix.findMaxCol());
        matrix.addFrontRow(-1,2,-3,4);
        matrix.outputArr2D("add -1,2,-3,4 to front of matrix");
        matrix.addEndRow(-4,5,-6,7);
        matrix.outputArr2D("add -4,5,-6,7 to end of matrix");
        matrix.addRow(2,0,0,0,0);
        matrix.outputArr2D("add 0,0,0,0 to index 2 of matrix");
        matrix.removeRow(2);
        matrix.outputArr2D("remove row has index 2 of matrix");
        matrix.removeCol(2);
        matrix.outputArr2D("remove col has index 2 of matrix");
        Array2D matrix4 = Array2D.parseArr2D("1;2;3;4;5;6;7;8;9",";",3,3);
        matrix4.outputArr2D("parse matrix4");
    }
}
class Array2D{
    private int[][] data;
    public Array2D(){
        this.data = null;
    }
    public  Array2D(int n, int m) {
        this.data = new int[n][m];
    }
    public Array2D(int[]...matrix){
        this.data = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                this.data[i][j] = matrix[i][j];
    }
    public Array2D(Array2D matrix) {
        this.data = new int[matrix.data.length][matrix.data[0].length];
        for(int i = 0; i < matrix.data.length; i++)
            for (int j = 0; j < matrix.data[i].length; j++)
                this.data[i][j] = matrix.data[i][j];
    }

    public void setData(int[]...matrix) {
        this.data = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                this.data[i][j] = matrix[i][j];
    }

    public int[][] getData() {
        return data;
    }

    public void inputArr2D(String title){
        Scanner scan = new Scanner(System.in);
        System.out.println(title);
        System.out.print("Enter n rows: ");
        int n = Integer.parseInt(scan.nextLine());
        System.out.print("Enter m columns: ");
        int m = Integer.parseInt(scan.nextLine());
        this.data = new int[n][m];
        for (int i = 0; i < this.data.length; i++){
            for (int j = 0; j < this.data[i].length; j++){
                System.out.print("a["+i+"]["+j+"]=");
                this.data[i][j] = Integer.parseInt(scan.nextLine());
            }
        }
    }
    public void outputArr2D(String title){
        System.out.println(title);
        for (int i = 0; i < this.data.length; i++){
            for (int j = 0; j < this.data[i].length; j++) {
                System.out.print(this.data[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public void SortRow(){
        for (int k = 0; k < this.data.length; k++)
            for (int i = 0; i < this.data[k].length - 1; i++){
                for(int j = i + 1; j < this.data[k].length; j++)
                    if (this.data[k][i] > this.data[k][j]){
                        int temp = this.data[k][i];
                        this.data[k][i] = this.data[k][j];
                        this.data[k][j] = temp;
                    }
            }
    }
    public void SortCol(){
        for (int k = 0; k < this.data[0].length; k++)
            for (int i = 0; i < this.data.length - 1; i++){
                for(int j = i + 1; j < this.data.length; j++)
                    if (this.data[i][k] < this.data[j][k]){
                        int temp = this.data[i][k];
                        this.data[i][k] = this.data[j][k];
                        this.data[j][k] = temp;
                    }
            }
    }
    public int sumArr2D() {
        int sum = 0;
        for(int i = 0; i < this.data.length; i++)
            for (int j = 0; j < this.data[i].length; j++)
                sum += this.data[i][j];
        return sum;
    }
    public int productArr2D() {
        int prod = 1;
        for(int i = 0; i < this.data.length; i++)
            for (int j = 0; j < this.data[i].length; j++)
                prod *= this.data[i][j];
        return prod;
    }
    public int findMax() {
        int max = this.data[0][0];
        for(int i = 0; i < this.data.length; i++)
            for (int j = 0; j < this.data[i].length; j++)
                if(max < this.data[i][j])
                    max = this.data[i][j];
        return max;
    }
    public int findMinPositive() {
        int min = 9999999; // define max int positive
        for(int i = 0; i < this.data.length; i++)
            for (int j = 0; j < this.data[i].length; j++)
                if(min > this.data[i][j] && this.data[i][j] > 0)
                    min = this.data[i][j];
        return min;
    }
    public int findMaxNegative() {
        int max = -99999999; // define min int negative
        for(int i = 0; i < this.data.length; i++)
            for (int j = 0; j < this.data[i].length; j++)
                if(max < this.data[i][j] && this.data[i][j] < 0)
                    max = this.data[i][j];
        return max;
    }
    public int findMaxRow() {
        int sum = 0, maxRow = 0;
        for(int i = 0; i < this.data.length; i++){
            int preSum = 0;
            for (int j = 0; j < this.data[i].length; j++) {
                preSum += this.data[i][j];
            }
            if(preSum > sum){
                maxRow = i;
                sum = preSum;
            }
        }
        return maxRow;
    }
    public int findMaxCol() {
        int sum = 0, maxCol = 0;
        for(int i = 0; i < this.data[0].length; i++){
            int preSum = 0;
            for (int j = 0; j < this.data.length; j++) {
                preSum += this.data[j][i];
            }
            if(preSum > sum){
                maxCol = i;
                sum = preSum;
            }
        }
        return maxCol;
    }

    public void addFrontRow(int...arr) {
        if(arr.length != this.data[0].length){
            System.out.println("length of array is not equal");
            return;
        }
        int[][] newMatrix = new int[this.data.length + 1][this.data[0].length];
        for (int j = 0; j < newMatrix[0].length; j++)
            newMatrix[0][j] = arr[j];
        for(int i = 1; i < newMatrix.length; i++)
            for (int j = 0; j < newMatrix[i].length; j++)
                newMatrix[i][j] = this.data[i - 1][j];
        this.setData(newMatrix);
    }

    public void addEndRow(int...arr) {
        if(arr.length != this.data[0].length){
            System.out.println("length of array is not equal");
            return;
        }
        int[][] newMatrix = new int[this.data.length + 1][this.data[0].length];
        for (int j = 0; j < newMatrix[0].length; j++)
            newMatrix[newMatrix.length-1][j] = arr[j];
        for(int i = 0; i < newMatrix.length - 1; i++)
            for (int j = 0; j < newMatrix[i].length; j++)
                newMatrix[i][j] = this.data[i][j];
        this.setData(newMatrix);
    }
    public void addRow(int id, int...arr) {
        if(arr.length != this.data[0].length || id > this.data.length){
            System.out.println("length of array is not equal");
            return;
        }
        int[][] newMatrix = new int[this.data.length + 1][this.data[0].length];
        for (int j = 0; j < newMatrix[0].length; j++)
            newMatrix[id][j] = arr[j];
        for(int i = 0; i < newMatrix.length - 1; i++)
            for (int j = 0; j < newMatrix[i].length; j++)
                if(i < id){
                    newMatrix[i][j] = this.data[i][j];
                }else {
                    newMatrix[i + 1][j] = this.data[i][j];
                }
        this.setData(newMatrix);
    }
    public void removeRow(int id) {
        if(id > this.data.length){
            System.out.println("length out of range");
            return;
        }
        int[][] newMatrix = new int[this.data.length - 1][this.data[0].length];
        for(int i = 0; i < newMatrix.length; i++)
            for (int j = 0; j < newMatrix[i].length; j++)
                if(i < id){
                    newMatrix[i][j] = this.data[i][j];
                }else {
                    newMatrix[i][j] = this.data[i + 1][j];
                }
        this.setData(newMatrix);
    }

    public void removeCol(int id) {
        if(id > this.data[0].length){
            System.out.println("length out of range");
            return;
        }
        int[][] newMatrix = new int[this.data.length][this.data[0].length - 1];
        for(int i = 0; i < newMatrix[0].length; i++)
            for (int j = 0; j < newMatrix.length; j++)
                if(i < id){
                    newMatrix[j][i] = this.data[j][i];
                }else {
                    newMatrix[j][i] = this.data[j][i + 1];
                }
        this.setData(newMatrix);
    }
    public static Array2D parseArr2D(String str, String ch, int n, int m){
        int[][] newMatrix = new int [n][m];
        String[] arrStr = str.split(ch);
        int k = 0;
        for(int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                newMatrix[i][j] = Integer.parseInt(arrStr[k++]);
        return new Array2D(newMatrix);
    }
}
