package no3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[] array=new int[n];
		for(int i=0;i<n;i++){
			array[i]=scanner.nextInt();
		}
		int max=0;
		for(int i=0;i<array.length;i++){
			int[] tmpArray=Arrays.copyOf(array, array.length);
			int tmp=Count(i, tmpArray);
			if (tmp>max) {
				max=tmp;
			}
		}
		System.out.println(max);
	}
	
	public static int Count(int index,int[] array){
		int res=0;
		int max=getMax(array);
		int cnt=1;
		int i=0;
		while (true) {
			int k=(i+index)%array.length;
			if(cnt==array[k]){
				res+=array[k];
				array[k]=-1;
				cnt=1;
				max=getMax(array);
			}if(array[k]!=-1)
				cnt++;
			if (cnt>max) {
				break;
			}
			index+=1;
		}
		return res;
	}

	private static int getMax(int[] array) {
		int max=array[0];
		for(int i=1;i<array.length;i++){
			if(array[i]>max){
				max=array[i];
			}
		}
		return max;
	}

}
