package SUS;

public class Pessoa {
    private String nome;
    private int idade;
    // Construtor da Classe Pessoa
    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
    public void displayInfo(){
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}
