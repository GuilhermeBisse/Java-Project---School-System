public class Armario {
    public int numero;
    public Aluno aluno;
    public Professor professor;


public Armario(int numero) {
    this.numero = numero;
}

public int getNumero() {
    return numero;
}

public void exibirDados() {
    System.out.println("Número do armário: " + numero);
    if (aluno != null) {
        System.out.println("Aluno: " + aluno.nome);
    } else 
    if (professor != null) {
        System.out.println("Professor: " + professor.nome);
    } else {
        System.out.println("Armário vazio.");
    }
    System.out.println();
}
}