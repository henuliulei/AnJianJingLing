package AnJIan;

import java.awt.AWTException;
import java.awt.FlowLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UI extends JFrame {
	
	static int sum=0;//窗口的横坐标
	static int sum2=0;//窗口的列坐标
	static int sp =0;//持续时长
	JTextField tf_length;
	JTextField tf_length2;
	JTextField speed;
	 static JButton btn;
	static  boolean flag=true;
	
	public UI() {
		super("按键精灵");
		this.setBounds(800, 300, 800, 220);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new FlowLayout(FlowLayout.RIGHT));
		JPanel p1=new JPanel();
		p1.add(new JLabel("请输入点击位置的x坐标(>0)"));
		tf_length=new JTextField(5);
		p1.add(tf_length);
		JPanel p2=new JPanel();
		p1.add(new JLabel("请输入点击位置的y坐标(>0)"));
		tf_length2=new JTextField(5);
		p1.add(tf_length2);
		p1.add(new JLabel("请输入点击时长(0-100000秒)"));
		speed=new JTextField(5);
		p1.add(speed);
		btn=new JButton("确定");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					sum=Integer.parseInt(tf_length.getText().trim());
					sum2=Integer.parseInt(tf_length2.getText().trim());
					sp=Integer.parseInt(speed.getText().trim());
					if(sum<0) {
						sum=0;
					}
					if(sum2<0) {
						sum2=0;
					}
					if(sp<1) {
						sp=1;
					}
					if(sp>100000) {
						sp=100000;
					}
					if(sp<0) {
						sp=0;
					}
					Robot r;
					try {
						r = new Robot();
						System.out.println(sum+","+sum2+","+sp);
						for (int i = 0; i <sp*10; i++) {//10次一秒
							r.mouseMove(sum,sum2);//将鼠标移至屏幕坐标(sum,sum2)//我的电脑的窗口的大小为1800*1000，左上角为（0,0,）
							r.delay(100);//停留100ms，这样每秒点击10次
							r.mousePress(InputEvent.BUTTON1_MASK);//按下鼠标左键
							r.delay(1);
							System.out.println("第"+i+"次点击");
							r.mouseRelease(InputEvent.BUTTON1_MASK);//松开左键
						}
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					System.out.println("输入有误，请重新输入");
				}
				
			}
		});
		p1.add(btn);
		this.getContentPane().add(p1);
			this.setVisible(true);
		
	}
	public static void Test() {
		UI ui=new UI();
		sum=ui.sum;
		sum2=ui.sum2;
		sp=ui.sp;
		
	}


}
