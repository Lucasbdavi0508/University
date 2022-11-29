import java.util.Scanner;
import java.util.Arrays;


// Classe que define o funcionamento dos metodos necessarios com retorno 
// Tambem define seu principal metodo void "rodar_metodos", que roda tudo necessario para o funcionamento do menu de metodos
public class metodos {
    
    /* recebe um objeto da classe CadastroDinossauro e retorna a quantidade de dinossauros 
       de cada tipo e categoria no cadastro*/
    public static String qtdCategoria(CadastroDinossauro cadastro) {
        int c1 = 0, c2 = 0, c3 = 0, h1 = 0, h2 = 0, h3 = 0; // definiçao das variaveis de cada par tipo-categoria
        for (Dinossauro d : cadastro.cadastroDinossauros) { // loop pelo cadastro
            if (d == null){break;}
            if (d.getTipo() == 1) {
                if (d.getCategoria() == 1) {
                    c1++;
                }
                if (d.getCategoria() == 2) {
                    c2++;
                } else {
                    c3++;
                }
            } else {
                if (d.getCategoria() == 1) {
                    h1++;
                }
                if (d.getCategoria() == 2) {
                    h2++;
                } else {
                    h3++;
                }
            }
        }
        // retorno em String formatada adequadamente
        return "Carnívoros: PP:" + c1 + " MP:" + c2 + " GP:" + c3 + " Herbívoro: PP:" + h1 + " MP:" + h2 + " GP:" + h3;
    }
    
    /* recebe um tipo, uma categoria, e um array de dinossauros (originado de CadastroDinossauro.cadastroDinossauro) */
    private static Dinossauro pesoPesado(int tipo, int categoria, Dinossauro[] cadastro) {
        Dinossauro mais_pesado = cadastro[0];
        for (Dinossauro d : cadastro) { //loop por todos dinossauros do array
            if (d == null) {
                break;
            }
            if (d.getTipo() == tipo && d.getCategoria() == categoria) {
                // substituiçao da variavel mais_pesado, caso seja mais pesado e do tipo-categoria correto
                if (d.getPeso() > mais_pesado.getPeso()) { mais_pesado = d; }
            }
        }
        
        return mais_pesado;
    }
    
    /* recebe um array de dinossauros (originado de CadastroDinossauro.cadastroDinossauro) e retorna a quantidade
       de carne a ser comprada, segundo as regras descritas*/
    private static float qtdCarne(Dinossauro[] cadastro) {
        float qtd = 0;
        for (Dinossauro d : cadastro) {
            if (d == null) {
                break;
            }
            if (d.getTipo() == 1) {
                // caso seja carnivoro, adicionar a qtd a quantidade de alimento mensal do dinossauro de acordo com a sua categoria
                if (d.getCategoria() == 1) {
                    qtd += (d.getPeso() * 0.1) * 30;
                }
                if (d.getCategoria() == 2) {
                    qtd += (d.getPeso() * 0.15) * 30;
                }
                if (d.getCategoria() == 3) {
                    qtd += (d.getPeso() * 0.2) * 30;
                }
            }
        }
        // retorne quantidade
        return qtd;
    }
    
    /* recebe: Distancia do Dinossauro do bunker (dd); Distancia da Pessoa do bunker (dp);
       Velocidade do Dinossauro (vd)
       
       retorna: Um boolean, que define se o tempo da pessoa chegar ao bunker e menor que 
       o tempo do dinossauro de chegar*/
    private static boolean daPraFugir(float dd, float dp, float vd) {
        float tempo_pessoa = dp / 20;
        float tempo_dinossauro = dd / vd;
        return tempo_pessoa < tempo_dinossauro;

    }
    
    /* recebe uma matriz parque 150x150, e retorna se qual hemisferio (Norte ou Sul) e o mais
       perigoso (maior quantidade de carnivoros) */
    private static String zonasPerigosas(Dinossauro[][] parque) {
        int norte = 0; 
        int sul = 0;
        // loop ate 75, metade da matriz, para dividi-la em duas metades
        for (int i=0;i<75;i++){
            // loop por todas indices de cada linha
            for (int j=0;j<150;j++){
                if (parque[i][j] != null && parque[i][j].getTipo() == 1){norte++;} // primeia metade
                if (parque[149-i][j] != null && parque[149-i][j].getTipo() == 1){sul++;} // segunda metade
            }
        }
        if (norte > sul){return "Norte e mais perigoso";}
        if (norte < sul){return "Sul e mais perigoso";}
        // caso nenhum ganhe, ou nao tenha nenhum dinossauro
        return "Empate";
    }
    
