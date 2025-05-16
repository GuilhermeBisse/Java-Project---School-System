public class Atividades {
    public String nome;
    public String descricao;
    public int peso;
    public Disciplina disciplina;

    public Atividades(String nome, int peso, String descricao, Disciplina disciplina) {
        this.nome = nome;
        this.peso = peso;
        this.descricao = descricao;
        this.disciplina = disciplina;
    }

    public String getNome() {
        return this.nome;
    }

    public void comunicado(){
        System.out.println("Atividade: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Peso: " + peso);
        System.out.println("Disciplina: " + disciplina.nome);
        System.out.println("Professor: " + disciplina.professor.nome);
        System.out.println("Enviando mensagem para os alunos: ");
        for (Turmas t : disciplina.turma) {
            for (Aluno a : t.alunos) {
                System.out.println(" - " + a.nome);
            }
        }
    }


}
