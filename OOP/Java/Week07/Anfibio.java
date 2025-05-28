class Anfibio extends Veiculo implements Voavel, Navegavel {

    public Anfibio(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public void acelerar() {
        System.out.println("O anfíbio " + marca + " " + modelo + " está acelerando.");
    }

    @Override
    public void voar() {
        System.out.println("O anfíbio " + marca + " " + modelo + " está voando.");
    }

    @Override
    public void navegar(String destino) {
        System.out.println("O anfíbio " + marca + " " + modelo + " está navegando para " + destino + ".");
    }
}
