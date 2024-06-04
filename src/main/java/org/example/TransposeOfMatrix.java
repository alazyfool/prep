package com.company;

public class TransposeOfMatrix {
    public static void main(String[] args) {

        int[][] arr = new int[3][3];
        arr[0][0] = 2;
        arr[0][1] = 4;
        arr[0][2] = -1;


        arr[1][0] = -10;
        arr[1][1] = 5;
        arr[1][2] = 11;

        arr[2][0] = 10;
        arr[2][1] = -7;
        arr[2][2] = 6;


        for(int i = 0;i<arr.length;i++) {
            for(int j = 0; j<arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("%%%%%%%%%%");

        for(int i = 0;i<arr[0].length;i++) {
            for(int j = 0; j<arr.length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }


        System.out.println("After Swapping complete");
        for(int i = 0;i<arr.length;i++) {
            for(int j = 0; j<arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
