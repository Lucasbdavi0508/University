// classe para padronizar o print dos menus de opçoes no terminal

public class terminal {
    
    // Metodo para formar o a imagem do terminal da pagina dos metodos especificados
    public static String terminal_metodos() {
        return "----------------------------------------------------------\n" + 
        "|Quantidade de animais de cada tipo e categoria       1  |\n"+
        "|Peso pesado                                          2  |\n"+
        "|Quantidade de carne para carnívoros                  3  |\n"+
        "|Dá tempo de fugir?                                   4  |\n"+
        "|Zonas perigosas do parque                            5  |\n"+
        "|nome dos dinossauros que possuem mais vogais         6  |\n"+
        "|                                                        |\n"+
        "|                                                        |\n"+
        "|                               Voltar  7       Sair  0  |\n"+
        "----------------------------------------------------------\n";
    }
    
    // Print padrao da classe terminal
    public String toString(){
        return "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n----------------------------------------------------------\n" + 
        "|Registrar Dinossauro                                 1  |\n"+
        "|Ver Registro                                         2  |\n"+
        "|Métodos Disponiveis                                  3  |\n"+
        "|Remover um Dinossauro Registrado                     4  |\n"+
        "|Pesquisar um Dinossauro por ID                       5  |\n"+
        "|                                                        |\n"+
        "|                                                        |\n"+
        "|                                                        |\n"+
        "|                                               Sair  0  |\n"+
        "----------------------------------------------------------\n";
    }
}

