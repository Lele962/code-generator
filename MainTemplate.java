package com.yeort.acm;

import java.util.scanner

/**
 * @author yeort
 */
public class MainTemplate{
    public static void main(String[] atgs){
        Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();

            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = scanner.nextInt();
            }
            int sum = 0;
            for (int num:arr){
                sum+=num;
            }
            System.out.println("uuiujpgo: "+ sum);
        scanner.close();
    }
}
