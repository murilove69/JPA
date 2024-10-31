import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gerenciamento {
    public static void main(String[] args) {
       
    	//Criando um Scanner e determinando que o mesmo deve ser um Array.
    	Scanner scanner = new Scanner(System.in);
        ArrayList<String> frutas = new ArrayList<>();

      //Utilizando o while para informar claramente ao usuário quais opções ele tem.
        while (true) {
            try {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Adicionar uma fruta");
                System.out.println("2. Listar todas as frutas");
                System.out.println("3. Modificar uma fruta");
                System.out.println("4. Remover uma fruta");
                System.out.println("5. Sair");
                System.out.print("Opção: ");
                
           //Criando a variável "opção" que será a qual o usuário irá nos informar
                int opcao = scanner.nextInt();
                scanner.nextLine();

              //Usando um switch para criar as opções para o usuário
                switch (opcao) {
                //Se o usuário colocar o número 1, ele irá apenas informar o nome da fruta.
                    case 1:
                        System.out.print("Digite o nome da fruta para adicionar: ");
                        String novaFruta = scanner.nextLine();
                        frutas.add(novaFruta);
                        System.out.println(novaFruta + " foi adicionada.");
                        break;
                  //No caso de ele escolher o 2, serão apenas mostradas as frutas já informadas, através do println.
                    case 2:
                        System.out.println("Frutas:");
                        for (String fruta : frutas) {
                            System.out.println(fruta);
                        }
                        break;
                    //Se por ventura, o número 3 for escolhido, a pessoa poderá alterar alguma fruta que ela já informou, desde que informe o índice certo ou já existente
                    case 3:
                        System.out.print("Digite o índice da fruta que deseja modificar: ");
                        int indiceModificar = scanner.nextInt();
                        scanner.nextLine();
                        if (indiceModificar >= 0 && indiceModificar < frutas.size()) {
                            System.out.print("Digite o novo nome da fruta: ");
                            String frutaModificada = scanner.nextLine();
                            frutas.set(indiceModificar, frutaModificada);
                            System.out.println("Fruta no índice " + indiceModificar + " foi modificada para " + frutaModificada);
                        } else {
                            System.out.println("Índice inválido.");
                        }
                        break;
               //No caso 4, será utilizado apenas um Scanner para fazer a remoção de um nome, caso o mesmo seja informado corretamente.
                    case 4:
                        System.out.print("Digite o nome da fruta que deseja remover: ");
                        String frutaRemover = scanner.nextLine();
                        if (frutas.remove(frutaRemover)) {
                            System.out.println(frutaRemover + " foi removida.");
                        } else {
                            System.out.println(frutaRemover + " não foi encontrada.");
                        }
                        break;
               //Já no ultimo caso, o programa apenas se encerra.
                    case 5:
                        System.out.println("Saindo...");
                        scanner.close();
                        return;
                    //Usando um default para o caso do usuário "meter o louco" como diria o professor e inserir um número inexistente.
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }//Este try-catch serve para capturar erros do tipo InputMismatchException 
            catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
            }
        }
    }
}