import javax.swing.JFrame;
public class Chess
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 540;
      final int FRAME_HEIGHT = 540;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("Chess");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      GameControllerComponent component = new GameControllerComponent();
      frame.add(component);

      frame.setVisible(true);

   }
}
