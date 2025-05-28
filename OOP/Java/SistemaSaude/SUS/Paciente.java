package SUS;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa{
    private String doenca;
    private List<Doutor> doutores;
    // Adicionado devido a Agregaçaão
    private List<Consulta> consultas;
    //Composicao
    private Prontuario prontuario;

    //Construtor
    public Paciente(String nome, int idade, String doenca){
        super(nome, idade);
        this.doenca = doenca;
        this.doutores = new ArrayList<>();
        this.consultas = new ArrayList<>();
        this.prontuario = new Prontuario(nome);
    }

    public void addDoutor(Doutor doutor){
        doutores.add(doutor);
    }
    public List<Doutor> getDoutor(){
        return doutores;
    }
    public String getDoenca(){
        return doenca;
    }

    public void addConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public Prontuario getProntuario(){
        return prontuario;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Doença: " + doenca);
        System.out.print("Doutors: ");
        for (Doutor doutor: doutores) {
            System.out.print(doutor.getNome() + " ");
        }
        System.out.println();
    }
}
