import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
public class JTableRow {

    public static void main(String[] args){
        
        JFrame frame = new JFrame();
        JTable table = new JTable(); 
        
        Object[] columns = {"First Name","Last Name","Age","Gender","Phone"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        table.setModel(model);
        
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        table.getTableHeader().setReorderingAllowed(false);
		
		
		JLabel label1= new JLabel("First Name");
		JLabel label2= new JLabel("Last Name");
		JLabel label3= new JLabel("Age");
		JLabel label4= new JLabel("Gender");
		JLabel label5 = new JLabel("Phone");
		
		
        JTextField textFname = new JTextField();
        JTextField textLname = new JTextField();
        JTextField textAge = new JTextField();
		JTextField textPhone = new JTextField();
		
		// define items in a String array:
		String[] gender = new String[] {"MALE", "FEMALE"};
 
		// create a combo box with the fixed array:
		JComboBox<String> cbGender  = new JComboBox<String>(gender);
		
		
		
		
		
		
		
		
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");     
        
		
		label1.setBounds(20, 220, 100, 25);
        label2.setBounds(20, 250, 100, 25);
        label3.setBounds(20, 280, 100, 25);
		label4.setBounds(20, 310, 100, 25);
		label5.setBounds(20, 340,100,25);
		
		
        textFname.setBounds(100, 220, 100, 25);
        textLname.setBounds(100, 250, 100, 25);
        textAge.setBounds(100, 280, 100, 25);
		textPhone.setBounds(100,340,100,25);
        cbGender.setBounds(100,310, 100, 25);
		
        btnAdd.setBounds(500, 220, 100, 25);
       // btnUpdate.setBounds(500, 265, 100, 25);
        btnDelete.setBounds(500, 310, 100, 25);
		
		
        
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
        
        frame.setLayout(null);
        
        frame.add(pane);
		
		
  
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
        
        frame.add(textFname);
        frame.add(textLname);
        frame.add(textAge);
		frame.add(textPhone);
		frame.add(cbGender);
		
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        
       
        Object[] row = new Object[5];

        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
               
                row[0] = textFname.getText();
                row[1] = textLname.getText();
                row[2] = textAge.getText();
                row[3] = cbGender.getSelectedItem();
				row[4] = textPhone.getText();
                model.addRow(row);
				
				textFname.setText("");
				textLname.setText("");
				textAge.setText("");
				textPhone.setText("");
            }
        });
        
   
       btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
        
                int i = table.getSelectedRow();
                if(i >= 0){
               
                    model.removeRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });
        
       
	   
	   /*
        table.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            
         
            int i = table.getSelectedRow();
            
            
            textFname.setText(model.getValueAt(i, 0).toString());
            textLname.setText(model.getValueAt(i, 1).toString());
            textAge.setText(model.getValueAt(i, 2).toString());
			cbGender.setText(model.getSelectedItem(i,3).toString());
        }
        });

        btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                int i = table.getSelectedRow();
                
                if(i >= 0) 
                {
                   
                   model.setValueAt(textFname.getText(), i, 0);
                   model.setValueAt(textLname.getText(), i, 1);
                   model.setValueAt(textAge.getText(), i, 2);
				   model.setValueAt(cbGender.getSelectedItem(),i,3);
                }
                else{
                    System.out.println("Update Error");
                }
            }
        });
		
		*/
        
        frame.setSize(900,450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}