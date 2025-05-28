package SUS;

public class Consulta{
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
