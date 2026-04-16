import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class Visualizador extends JPanel {
    private BufferedImage imagem;

    public Visualizador(BufferedImage img) {
        this.imagem = img;
        this.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (imagem != null) {
            g2d.drawImage(imagem, 0, 0, null);
        }
    }
}