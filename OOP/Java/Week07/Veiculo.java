abstract class Veiculo {
    protected String marca;
    protected String modelo;

    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    // Método abstrato
    public abstract void acelerar();

    // Método concreto
    public void frear() {
        System.out.println("O veículo está freando.");
    }
}
