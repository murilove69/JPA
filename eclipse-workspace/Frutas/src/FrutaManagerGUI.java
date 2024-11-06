import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Bibliotecas fornecem as ferramentas para criar, exibir e interagir com a interface gráfica.
public class FrutaManagerGUI {
	private ArrayList<String> frutas;
	private DefaultListModel<String> listModel;
	private JList<String> list;

	public FrutaManagerGUI() {
		frutas = new ArrayList<>();
		listModel = new DefaultListModel<>();
//Método padrão para a criação da tela
		JFrame frame = new JFrame("Gerenciador de Frutas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		frame.setLayout(new BorderLayout());
//Criando um novo Panel
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
//Informando o tamanho do texto
		JTextField frutaField = new JTextField(15);
		panel.add(frutaField);
//Criando o botão para adicionar a fruta
		JButton addButton = new JButton("Adicionar");
		panel.add(addButton);
		// Criando o botão para fazer a modificação do nome da fruta
		JButton modifyButton = new JButton("Modificar");
		modifyButton.setEnabled(false);
		panel.add(modifyButton);
//Criação do botão que faz a remoção da fruta da lista
		JButton removeButton = new JButton("Remover");
		removeButton.setEnabled(false);
		panel.add(removeButton);

		frame.add(panel, BorderLayout.NORTH);

		list = new JList<>(listModel);
		JScrollPane scrollPane = new JScrollPane(list);
		frame.add(scrollPane, BorderLayout.CENTER);

		JButton listButton = new JButton("Listar Frutas");
		frame.add(listButton, BorderLayout.SOUTH);
//Define o que deve acontecer quando o botão "Adicionar" é clicado pelo usuário.
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String novaFruta = frutaField.getText();
				if (!novaFruta.isEmpty()) {
					frutas.add(novaFruta);
					listModel.addElement(novaFruta);
					frutaField.setText("");
					JOptionPane.showMessageDialog(frame, novaFruta + " foi adicionada.");
				}
			}
		});
//Permite ao usuário modificar uma fruta já existente na lista, já dando a funcionalidade ao botão.
		modifyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list.getSelectedIndex();
				if (selectedIndex != -1) {
					String frutaSelecionada = listModel.getElementAt(selectedIndex);
					String novaFruta = JOptionPane.showInputDialog(frame, "Modificar " + frutaSelecionada + " para:",
							frutaSelecionada);
					if (novaFruta != null && !novaFruta.isEmpty()) {
						frutas.set(selectedIndex, novaFruta);
						listModel.set(selectedIndex, novaFruta);
						JOptionPane.showMessageDialog(frame,
								"Fruta " + frutaSelecionada + " foi modificada para " + novaFruta);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Selecione uma fruta para modificar.");
				}
			}
		});
		// Criando a opção do usuário poder remover a fruta, após seleciona-la e
		// apertando este botão.
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list.getSelectedIndex();
				if (selectedIndex != -1) {
					String frutaRemovida = frutas.remove(selectedIndex);
					listModel.remove(selectedIndex);
					JOptionPane.showMessageDialog(frame, frutaRemovida + " foi removida.");
				} else {
					JOptionPane.showMessageDialog(frame, "Selecione uma fruta para remover.");
				}
			}
		});
		// Fazendo a exibição da lista após o usuário clicar no BOTÃO "listar frutas".
		listButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (frutas.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Nenhuma fruta na lista.");
				} else {
					JOptionPane.showMessageDialog(frame, "Frutas: " + frutas);
				}
			}
		});

		// Isso aqui serve basicamente pro programa entender se o usuário clicou ou não
		// no nome da fruta, para eventualmente fazer a remoção ou modificação.
		list.addListSelectionListener(e -> {
			boolean selectionExists = !list.isSelectionEmpty();
			removeButton.setEnabled(selectionExists);
			modifyButton.setEnabled(selectionExists);
		});

		// Tornar a janela visível
		frame.setVisible(true);
	}

//Executando/exibindo a janela.
	public static void main(String[] args) {
		new FrutaManagerGUI();
	}
}
