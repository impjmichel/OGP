package w5;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Hangman
{
	private JTextField  input;
	private Set<String> guessedSet;
	private JPanel guessedPane;
	private JFrame frame;
	
	public Hangman(String word)
	{
		Set<String> wordSet = new TreeSet<String>();
		guessedSet = new TreeSet<String>();
		
		int currentLetter = 0;
		for(int i = 0; i < word.length(); i++)
		{
			currentLetter++;
			wordSet.add(word.substring(i, currentLetter));
		}
		
		for(String string : wordSet)
		{
			System.out.println(string);
		}
	}
	
	public void verify(String guess)
	{
		int currentLetter = 0;
		for(int i = 0; i < guess.length(); i++)
		{
			currentLetter++;
			if(!guessedSet.contains(guess.substring(i, currentLetter)))
			{
				guessedSet.add(guess.substring(i, currentLetter));
				JLabel pane = new JLabel(guess.substring(i, currentLetter)+", ");
				guessedPane.add(pane);
			}
		}
		System.out.println(guess);
		frame.validate();
	}
	
	public void createFrame()
	{
		frame = new JFrame("Hangman!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel(new FlowLayout());
		contentPane.setPreferredSize(new Dimension(300,300));
		input = new JTextField(2);
		input.addKeyListener(new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				// TODO Auto-generated method stub
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
				{
					verify(input.getText());
					input.setText("");
				}
			}
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}
		});
		contentPane.add(input);
		guessedPane = new JPanel(new FlowLayout());
		JLabel label = new JLabel("guessed :");
		guessedPane.add(label);
		contentPane.add(guessedPane);
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] arg)
	{
		Hangman game = new Hangman("wordgfKLDfhw");
		game.createFrame();
	}
}
