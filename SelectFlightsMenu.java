import java.util.ArrayList;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

public class SelectFlightsMenu extends JDialog implements ActionListener, CellEditorListener {

	private ArrayList<Flight> flights = new ArrayList<>();
	private JPanel entryPanel = new JPanel();
	private ArrayList<JPanel> entries;

	public SelectFlightsMenu(JFrame parent) {
		super(parent, "Select Flights");

		entries = new ArrayList<>();
		this.setPreferredSize(new Dimension(800, 250));
		getContentPane().add(getPanel());
		pack();
		setVisible(true);

	}

	private JPanel getPanel() {

		JPanel mainPanel = new JPanel(new BorderLayout());
		JLabel designLabel = new JLabel("");

		// Setting up button Panel
		JPanel buttonPanel = this.getButtonPanel();
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		entryPanel = getEntryPanel();
		mainPanel.add(entryPanel);

		JButton addEntryButton = new JButton("Add");
		addEntryButton.addActionListener(this);
		addEntryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("test");
				entryPanel.add(getFlightEntry());

				entryPanel.revalidate();

			}
		});
		mainPanel.add(addEntryButton, BorderLayout.NORTH);

		return mainPanel;
	}

	private JPanel getEntryPanel() {

		// JPanel wrapper = new JPanel();
		JPanel flightPanel = new JPanel();

		BoxLayout b = new BoxLayout(flightPanel, BoxLayout.Y_AXIS);
		flightPanel.setLayout(b);

		for (int i = 0; i < 3; i++) {
			flightPanel.add(getFlightEntry());

		}

		// flightPanel.setPreferredSize(new Dimension(800,300));
		// wrapper.add(flightPanel);

		return flightPanel;
	}

	private JPanel getFlightEntry() {

		JPanel pp = new JPanel(new BorderLayout());

		JPanel p = new JPanel();
		p.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				p.setOpaque(true);
				p.setBackground(Color.lightGray);
				p.revalidate();

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JCheckBox cb1 = new JCheckBox();
		JCheckBox cb2 = new JCheckBox();
		JTextField name = new JTextField(15);
		JTextField dest = new JTextField(15);
		JTextField dfix = new JTextField(15);
		JButton button = new JButton("...");

		p.add(cb1);
		p.add(name);
		p.add(dest);
		p.add(dfix);
		p.add(cb2);
		p.add(button);
		// p.setPreferredSize(new Dimension(1000,100));
		pp.add(p, BorderLayout.WEST);
		return pp;
	}

	/*
	 * private JScrollPane getTable(){ JTable flightTable = new JTable();
	 * 
	 * JScrollPane scrollPane = new JScrollPane(flightTable);
	 * flightTable.setFillsViewportHeight(true);
	 * 
	 * 
	 * 
	 * DefaultTableModel model = (DefaultTableModel) flightTable.getModel();
	 * JCheckBox test = new JCheckBox();
	 * 
	 * 
	 * model.addColumn("name"); model.addColumn("dest");
	 * model.addColumn("dfix"); model.addColumn("definition"); model.addRow(new
	 * Object[]{"a","a","a",false}); TableColumn definition =
	 * flightTable.getColumnModel().getColumn(3);
	 * 
	 * 
	 * definition.setCellEditor((flightTable.getDefaultEditor(Boolean.class)));
	 * definition.setCellRenderer((flightTable.getDefaultRenderer(Boolean.class)
	 * ));
	 * flightTable.getDefaultEditor(Boolean.class).addCellEditorListener(this);
	 * 
	 * /* for(Flight f: flights){ //flightTable.add(); }
	 * 
	 * return scrollPane; }
	 */

	private JPanel getButtonPanel() {
		JPanel buttonPanel = new JPanel(new GridLayout());

		JPanel applyWrapper = new JPanel();
		JButton applyButton = new JButton("Apply");
		applyButton.setActionCommand(applyButton.getText());
		applyButton.addActionListener(this);
		applyWrapper.add(applyButton);
		
		JPanel okWrapper = new JPanel();
		JButton okButton = new JButton("OK");
		okButton.setActionCommand(okButton.getText());
		okButton.addActionListener(this);
		okWrapper.add(okButton);
		
		JPanel cancelWrapper = new JPanel();
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand(cancelButton.getText());
		cancelButton.addActionListener(this);
		cancelWrapper.add(cancelButton);
		
		JPanel helpWrapper = new JPanel();
		JButton helpButton = new JButton("Help");
		helpButton.setActionCommand(helpButton.getText());
		helpButton.addActionListener(this);
		helpWrapper.add(helpButton);

		buttonPanel.add(okWrapper);
		buttonPanel.add(applyWrapper);
		buttonPanel.add(cancelWrapper);
		buttonPanel.add(helpWrapper);

		return buttonPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.print("dfdfD");
		if (e.getActionCommand().equals("Apply")) {
		} else if (e.getActionCommand().equals("OK")) {
			dispose();
		} else if (e.getActionCommand().equals("Cancel")) {
			dispose();
		}

	}

	@Override
	public void editingStopped(ChangeEvent e) {
		
	}

	@Override
	public void editingCanceled(ChangeEvent e) {
		

	}
}
