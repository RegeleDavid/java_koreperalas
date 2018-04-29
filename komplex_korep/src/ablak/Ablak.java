package ablak;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import korep_mysql_oop.*;
import javax.swing.JLabel;

public class Ablak extends JFrame {

	private JPanel contentPane;
	private JTextField nev;
	private JTextField jelszo_b;
	private kiir k=new kiir();
	private JTextField nev_b;
	private JTextField nev_beszur;
	private JTextField jelszo_beszur;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ablak frame = new Ablak();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ablak() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMysql = new JMenu("mysql");
		menuBar.add(mnMysql);
		
		JMenuItem mntmKiir = new JMenuItem("kiir");
		
		mnMysql.add(mntmKiir);
		
		JMenuItem mntmBeszur = new JMenuItem("belepes");
		
		mnMysql.add(mntmBeszur);
		
		JMenuItem mntmTablazat = new JMenuItem("tablazat");
		mntmTablazat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnMysql.add(mntmTablazat);
		
		JMenuItem mntmBeszuras = new JMenuItem("beszuras");
		
		mnMysql.add(mntmBeszuras);
		
		JMenu mnKilep = new JMenu("kilep");
		mnKilep.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			
		});
		menuBar.add(mnKilep);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel p2 = new JPanel();
		p2.setBounds(10, 11, 414, 218);
		contentPane.add(p2);
		p2.setLayout(null);
		
		jelszo_b = new JTextField();
		jelszo_b.setBounds(49, 47, 86, 20);
		p2.add(jelszo_b);
		jelszo_b.setColumns(10);
		remove(p2);
		
		nev_b = new JTextField();
		nev_b.setBounds(191, 47, 86, 20);
		p2.add(nev_b);
		nev_b.setColumns(10);
		
		JButton belep = new JButton("belep");
		
		belep.setBounds(136, 132, 89, 23);
		p2.add(belep);
		belep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(new kiir().login(nev_b.getText(), jelszo_b.getText())){
					nev_b.setText(":)");
				}else{
					jelszo_b.setText(":(");
				}
			}
		});
		
		JPanel p4 = new JPanel();
		p4.setBounds(10, 11, 414, 218);
		contentPane.add(p4);
		p4.setLayout(null);
		
		nev_beszur = new JTextField();
		nev_beszur.setBounds(37, 41, 86, 20);
		p4.add(nev_beszur);
		nev_beszur.setColumns(10);
		
		JLabel lblNev = new JLabel("nev:");
		lblNev.setBounds(37, 26, 46, 14);
		p4.add(lblNev);
		
		jelszo_beszur = new JTextField();
		jelszo_beszur.setBounds(219, 41, 86, 20);
		p4.add(jelszo_beszur);
		jelszo_beszur.setColumns(10);
		
		JLabel lblJelszo = new JLabel("jelszo:");
		lblJelszo.setBounds(219, 26, 46, 14);
		p4.add(lblJelszo);
		
		JButton beszur = new JButton("beszur");
		beszur.setBounds(91, 155, 89, 23);
		p4.add(beszur);
		
		JPanel p3 = new JPanel();
		p3.setBounds(10, 11, 414, 218);
		contentPane.add(p3);
		p3.setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBounds(10, 11, 414, 218);
		contentPane.add(p1);
		p1.setLayout(null);
		
		JButton btnKiir = new JButton("kiir");
		
		btnKiir.setBounds(195, 111, 89, 23);
		p1.add(btnKiir);
		
		JTextArea kiir_area = new JTextArea();
		kiir_area.setBounds(49, 104, 86, 82);
		p1.add(kiir_area);
		
		remove(p1);
		
		nev = new JTextField();
		nev.setBounds(49, 56, 86, 20);
		p1.add(nev);
		nev.setColumns(10);
		btnKiir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String szo=k.matrinx_nev(nev.getText());
				kiir_area.setText(szo);
			}
		});
		
		mntmKiir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remove(p2);
				remove(p3);
				remove(p4);
				getContentPane().add(p1);
				repaint();
			}
		});
		mntmBeszur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(p1);
				remove(p3);
				remove(p4);
				getContentPane().add(p2);
				repaint();
				
			}
		});
		mntmTablazat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remove(p1);
				remove(p2);
				remove(p4);
				String[] cim={"nev","jelszo"};
				JTable tabla=new JTable(new korep_mysql_oop.tabla().matrix(),cim);
				JScrollPane scrol=new JScrollPane(tabla);
				scrol.setBounds(20, 20, 200, 200);
				p3.add(scrol);
				getContentPane().add(p3);
				repaint();
			}
		});
		mntmBeszuras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remove(p1);
				remove(p2);
				remove(p3);
				getContentPane().add(p4);
				repaint();
			}
		});
	}
}
