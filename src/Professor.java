import java.util.List;
import java.util.ArrayList;

public class Professor extends Pessoa {
    public List<Disciplina> disciplina;
    public Armario armario;

    public Professor (String nome, int idade, String cpf) {
        super(nome, idade, cpf);
        this.disciplina = new ArrayList<>();
    }

    public void adicionarArmario(Armario armario) {
        this.armario = armario;
        this.armario.professor = this;
    }

    public void adicionarDisciplina(Disciplina d) {
        disciplina.add(d);
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + cpf);
        System.out.println("Disciplinas: ");
        for (Disciplina d : disciplina) {
            System.out.println(" - " + d.nome);
        }
    }

}
