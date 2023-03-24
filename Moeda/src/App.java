public class App {
    public static void main(String[] args) {    
        Moeda[] moedas = {
            new Moeda(NomeMoeda.Cinco),
            new Moeda(NomeMoeda.Cinquenta),
            new Moeda(NomeMoeda.Um),
            new Moeda(NomeMoeda.VinteCinco),
            new Moeda(NomeMoeda.UmReal),
            new Moeda(NomeMoeda.Dez),
            new Moeda(NomeMoeda.Cinquenta),
            new Moeda(NomeMoeda.Um),
            new Moeda(NomeMoeda.UmReal),
            new Moeda(NomeMoeda.Cinco),
        };
        Cofrinho cofrinho = new Cofrinho(100);
        
        for (Moeda moeda : moedas) {
            cofrinho.insere(moeda);
        }

        System.out.println("Moedas iniciais adicionadas ao cofrinho");

        // 2)
        // a)
        System.out.println(cofrinho.getQtdadeMoedas() + " Moedas no total");

        // b)
        System.out.println(cofrinho.getQtdadeMoedasTipo(NomeMoeda.UmReal) + " Moedas de um real");

        // c)
        System.out.println(cofrinho.getQtdadeMoedasTipo(NomeMoeda.Cinquenta) + " Moedas de 50 centavos");

        // d)
        System.out.println("O cofrinho tem " + cofrinho.getValorTotalCentavos() + " centavos armazenados");

        // e)
        System.out.println("O cofrinho tem " + cofrinho.getValorTotalReais() + " reais armazenados");

        // f)
        System.out.println("Moeda " + cofrinho.retira() + " retirada do cofrinho");
        System.out.println("Moeda " + cofrinho.retira() + " retirada do cofrinho");

        System.out.println("O cofrinho tem " + cofrinho.getValorTotalCentavos() + " centavos armazenados");

    }
    
}
