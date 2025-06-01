// Interface comum que define o comportamento esperado de um relatório
interface Relatorio {
    void exibir(); // método que deve ser implementado por qualquer tipo de relatório
}

// Classe real que representa um relatório financeiro pesado/confidencial
class RelatorioFinanceiroReal implements Relatorio {

    // Construtor - simula uma operação custosa, como carregar dados de um banco
    public RelatorioFinanceiroReal() {
        carregarDados();
    }

    // Simula um carregamento demorado de dados financeiros
    private void carregarDados() {
        System.out.println("Carregando dados financeiros confidenciais...");
    }

    // Exibe o conteúdo do relatório
    @Override
    public void exibir() {
        System.out.println("Relatório: Lucro líquido em maio foi de R$ 100.000,00");
    }
}

// Classe Proxy que controla o acesso ao RelatorioFinanceiroReal
class ProxyRelatorioFinanceiro implements Relatorio {

    // Referência para o objeto real (só é instanciado quando necessário)
    private RelatorioFinanceiroReal relatorioReal;

    // Nome do usuário atual que está tentando acessar
    private String usuario;

    // Construtor do proxy recebe o nome do usuário
    public ProxyRelatorioFinanceiro(String usuario) {
        this.usuario = usuario;
    }

    // Método que controla o acesso ao relatório real
    @Override
    public void exibir() {
        // Verifica se o usuário tem permissão para ver o relatório
        if (usuario.equalsIgnoreCase("admin")) {
            // Se o objeto real ainda não foi criado, cria agora (lazy initialization)
            if (relatorioReal == null) {
                relatorioReal = new RelatorioFinanceiroReal();
            }
            // Exibe o relatório real
            relatorioReal.exibir();
        } else {
            // Caso o usuário não seja autorizado
            System.out.println("Acesso negado: usuário não autorizado.");
        }
    }
}
