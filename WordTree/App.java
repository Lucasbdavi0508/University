
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        LinkedList<Palavra> lista = new LinkedList<>();
        String aux[];
                
        Path path1 = Paths.get("dicionario.csv");

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("UTF-8"))) {// Charset.defaultCharset())
            String line = reader.readLine();
            while (line != null) {
                aux = line.split(";");
                Palavra p = new Palavra(aux[0],aux[1]);
                lista.add(p);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        } 

        WordTree wordTree = new WordTree();

        for (Palavra palavra : lista) {
            wordTree.addWord(palavra);
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite a pesquisa (por palavra ou prefixo):");
            String inp = scanner.nextLine().trim();
            inp = inp.substring(0, 1).toUpperCase() + inp.substring(1);
            List<String> wordList = wordTree.searchAll(inp);
            if (wordList.size() == 0) {
                System.out.println("Não foram encontradas palavras com esse prefixo");
                System.exit(0);
            }

            System.out.println("As palavras encontradas foram: ");
            int index = 1;
            for (String palavra: wordList) {
                System.out.println(index + ". " + palavra);
                index++;
            }

            System.out.println("Digite o número da palavra que queira ver o significado: ");
            int n = scanner.nextInt();

            System.out.println(wordTree.getWord(wordList.get(n-1)));


            
        }
        
    }
 
}
