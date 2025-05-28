package SUS;

import java.util.ArrayList;
import java.util.List;

public class Prontuario {
    private String pacienteNome;
    private List<String> historico;
    private List<String> medicamentos;
    private List<String> exames;

    // Construtor
    public Prontuario(String pacienteNome){
        this.pacienteNome = pacienteNome;
        this.historico = new ArrayList<>();
        this.medicamentos = new ArrayList<>();
        this.exames = new ArrayList<>();
    }

    public String getPacienteNome(){
        return pacienteNome;
    }

    public void addHistorico(String registro){
        historico.add(registro);
    }

    public void addMedicamento(String medicamento){
        medicamentos.add(medicamento);
    }

    public void addExame(String exame){
        exames.add(exame);
    }

    public List<String> getHistorico(){
        return historico;
    }

    public List<String> getMedicamentos(){
        return medicamentos;
    }

    public List<String> getExames(){
        return exames;
    }

    public void displayInfo(){
        System.out.println("Prontuário de " + pacienteNome);
        System.out.println("Histórico:");
        for(String registro: historico){
            System.out.println("- " + registro);
        }
        System.out.println("Exames:");
        for(String exame: exames){
            System.out.println("- " + exame);
        }
    }
}
