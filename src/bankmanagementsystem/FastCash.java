package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton deposit, withdraw, ministatement, pinchange, fastcash, balanceenquiry, exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 730, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 730);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAL AMOUNT");
        text.setBounds(215, 230, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(165, 327, 130, 20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdraw = new JButton("Rs 500");
        withdraw.setBounds(380, 327, 130, 20);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(165, 352, 130, 20);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(380, 352, 130, 20);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(165, 377, 130,20);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(380, 377, 130, 20);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("BACK");
        exit.setBounds(380, 405, 130, 20);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900, 730);
        setLocation(200, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3); //Rs 500
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Incufficient Balance");
                    return;
                }
               
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'withdraw', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+ amount + " Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String args[]) {
        new FastCash("");
    }
}
