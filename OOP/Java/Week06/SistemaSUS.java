import java.util.ArrayList;
import java.util.List;

class Pessoa {
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

// Classe Doutor
class Doutor extends Pessoa{
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

class Paciente extends Pessoa{
    private String doenca;
    private List<Doutor> doutores;
    private List<Consulta> consultas;

    //Construtor
    public Paciente(String nome, int idade, String doenca){
        super(nome, idade);
        this.doenca = doenca;
        this.doutores = new ArrayList<>();
        this.consultas = new ArrayList<>();
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

class Consulta{
    private Doutor doutor;
    private Paciente paciente;
    private String data;

    public Consulta(Doutor doutor, Paciente paciente, String data){
        this.doutor = doutor;
        this.paciente = paciente;
        this.data = data;
    }

    public Doutor getDoutor()
    {
        return doutor;
    }

    public Paciente getPaciente(){
        return paciente;
    }

    public String getData(){
        return data;
    }
    @Override
    public String toString(){
        return "Consulta em " + data + " com Dr. " + doutor.getNome() + " e paciente " + paciente.getNome();

    }
}

public class SistemaSUS {
    public static void main(String[] args) {
        Doutor medico1 = new Doutor("Dr. Silva", 45, "Cardiologista");
        Doutor medico2 = new Doutor("Dr. Souza", 50, "Neurologista");

        Paciente paciente1 = new Paciente("Ana", 30, "Doença Cardíaca");
        Paciente paciente2 = new Paciente("João", 40, "Enxaqueca");

        // Estabelecendo associações
        medico1.addPaciente(paciente1);
        medico2.addPaciente(paciente2);
        medico2.addPaciente(paciente1);

        paciente1.addDoutor(medico1);
        paciente1.addDoutor(medico2);
        paciente2.addDoutor(medico2);

        // Marcando consultas
        medico1.marcarConsulta(paciente1, "2024-08-01");
        medico2.marcarConsulta(paciente2, "2024-08-02");
        medico2.marcarConsulta(paciente1, "2024-08-03");

        // Exibindo informações
        medico1.displayInfo();
        medico2.displayInfo();
        paciente1.displayInfo();
        paciente2.displayInfo();

        // Exibindo consultas
        for (Consulta consulta : medico1.getConsultas()) {
            System.out.println(consulta);
        }
        for (Consulta consulta : medico2.getConsultas()) {
            System.out.println(consulta);
        }
    }
}