    /* Recebe um array de dinossauros de retorna um outro array de dinossauros, com os dinossauros
       que possuem a maior quantidade de vogais, em ordem alfabetica*/
    private static Dinossauro[] maisVogais(Dinossauro[] cadastro) {
        int qtdVogais = 0; // sera a quantidade de vogais no nome do dinossauro com a maior quantidade de vogais
        int curVogais = 0; // sera a quantidade de vogais de cada dinossauro, modificando a cada iteraçao
        
        // primeiro loop, para definir qtdVogais, o maior numero entre todos curVogais
        for (Dinossauro d : cadastro) {
            if (d==null){break;}
            curVogais = 0;
            String nome = d.getNomeRaca().toLowerCase();
            for (int i = 0; i < nome.length(); i++) {
                if (nome.charAt(i) == 'a' || nome.charAt(i) == 'e' || nome.charAt(i) == 'i' || nome.charAt(i) == 'o'
                        || nome.charAt(i) == 'u') {
                    curVogais++;
                }
            }
            if (curVogais>qtdVogais){qtdVogais=curVogais;}
        }
        
        // definir array para colocar os dinossauros a serem retornados
        Dinossauro[] maisVogais = new Dinossauro[cadastro.length];
        
        int i = 0; // index a posicionar o dinossauro, quando necessario
        for (Dinossauro d : cadastro) {
            if (d==null){break;}
            curVogais = 0;
            String nome = d.getNomeRaca().toLowerCase();
            
            // contar a quantidade de vogais novamente
            for (int j = 0; j < nome.length(); j++) {
                if (nome.charAt(j) == 'a' || nome.charAt(j) == 'e' || nome.charAt(j) == 'i' || nome.charAt(j) == 'o'
                        || nome.charAt(j) == 'u') {
                    curVogais++;
                }
            }
            
            // posicionar no array caso tenha a maior quantidade de vogais
            if (curVogais==qtdVogais){
                maisVogais[i]=d;
                i++;
            }
        }
        
        // limpar o array de todos os elementos null
        Dinossauro[] cleanArr = new Dinossauro[i];
        for (int k = 0; k < i; k++){
            cleanArr[k] = maisVogais[k];
        }
        
        /* dar sort no array, com uma funçao comparador lambda, que usa os retorno de getNomeRaca
           como parametro de comparaçao*/
           
        Arrays.sort(cleanArr, (dino1, dino2) -> {
          return dino1.getNomeRaca().compareTo(dino2.getNomeRaca());  
        });
        return cleanArr;

    }
    
    /* recebe um objeto CadastroDinossauro, e roda todos os metodos especificados utilizando seu cadastro como base de dados
       
       Mostra o terminal para metodos e organiza seus chamamentos de acordo com o input do usuario
       */
    public static void rodar_metodos(CadastroDinossauro cadastro) {
        Scanner input = new Scanner(System.in);

        System.out.println(terminal.terminal_metodos());
        int option = input.nextInt();
        if (option == 1) {
            System.out.println(qtdCategoria(cadastro));
        } else if (option == 2) {
            System.out.println("Digite o Tipo e a Categoria: ");
            System.out.print("Tipo: ");
            int t = input.nextInt();
            System.out.print("Categoria: ");
            int c = input.nextInt();
            System.out.println("O Dinossauro mais pesado é: ");
            Dinossauro ans = pesoPesado(t, c, cadastro.cadastroDinossauros);
            if (ans == null){System.out.println("nao ha nenhum dinossauro");}
            else {System.out.println(pesoPesado(t, c, cadastro.cadastroDinossauros));}
        } else if (option == 3) {
            System.out.println("Quantidade de carne a ser comprada no mês: ");
            System.out.println(qtdCarne(cadastro.cadastroDinossauros));

        } else if (option == 4) {
            System.out.print("Distância entre o dinossauro e o bunker (em km): ");
            float dd = input.nextFloat();
            System.out.print("Distância entre a pessoa e o bunker (em km): ");
            float dp = input.nextFloat();
            System.out.print("Velocidade média do dinossauro (em km/h): ");
            float vd = input.nextFloat();

            if (daPraFugir(dd, dp, vd)) {
                System.out.println("Dá para fugir!");
            } else {
                System.out.println("CUIDADO: NÃO DA PARA FUGIR!!!");
            }

        } else if (option == 5){
            
            // criaçao da matriz da planta do parque
            Dinossauro[][] parque = new Dinossauro[150][150];
            
            // loop para pedir ao administrador a posiçao de cada dinossauro
            for (Dinossauro d : cadastro.cadastroDinossauros){
                if (d==null){break;}
                System.out.print("Digite a posição X do dinossauro "+d.getNomeRaca()+": ");
                int x = input.nextInt();
                System.out.print("Digite a posição Y do dinossauro "+d.getNomeRaca()+": ");
                int y = input.nextInt();
                parque[y][x]=d;
            }

            System.out.println(zonasPerigosas(parque));


        } else if (option == 6) {
            for (Dinossauro d: maisVogais(cadastro.cadastroDinossauros)){
                if (d==null){
                    break;
                }
                System.out.println("Dinossauros com mais vogais no nome: ");
                System.out.println(d);
            }


        } else if (option == 0) {
            System.exit(0);
        }
        input.nextLine(); // limpeza de buffer

    }
}
