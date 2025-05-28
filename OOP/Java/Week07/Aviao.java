class Aviao extends Veiculo implements Voavel {

    public Aviao(String marca, String modelo) {
        super(marca, modelo);
    }

    // Sobrecarga do método acelera() da Classe Abstrata Veiculo
    @Override
    public void acelerar() {
        System.out.println("O avião " + marca + " " + modelo + " está acelerando na pista.");
    }

    @Override
    public void voar() {
        System.out.println("O avião " + marca + " " + modelo + " está voando.");
    }

    @Override
    public void frear() {
        System.out.println("Avião não freia, cai!");
    }
}
