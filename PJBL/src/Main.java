
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                File arquivoOriginal = new File("CROCOCODILO.png");
                if (!arquivoOriginal.exists()) {
                    System.out.println("Erro: Cadê o arquivo CROCOCODILO.png na pasta do projeto?");
                    return;
                }
                BufferedImage imagemParaPintar = ImageIO.read(arquivoOriginal);

                JFrame janela = new JFrame("Meu Pintor de Flood Fill");
                Visualizador tela = new Visualizador(imagemParaPintar);

                janela.add(tela);
                janela.pack();
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.setLocationRelativeTo(null);
                janela.setVisible(true);

                Pintor artista = new Pintor();

                new Thread(() -> {
                    System.out.println("Trabalho iniciado...");

                    artista.pintar(imagemParaPintar, 0, 0, true, tela);

                    System.out.println("Trabalho finalizado! Salvando...");

                    try {
                        ImageIO.write(imagemParaPintar, "png", new File("resultado_final.png"));
                    } catch (Exception e) {
                        System.out.println("Não consegui salvar a imagem.");
                    }
                }).start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
