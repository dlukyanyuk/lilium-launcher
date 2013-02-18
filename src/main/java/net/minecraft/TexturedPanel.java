package net.minecraft;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TexturedPanel extends JPanel
{
  private static final long serialVersionUID = 1L;
  private Image img;
  private Image bgImage;

  public TexturedPanel()
  {
    setOpaque(true);
    try
    {
      bgImage = ImageIO.read(LoginForm.class.getResource("down.png")).getScaledInstance(866, 110, 16);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void update(Graphics g) {
	    paint(g);
	  }

  public void paintComponent(Graphics g) {
	    g.drawImage(bgImage, 0, 0, null);
	  }
	}