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
	
	static int sum=0;//���ڵĺ�����
	static int sum2=0;//���ڵ�������
	static int sp =0;//����ʱ��
	JTextField tf_length;
	JTextField tf_length2;
	JTextField speed;
	 static JButton btn;
	static  boolean flag=true;
	
	public UI() {
		super("��������");
		this.setBounds(800, 300, 800, 220);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new FlowLayout(FlowLayout.RIGHT));
		JPanel p1=new JPanel();
		p1.add(new JLabel("��������λ�õ�x����(>0)"));
		tf_length=new JTextField(5);
		p1.add(tf_length);
		JPanel p2=new JPanel();
		p1.add(new JLabel("��������λ�õ�y����(>0)"));
		tf_length2=new JTextField(5);
		p1.add(tf_length2);
		p1.add(new JLabel("��������ʱ��(0-100000��)"));
		speed=new JTextField(5);
		p1.add(speed);
		btn=new JButton("ȷ��");
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
						for (int i = 0; i <sp*10; i++) {//10��һ��
							r.mouseMove(sum,sum2);//�����������Ļ����(sum,sum2)//�ҵĵ��ԵĴ��ڵĴ�СΪ1800*1000�����Ͻ�Ϊ��0,0,��
							r.delay(100);//ͣ��100ms������ÿ����10��
							r.mousePress(InputEvent.BUTTON1_MASK);//����������
							r.delay(1);
							System.out.println("��"+i+"�ε��");
							r.mouseRelease(InputEvent.BUTTON1_MASK);//�ɿ����
						}
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					System.out.println("������������������");
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
