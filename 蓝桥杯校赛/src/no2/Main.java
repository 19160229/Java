package no2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		for(int i=a;i<=b;i++){
			if (i>10) {
				boolean res=false;
				if ((int)Math.sqrt(i)*(int)Math.sqrt(i)==i) {
					res=isF(i);
				}
				if (res) {
					System.out.println(i);
				}	
			}
		}
	}
	
	public static boolean isF(int n){
		for(int i=10;i<n;i=i*10){
			int tmpA=n%i;
			int tmpB=n/i;
			if (tmpA==0) {
				continue;
			}
			boolean a=((int)Math.sqrt(tmpA)*(int)Math.sqrt(tmpA)==tmpA);
			boolean b=((int)Math.sqrt(tmpB)*(int)Math.sqrt(tmpB)==tmpB);
			if(a&&b){
				return true;
			}
		}
		return false;
	}

}
