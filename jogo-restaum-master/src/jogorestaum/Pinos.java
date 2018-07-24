package jogorestaum;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Pinos extends JButton {

	private Icon ico;
	private String icon;

	public String descobreIcon() {
		return icon;
	}

	Pinos(String nome, String estilo) {
		super(nome);
		this.setSize(55, 55);
		this.setBorderPainted(false);

		switch (estilo) {
		case "n":
			icon = "nulo";
			break;
		case "c":
			icon = "box-clean";
			break;
		case "b":
			icon = "box";
			break;
		}

		// icon+=".png";
		ico = new ImageIcon("img/" + icon);
		// System.out.println(ico);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setIcon(icon);
	}

	public void setIconBox() {
		this.setIcon("box");
	}

	public void setIconBoxSpecial() {
		this.setIcon("box-special");
	}

	public void setIconBoxClean() {
		this.setIcon("box-clean");
	}

	private void setIcon(String icon) {
		this.ico = new ImageIcon("src/img/" + icon + ".png");
		this.setIcon(this.ico);
	}
}
