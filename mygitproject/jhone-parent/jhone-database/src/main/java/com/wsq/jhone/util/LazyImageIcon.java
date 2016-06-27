package com.wsq.jhone.util;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;

public class LazyImageIcon extends ImageIcon {

	/**
	 * 
	 */
	private static final long serialVersionUID = 414725279783353952L;
	private transient URL location;
	private transient Image img;

	public LazyImageIcon(URL location) {
		this.location = location;

		this.img = Toolkit.getDefaultToolkit().getImage(location);
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		if (getImage() != null)
			super.paintIcon(c, g, x, y);
	}

	public int getIconWidth() {
		if (getImage() != null) {
			return super.getIconWidth();
		}
		return 0;
	}

	public int getIconHeight() {
		if (getImage() != null) {
			return super.getIconHeight();
		}
		return 0;
	}

	public Image getImage() {
		if (this.location != null) {
			setImage(this.img);
			this.location = null;
		}
		return super.getImage();
	}
}
