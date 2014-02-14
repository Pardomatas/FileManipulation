import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Main extends javax.swing.JFrame {
	private JButton firstLine;
	private JButton reset;
	private JTextField fileNameTxt;
	private JTextField firstLineTxt;
	private JButton removeFile;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Main inst = new Main();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Main() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				firstLine = new JButton();
				getContentPane().add(firstLine);
				firstLine.setText("Show first line");
				firstLine.setBounds(40, 14, 125, 29);
				firstLine.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						firstLineActionPerformed(evt);
					}
				});
			}
			{
				removeFile = new JButton();
				getContentPane().add(removeFile);
				removeFile.setText("Remove file");
				removeFile.setBounds(255, 14, 125, 29);
				removeFile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						removeFileActionPerformed(evt);
					}
				});
			}
			{
				reset = new JButton();
				getContentPane().add(reset);
				reset.setText("Reset");
				reset.setBounds(469, 14, 125, 29);
				reset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						resetActionPerformed(evt);
					}
				});
			}
			{
				fileNameTxt = new JTextField();
				getContentPane().add(fileNameTxt);
				fileNameTxt.setText("Enter file name here");
				fileNameTxt.setBounds(40, 77, 554, 34);
			}
			{
				firstLineTxt = new JTextField();
				getContentPane().add(firstLineTxt);
				firstLineTxt.setBounds(40, 146, 554, 34);
			}
			pack();
			this.setSize(652, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void firstLineActionPerformed(ActionEvent evt) {
		
		Scanner inputStream = null;
		String fileName = fileNameTxt.getText();
		File fileObject = new File(fileName);
		
		try {
			
			if(fileName.endsWith(".txt"))
			{
				inputStream = new Scanner( new File(fileName));
			    String line = inputStream.nextLine(); 
			    firstLineTxt.setText(line);  
			    inputStream.close();
			}
			else if (fileName.endsWith(".dat"))
			{
				ObjectInputStream st = new ObjectInputStream(new FileInputStream(fileName));
				String s = st.readUTF();
				firstLineTxt.setText(s);
				st.close();
			}
			else
			{
				firstLineTxt.setText("Error: File not found.");
			}
			    
		} catch (FileNotFoundException e) {
			if (fileObject.exists()){
				firstLineTxt.setText("Error: File protected");
			} else {
				firstLineTxt.setText("Error: " + e.getMessage()); 
			}
		} catch (IOException e) {
			firstLineTxt.setText("Error: Not a binary file.");
				
		} 
		
	}
	
	private void removeFileActionPerformed(ActionEvent evt) {
		
		String fileName = fileNameTxt.getText();
		File fileObject = new File(fileName);
		
		boolean success = fileObject.delete();

	    if (!success)
			firstLineTxt.setText("Error: File not found");
	}
	
	private void resetActionPerformed(ActionEvent evt) {
		fileNameTxt.setText("Enter file name here");
		firstLineTxt.setText("");
	}
}

