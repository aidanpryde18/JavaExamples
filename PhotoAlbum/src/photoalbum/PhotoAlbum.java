package photoalbum;
import javax.swing.*;

public class PhotoAlbum {

    public static void main(String[] args) {
        JFrame frame = new JFrame ("Family Photos");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new AlbumPanel());

        frame.pack();
        frame.setVisible(true);
    }
}
