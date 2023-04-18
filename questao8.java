package avaliacao;

import java.util.ArrayList;

public class questao8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("jeremias");
		list.add("é");
		list.add("o");
		list.add("cara");
		int x = list.size();
		String tudo="";
		for(int i =0 ; i<=x-1;i++) {
			tudo += list.get(i);
		}
		System.out.println(tudo);
	}

}
