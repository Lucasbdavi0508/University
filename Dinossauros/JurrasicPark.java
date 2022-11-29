import java.util.Scanner;

/* Classe a ser executada, que chama todas as outras quando necessario */

public class JurrasicPark {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CadastroDinossauro cadastro = new CadastroDinossauro();
        terminal terminal = new terminal();
        
        // loop infinito de execuçao do programa. Condiçao de saida e o System.exit(0)
        while (true){
            // chamada inutil de input, para atrasar o print do terminal, possibilitando ler os outputs dos metodos usados
            // anteriormente no seu tempo
            System.out.println("pressione enter para ir para o menu");
            input.nextLine();
            System.out.println(terminal);
            int option = input.nextInt();
            
            // sequencia de ifs e else ifs para definir o caminho com base no input do usuario
            if (option == 1){
                System.out.println("Adicione um novo dinossauro\n");
                System.out.print("Raça: ");
                input.nextLine();
                String raça = input.nextLine();
                System.out.print("Tipo (carnívoro[1], herbívoro[2]): ");
                int tipo = input.nextInt();
                System.out.print("categoria (Pequeno[1], Médio[2], Grande[3]): ");
                int categoria = input.nextInt();
                System.out.print("Peso (em kilogramas): ");
                float peso = input.nextFloat();
                if ((tipo != 1 && tipo != 2) || (categoria != 1 && categoria != 2 && categoria != 3)){
                    System.out.println("Dinossauro inválido");
                    input.nextLine();
                    continue;
                }
                boolean Validação = true;
                // loop de definiçao de ID, ate que um valido seja colocado
                while (Validação){
                    System.out.print("digite um id para seu dinossauro: ");
                    int id = input.nextInt();
                    if (cadastro.pesquisarDinossauro(id) != null){
                        System.out.println("id inválido\n");
                        input.nextLine();
                    }
                    else{
                        Validação = false;
                        cadastro.adicionarDinossauro(new Dinossauro(id, raça, tipo, categoria, peso));
                    }

                }
            }
            else if (option == 2){
                // printar todos os dinossauros
                int qtdDinossauros = 0;
                for (Dinossauro i: cadastro.cadastroDinossauros){
                    if (i == null){break;}
                    System.out.println(i);
                    qtdDinossauros++;
                }
                System.out.println(50 - qtdDinossauros + " Espaços livres no registro");
            }
            else if (option == 3){
                // passar o usuario para a pagina de metodos
                metodos.rodar_metodos(cadastro);
            }
            else if (option == 4){
                // apagar um dinossauro
                System.out.print("\n\n\nDigite a ID do dinossauro a ser apagado: ");
                int id = input.nextInt();
                cadastro.removerDinossauro(id);

            }
            else if (option == 5){
                // procurar um dinosauro pelo id
                System.out.print("\n\n\nDigite a ID do dinossauro que procura: ");
                int id = input.nextInt();
                if (cadastro.pesquisarDinossauro(id) == null){
                    System.out.println("dinossauro inexistente");
                }
                else{
                    System.out.println(cadastro.pesquisarDinossauro(id));
                }

            }
            else if (option == 0){
                // sair do loop do programa
                System.exit(0);
            }
        // limpeza de buffer para a "chamada inutil de input"
        input.nextLine();
        }
    }

}
