public class Main {
    public static void main(String[] args) {
        // Criação de um avião
        Aviao aviao = new Aviao("Boeing", "747");
        aviao.acelerar();
        aviao.voar();
        aviao.frear();

        // Criação de um barco
        Barco barco = new Barco("Yamaha", "WaveRunner");
        barco.acelerar();
        barco.navegar("Ilha de Itaparica");
        barco.frear();

        // Criação de um anfíbio
        Anfibio anfibio = new Anfibio("Gibbs", "Aquada");
        anfibio.acelerar();
        anfibio.navegar("Porto Seguro");
        anfibio.voar();
        anfibio.frear();
    }
}
