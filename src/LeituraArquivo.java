import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class LeituraArquivo {

    private String[][] arquivos = new String[10][22]; // Armazena todos os dados dos arquivos de instruções no array arquivos
    private List<Integer> prioridades = new ArrayList<>(); // Armazena as prioridades dos processos.
    private int quantum; // Armazena valor do quantum.

    // Método de leitura dos dados dos arquivos em diretório.
    public LeituraArquivo() throws Exception {
        lerTxt();
        lerPrioridades();
        lerQuantum();
    }

    // Método de leitura dos arquivos de processos.
    private void lerTxt() throws Exception {
        int j = 0;
        for (int i = 1; i <= 10; i++) { // For utilizando a quantidade total de arquivos no diretório (10).
            if (i < 10) {
                FileReader file = new FileReader("processos/0" + i + ".txt"); // Leitura dos dados do TXT de processos.

                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) { //Verifica se há linhas com dados para leitura.
                    arquivos[i-1][j] = sc.nextLine(); // Armazena valor das instruçoes no array arquivos.
                    j++;
                }
                sc.close();
                j = 0;

            } else {
                FileReader file = new FileReader("processos/10.txt"); // Leitura em bufer dos dados do TXT.
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) { //Verifica se há linhas com dados para leitura.
                    arquivos[i-1][j] = sc.nextLine(); // Armazena valor das instruçoes no array arquivos.
                    j++;
                }
                sc.close();
                j = 0;
            }
        }

        
    };

    // Método de leitura do arquivo de prioridades.
    private void lerPrioridades() {
        File file = new File("processos/prioridades.txt"); // Leitura dos dados do TXT de prioridades.
        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) { //Verifica se há linhas com dados para leitura.
                prioridades.add(sc.nextInt()); // Armazenando valores lidos em buffer das prioridades em String List.
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Método de leitura do valor do quantum.
    private void lerQuantum() {
        File file = new File("processos/quantum.txt");  // Leitura dos dados do TXT de quantum.
        try {
            Scanner sc = new Scanner(file);
            quantum = sc.nextInt(); // Armazena valor do quantum na variável.
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
