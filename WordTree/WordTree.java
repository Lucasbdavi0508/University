// 4645G-04 - Algoritmos e Estruturas de Dados I
// 2023-1

import java.util.ArrayList;
import java.util.List;

public class WordTree {
    
    // Classe interna
    private class CharNode {
        private char character;
	    private String significado;
        private boolean isFinal;
        private CharNode father;
        private List<CharNode> children;

        public CharNode(char character, CharNode father) {
            this.character = character;
            this.father = father;
            this.children = new ArrayList<>();
        }

        public void setAsWord(String significado) {
            this.isFinal = true;
            this.significado = significado;
        }
        /**
        * Adiciona um filho (caracter) no nodo. Não pode aceitar caracteres repetidos.
        * @param character - caracter a ser adicionado
        * @param isfinal - se é final da palavra ou não
        */
        public void addChild (CharNode charNode) {
            this.children.add(charNode);
        }

        public String getSignificado() {
            return this.significado;
        }

        /**
         * Obtém a palavra correspondente a este nodo, subindo até a raiz da árvore
         * @return a palavra
         */
        private String getWord() {
            if (this.father == null) {
                return "";
            }

            return father.getWord() + this.character;
        }
        
        /**
        * Encontra e retorna o nodo que tem determinado caracter.
        * @param character - caracter a ser encontrado.
        */
        public CharNode findChildChar (char character) {
            for (CharNode charNode : children) {
                if (charNode.character == character) {
                    return charNode;
                }
            }

            return null;
        }
        
    }


    
    // Atributos
    private CharNode root;
    private int totalNodes = 0;
    private int totalWords = 0;
    


    // Construtor
    public WordTree() {
      this.root = new CharNode(' ', null);
    }


    
    // Metodos
    public int getTotalWords() {
        return totalWords;
    }

    public int getTotalNodes() {
        return totalNodes;
    }
    
    /**
    *Adiciona palavra na estrutura em árvore
    *@param word
    */
    public void addWord(Palavra palavra) {
        CharNode curNode = this.root;

        for (char curChar : palavra.getPalavra().toCharArray()) {
            CharNode nextNode = curNode.findChildChar(curChar);

            if (nextNode == null) {
                nextNode = new CharNode(curChar, curNode);
                totalNodes += 1;
                curNode.addChild(nextNode);
            }

            curNode = nextNode;
        }

        curNode.setAsWord(palavra.getSignificado());
        totalWords += 1;
    }
    
    /**
     * Vai descendo na árvore até onde conseguir encontrar a palavra
     * @param word
     * @return o nodo final encontrado
     */
    private CharNode findCharNodeForWord(String word) {
        CharNode cur = this.root;
        for (char curChar : word.toCharArray()) {
            cur = cur.findChildChar(curChar);
            if (cur == null) {
                return null;
            }
        }

        // DOESNT WORK IF WORD IS IN TREE BY ACCIDENT 
        
        return cur;
    }

    public Palavra getWord(String word) {
        CharNode finalNode = findCharNodeForWord(word);

        return new Palavra(finalNode.getWord(), finalNode.getSignificado());
    }
    public Palavra getWord(Palavra word) {
        CharNode finalNode = findCharNodeForWord(word.getPalavra());

        return new Palavra(finalNode.getWord(), finalNode.getSignificado());
    }

    private void searchAllHelper(CharNode node, List<String> wordList) {
        
        if (node.isFinal) {
            wordList.add(node.getWord());
        }

        for (CharNode curCharNode : node.children) {
            searchAllHelper(curCharNode, wordList);
        }
    }

    /**
    * Percorre a árvore e retorna uma lista com as palavras iniciadas pelo prefixo dado.
    * Tipicamente, um método recursivo.
    * @param prefix
    */
    public List<String> searchAll(String prefix) {
        CharNode cur = this.root;
        List<String> wordList = new ArrayList<>();
        for (char curChar : prefix.toCharArray()) {
            cur = cur.findChildChar(curChar);
            if (cur == null) {
                return wordList;
            }
        }

        searchAllHelper(cur, wordList);

        return wordList;

    }   

}
