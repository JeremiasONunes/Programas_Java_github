package br.edu.univas;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//autor: jereh6292
//jeremias de oliveira nunes

/*
O trabalho consiste em desenvolver um sistema em Java que permita a gestão de
uma biblioteca. O sistema deve permitir a adição e a remoção de livros, além de
possibilitar a busca por livros pelo título, area de interesse ou pelo nome do autor.
Além disso, o sistema deve ser capaz de gerar relatórios com informações sobre os
livros cadastrados.
O sistema deve armazenar os registros em um arquivo .csv com o seguinte padrão
nome_do_livro,numero_de_paginas,nome_do_autor,area_de_interesse
Estrutura de dados,200,Michael T. Goodrich,Programação de computadores
 */


public class Biblioteca {
    private ArrayList<Livro> livros;
    public Biblioteca() {
        livros = new ArrayList<>();
    }
    public void adicionarLivro(String titulo,String numeroDePaginas, String autor, String areaDeInteresse) {
        Livro novoLivro = new Livro(titulo,numeroDePaginas, autor, areaDeInteresse);
        livros.add(novoLivro);
        System.out.println("Livro adicionado: " + novoLivro);
    }
    public void removerLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                livros.remove(livro);
                System.out.println("Livro removido: " + livro);
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }
    public void BuscarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
            	System.out.println(livro);
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }
    public void BuscarLivroArea(String areaDeInteresse) {
    	boolean ver =false;
        for (Livro livro : livros) {
            if (livro.getAreaDeInteresse().equals(areaDeInteresse)) {
            	System.out.println(livro);
                ver = true;
            }           
        }
        if(ver == false)
        	System.out.println("Livro não encontrado.");	        
    }
    public void BuscarLivroAutor(String Autor) {
    	boolean ver =false;
        for (Livro livro : livros) {
            if (livro.getAutor().equals(Autor)) {
            	System.out.println(livro);
                ver = true;
            }                        	            
        }
        if(ver == false)
        	System.out.println("Livro não encontrado.");	
        
    }

    public void gerarRelatorio(String nomeArquivo) throws IOException {
        FileWriter writer = new FileWriter(nomeArquivo);
        writer.append("Titulo, numeroDePaginas, Autor, Area de Interesse\n");
        for (Livro livro : livros) {
        	
            writer.append(livro.getTitulo()).append(",");
            
            writer.append(livro.getNumeroDePaginas()).append(",");
            
            writer.append(livro.getAutor()).append(",");
            
            writer.append(livro.getAreaDeInteresse()).append("\n");
        }
        writer.close();
        System.out.println("Relatório gerado com sucesso.");
    }
    public static void main(String[] args) throws IOException {
        Biblioteca biblioteca = new Biblioteca();
        int opcao;
        Scanner sc = new Scanner(System.in);
        String titulo;
        String numeroDePaginas;
        String autor;
        String areaDeInteresse;
        do {        	
        	System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Remover livro");
            System.out.println("3 - Buscar livro por título");
            System.out.println("4 - Buscar livro por área de interesse");
            System.out.println("5 - Buscar livro por autor");
            System.out.println("6 - Gerar relatório");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();
	         switch (opcao) {
	            case 1:	
	            	System.out.println("Você escolheu a Opção 1");
		               System.out.println("Digite o título do livro:");
	                   titulo = sc.nextLine();
	                   System.out.println("Digite o numero de paginas do livro:");
	                   numeroDePaginas = sc.nextLine();
	                   System.out.println("Digite o nome do autor:");
	                   autor = sc.nextLine();
	                   System.out.println("Digite a área de interesse:");
	                   areaDeInteresse = sc.nextLine();	                   
	            	   biblioteca.adicionarLivro(titulo,numeroDePaginas, autor, areaDeInteresse);               	                
	            	break;
	            case 2:
	               System.out.println("Você escolheu a Opção 2");
	               System.out.println("Digite o título do livro:");
                   titulo = sc.nextLine();
	               biblioteca.removerLivro(titulo);
	               break;
	            case 3:
	               System.out.println("Você escolheu a Opção 3");
	               System.out.println("Digite o título do livro:");
                   titulo = sc.nextLine();
	               biblioteca.BuscarLivro(titulo);
	               break;
	            case 4:
	               System.out.println("Você escolheu a Opção 4");
	               System.out.println("Digite a area de interesse do livro:");
	               areaDeInteresse = sc.nextLine();
	               biblioteca.BuscarLivroArea(areaDeInteresse);;
	               break;
	            case 5:	               
	               System.out.println("Digite o autor do livro:");
	               autor = sc.nextLine();
	               biblioteca.BuscarLivroAutor(autor);;
	               break;	               
	            case 6:
	            	biblioteca.gerarRelatorio("livros.csv");               
		               break;
	            case 0:
		               System.out.println("Encerrando o programa...");		              
		               break;
	            default:
	               System.out.println("Opção inválida. Escolha novamente.");
	               break;
	         }
	      } while (opcao != 0);
     sc.close();
    }
}
class Livro {
    private String titulo;
    private String numeroDePaginas;
    private String autor;
    private String areaDeInteresse;
    public Livro(String titulo,String numeroDePaginas, String autor, String areaDeInteresse) {
        this.titulo = titulo;
        this.numeroDePaginas = numeroDePaginas;
        this.autor = autor;
        this.areaDeInteresse = areaDeInteresse;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getNumeroDePaginas() {
        return numeroDePaginas;
    }
    public String getAutor() {
        return autor;
    }
    public String getAreaDeInteresse() {
        return areaDeInteresse;
    }
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                "numero de paginas='" + numeroDePaginas + '\'' +
                ", autor='" + autor + '\'' +
                ", areaDeInteresse='" + areaDeInteresse + '\'' +
                '}';
    }
}