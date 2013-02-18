package net.minecraft;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class OptionsPanel extends JDialog {
	private static final long serialVersionUID = 1L;
	public static final String MEMORY_KEY = "memory";
	public JTextField memoryfield = new JTextField(4);
	public static int memory;
	public static String memorys;
	
	private JPanel panel;
	private JPanel optionsPanel;
	private JPanel labelPanel;
	private JPanel fieldPanel;
	
	private JButton saveButton;
	private JButton forceButton;
	private JButton skinsButton;
	private JButton siteButton;
	
	private JPanel skinSystemPanel;
	
	private TransparentLabel dirLink;

	public OptionsPanel(Frame parent) {
		super(parent);

		setModal(true);

		panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Настройки:", 0);
		label.setBorder(new EmptyBorder(0, 0, 16, 0));
		label.setFont(new Font("Default", 1, 16));
		panel.add(label, "North");

		optionsPanel = new JPanel(new BorderLayout());
		labelPanel = new JPanel(new GridLayout(0, 1));
		fieldPanel = new JPanel(new GridLayout(0, 1));
		optionsPanel.add(labelPanel, "West");
		optionsPanel.add(fieldPanel, "Center");

		forceButton = new JButton("Обновить клиент!");
		labelPanel.add(new JLabel("Обновление:", 4));
		fieldPanel.add(forceButton);

		labelPanel.add(new JLabel("Расположение клиента на компьютере: ", 4));
		dirLink = new DirLabel(Util.getWorkingDirectory().toString());
		labelPanel.add(new JLabel("Ip cервера по-умолчанию: ", 4));

		labelPanel.add(new JLabel("Выбор памяти, МБ:", 4));
		dirLink.setCursor(Cursor.getPredefinedCursor(12));		
		dirLink.setForeground(new Color(2105599));

		fieldPanel.add(dirLink);
		fieldPanel.add(new JLabel(Config.serverip1, 2));

		memory = Util.getMemorySelection();
		if (memory == 1) {
			memory = 1024;
		}
		String memos = Integer.toString(memory);
		memoryfield.setText(memos);
		fieldPanel.add(memoryfield, "mb");

		panel.add(optionsPanel, "Center");

		skinSystemPanel = new JPanel(new BorderLayout());
		skinSystemPanel.add(new JPanel(), "Center");
		skinsButton = new JButton("Cистема скинов");
		
		siteButton = new JButton("Сайт сервера");

		saveButton = new JButton("Сохранить");
		
		skinSystemPanel.add(skinsButton, "East");
		skinSystemPanel.setBorder(new EmptyBorder(16, 0, 0, 0));
		skinSystemPanel.add(siteButton, "Center");
		skinSystemPanel.add(saveButton, "West");

		panel.add(skinSystemPanel, "South");
		initActions();
		add(panel);
		panel.setBorder(new EmptyBorder(16, 24, 24, 24));
		pack();
		setLocationRelativeTo(parent);
	}
	
	private void initActions() {
		dirLink.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				try {
					Util.openLink(new URL("file://"
							+ Util.getWorkingDirectory().getAbsolutePath())
							.toURI());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		forceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				GameUpdater.forceUpdate = true;
				forceButton.setText("Сейчас начнётся автоматическое скачивание клиента!");
				forceButton.setEnabled(false);
			}
		});
		skinsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				brouseToUrl(Config.skinsystem);
				setVisible(true);
			}
		});
		siteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				brouseToUrl(Config.site);
				setVisible(true);
			}
		});
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				memorys = memoryfield.getText();
				int memory = Integer.parseInt(memorys);
				if (memory != Util.getMemorySelection()) {
					Util.setMemorySelection(memory);
					Map params = new HashMap();
					params.put(MEMORY_KEY, memory);
					try {
						MinecraftLauncher.updateMainFrame(params);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				setVisible(false);
			}
		});
	}
	
	private void brouseToUrl(String stringUrl) {
		Desktop desktop = null;
		try {
			desktop = Desktop.getDesktop();
		} catch (Exception ex) {
			System.err.println("ОС не поддердивается....");
			return;
		}
		if (!desktop.isSupported(Desktop.Action.BROWSE)) {
			System.err.println("Операция не поддерживается...");
			return;
		}
		try {
			try {
				desktop.browse(new URL(stringUrl).toURI());
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		} catch (IOException ex) {
			System.err.println("Ошибка в инициализации пути..."
					+ ex.getLocalizedMessage());
			return;
		}
	}

	public static void browse2(String url) {
		Desktop desktop = null;
		try {
			desktop = Desktop.getDesktop();
		} catch (Exception ex) {
			System.err.println("ОС не поддердивается....");
			return;
		}
		if (!desktop.isSupported(Desktop.Action.BROWSE)) {
			System.err.println("Операция не поддерживается...");
			return;
		}
		try {
			try {
				desktop.browse(new URL(Config.forum).toURI());
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		} catch (IOException ex) {
			System.err.println("Ошибка в инициализации пути..."
					+ ex.getLocalizedMessage());
			return;
		}
	}
	
	private static class DirLabel extends TransparentLabel {
		
		private static final long serialVersionUID = 0L;

		public DirLabel(String string) {
			super(string);			
		}		

		public void paint(Graphics g) {
			super.paint(g);

			int x = 0;
			int y = 0;

			FontMetrics fm = g.getFontMetrics();
			int width = fm.stringWidth(getText());
			int height = fm.getHeight();

			if (getAlignmentX() == 2.0F)
				x = 0;
			else if (getAlignmentX() == 0.0F)
				x = getBounds().width / 2 - width / 2;
			else if (getAlignmentX() == 4.0F)
				x = getBounds().width - width;
			y = getBounds().height / 2 + height / 2 - 1;

			g.drawLine(x + 2, y, x + width - 2, y);
		}

		public void update(Graphics g) {
			paint(g);
		}		
	}
}