import javax.swing.JFrame;

public class Tetris extends JFrame{
    public void initWindow(){
        //设置窗口大小
        this.setSize(600, 850);
        //设置窗口是否可见
        this.setVisible(true);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置释放窗体
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小不可变
        this.setResizable(false);
        //设置标题
        this.setTitle("俄罗斯方块");

    }

    public Tertris(){
        
    }
}