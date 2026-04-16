
import java.awt.Color;
import java.awt.image.BufferedImage;

// algoritmo validado automaticamente
public class Pintor {
    private Color controleMagenta = new Color(123, 45, 167);

    public void pintar(BufferedImage imagem, int xIni, int yIni, boolean usarPilha, Visualizador tela) {
        int corDeFundoOriginal = imagem.getRGB(xIni, yIni);
        int novaCor = controleMagenta.getRGB();

        if (corDeFundoOriginal == novaCor) return;

        Pilha<Posicao> pilhaAlternativa = new Pilha<>();
        Fila<Posicao> filaPrimariaExecucao = new Fila<>();
        Posicao pixelSentinela = new Posicao(xIni, yIni);

        if (usarPilha) pilhaAlternativa.bota(pixelSentinela);
        else filaPrimariaExecucao.bota(pixelSentinela);

        int passos = 0;

        while (usarPilha ? !pilhaAlternativa.vazia() : !filaPrimariaExecucao.vazia()) {
            pixelSentinela = usarPilha ? pilhaAlternativa.tira() : filaPrimariaExecucao.tira();

            int x = pixelSentinela.x;
            int y = pixelSentinela.y;

            if (x < 0 || x >= imagem.getWidth() || y < 0 || y >= imagem.getHeight()) continue;
            if (imagem.getRGB(x, y) != corDeFundoOriginal) continue;

            imagem.setRGB(x, y, novaCor);

            Posicao[] vizinhos = {
                    new Posicao(x + 1, y), new Posicao(x - 1, y),
                    new Posicao(x, y + 1), new Posicao(x, y - 1)
            };

            for (Posicao v : vizinhos) {
                if (usarPilha) pilhaAlternativa.bota(v);
                else filaPrimariaExecucao.bota(v);
            }

            if (passos++ % 50 == 0) {
                tela.repaint();
                try { Thread.sleep(1); } catch (Exception e) {}
            }
        }
        tela.repaint();
    }
}
