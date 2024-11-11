package modulos;
import javax.swing.*;

public class PaginaQuestoesModulo extends JFrame {
    private int acertos = 0;

    public PaginaQuestoesModulo() {
        setTitle("Questões do Módulo");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Define para tela cheia com bordas
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Questão 1
        JLabel pergunta1 = new JLabel("Questão 1: Qual é 2 + 2?");
        pergunta1.setBounds(400, 100, 300, 30); 
        add(pergunta1);

        JRadioButton opcao1 = new JRadioButton("3");
        opcao1.setBounds(400, 140, 100, 30);
        add(opcao1);

        JRadioButton opcao2 = new JRadioButton("4");
        opcao2.setBounds(510, 140, 100, 30);
        add(opcao2);

        JRadioButton opcao3 = new JRadioButton("5");
        opcao3.setBounds(620, 140, 100, 30); 
        add(opcao3);

        JRadioButton opcao4 = new JRadioButton("6");
        opcao4.setBounds(730, 140, 100, 30); 
        add(opcao4);

        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(opcao1);
        grupo1.add(opcao2);
        grupo1.add(opcao3);
        grupo1.add(opcao4);

        // Questão 2
        JLabel pergunta2 = new JLabel("Questão 2: Qual é 5 - 3?");
        pergunta2.setBounds(400, 200, 300, 30);
        add(pergunta2);

        JRadioButton opcao5 = new JRadioButton("1");
        opcao5.setBounds(400, 240, 100, 30);
        add(opcao5);

        JRadioButton opcao6 = new JRadioButton("2");
        opcao6.setBounds(510, 240, 100, 30);
        add(opcao6);

        JRadioButton opcao7 = new JRadioButton("3");
        opcao7.setBounds(620, 240, 100, 30); 
        add(opcao7);

        JRadioButton opcao8 = new JRadioButton("4");
        opcao8.setBounds(730, 240, 100, 30); 
        add(opcao8);

        ButtonGroup grupo2 = new ButtonGroup();
        grupo2.add(opcao5);
        grupo2.add(opcao6);
        grupo2.add(opcao7);
        grupo2.add(opcao8);

        // Questão 3
        JLabel pergunta3 = new JLabel("Questão 3: Qual é 3 x 3?");
        pergunta3.setBounds(400, 300, 300, 30);
        add(pergunta3);

        JRadioButton opcao9 = new JRadioButton("6");
        opcao9.setBounds(400, 340, 100, 30);
        add(opcao9);

        JRadioButton opcao10 = new JRadioButton("9");
        opcao10.setBounds(510, 340, 100, 30);
        add(opcao10);

        JRadioButton opcao11 = new JRadioButton("8");
        opcao11.setBounds(620, 340, 100, 30); 
        add(opcao11);

        JRadioButton opcao12 = new JRadioButton("12");
        opcao12.setBounds(730, 340, 100, 30);
        add(opcao12);

        ButtonGroup grupo3 = new ButtonGroup();
        grupo3.add(opcao9);
        grupo3.add(opcao10);
        grupo3.add(opcao11);
        grupo3.add(opcao12);

        // Questão 4
        JLabel pergunta4 = new JLabel("Questão 4: Qual é a capital da França?");
        pergunta4.setBounds(400, 400, 300, 30);
        add(pergunta4);

        JRadioButton opcao13 = new JRadioButton("Berlim");
        opcao13.setBounds(400, 440, 100, 30);
        add(opcao13);

        JRadioButton opcao14 = new JRadioButton("Madri");
        opcao14.setBounds(510, 440, 100, 30);
        add(opcao14);

        JRadioButton opcao15 = new JRadioButton("Paris");
        opcao15.setBounds(620, 440, 100, 30);
        add(opcao15);

        JRadioButton opcao16 = new JRadioButton("Roma");
        opcao16.setBounds(730, 440, 100, 30); 
        add(opcao16);

        ButtonGroup grupo4 = new ButtonGroup();
        grupo4.add(opcao13);
        grupo4.add(opcao14);
        grupo4.add(opcao15);
        grupo4.add(opcao16);

        // Botão para enviar respostas
        JButton botaoEnviar = new JButton("Enviar Respostas");
        botaoEnviar.setBounds(500, 500, 200, 40);
        botaoEnviar.addActionListener(e -> {
            acertos = 0;

            if (opcao2.isSelected()) acertos++; 
            if (opcao6.isSelected()) acertos++; 
            if (opcao10.isSelected()) acertos++; 
            if (opcao15.isSelected()) acertos++;

            if (acertos < 3) {
                JOptionPane.showMessageDialog(this, "Você errou. Tente novamente.");
            } else {
                dispose();
                new PaginaQuestaoSustentabilidade().setVisible(true);
            }
        });
        add(botaoEnviar);
    }
}
