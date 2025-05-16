import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Turmas> turmas = new ArrayList<>();
        ArrayList<Armario> armarios = new ArrayList<>();
        ArrayList<Professor> professores = new ArrayList<>();
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        ArrayList<Pessoa> alunos = new ArrayList<>();
        ArrayList<Atividades> atividades = new ArrayList<>();

        boolean ligado = true;

        while (ligado) {
            try {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Criar turma");
                System.out.println("2. Criar armário");
                System.out.println("3. Criar professor");
                System.out.println("4. Criar disciplina");
                System.out.println("5. Criar aluno");
                System.out.println("6. Criar atividade");
                System.out.println("7. Adicionar turma à disciplina");
                System.out.println("8. Exibir comunicado da atividade");
                System.out.println("9. Adicionar armário ao aluno");
                System.out.println("10. Adicionar armário ao professor");
                System.out.println("11. Exibir dados de um armário");
                System.out.println("12. Exibir dados de alunos");
                System.out.println("13. Exibir dados de professores");
                System.out.println("14. Exibir dados de disciplinas");
                System.out.println("15. Exibir dados de turmas");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Nome da turma: ");
                        String nomeTurma = scanner.nextLine();
                        System.out.print("Ano da turma: ");
                        int anoTurma = scanner.nextInt();
                        turmas.add(new Turmas(nomeTurma, anoTurma));
                        System.out.println("Turma criada com sucesso.");
                        break;
                    case 2:
                        System.out.print("Número do armário: ");
                        int numeroArmario = scanner.nextInt();
                        armarios.add(new Armario(numeroArmario));
                        System.out.println("Armário criado com sucesso.");
                        break;
                    case 3:
                        System.out.print("Nome do professor: ");
                        String nomeProfessor = scanner.nextLine();
                        System.out.print("Idade do professor: ");
                        int idadeProfessor = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("CPF do professor: ");
                        String cpfProfessor = scanner.nextLine();
                        professores.add(new Professor(nomeProfessor, idadeProfessor, cpfProfessor));
                        System.out.println("Professor criado com sucesso.");
                        break;
                    case 4:
                        System.out.print("Nome da disciplina: ");
                        String nomeDisciplina = scanner.nextLine();
                        System.out.print("Código da disciplina: ");
                        String codigoDisciplina = scanner.nextLine();
                        if (professores.isEmpty()) {
                            System.out.println("Nenhum professor disponível. Crie um professor primeiro.");
                            break;
                        }
                        System.out.println("Escolha o professor pelo índice:");
                        for (int i = 0; i < professores.size(); i++) {
                            System.out.println(i + ". " + professores.get(i).getNome());
                        }
                        int indiceProfessor = scanner.nextInt();
                        disciplinas.add(new Disciplina(nomeDisciplina, codigoDisciplina, professores.get(indiceProfessor)));
                        System.out.println("Disciplina criada com sucesso.");
                        break;
                    case 5:
                        System.out.print("Nome do aluno: ");
                        String nomeAluno = scanner.nextLine();
                        System.out.print("Idade do aluno: ");
                        int idadeAluno = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("CPF do aluno: ");
                        String cpfAluno = scanner.nextLine();
                        System.out.print("Matrícula do aluno: ");
                        String matriculaAluno = scanner.nextLine();
                        if (turmas.isEmpty()) {
                            System.out.println("Nenhuma turma disponível. Crie uma turma primeiro.");
                            break;
                        }
                        System.out.println("Escolha a turma pelo índice:");
                        for (int i = 0; i < turmas.size(); i++) {
                            System.out.println(i + ". " + turmas.get(i).getNome());
                        }
                        int indiceTurma = scanner.nextInt();
                        alunos.add(new Aluno(nomeAluno, idadeAluno, cpfAluno, matriculaAluno, turmas.get(indiceTurma)));
                        System.out.println("Aluno criado com sucesso.");
                        break;
                    case 6:
                        System.out.print("Nome da atividade: ");
                        String nomeAtividade = scanner.nextLine();
                        System.out.print("Nota máxima da atividade: ");
                        int notaMaxima = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha
                        System.out.print("Descrição da atividade: ");
                        String descricaoAtividade = scanner.nextLine();
                        if (disciplinas.isEmpty()) {
                            System.out.println("Nenhuma disciplina disponível. Crie uma disciplina primeiro.");
                            break;
                        }
                        System.out.println("Escolha a disciplina pelo índice:");
                        for (int i = 0; i < disciplinas.size(); i++) {
                            System.out.println(i + ". " + disciplinas.get(i).getNome());
                        }
                        int indiceDisciplina = scanner.nextInt();
                        atividades.add(new Atividades(nomeAtividade, notaMaxima, descricaoAtividade, disciplinas.get(indiceDisciplina)));
                        System.out.println("Atividade criada com sucesso.");
                        break;
                    case 7:
                        if (disciplinas.isEmpty()) {
                            System.out.println("Nenhuma disciplina disponível. Crie uma disciplina primeiro.");
                            break;
                        }
                        if (turmas.isEmpty()) {
                            System.out.println("Nenhuma turma disponível. Crie uma turma primeiro.");
                            break;
                        }
                        System.out.println("Escolha a disciplina pelo índice:");
                        for (int i = 0; i < disciplinas.size(); i++) {
                            System.out.println(i + ". " + disciplinas.get(i).getNome());
                        }
                        int indiceDisciplinaTurma = scanner.nextInt();
                        System.out.println("Escolha a turma pelo índice:");
                        for (int i = 0; i < turmas.size(); i++) {
                            System.out.println(i + ". " + turmas.get(i).getNome());
                        }
                        int indiceTurmaDisciplina = scanner.nextInt();
                        disciplinas.get(indiceDisciplinaTurma).adicionarTurmas(turmas.get(indiceTurmaDisciplina));
                        System.out.println("Turma adicionada à disciplina.");
                        break;
                    case 8:
                        if (atividades.isEmpty()) {
                            System.out.println("Nenhuma atividade disponível. Crie uma atividade primeiro.");
                            break;
                        }
                        System.out.println("Escolha a atividade pelo índice:");
                        for (int i = 0; i < atividades.size(); i++) {
                            System.out.println(i + ". " + atividades.get(i).getNome());
                        }
                        int indiceAtividade = scanner.nextInt();
                        atividades.get(indiceAtividade).comunicado();
                        break;
                    case 9:
                        if (alunos.isEmpty()) {
                            System.out.println("Nenhum aluno disponível. Crie um aluno primeiro.");
                            break;
                        }
                        if (armarios.isEmpty()) {
                            System.out.println("Nenhum armário disponível. Crie um armário primeiro.");
                            break;
                        }
                        System.out.println("Escolha o aluno pelo índice:");
                        for (int i = 0; i < alunos.size(); i++) {
                            System.out.println(i + ". " + alunos.get(i).getNome());
                        }
                        int indiceAluno = scanner.nextInt();
                        System.out.println("Escolha o armário pelo índice:");
                        for (int i = 0; i < armarios.size(); i++) {
                            if (armarios.get(i).aluno != null) {
                                System.out.println(i + ". Armário " + armarios.get(i).getNumero() + " - Já ocupado!");
                            } else {
                                System.out.println(i + ". Armário " + armarios.get(i).getNumero());
                            }
                        }
                        int indiceArmarioAluno = scanner.nextInt();
                        alunos.get(indiceAluno).adicionarArmario(armarios.get(indiceArmarioAluno));
                        System.out.println("Armário adicionado ao aluno.");
                        break;
                    case 10:
                        if (professores.isEmpty()) {
                            System.out.println("Nenhum professor disponível. Crie um professor primeiro.");
                            break;
                        }
                        if (armarios.isEmpty()) {
                            System.out.println("Nenhum armário disponível. Crie um armário primeiro.");
                            break;
                        }
                        System.out.println("Escolha o professor pelo índice:");
                        for (int i = 0; i < professores.size(); i++) {
                            System.out.println(i + ". " + professores.get(i).getNome());
                        }
                        int indiceProfessorArmario = scanner.nextInt();
                        System.out.println("Escolha o armário pelo índice:");
                        for (int i = 0; i < armarios.size(); i++) {
                            if (armarios.get(i).aluno != null) {
                                System.out.println(i + ". Armário " + armarios.get(i).getNumero() + " - Já ocupado!");
                            } else {
                                System.out.println(i + ". Armário " + armarios.get(i).getNumero());
                            }
                        }
                        int indiceArmarioProfessor = scanner.nextInt();
                        professores.get(indiceProfessorArmario).adicionarArmario(armarios.get(indiceArmarioProfessor));
                        System.out.println("Armário adicionado ao professor.");
                        break;
                    case 11:
                        if (armarios.isEmpty()) {
                            System.out.println("Nenhum armário disponível. Crie um armário primeiro.");
                            break;
                        }
                        System.out.println("Escolha o armário pelo índice:");
                        for (int i = 0; i < armarios.size(); i++) {
                            System.out.println(i + ". Armário " + armarios.get(i).getNumero());
                        }
                        int indiceArmario = scanner.nextInt();
                        armarios.get(indiceArmario).exibirDados();
                        break;
                    case 12:
                        if (alunos.isEmpty()) {
                            System.out.println("Nenhum aluno disponível. Crie um aluno primeiro.");
                            break;
                        }
                        System.out.println("\n--- Dados dos Alunos ---");
                        for (Pessoa aluno : alunos) {
                            aluno.exibirDados();
                        }
                        break;
                    case 13:
                        if (professores.isEmpty()) {
                            System.out.println("Nenhum professor disponível. Crie um professor primeiro.");
                            break;
                        }
                        System.out.println("\n--- Dados dos Professores ---");
                        for (Professor professor : professores) {
                            professor.exibirDados();
                        }
                        break;
                    case 14:
                        if (disciplinas.isEmpty()) {
                            System.out.println("Nenhuma disciplina disponível. Crie uma disciplina primeiro.");
                            break;
                        }
                        System.out.println("\n--- Dados das Disciplinas ---");
                        for (Disciplina disciplina : disciplinas) {
                            disciplina.exibirDados();
                        }
                        break;
                    case 15:
                        if (turmas.isEmpty()) {
                            System.out.println("Nenhuma turma disponível. Crie uma turma primeiro.");
                            break;
                        }
                        System.out.println("\n--- Dados das Turmas ---");
                        for (Turmas turma : turmas) {
                            turma.exibirDados();
                        }
                        break;
                    case 0:
                        ligado = false;
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um valor correto.");
                scanner.nextLine(); 
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Índice inválido. Por favor, tente novamente.");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
