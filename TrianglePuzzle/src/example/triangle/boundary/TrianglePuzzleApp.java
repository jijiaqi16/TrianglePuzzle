package example.triangle.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import example.triangle.controller.ResetController;
import example.triangle.controller.SwapController;
import example.triangle.controller.UnselectAllNodeController;
import example.triangle.controller.selectedNodeController;

import example.triangle.model.Model;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TrianglePuzzleApp extends JFrame {

	private JPanel contentPane;
	TrianglePanel panel;

	Model model;
	JButton btnReset, btnUnselect, btnSwap;
	JLabel moves,swapScore,winner;
	

	public TrianglePanel getTrianglePanel() {
		return panel;
	}

	public JButton getBtnResetButton() {
		return btnReset;
	}

	public JButton getBtnSwapButton() {
		return btnSwap;
	}

	public JButton getBtnUnselectButton() {
		return btnUnselect;
	}

	public JLabel getMovesLabel() {
		return moves;
	}
	
	public JLabel getSwapScoreLabel() {
		return swapScore;
	}
	
	public JLabel getWinner() {
		return winner;
	}
	
	public TrianglePuzzleApp(Model m) {
		super();
		this.model = m;
		setTitle("Triangle Puzzle Application");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 700, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		panel = new TrianglePanel(model);
		panel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent me) {
				new selectedNodeController(model, TrianglePuzzleApp.this).ClickNode(me.getPoint());
			}
		});

		panel.setBackground(Color.LIGHT_GRAY);

//JButton
		btnReset = new JButton("Reset");
		btnReset.setForeground(Color.RED);
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new ResetController(model,TrianglePuzzleApp.this).reset();
				
			}
		});

		btnUnselect = new JButton("Unselect");
		btnUnselect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new UnselectAllNodeController(model, TrianglePuzzleApp.this).UnselectAll();

			}
		});

		btnSwap = new JButton("Swap");
		btnSwap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				new SwapController(model, TrianglePuzzleApp.this).Swap();
				
			}
		});
		
		btnSwap.setForeground(Color.BLACK);
		JLabel scoreLabel = new JLabel("Score:");

		swapScore = new JLabel(""+model.getScore());

		JLabel moveLabel = new JLabel("Number of Moves:");

		moves = new JLabel(""+model.getMoves());
		
		winner = new JLabel("You win!!!");
		winner.setForeground(new Color(255, 0, 0));
		winner.setFont(new Font("Tahoma", Font.PLAIN, 26));
		winner.setHorizontalAlignment(SwingConstants.CENTER);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(scoreLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(swapScore, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnReset, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnUnselect, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnSwap, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addContainerGap(62, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(moveLabel)
							.addGap(6)
							.addComponent(moves, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addGap(22))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(winner, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(scoreLabel)
								.addComponent(swapScore))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(moveLabel)
								.addComponent(moves))
							.addGap(40)
							.addComponent(btnSwap)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnUnselect)
							.addGap(52)
							.addComponent(winner, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnReset)))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		UpdataButton.InitButtons(this);
	}
}
