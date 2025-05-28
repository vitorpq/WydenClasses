package Lab05;

class Pessoa{
        // Atributos
        private int idade;
        private String nome;

        /*
        Polimorfismo estático
         */
        // Construtor 1
        public Pessoa(String nome, int idade){
            this.nome = nome;
            this.idade = idade;
        };

        // Métodos - getters and setters
        // Getters
        public String getNome(){
            return nome;
        }

        public int getIdade()
        {
            return idade;
        }

        // Setters
        public void setNome(String nome){
            this.nome = nome;
        }

        public void setIdade(int idade){
            this.idade = idade;
        }

        // Método que retorna todas os atributos da Classe
        public void displayInfo(){
            System.out.println("Nome: "+ getNome() + " e Idade: " + getIdade());
        }

        }

        class Aluno extends Pessoa{
            // Atributo
            private int Matricula;

            // Construtor
            public Aluno (String nome, int idade, int Matricula){
                super(nome, idade);
                this.Matricula = Matricula;
            }
            // Métodos Getters
            public int getMatricula(){
                return Matricula;
            }

            // Polimorfismo Dinâmico
            @Override
            public void displayInfo(){
                System.out.println("Nome: "+ getNome() + ", Idade: " + getIdade() + " e Matrícula: " + getMatricula());
            }

        }


public class Polimorfismo {
    public static void main(String[] args) {
        Pessoa pessoaOne = new Pessoa("Ana", 24);
        pessoaOne.displayInfo();

        pessoaOne.setIdade(15);
        pessoaOne.setNome("Luiz");
        //
        Aluno alunoOne = new Aluno(pessoaOne.getNome(), pessoaOne.getIdade(), 123456);
        alunoOne.displayInfo();
    }
}
