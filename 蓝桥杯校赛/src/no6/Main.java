package no6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=scanner.nextInt();
		}
		int max=0;
		for(int i=0;i<n;i++){
			int tmp=Count(arr,i);
			if (tmp>max) {
				max=tmp;
			}
		}
		System.out.println(max);
	}

	private static int Count(int[] arr, int i) {
		List<Integer> tmpList=new ArrayList<>();
		int k=i+1;
		while (true) {
			k=arr[k-1];
			if (!tmpList.contains(k)) {
				tmpList.add(k);
			}else {
				break;
			}
		}
		return tmpList.size();
	}

}
