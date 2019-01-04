package no1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String strA=scanner.nextLine();
		String strB=scanner.nextLine();
		Queue<String> a=new LinkedList<>();
		Queue<String> b=new LinkedList<>();
		for(int i=0;i<strA.length();i++){
			a.add(strA.substring(i, i+1));
		}
		for(int i=0;i<strB.length();i++){
			b.add(strB.substring(i, i+1));
		}
		boolean aFirst=true;
		List<String> res=new ArrayList<>();
		while((!a.isEmpty())&&(!b.isEmpty())){
			String tmp=null;
			if (aFirst) {
				tmp=a.remove();
				res.add(tmp);
				aFirst=false;
			}else{
				tmp=b.remove();
				res.add(tmp);
				aFirst=true;
			}
			int first=res.indexOf(tmp);
			int second=res.lastIndexOf(tmp);
			if(first!=second){
				if (aFirst) {
					for(int i=second;i>=first;i--){
						b.add(res.get(i));
					}
					res.subList(first, second+1).clear();
					aFirst=false;
				}else {
					for(int i=second;i>=first;i--){
						a.add(res.get(i));
					}
					res.subList(first, second+1).clear();
					aFirst=true;
				}
			}
		}
		while (!b.isEmpty()) {
			System.out.print(b.remove());
		}
		while(!a.isEmpty()){
			System.out.print(a.remove());
		}
		System.out.println();
	}

}
