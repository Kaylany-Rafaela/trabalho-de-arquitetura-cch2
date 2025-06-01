// Classe principal que executa o programa
public class Main {

    // Método main - ponto de entrada da aplicação
    public static void main(String[] args) {

        // Criando um proxy com usuário 'admin' (autorizado)
        Relatorio relatorioAdmin = new ProxyRelatorioFinanceiro("admin");

        // Criando um proxy com usuário 'joao' (não autorizado)
        Relatorio relatorioUser = new ProxyRelatorioFinanceiro("joao");

        // Tentativa de acesso com usuário autorizado
        System.out.println("Usuário admin acessando:");
        relatorioAdmin.exibir();

        // Linha em branco para separar visualmente os testes
        System.out.println();

        // Tentativa de acesso com usuário não autorizado
        System.out.println("Usuário joao acessando:");
        relatorioUser.exibir();
    }
}
