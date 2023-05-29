import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BasicRenumber {

    private String narq;
    private List<List<String>> tokenHolder;
    HashMap<String, String> numberMap = new HashMap<>();


    public BasicRenumber(String narq){
        this.narq = narq;
        tokenHolder = new ArrayList<>(new ArrayList<>());
    }

    public void loadProgram() {
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir + "/" + narq + ".bas";
        Path path2 = Paths.get(nameComplete);
        try (Scanner sc = new Scanner(Files.newBufferedReader(path2, Charset.defaultCharset()))) {
            int lineNumber = 10;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] tokens = line.split(" ");
                numberMap.put(tokens[0], String.valueOf(lineNumber));
                tokenHolder.add(Arrays.asList(tokens));   
                lineNumber += 10;
            }
            
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }

    public String correctLine(List<String> line){
        line.set(0, numberMap.get(line.get(0)));

        for (int i = 1; i < line.size(); i++) {
            String token = line.get(i);
            if (token.toLowerCase().equals("goto") || token.toLowerCase().equals("gosub") ){
                line.set(i + 1, numberMap.get(line.get(i+1)));
            }
        }

        return String.join(" ", line);
    }

    public void outputProgram(){
        try (FileWriter myWriter = new FileWriter(narq + "-rn.bas")){
            for (List<String> list : tokenHolder) {
                myWriter.write(correctLine(list) + "\n");
            }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }

}