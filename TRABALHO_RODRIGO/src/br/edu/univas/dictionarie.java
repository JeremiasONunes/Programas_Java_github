package br.edu.univas;
import java.util.Scanner;
import java.util.Arrays;
public class dictionarie {
	public static void main(String[] args) {		
		// utilitarios
		Scanner sc = new Scanner(System.in);		
		//variaveis arrays e constates
		String[] wordEN= new String[100];
		String[] wordPT = new String[100];
		String[] meaning = new String[100];
		int contador = 0;
		boolean status;
		boolean status1;
		int word_temp;
		int meaning_temp;
		int option2;
		int option;
		String word3 = "vazio";	
		//menu de interação do usuario
		do {
			word_temp=0;
			meaning_temp=0;
        System.out.print("|-----------------------------|\n");
        System.out.print("| Option 1 - New Registration |\n");
        System.out.print("| Option 2 - Change word      |\n");
        System.out.print("| Option 3 - Search word      |\n");
        System.out.print("| Option 4 - Delete word      |\n");
        System.out.print("| Option 5 - exit             |\n");
        System.out.print("|-----------------------------|\n");
        System.out.print("enter an option: ");
        option = sc.nextInt();
        sc.nextLine();
        switch (option) {
		case 1:			
			do {
				System.out.println("type the word english");
				wordEN[contador] = sc.nextLine();				
				System.out.println("type the word portuguese");
				wordPT[contador]=sc.nextLine();				
				System.out.println("type the meaning of the word in english or portuguese");
				meaning[contador] = sc.nextLine();				
				status = searchDuplicate(wordEN);
				if(status == false) {
					contador++;
					status1=false;	
				}else {	
					System.out.println("repeated word type another");
					status1=true;				}
			}while(status1 == true);			
			break;
		case 2:			
			System.out.print("|------------------------------------|\n");
	        System.out.print("| Option 1 - change in English       |\n");
	        System.out.print("| Option 2 - change in portuguese    |\n");
	        System.out.print("| Option 3 - change the a meaning    |\n");
	        System.out.print("|------------------------------------|\n");
	        System.out.print("Digite uma opção: ");
	        option2 = sc.nextInt();
	        sc.nextLine();	        
	        switch (option2) {
			case 1:
				System.out.println("type the word english");
				word3 = sc.nextLine();			
				word_temp  = search(wordEN, wordEN, word3);
				if(word_temp != -1) {
				System.out.println("type the new word english");
				wordEN[word_temp] = sc.nextLine();
				}else
				System.out.println("palavra não existe");
				break;
			case 2:
				System.out.println("type the word portuguese");
				word3 = sc.nextLine();
				word_temp  = search(wordEN, wordEN, word3);
				if(word_temp != -1) {
				System.out.println("type the new word portuguese");
				wordPT[word_temp] = sc.nextLine();
				}else
				System.out.println("palavra não existe");
				break;
			case 3:
				System.out.println("type the word english for seach in dicitionary");
				word3 = sc.nextLine();			
				word_temp  = search(wordEN, wordEN, word3);
				if(word_temp != -1) {
				System.out.println("type the new meaning in english or portuguese");
				meaning[word_temp] = sc.nextLine();
				}else
				System.out.println("palavra não existe");
				break;
			default:
				break;
			} 
			break;
		case 3:			
			System.out.print("|---------------------------------|\n");
	        System.out.print("| Option 1 - search in English    |\n");
	        System.out.print("| Option 2 - Search in Portuguese |\n");
	        System.out.print("|---------------------------------|\n");
	        System.out.print("enter an option: ");
	        option2 = sc.nextInt();
	        sc.nextLine();	        
	        switch (option2) {
			case 1:
				System.out.println("type the word english");
				word3 = sc.nextLine();							
				word_temp  = search(wordEN, wordEN, word3);
				meaning_temp =search(wordEN, meaning, word3);
				if(word_temp != -1) { 
				System.out.println(wordPT[word_temp]);
				System.out.println(meaning[meaning_temp]);
				}else 
					System.out.println("palavra não existe");				
				break;
			case 2:
				System.out.println("type the word portuguese");
				word3 = sc.nextLine();
				word_temp  = search(wordPT, wordEN, word3);
				meaning_temp =search(wordPT, meaning, word3);
				if(word_temp != -1) {
				System.out.println(wordEN[word_temp]);
				System.out.println(meaning[meaning_temp]);
				}else
					System.out.println("palavra não existe");
				break;
			default:
				break;
			}
			break;
		case 4:
			System.out.print("|------------------------------------|\n");
	        System.out.print("| Option 1 - Delete in English       |\n");
	        System.out.print("| Option 2 - Delete in Portuguese    |\n");
	        System.out.print("|------------------------------------|\n");
	        System.out.print("enter an option: ");
	        option2 = sc.nextInt();
	        sc.nextLine();	        
	        switch (option2) {
			case 1:
				System.out.println("type the word english");
				word3 = sc.nextLine();			
				word_temp  = search(wordEN, wordEN, word3);
				if(word_temp != -1) {
				System.out.println("word deleted");
				wordEN[word_temp] = "palavra deletada pelo usuario ";
				wordPT[word_temp] = "word deleted by the user";
				meaning[word_temp] = "palavra deletada pelo usuario/word deleted by the user";
				}else
					System.out.println("palavra não existe");
				break;
			case 2:
				System.out.println("type the word portuguese");
				word3 = sc.nextLine();
				word_temp  = search(wordEN, wordEN, word3);
				if(word_temp != -1) {
				System.out.println("palavra deletada");
				wordEN[word_temp] = "palavra deletada pelo usuario ";
				wordPT[word_temp] = "word deleted by the user";
				meaning[word_temp] = "palavra deletada pelo usuario/word deleted by the user";
				}else
					System.out.println("palavra não existe");
				break;
		default:
			break;
		}
        }
		}while (option!= 5);		
		sc.close();
	}	
	// metodos palavras duplicadas
	public static boolean searchDuplicate(String[] word01) {		
		for (int i = 0; i < word01.length; i++)
	    {
	        for (int j = i + 1; j < word01.length; j++)
	        {
	            if (word01[i] != null && word01[i].equals(word01[j])) {
	                return true;
	            }
	        }
	    }	 
	    // nenhuma duplicata foi encontrada
	    return false;		
	}
	//metodo return tradução
	public static int search(String[] word01,String[] word02,String word03) {			
	         int index = Arrays.asList(word01).indexOf(word03);            	
	         return index;
		
	}

}
