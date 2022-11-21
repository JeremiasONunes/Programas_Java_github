package br.edu.univas;

import java.time.temporal.TemporalAmount;
import java.util.Scanner;

public class dictionarie {

	public static void main(String[] args) {
		
		// utilitarios
		Scanner sc = new Scanner(System.in);
		
		//variaveis arrays e constates
		String[] wordEN= new String[100];
		String[] wordPT = new String[100];
		String[] meaning = new String[100];
		int amount;
		int contador = 0;
		boolean status;
		boolean status1;
		String word1 = "vazio";
		String word2 = "vazio";
		String word3 = "vazio";	
		
		// menu de interação direta
		int option;
		//variaveis locais para uso local
		String word_temporal;
		String meaning_temporal;
		int word_temp;
		int meaning_temp;
		int option2;
		String new_word;
		
		
		//menu de interação do usuario
		do {
        System.out.print("|-----------------------------|\n");
        System.out.print("| Opção 1 - Novo Cadastro     |\n");
        System.out.print("| Opção 2 - Alterar palavra   |\n");
        System.out.print("| Opção 3 - Buscar palavra    |\n");
        System.out.print("| Opção 4 - Excluir palavra   |\n");
        System.out.print("| Opção 5 - Sair              |\n");
        System.out.print("|-----------------------------|\n");
        System.out.print("Digite uma opção: ");
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
					
					System.out.println("palavra repetida digita outra");
					status1=true;
				}
			}while(status1 == true);
			
			break;
		case 2:
			
			System.out.print("|------------------------------------|\n");
	        System.out.print("| Opção 1 - alteral em ingles        |\n");
	        System.out.print("| Opção 2 - alteral em portugues     |\n");
	        System.out.print("| Opção 3 - alteral em seguinficado  |\n");
	        System.out.print("|------------------------------------|\n");
	        System.out.print("Digite uma opção: ");
	        option2 = sc.nextInt();
	        sc.nextLine();
	        
	        
	        switch (option2) {
			case 1:
				System.out.println("type the word english");
				word3 = sc.nextLine();			
				word_temp  = searchWord(wordEN, wordEN, word3);
				System.out.println("type the new word english");
				wordEN[word_temp] = sc.nextLine();
				
				break;
			case 2:
				System.out.println("type the word portuguese");
				word3 = sc.nextLine();
				word_temp  = searchWord(wordEN, wordEN, word3);
				System.out.println("type the new word portuguese");
				wordPT[word_temp] = sc.nextLine();
				break;
			case 3:
				System.out.println("type the word english for seach in dicitionary");
				word3 = sc.nextLine();			
				word_temp  = searchWord(wordEN, wordEN, word3);
				System.out.println("type the new meaning in english or portuguese");
				meaning[word_temp] = sc.nextLine();
				
				break;
			default:
				break;
			}
	        
	        
			break;
		case 3:
			
			System.out.print("|-----------------------------|\n");
	        System.out.print("| Opção 1 - busca em ingles   |\n");
	        System.out.print("| Opção 2 - busca em portugues|\n");
	        System.out.print("|-----------------------------|\n");
	        System.out.print("Digite uma opção: ");
	        option2 = sc.nextInt();
	        sc.nextLine();
	        
	        
	        switch (option2) {
			case 1:
				System.out.println("type the word english");
				 word3 = sc.nextLine();
							
				word_temp  = searchWord(wordEN, wordEN, word3);
				meaning_temp =meaning(wordEN, meaning, word3);
				System.out.println(wordPT[word_temp]);
				System.out.println(meaning[meaning_temp]);
				
				break;
			case 2:
				System.out.println("type the word portuguese");
				word3 = sc.nextLine();
				word_temp  = searchWord(wordPT, wordEN, word3);
				meaning_temp =meaning(wordPT, meaning, word3);
				System.out.println(wordEN[word_temp]);
				System.out.println(meaning[meaning_temp]);
				break;
			default:
				break;
			}
			break;
		case 4:
			System.out.print("|------------------------------------|\n");
	        System.out.print("| Opção 1 - excluir em ingles        |\n");
	        System.out.print("| Opção 2 - excluir em portugues     |\n");
	        System.out.print("|------------------------------------|\n");
	        System.out.print("Digite uma opção: ");
	        option2 = sc.nextInt();
	        sc.nextLine();
	        
	        
	        switch (option2) {
			case 1:
				System.out.println("type the word english");
				word3 = sc.nextLine();			
				word_temp  = searchWord(wordEN, wordEN, word3);
				System.out.println("word deleted");
				wordEN[word_temp] = "word deleted by the user ";
				wordPT[word_temp] = "palavra deletada pelo usuario";
				meaning[word_temp] = "palavra deletada pelo usuario";
				break;
			case 2:
				System.out.println("type the word portuguese");
				word3 = sc.nextLine();
				word_temp  = searchWord(wordEN, wordEN, word3);
				System.out.println("palavra deletada");
				wordEN[word_temp] = "word deleted by the user ";
				wordPT[word_temp] = "palavra deletada pelo usuario";
				meaning[word_temp] = "palavra deletada pelo usuario";
				
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
	public static int searchWord(String[] word01,String[] word02,String word03) {		
		for (int i = 0; i < word01.length; i++)
	    {	        
	            if (word01[i] != null && word01[i].equals(word03)) {
	            	
	            	int index = word01[i].indexOf(word03);
	                return index;
	            }	        
	    }
		return 0;		
	}
		
	//metodo retorn sigficado
public static int meaning(String[] word01,String[] meaning,String word03) {		
		for (int i = 0; i < word01.length; i++)
	    {	        
	            if (word01[i] != null && word01[i].equals(word03)) {
	            	int index = word01[i].indexOf(word03);
	                return index;
	            }	        
	    }
		return 0;		
	}
}
