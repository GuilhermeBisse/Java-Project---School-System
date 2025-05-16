import java.util.List;
import java.util.ArrayList;

public class Turmas {
    public String nome;
    public int ano;
    public List<Aluno> alunos;

    public Turmas(String nome, int ano) {
        this.nome = nome;
        this.ano = ano;
        this.alunos = new ArrayList<>();
    }
    public void adicionarAluno(Aluno a) {
        alunos.add(a);
    }

    public String getNome(){
        return this.nome;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Ano: " + ano);
        System.out.println("Alunos: ");
        for (Aluno a : alunos) {
            System.out.println(" - " + a.nome);
        }
    }
}
