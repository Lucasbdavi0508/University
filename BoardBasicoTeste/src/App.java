import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class App extends JFrame implements ActionListener {
    private Personagem personagem;
    private final Tabuleiro tabuleiro;
    private final ArrayList<Destino> destinos;
    private final ArrayList<Marker> markers;
    private final Fases fases;

    public App() {
        super();
        // Define os componentes da tela
        tabuleiro = new Tabuleiro();
        destinos = new ArrayList<>();
        fases = new Fases();
        markers = new ArrayList<>();

        JPanel botoesDirecao = new JPanel(new FlowLayout());
        JButton butDir = new JButton("Direita");
        butDir.addActionListener(this);
        JButton butEsq = new JButton("Esquerda");
        butEsq.addActionListener(this);
        JButton butCima = new JButton("Acima");
        butCima.addActionListener(this);
        JButton butBaixo = new JButton("Abaixo");
        butBaixo.addActionListener(this);
        JButton butReset = new JButton("Reset");
        butReset.addActionListener(this);
        JButton butFinal = new JButton("Terminei");
        butFinal.addActionListener(this);

        botoesDirecao.add(butEsq);
        botoesDirecao.add(butDir);
        botoesDirecao.add(butCima);
        botoesDirecao.add(butBaixo);
        botoesDirecao.add(butReset);
        botoesDirecao.add(butFinal);

        JPanel painelGeral = new JPanel();
        painelGeral.setLayout(new BoxLayout(painelGeral, BoxLayout.PAGE_AXIS));
        painelGeral.add(tabuleiro);
        painelGeral.add(botoesDirecao);

        /* COMEÇA AREA DE MANUSEIO */

        this.setTabuleiroComFase();

        /* ACABA AREA DE MANUSEIO */
        this.add(painelGeral);

        this.setSize(1300, 1100);
        this.setTitle("Sokoban");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true);
        tabuleiro.atualizaVisualizacao();
    }

    private void setTabuleiroComFase() {
        String fase = fases.getFase();

        for (int i = 0; i < Tabuleiro.getMaxlin(); i++) {
            for (int j = 0; j < Tabuleiro.getMaxcol(); j++) {
                char cur = fase.charAt(j + i * Tabuleiro.getMaxcol());

                if (cur == 'p') {
                    tabuleiro.insereElemento(new Parede("0", i, j, tabuleiro));
                } else if (cur == 'j') {
                    personagem = new Personagem("jogador", "chad.jpg", i, j, tabuleiro);
                    personagem.setAnterior(tabuleiro.insereElemento(personagem));
                } else if (cur == 'c') {
                    Caixa caixa = new Caixa("caixa", i, j, tabuleiro);
                    caixa.setAnterior(tabuleiro.insereElemento(caixa));
                } else if (cur == 'd') {
                    Destino destino = new Destino("dest", i, j, tabuleiro);
                    tabuleiro.insereElemento(destino);
                    destinos.add(destino);
                } else if (cur == ' ') {
                    tabuleiro.insereElemento(new Fundo("f", i, j, tabuleiro));
                } else if (cur == 'm') {
                    Marker marker = new Marker("m", i, j, tabuleiro);
                    tabuleiro.insereElemento(marker);
                    markers.add(marker);
                }
            }
        }
    }

    /*
     * 
     * CONSERTAR PASSAGEM DE NIVEL
     */

    @Override
    public void actionPerformed(ActionEvent arg0) {
        JButton but = (JButton) arg0.getSource();
        if (but.getText().equals("Direita")) {
            personagem.moveDireita();
        }
        if (but.getText().equals("Esquerda")) {
            personagem.moveEsquerda();
        }
        if (but.getText().equals("Acima")) {
            personagem.moveCima();
        }
        if (but.getText().equals("Abaixo")) {
            personagem.moveBaixo();
        }

        if (but.getText().equals("Reset")) {
            this.setTabuleiroComFase();
        }
        
        if (but.getText().equals("Terminei")) {
            if (this.checarTerminou()) {
                fases.passarFase();
                if (fases.checarTerminou()) {
                    JOptionPane.showMessageDialog(getRootPane(), "Parabens, Você Ganhou");
                }
                this.setTabuleiroComFase();
            }
        }

        tabuleiro.atualizaVisualizacao();
    }

    private boolean checarTerminou() {
        for (Destino destino : this.destinos) {
            if (!destino.getChecked()) {
                return false;
            }
        }

        for (Marker marker : this.markers) {
            if (!marker.getChecked()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }
}