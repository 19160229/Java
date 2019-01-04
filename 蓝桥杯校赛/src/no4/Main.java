package no4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[] v = new int[n];
		for(int i=0;i<n;i++){
			v[i]=scanner.nextInt();
		}
		int res=0;
		for (int i = 0; i < v.length-2; i++) {
			for(int j=i+1;j<v.length-1;j++){
				if (v[j]>v[i]) {
					for(int k=j+1;k<v.length;k++){
						if (v[k]>v[j]) {
							res++;
						}
					}
				}
			}
		}
		System.out.println(res);
	}
	
}
