import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner input = new Scanner(System.in);

        System.out.println("####################################");
        System.out.println("Bem vindo a API para consulta de CEP");
        System.out.println("Digite o CEP desejado para fazer a busca: ");
        String cep = input.nextLine();

        ConsultaCep consultaCep = new ConsultaCep();

        try{
            Endereco novoEndereco = consultaCep.buscaEndereco(cep);
            System.out.println(novoEndereco);
            GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
            geradorDeArquivo.salvaJson(novoEndereco);
        } catch (RuntimeException | IOException e){
            System.out.println("Erro encontrado: ");
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Finalizando a aplicação!");
            System.out.println("####################################");
        }
    }
}
