/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Doctor
 */
public class Frontend extends JFrame
{
    private final int WIDHT  = 400,
                      HEIGHT = 500;
    
    private JPanel northInput,
                   southButtons;
    private JPanel[] northInputs = new JPanel[ 7 ];
    private JLabel nameLabel,
                   diffLabel,
                   speedLabel,
                   colorLabel;
    private JTextField name;
    private JCheckBox notify;
    private JRadioButton beg,
                         exr,
                         adv,
                         exp;
    private ButtonGroup difficulty;
    private JSlider speed;
    private JComboBox color;
    private JTextArea results;
    private JButton confirm, exit;
    private Object[] comps = new Object[ 8 ];
    private String[] colors = { "", "Red", "Orange", "Yellow", "Green", "Blue",
            "Indigo", "Violet", "Black", "White", "Grey", "Random" };
    
    private Frontend()
    {
        
        setTitle( "Game Window" );
        
        setSize( WIDTH, HEIGHT );
        
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        setLayout( new BorderLayout() );
        
        northInput = new JPanel();
        fillNorthInput();
        add( northInput, BorderLayout.NORTH );
        
        results = new JTextArea( "some text" );
        results.setEditable( false );
        add( results, BorderLayout.CENTER );
        
        southButtons = new JPanel();
        fillSouthButtons();
        add( southButtons, BorderLayout.SOUTH );
        
        setVisible( true );
    }
    
    private void fillNorthInput()
    {
        int row = 0; // Counter for the row of the layout
        northInput.setLayout( new GridLayout( 8, 1 ) );
        for ( int i = 0; i < northInputs.length; i++ )
        {
            northInputs[ i ] = new JPanel();
            northInputs[ i ].setLayout( new GridLayout( 1, 2 ));
        }
        
        nameLabel = new JLabel( "Username: " );
        name      = new JTextField( "(e.g. MyUserName)" );
        northInputs[ 0 ].add( nameLabel );
        northInputs[ 0 ].add( name );
        comps[ row++ ] = northInputs[ 0 ];
        
        notify    = new JCheckBox( "<html>Check this to receive text/email "
                + "communications about your account.</html>" );
        comps[ row++ ] = notify;
        
        diffLabel = new JLabel( "Difficulty: " );
        beg       = new JRadioButton( "Beginner" );
        exr       = new JRadioButton( "Experienced", true );
        adv       = new JRadioButton( "Advanced" );
        exp       = new JRadioButton( "Expert" );
        
        difficulty = new ButtonGroup();
        difficulty.add( beg );
        difficulty.add( exr );
        difficulty.add( adv );
        difficulty.add( exp );
        
        northInputs[ 1 ].add( diffLabel );
        northInputs[ 1 ].add( beg );
        comps[ row++ ] = northInputs[ 1 ];
        
        northInputs[ 2 ].add( new JLabel() );
        northInputs[ 2 ].add( exr );
        comps[ row++ ] = northInputs[ 2 ];
        
        northInputs[ 3 ].add( new JLabel() );
        northInputs[ 3 ].add( adv );
        comps[ row++ ] = northInputs[ 3 ];
        
        northInputs[ 4 ].add( new JLabel () );
        northInputs[ 4 ].add( exp );
        comps[ row++ ] = northInputs[ 4 ];
        
        speedLabel     = new JLabel( "Game Speed: " );
        speed          = new JSlider( 5, 10 );
        
        northInputs[ 5 ].add( speedLabel );
        northInputs[ 5 ].add( speed );
        comps[ row++ ] = northInputs[ 5 ];
        
        colorLabel     = new JLabel( "Character Color: " );
        color          = new JComboBox( colors );
        
        northInputs[ 6 ].add( colorLabel );
        northInputs[ 6 ].add( color );
        comps[ row++ ] = northInputs[ 6 ];
        
        for ( int i = 0; i < comps.length; i++ )
        {
            northInput.add( (Component) comps[ i ] );
        }
    }
    
    private void fillSouthButtons()
    {
        confirm = new JButton( "Confirm" );
        exit    = new JButton( "Exit" );
        
        southButtons.setLayout( new FlowLayout( FlowLayout.CENTER ) );
        
        southButtons.add( confirm );
        southButtons.add( exit );
        
        confirm.addActionListener( new ButtonListener() );
        exit.addActionListener(new ButtonListener() );
    }
    
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if ( e.getSource() == confirm )
            {
                
            }
            else
                System.exit(0);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main( String[] args )
    {
        new Frontend();
    }
}