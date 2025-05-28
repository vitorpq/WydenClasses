package SUS;

public class Main {
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

        // Adicionar informações ao prontuário
        paciente1.getProntuario().addHistorico("Paciente sentiu dor de cabeça. - Dr. Vitor 08/08/2024");

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
