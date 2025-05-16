public abstract class Pessoa {
    public String nome;
    public int idade;
    public String cpf;

    public Pessoa (String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }
    
    public void exibirDados(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + cpf);
    }

    public String getNome() {
        return nome;
    }
    public void adicionarArmario(Armario armario) {
        // Método vazio, pode ser sobrescrito nas subclasses
    }
}
