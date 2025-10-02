package view;

import controller.PacienteController;
import controller.ProfissionalSaudeController;
import controller.TeleconsultaController;
import model.Paciente;
import model.ProfissionalSaude;
import model.vo.TeleconsultaDetalhe;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ColaboradorView {

    private final PacienteController pacienteController;
    private final ProfissionalSaudeController profissionalSaudeController;
    private final TeleconsultaController teleconsultaController; // Novo atributo
    private final Scanner scanner;

    public ColaboradorView() {
        this.pacienteController = new PacienteController();
        this.profissionalSaudeController = new ProfissionalSaudeController();
        this.teleconsultaController = new TeleconsultaController(); // Nova instância
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("\n >>> Menu do Colaborador <<<");
            System.out.println("=============================");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Adicionar Profissional de Saúde");
            System.out.println("3. Visualizar Consultas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Digite um número.");
                scanner.nextLine(); // Limpa a entrada inválida
                opcao = 0;
            }

            switch(opcao) {
                case 1:
                    adicionarPaciente();
                    break;
                case 2:
                    adicionarProfissional();
                    break;
                case 3:
                    visualizarConsultas();
                    break;
                case 4:
                    System.out.println("Saindo do menu de Colaborador...");
                    break;
                default:
                    if (opcao != 4) System.out.println("Opção não reconhecida.");
            }

        }while(opcao != 4);
    }

    // MÉTODOS AUXILIARES

    private void adicionarPaciente() {
        System.out.println("\n--- Cadastro de Novo Paciente ---");

        Paciente novo = new Paciente();

        System.out.print("RGHC (Identificador): ");
        novo.setIdentificadorRghc(scanner.nextLine());

        System.out.print("CPF: ");
        novo.setCpfPaciente(scanner.nextLine());

        System.out.print("Nome: ");
        novo.setNomePaciente(scanner.nextLine());

        System.out.print("Data de Nascimento (DD/MM/AAAA): ");
        String dataStr = scanner.nextLine();

        System.out.print("Tipo Sanguíneo: ");
        novo.setTipoSanguineo(scanner.nextLine());

        // Validação e Conversão da Data
        LocalDate dataNasc = parseDate(dataStr);

        if (dataNasc == null) {
            System.err.println("Cadastro de Paciente cancelado.");
            return;
        }

        novo.setDataNascimento(dataNasc);

        pacienteController.adicionar(novo);
    }

    private void adicionarProfissional() {
        System.out.println("\n--- Cadastro de Novo Profissional de Saúde ---");

        ProfissionalSaude novo = new ProfissionalSaude();

        System.out.print("ID da Especialidade (Inteiro, Ex: 1-Clínico): ");

        if (scanner.hasNextInt()) {
            novo.setIdEspecialidade(scanner.nextInt());
            scanner.nextLine(); // Limpa o buffer
        } else {
            System.err.println("ERRO: O ID da Especialidade deve ser um número inteiro. Cadastro cancelado.");
            scanner.nextLine();
            return;
        }

        System.out.print("CPF: ");
        novo.setCpfProfissional(scanner.nextLine());

        System.out.print("Email Corporativo: ");
        novo.setEmailCorporativoProfissional(scanner.nextLine());

        System.out.print("Nome: ");
        novo.setNomeProfissionalSaude(scanner.nextLine());

        profissionalSaudeController.adicionar(novo);
    }

    private void visualizarConsultas() {
        System.out.println("\n--- Visualizar Consultas ---");
        // Chama o novo método do controller
        List<TeleconsultaDetalhe> consultas = teleconsultaController.listarTodasDetalhado();

        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta cadastrada!");
        } else {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-5s | %-20s | %-25s | %-15s | %-20s |\n", "ID", "Paciente", "Profissional", "Status", "Data/Hora");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

            for (TeleconsultaDetalhe detalhe : consultas) {
                String dataFormatada = (detalhe.getDataHoraConsulta() != null)
                        ? detalhe.getDataHoraConsulta().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
                        : "N/A";

                System.out.printf("| %-5d | %-20s | %-25s | %-15s | %-20s |\n",
                        detalhe.getIdConsulta(),
                        detalhe.getNomePaciente(),
                        detalhe.getNomeProfissional(),
                        detalhe.getNomeStatus(),
                        dataFormatada);
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    private LocalDate parseDate(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            System.err.println("ERRO: Formato de data inválido. Use o padrão DD/MM/AAAA.");
            return null;
        }
    }
}