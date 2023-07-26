package TestGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Mainframe extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSlider dSlider, redSlider, greenSlider, blueSlider;
	private drawCircle myPanel;
	private JPanel panel;
	private JLabel dLabel,colorLabel;

	
	
	public Mainframe() {
		
		//setting JFrame title
		
		super("Move the slider to change the diameter and colors");
		
	
		//setting panel
		panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		panel.setLayout(new GridLayout(6,1,40,40));
	
		add(panel, BorderLayout.EAST);
		
		 
		//setting diameter slider and label
		dSlider = createSlider(0,100,20,5,10);
		dLabel = new JLabel ("Diameter");
		panel.add(dLabel);
		panel.add(dSlider);
				
		//setting red slider and label	
		redSlider = createSlider(0,100,0,5,10);
		JLabel redLabel = new JLabel ("Red");
	    panel.add(redLabel);
	    panel.add(redSlider);
	    
	    //setting green label and slider
		greenSlider = createSlider(0,100,0,5,10);
		JLabel greenLabel = new JLabel ("Green");
		panel.add(greenLabel);
		panel.add(greenSlider);
		
		//setting blue slider and label
	    blueSlider = createSlider(0,100,0,5,10);
	    JLabel blueLabel = new JLabel("Blue");
	    panel.add(blueLabel);
		panel.add(blueSlider);
		
		//setting the circle
		myPanel = new drawCircle(); 
		add(myPanel, BorderLayout.CENTER);
		
		// new text area where initial diameter will be displayed with option to choose one language
		JTextArea textField = new JTextArea();
		JLabel desc = new JLabel("For a new reading please move the slider again and select a new language.");
		textField.setFont(new Font("Arial", Font.BOLD, 12));
	  
		panel.add(desc);
		
		
		// array that contains 2 countries
		String [] countries = new String[2];
		countries[0]="English";
		countries[1]="Irish";
		//list to display the countries
		JList countryJList = new JList(countries);
		countryJList.setVisibleRowCount(2); 
		
		JScrollPane jsp = new JScrollPane(countryJList);
		panel.add(jsp);
		panel.add(textField,BorderLayout.WEST);
		
		
		// add a listener to the list
		countryJList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				String SelectedLanguage = (String) countryJList.getSelectedValue();
				if (SelectedLanguage == countries[0]) {
					textField.setText("The diameter is " + dSlider.getValue());
				}
				else {
					textField.setText("Tá an trastomhas " + dSlider.getValue());
				}
				;
				
			}
			
		});
	}
		
	//new class to set sliders 
	
	public JSlider createSlider(int min, int max, int initial, int minorT, int majorT) {
		JSlider slider = new JSlider(JSlider.HORIZONTAL, min,max,initial);
		slider.setMinorTickSpacing(minorT);
		slider.setMajorTickSpacing(majorT);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(new SliderListener());
		return slider;
	} 
	
	
 
	// new class for sliderListener
	public class SliderListener implements ChangeListener {


		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider slider = (JSlider) e.getSource();
			
			// create conditional statement for each slider
			if (slider == dSlider) {
				myPanel.d=slider.getValue();
				repaint();
			
			}
			else if (slider == redSlider) {
				
				myPanel.rValue=slider.getValue();
				showColors();
				
			}
			else if (slider == greenSlider) {
				myPanel.gValue=slider.getValue();
				showColors(); 
				}
			else if (slider == blueSlider) {
				myPanel.bValue = slider.getValue();
				showColors();
				 }
		
			myPanel.repaint();
			
			
		} //end stateChanged
		
		
		// method to show new color
		public void showColors() {
			myPanel.setNewColor();
					
		 colorLabel.setText("HEX: "+ myPanel.getNewColorHex());
				
		}
		
	}
}
	

	
			
			
	
		 
	
	
		
		
	
	
	
