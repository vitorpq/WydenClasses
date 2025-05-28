class Barco extends Veiculo implements Navegavel {

    public Barco(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public void acelerar() {
        System.out.println("O barco " + marca + " " + modelo + " está acelerando na água.");
    }

    @Override
    public void navegar(String destino) {
        System.out.println("O barco " + marca + " " + modelo + " está navegando para " + destino + ".");
    }
}
