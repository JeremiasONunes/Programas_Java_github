package avaliacao;

public class questao6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    String nome = "jeremias";
    String invertida= "";
    for(int i = nome.length()-1;i>=0;i--) {
    invertida += nome.charAt(i);
    }
    System.out.println(invertida);
	}

}
