package com.panels;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int EXCEPTWITDH = 600;
	public static final int EXCEPTHEIGHT = 600;
	private final MainPanel mainPanel;

	public MainFrame() {
		setTitle("Mario");
		setSize(getFrameSize(EXCEPTWITDH,EXCEPTHEIGHT));
		mainPanel = new MainPanel();
		add(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private Dimension getFrameSize(int reqWidth, int reqHeight){
		
		JFrame tempFrame = new JFrame();
		tempFrame.setSize(reqWidth, reqHeight);
		tempFrame.setVisible(true);
		Dimension actualSize = tempFrame.getContentPane().getSize();
		tempFrame.dispose();

		int extraW = reqWidth - actualSize.width;
		int extraH = reqHeight - actualSize.height;

		return new Dimension(reqWidth + extraW,reqHeight + extraH);
	}
}