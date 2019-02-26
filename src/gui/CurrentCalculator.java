/*
 * Title:		CSIS 484 Current Calculator
 * Author:		achelmo, bxlabz
 * 
 * Created:		2/18/19
 * Modified:	2/25/19
 * Description:	
 * 
 * 	
 */

package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
//import java.util.Collections;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

//import com.mysql.cj.xdevapi.Statement;


public class CurrentCalculator extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int WIDTH = 800;
	private static int HEIGHT = 600;
	
	public JComboBox<String> fromCB, toCB;
	private JLabel fromL, toL;
	private JButton calculateB;
	private JTextArea linksTA;
	
	public CurrentCalculator() {
		
		
		
		
		setTitle("Current Calculator");
		setSize(WIDTH, HEIGHT);
		
		String[] countries = { "Select a Country",
				
				"Afghanistan","Albania","Algeria",
				"American Samoa","Andorra","Angola","Anguilla",
				"Antigua and Barbuda","Argentina","Armenia",
				"Aruba","Australia","Austria","Azerbaijan",
				"Azores",
				
				"Bahamas","Bahrain","Balearic Islands",
				"Bangladesh","Barbados","Belarus","Belgium",
				"Belize","Benin","Bermuda","Bhutan","Bolivia",
				"Bonaire","Bosnia & Herzegovina","Botswana","Brazil",
				"British Virgin Islands","Brunei","Bulgaria","Burkina Faso",
				"Burma (officially Myanmar)","Burundi",
				
				"Cambodia","Cameroon","Canada","Canary Islands","Cape Verde (in Portuguese: Cabo Verde)",
				"Cayman Islands","Central African Republic","Chad",
				"Channel Islands (Guernsey & Jersey)","Chile","China, People�s Republic of",
				"Christmas Island","Cocos (Keeling) Islands","Colombia",
				"Comoros","Congo, Democratic Republic of the (Congo-Kinshasa)","Congo, Republic of the (Congo-Brazzaville)",
				"Cook Islands","Costa Rica","C�te d�Ivoire (Ivory Coast)","Croatia",
				"Cuba","Cura�ao","Cyprus","Cyprus, North (unrecognised, self-declared state)",
				"Czechia (Czech Republic)",
				
				"Denmark","Djibouti","Dominica","Dominican Republic",
				"Dubai (not a country, but the largest city in the United Arab Emirates)",
				
				"East Timor (Timor-Leste)","Ecuador","Egypt","El Salvador","England",
				"Equatorial Guinea","Eritrea","Estonia","Ethiopia",
				
				"Faeroe Islands","Falkland Islands","Fiji","Finland",
				"France","French Guiana",
				
				"Gabon (Gabonese Republic)","Gambia","Gaza Strip (Gaza)","Georgia",
				"Germany","Ghana","Gibraltar","Great Britain (GB)",
				"Greece","Greenland","Grenada","Guadeloupe",
				"Guam","Guatemala","Guinea","Guinea-Bissau","Guyana",
				
				"Haiti","Holland (officially the Netherlands)","Honduras",
				"Hong Kong","Hungary",
				
				"Iceland","India","Indonesia","Iran","Iraq","Ireland (Eire)",
				"Ireland, Northern","Isle of Man","Israel","Italy",
				
				"Jamaica","Japan","Jordan",
				
				"Kazakhstan","Kenya","Kiribati","Korea, North","Korea, South",
				"Kosovo","Kuwait","Kyrgyzstan",
				
				"Laos","Latvia","Lebanon","Lesotho","Liberia","Libya",
				"Liechtenstein","Lithuania","Luxembourg",
				
				"Macau","Macedonia, North","Madagascar","Madeira","Malawi",
				"Malaysia","Maldives","Mali","Malta","Marshall Islands","Martinique",
				"Mauritania","Mauritius","Mayotte","Mexico","Micronesia, Federated States of",
				"Moldova","Monaco","Mongolia","Montenegro","Montserrat","Morocco",
				"Mozambique","Myanmar (formerly Burma)",
				
				"Namibia","Nauru","Nepal","Netherlands","New Caledonia",
				"New Zealand","Nicaragua","Niger","Nigeria","Niue",
				"Norfolk Island","North Cyprus (unrecognised, self-declared state)",
				"North Korea","North Macedonia","Northern Ireland","Norway",
				
				"Oman",
				
				"Pakistan","Palau","Palestine","Panama","Papua New Guinea","Paraguay",
				"Peru","Philippines","Pitcairn Islands","Poland","Portugal","Puerto Rico",
				
				"Qatar",
				
				"R�union","Romania","Russia (officially the Russian Federation)","Rwanda",
				
				"Saba","Saint Barth�lemy (informally also referred to as Saint Barth�s or Saint Barts)",
				"Saint Helena","Saint Kitts and Nevis (officially the Federation of Saint Christopher and Nevis)",
				"Saint Lucia","Saint Martin","Saint Vincent and the Grenadines",
				"Samoa","San Marino","S�o Tom� and Pr�ncipe","Saudi Arabia",
				"Scotland","Senegal","Serbia","Seychelles","Sierra Leone","Singapore",
				"Sint Eustatius","Sint Maarten","Slovakia","Slovenia","Solomon Islands",
				"Somalia","Somaliland","South Africa","South Korea","South Sudan",
				"Spain","Sri Lanka","Sudan","Suriname","Swaziland","Sweden",
				"Switzerland","Syria",
				
				"Tahiti","Taiwan","Tajikistan","Tanzania","Thailand",
				"Togo","Tokelau","Tonga","Trinidad & Tobago","Tunisia",
				"Turkey","Turkmenistan","Turks and Caicos Islands","Tuvalu",
				
				"Uganda","Ukraine","United Arab Emirates (UAE)","United Kingdom (UK)",
				"United States of America (USA)","United States Virgin Islands",
				"Uruguay","Uzbekistan",
				
				"Vanuatu","Vatican City","Venezuela","Vietnam","Virgin Islands (British)","Virgin Islands (USA)",
				
				"Wales","Western Sahara",
				
				"Yemen",
				
				"Zambia","Zimbabwe",
				
				"test",
				"test1"};
		
		fromCB = new JComboBox <String> (countries);
		toCB = new JComboBox <String> (countries);
		fromL = new JLabel("From:");
		toL = new JLabel("To:");
		calculateB = new JButton("Calculate");
		calculateB.addActionListener(new Calculate());
		linksTA = new JTextArea(6, 30);
		
		Container pane = getContentPane();
		pane.setLayout(null);  
		
		
		fromCB.setLocation(50, 0);
		fromCB.setSize(200, 35);
		toCB.setLocation(350, 0);
		toCB.setSize(200, 35);
		fromL.setLocation(0, 0);
		fromL.setSize(50, 35);
		toL.setLocation(300, 0);
		toL.setSize(50, 35);
		calculateB.setLocation(0, 100);
		calculateB.setSize(100, 35);
		linksTA.setLocation(0, 200);
		linksTA.setSize(600,200);
		
		
		
		pane.add(fromCB);
		pane.add(toCB);
		pane.add(fromL);
		pane.add(toL);
		pane.add(calculateB);
		pane.add(linksTA);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	private class Calculate implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String from = String.valueOf(fromCB.getSelectedItem());
			String to = String.valueOf(toCB.getSelectedItem());
			linksTA.setText("");
			if(from.equals("Select a Country")) {
				linksTA.setText("Please select where you are from");
			} // end of if
			else if (to.equals("Select a Country")) {
				linksTA.setText("Please select where you are going to");
			}
			else {
				linksTA.setText("Top links for traveling from " + from + " to " + to);
				//cc.createConnection();
			} // end of else
			//linksTA.append(from + "\n");
			//linksTA.append(to);
			//System.out.println(from);	
			//System.out.println(to);	
		}
	}
	
   
	
	
	public static void main(String[] args) {
		//CurrentCalculator pro = new CurrentCalculator();
		CurrentCalculator cc = new CurrentCalculator();
		cc.createConnection();
	}
	
	void createConnection() {
		try {
			//load the driver
			Class.forName("com.mysql.jdbc.Driver");
			//establish the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			
			//create a statement object
			java.sql.Statement stmt = con.createStatement();
			
			String a = "test";
			String b = "test1";
			
			//create query
			//ResultSet rs = ((java.sql.Statement) stmt).executeQuery("SELECT * FROM countrylinks");
					//+ " WHERE countryFrom '"+ a +"' AND WHERE countryTo '" + b + "'");
			
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery("SELECT * FROM countrylinks WHERE "
					+ "countryFrom='"+ a +"'" + "AND countryTo='"+b+"'");
			
			
			while(rs.next()) {
				System.out.println("Links for traveling from " + rs.getString("countryFrom")+" to " +rs.getString("countryTo"));
				String name = rs.getString("link1");
				String name1 = rs.getString("link2");
				String name2 = rs.getString("link3");
				System.out.println(name);
				System.out.println(name1);
				System.out.println(name2);
				System.out.println();
			}
			
			System.out.println("Database Connection Successfull!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(CurrentCalculator.class.getName()).log(Level.SEVERE,null,e);
			//e.printStackTrace();
			System.out.println("fail1");
		}
		
		catch (SQLException e) {
			Logger.getLogger(CurrentCalculator.class.getName()).log(Level.SEVERE,null,e);
			System.out.println("fail2");
		}
	}

}
