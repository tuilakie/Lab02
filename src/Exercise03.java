import java.util.Scanner;

/**
 * PACKAGE_NAME
 * Created by Nguyen Thanh Kien 19127456
 * Date 19/10/2021 - 11:20 SA
 * Description: ...
 */
public class Exercise03 {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2},
                {3, 4, 5},
                {5, 6, 7, 8},
                {7, 8, 9, 10}
        };
        jaggedArray jagged = new jaggedArray();
        jaggedArray jagged1 = new jaggedArray(
                new int[] {1,2,3},
                new int[] {4,5,6,7,8},
                new int[] {9,10}
        );
        jaggedArray jagged2 = new jaggedArray(jagged1);
        jaggedArray jagged3 = new jaggedArray();
        jagged3.setJagged(a);
        jagged.inputJagged("input jagged");
        jagged.outputJagged("output jagged");
        jagged1.outputJagged("output jagged1");
        jagged2.outputJagged("output jagged2");
        jagged3.outputJagged("output jagged3");
    }
}

class jaggedArray {
    private int [][] jagged;

    public jaggedArray(){
        this.jagged = null;
    }
    public  jaggedArray(int n) {
        this.jagged = new int[n][];
    }
    public jaggedArray(int[]...matrix){
        this.jagged = new int[matrix.length][];
        for(int i = 0; i < matrix.length; i++) {
            this.jagged[i] = new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++)
                this.jagged[i][j] = matrix[i][j];
        }
    }
    public jaggedArray(jaggedArray matrix) {
        this.jagged = new int[matrix.jagged.length][];
        for(int i = 0; i < matrix.jagged.length; i++) {
            this.jagged[i] = new int[matrix.jagged[i].length];
            for (int j = 0; j < matrix.jagged[i].length; j++)
                this.jagged[i][j] = matrix.jagged[i][j];
        }
    }
    public void setJagged(int[]...matrix) {
        this.jagged = new int[matrix.length][];
        for(int i = 0; i < matrix.length; i++) {
            this.jagged[i] = new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++)
                this.jagged[i][j] = matrix[i][j];
        }
    }

    public int[][] getJagged() {
        return jagged;
    }
    public void inputJagged(String title) {
        Scanner scan = new Scanner(System.in);
        System.out.println(title);
        System.out.print("Enter number of rows n:");
        int n = Integer.parseInt(scan.nextLine());
        this.jagged = new int[n][];
        for (int i = 0; i < this.jagged.length; i++){
            System.out.print("Enter columns of row "+i+": ");
            int m = Integer.parseInt(scan.nextLine());
            this.jagged[i]=new int[m];
            for (int j = 0; j < this.jagged[i].length; j++) {
                System.out.print("jagged["+i+"]["+j+"]= ");
                this.jagged[i][j] = Integer.parseInt(scan.nextLine());
            }
        }
    }
    public void outputJagged(String title) {
        System.out.println();
        System.out.println(title);
        for (int i = 0; i < this.jagged.length; i++){
            for (int j = 0; j < this.jagged[i].length; j++){
                System.out.print(this.jagged[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
