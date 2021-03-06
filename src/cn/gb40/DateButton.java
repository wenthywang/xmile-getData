package cn.gb40;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 * 
 * <pre>
 * 日期控件的按钮初始化。
 * </pre>
 * @author 王文辉  wangwenhui@jiaxincloud.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class DateButton extends JButton {
	private static final long serialVersionUID = 1L;
	protected Color normalBackground;
	protected Color selectedBackground;
	public DateButton() {
		initAttributes();
	}

	public DateButton(Icon icon) {
		super(icon);
		initAttributes();
	}

	public DateButton(String text, Icon icon) {
		super(text, icon);
		initAttributes();
	}

	public DateButton(String text) {
		super(text);
		initAttributes();
	}

	public DateButton(Action a) {
		super(a);
		initAttributes();
	}

	public void initAttributes() {
		setRolloverEnabled(true);
		setBorder(BorderFactory.createEmptyBorder());
		setContentAreaFilled(false);
		setFocusPainted(false);
		setNormalBackground(new Color(216, 216, 216));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Paint oldPaint = g2d.getPaint();
		
		if ((getModel().isSelected() || getModel().isPressed()) && selectedBackground != null) {
			g2d.setPaint(selectedBackground);
			g2d.fillRect(0, 0, getWidth(), getHeight());
		} else if (getNormalBackground() != null) {
			g2d.setPaint(getNormalBackground());
			g2d.fillRect(0, 0, getWidth(), getHeight());
		}
		g2d.setPaint(oldPaint);
		super.paint(g2d);

	}

	public void clearDefaultAttribute() {
		setNormalBackground(null);
	}

	@Override
	public void setBackground(Color bg) {
		super.setBackground(bg);
		normalBackground = bg;
	}

	public Color getNormalBackground() {
		return normalBackground;
	}

	public void setNormalBackground(Color normalBackground) {
		super.setBackground(normalBackground);
		this.normalBackground = normalBackground;
	}

	

	public void setSelectedBackground(Color selectedBackground) {
		this.selectedBackground = selectedBackground;
	}

}