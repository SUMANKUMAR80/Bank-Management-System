package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame  implements ActionListener {
   
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, education, income;
    String formno;
    
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Railway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Railway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        String valReligion[] = {"select Any","Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Railway", Font.BOLD, 20));
        fname.setBounds(100, 180, 200, 30);
        add(fname);
        
        String valCategory[] = {"Select Any", "General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 180, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Railway", Font.BOLD, 20));
        dob.setBounds(100, 220, 200, 30);
        add(dob);
        
        String incomeCategory[] = {"null", "< 1,50,000", "<2,50,000", "<5,00,000", "upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 220, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel gender = new JLabel("Education/");
        gender.setFont(new Font("Railway", Font.BOLD, 20));
        gender.setBounds(100, 260, 200, 30);
        add(gender);
        
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Railway", Font.BOLD, 20));
        email.setBounds(100, 285, 200, 30);
        add(email);
        
        String educationValues[] = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctrate", "Other"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 285, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Railway", Font.BOLD, 20));
        marital.setBounds(100, 340, 200, 30);
        add(marital);
        
        String occupationValues[] = {"Salaried", "Self-Employee", "Bussiness", "Student", "Retired", "Other"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 340, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel address = new JLabel("Pan Number:");
        address.setFont(new Font("Railway", Font.BOLD, 20));
        address.setBounds(100, 380, 200, 30);
        add(address);
        
        pan = new JTextField();
        pan.setFont(new Font("Railway", Font.BOLD, 14));
        pan.setBounds(300, 380, 400, 30);
        add(pan);
        
        JLabel city = new JLabel("Aadhar Number:");
        city.setFont(new Font("Railway", Font.BOLD, 20));
        city.setBounds(100, 420, 200, 30);
        add(city);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Railway", Font.BOLD, 14));
        aadhar.setBounds(300, 420, 400, 30);
        add(aadhar);
        
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Railway", Font.BOLD, 20));
        state.setBounds(100, 460, 200, 30);
        add(state);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 460, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 460, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
        
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Railway", Font.BOLD, 20));
        pincode.setBounds(100, 500, 200, 30);
        add(pincode);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 500, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 500, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);
        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway", Font.BOLD, 14));
        next.setBounds(620, 560, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 660);
        setLocation(220, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }else if(sno.isSelected()){
            seniorcitizen = "No";
        }
        
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        }else if(eno.isSelected()){
            existingaccount = "no";
        }
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        try{
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
            c.s.executeUpdate(query);
            
            //Signup3 object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new SignupTwo("");
    }
}



        