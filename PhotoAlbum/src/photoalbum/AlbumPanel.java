package photoalbum;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AlbumPanel extends JPanel
{
    private JButton mickey, minnie, elsa, pluto, popeye, grover, close;
    private JLabel picture;
    private JTextArea description;
    private ImageIcon elsaImg, mickeyImg, minnieImg, plutoImg, popeyeImg, groverImg;
    private String mickeyText, minnieText, elsaText, plutoText, popeyeText, groverText;

    public AlbumPanel()
    {
       // BUTTON SECTION
        mickey = new JButton("Mickey");
        minnie = new JButton("Minnie");
        elsa = new JButton("Elsa");
        pluto = new JButton("Pluto");
        popeye = new JButton("Popeye");
        grover = new JButton("Grover");
        close = new JButton("Close");

        // IMAGE ICON SECTION
        elsaImg = new ImageIcon("Elsa.jpg");
        mickeyImg = new ImageIcon("Mickey.jpg");
        minnieImg = new ImageIcon("minnie.jpg");
        plutoImg = new ImageIcon("Pluto.jpg");
        popeyeImg = new ImageIcon("Popeye.png");
        groverImg = new ImageIcon("Grover.jpg");

        // ACTION LISTENER SECTION
        mickey.addActionListener(new ButtonClick());
        minnie.addActionListener(new ButtonClick());
        elsa.addActionListener(new ButtonClick());
        pluto.addActionListener(new ButtonClick());
        popeye.addActionListener(new ButtonClick());
        grover.addActionListener(new ButtonClick());
        close.addActionListener(new ButtonClick());

        // STRING ASSIGNMENT SECTION
        mickeyText = "Mickey Mouse is a funny animal cartoon character and the official mascot of "  +
                "The Walt Disney Company. He was created by Walt Disney and Ub Iwerks at the Walt Disney Studios" +
                " in 1928. An anthropomorphic mouse who typically wears red shorts, large yellow shoes, " +
                "and white gloves, Mickey has become one of the world's most recognizable characters. - All text \u00a9 Wikipedia";

        minnieText = "Minerva \"Minnie\" Mouse is a funny animal cartoon character created by Ub Iwerks and " +
                "Walt Disney. She was first drawn by Iwerks in 1928, as was Mickey Mouse. The comic strip story" +
                " \"The Gleam\" (published January 19–May 2, 1942) by Merrill De Maris and Floyd Gottfredson " +
                "first gave her full name as Minerva Mouse, although this is seldom used. - All text \u00a9 Wikipedia";

        elsaText = "Queen Elsa of Arendelle is a fictional character who appears in Walt Disney Animation Studios' " +
                "53rd animated film Frozen. She is voiced primarily by Broadway actress and singer Idina Menzel. " +
                "At the beginning of the film, she is voiced by Eva Bella as a young child and by Spencer Lacey " +
                "Ganus as a teenager. - All text \u00a9 Wikipedia";

        plutoText = "Pluto, also called Pluto the Pup, is a cartoon character created in 1930 by " +
                "Walt Disney Productions. He is a yellow orange-color, medium-sized, short-haired dog with " +
                "black ears. Unlike most Disney characters, Pluto is not anthropomorphic beyond some characteristics " +
                "such as facial expression, though he did speak for a short portion of his history. " +
                "He is Mickey Mouse's pet. - All text \u00a9 Wikipedia";

        popeyeText = "Popeye the Sailor Man is a cartoon fictional character created by Elzie Crisler Segar " +
                "who has appeared in comic strips and theatrical and television animated cartoons. He first " +
                "appeared in the daily King Features comic strip Thimble Theatre on January 17, 1929; Popeye " +
                "became the strip's title in later years. - All text \u00a9 Wikipedia";

        groverText = "Grover, also known as Grover Monster, is a Muppet character on the popular television " +
                "show Sesame Street. Self-described as lovable, cute and furry, he is a blue monster who rarely " +
                "uses contractions when he speaks or sings. Grover was originally performed by Frank Oz from his " +
                "earliest appearances until 2001. Eric Jacobson began performing Grover in 1998; he has performed " +
                "the character regularly since 2001, although Oz still performs him occasionally. - All text \u00a9 Wikipedia";

        // TEXT AREA SECTION
        description = new JTextArea(3, 40);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setText(mickeyText);

        // Instantiates Picture Label with Mickey picture
        picture = new JLabel(mickeyImg);

        setPreferredSize(new Dimension(450, 450));

        // Add objects to Panel
        add(mickey);
        add(minnie);
        add(elsa);
        add(pluto);
        add(popeye);
        add(grover);
        add(picture);
        add(description);
        add(close);
    }

    // Button Click Action Listener. It evaluates the source and then performs the action based on that source
    // Character buttons change the ImageIcon and TextArea, close button closes the program
    private class ButtonClick implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == mickey)
            {
                picture.setIcon(mickeyImg);
                description.setText(mickeyText);
            }
            else if (event.getSource() == minnie)
            {
                picture.setIcon(minnieImg);
                description.setText(minnieText);
            }
            else if (event.getSource() == elsa)
            {
                picture.setIcon(elsaImg);
                description.setText(elsaText);
            }
            else if (event.getSource() == pluto)
            {
                picture.setIcon(plutoImg);
                description.setText(plutoText);
            }
            else if (event.getSource() == popeye)
            {
                picture.setIcon(popeyeImg);
                description.setText(popeyeText);
            }
            else if (event.getSource() == grover)
            {
                picture.setIcon(groverImg);
                description.setText(groverText);
            }
            else if(event.getSource() == close)
            {
                System.exit(0);
            }

        }
    }
}
