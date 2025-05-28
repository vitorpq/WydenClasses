package SUS;

import java.util.ArrayList;
import java.util.List;

public class Doutor extends Pessoa{
    private String especializacao;
    private List<Paciente> pacientes;
    private List<Consulta> consultas;

    // construtor
    public Doutor(String nome, int idade, String especializacao){
        super(nome, idade);
        this.especializacao = especializacao;
        this.pacientes = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }
    public void addPaciente(Paciente paciente){
        pacientes.add(paciente);
    }

    public void marcarConsulta(Paciente paciente, String data) {
        Consulta consulta = new Consulta(this, paciente, data);
        consultas.add(consulta);
        paciente.addConsulta(consulta);
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Especialização: " + especializacao);
        System.out.print("Pacientes: ");
        for (Paciente paciente : pacientes) {
            System.out.print(paciente.getNome() + " ");
        }
        System.out.println();
    }
}
