import java.util.List;
import java.util.ArrayList;

public class Disciplina {
    public String nome;
    public int cargaHoraria;
    public String codigo;
    public Professor professor;
    public List<Turmas> turma;
    public List<Atividades> atividades;

    public Disciplina(String nome, int cargaHoraria, String codigo, Professor professor) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
        this.professor = professor;
        this.turma = new ArrayList<>();
        professor.adicionarDisciplina(this);
        this.atividades = new ArrayList<>();
    }

    public Disciplina(String nome, String codigo, Professor professor){
        this.nome = nome;
        this.cargaHoraria = 180;
        this.codigo = codigo;
        this.professor = professor;
        this.turma = new ArrayList<>();
        professor.adicionarDisciplina(this);
        this.atividades = new ArrayList<>();
    }
    public void adicionarTurmas(Turmas t) {
        turma.add(t);
    }

    public String getNome() {
        return this.nome;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Carga Horária: " + cargaHoraria);
        System.out.println("Código: " + codigo);
        System.out.println("Professor: " + professor.nome);
        System.out.println("Alunos: ");
        for (Turmas t : turma) {
            for (Aluno a : t.alunos) {
                System.out.println(" - " + a.nome);
            }
        }
    }


}
