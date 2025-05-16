import java.util.List;
import java.util.ArrayList;

public class Aluno extends Pessoa {
    public String matricula;
    public Turmas turma;
    public Armario armario;
    public List<Disciplina> disciplinas;

    public Aluno (String nome, int idade, String cpf, String matricula, Turmas turma) {
        super(nome, idade, cpf);
        this.matricula = matricula;
        this.turma = turma;
        turma.adicionarAluno(this);
        this.disciplinas = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina d) {
        disciplinas.add(d);
    }

    public void adicionarArmario(Armario armario) {
        this.armario = armario;
        this.armario.aluno = this;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + cpf);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Turma: " + turma.nome);
        System.out.println("Disciplinas: ");
        for (Disciplina d : disciplinas) {
            System.out.println(" - " + d.nome);
        }
    }
}
