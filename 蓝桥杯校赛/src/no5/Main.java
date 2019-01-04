package no5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int p=scanner.nextInt();
		int q=scanner.nextInt();
		Map<Integer, Boolean> map=new HashMap<Integer, Boolean>();
		for(int i=0;i<10;i++){
			map.put(i, false);
		}
		for (int i = 0; i < q; i++) {
			p*=10;
			int tmp=p/q;
			p=p%q;
			map.put(tmp, true);
		}
		for(int i=0;i<10;i++){
			if (map.get(i)) {
				System.out.print(i);
			}
		}
	}

}
