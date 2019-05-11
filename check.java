import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Collections;


class variables
{
    public static int[] process_id=new int[9];
    /* public static int[] arrival_time=new int[9];
     public static int[] burst_time=new int[9];*/
    public static int[][] data=new int[3][9];
    //public static int[] priority=new int[];
    public static LinkedList<Integer> q1 = new LinkedList<Integer>(); //First queue
    public static LinkedList<Integer> q2 = new LinkedList<Integer>(); //Second queue
    public static LinkedList<Integer> q3 = new LinkedList<Integer>(); //Third queue
    public static LinkedList<Integer> readyq = new LinkedList<Integer>(); //Third queue
    public static int tq1=2;
    public static int tq2=4;
    public static int time=0;
    public static int flagg=-1;
    public static int bt_array[];
    public static int count=0;
    public static int formFlag=0;
    public static  int submitFlag=0;
    public static Thread t;
    public static Frame ff1;
    public static int size;
    public static String ma;
    public static  Frame f;
    public static String error="";
    public static int finalwalatemp=1;

}
class form extends Frame implements ActionListener
{
    Button b= new Button("Submit");
    Choice pid1;
    Label l=new Label("Number of processes : ");
    Font f1,f2,f3,f4;
    form(String title)
    {
        super(title);
        f1 = new Font("Arial",Font.BOLD,22);
        f2 = new Font("Arial",Font.BOLD,18);
        f3= new Font("Arial",Font.BOLD,28);
        f4= new Font("Arial",Font.ITALIC,20);
        setLayout(null);
        pid1=new Choice();
        pid1.add("1");
        pid1.add("2");
        pid1.add("3");
        pid1.add("4");

        add(l);
        add(pid1);
        add(b);
        b.addActionListener(this);
        b.setBounds(120,250,150,40);
        b.setFont(f1);
        l.setBounds(100,70,250,30);
        l.setForeground(Color.white);
        l.setFont(f1);
        pid1.setBounds(120,120,150,150);
        pid1.setFont(f1);

        addWindowListener(new MyWindowAdapter(this));
        setBackground(Color.black);


    }
    public void actionPerformed(ActionEvent a)
    {
        variables.size=Integer.valueOf(pid1.getSelectedItem());
        variables.ma=pid1.getSelectedItem();
        variables.ff1 = new formFinal("Detail Form");
        variables.ff1.setSize(1500,1000);
        variables.ff1.setVisible(true);
        variables.submitFlag=1;

    }

}
class MyWindowAdapter extends WindowAdapter
{
    form sampleFrame;
    public MyWindowAdapter(form sampleFrame)
    {
        this.sampleFrame = sampleFrame;
    }
    public void windowClosing(WindowEvent we)
    {
        sampleFrame.setVisible(false);
    }
}
class formFinal extends Frame implements ActionListener
{
    Font f1,f2,f3,f4;
    Button b= new Button("Submit ");
    TextField t1 = new TextField(10);
    TextField t2 = new TextField(10);
    TextField t3 = new TextField(10);
    TextField t4 = new TextField(10);
    TextField t5 = new TextField(10);
    TextField t6 = new TextField(10);
    TextField t7 = new TextField(10);
    TextField t8 = new TextField(10);
    TextField t9 = new TextField(10);
    TextField t10 = new TextField(10);
    TextField t11 = new TextField(10);
    TextField t12 = new TextField(10);
    Label l0=new Label("Enter the number of process");
    Label l1 = new Label("Enter Process ID: ");
    Label l2 = new Label("Enter Arrival Time: ");
    Label l3 = new Label("Enter Burst Time: ");
    Label l4 = new Label("Enter Process ID: ");
    Label l5 = new Label("Enter Arrival Time: ");
    Label l6 = new Label("Enter Burst Time: ");
    Label l7 = new Label("Enter Process ID: ");
    Label l8 = new Label("Enter Arrival Time: ");
    Label l9 = new Label("Enter Burst Time: ");
    Label l10 = new Label("Enter Process ID: ");
    Label l11 = new Label("Enter Arrival Time: ");
    Label l12 = new Label("Enter Burst Time: ");
    Label l13 = new Label("Process 1 ");
    Label l14 = new Label("Process 2 ");
    Label l15 = new Label("Process 3 ");
    Label l16 = new Label("Process 4 ");

    formFinal(String title)
    {
        super(title);
        setBackground(Color.black);
        f1 = new Font("Arial",Font.BOLD,22);
        f2 = new Font("Arial",Font.BOLD,18);
        f3= new Font("Arial",Font.BOLD,28);
        f4= new Font("Arial",Font.ITALIC,20);


        setLayout(null);
        if(variables.size>=1) {

            add(l1);
            add(t1);
            add(l2);
            add(t2);
            add(l3);
            add(t3);
            add(l13);
            l1.setBounds(30,150,200,30);
            l1.setForeground(Color.white);
            l1.setFont(f1);
            t1.setBounds(250,150,150,30);
            l2.setBounds(450,150,200,30);
            l2.setForeground(Color.white);
            l2.setFont(f1);
            t2.setBounds(680,150,150,30);
            l3.setBounds(880,150,200,30);
            l3.setForeground(Color.white);
            l3.setFont(f1);
            t3.setBounds(1100,150,150,30);
            l13.setBounds(600, 80, 200, 30);
            l13.setForeground(Color.white);
            l13.setFont(f3);




        }

        if(variables.size>=2) {
            add(l4);
            add(t4);
            add(l5);
            add(t5);
            add(l6);
            add(t6);
            add(l14);
            l4.setBounds(30,350,200,30);
            l4.setForeground(Color.white);
            l4.setFont(f1);
            t4.setBounds(250,350,150,30);
            l5.setBounds(450,350,200,30);
            l5.setForeground(Color.white);
            l5.setFont(f1);
            t5.setBounds(680,350,150,30);
            l6.setBounds(880,350,200,30);
            l6.setForeground(Color.white);
            l6.setFont(f1);
            t6.setBounds(1100,350,150,30);
            l14.setBounds(600, 250, 200, 30);
            l14.setForeground(Color.white);
            l14.setFont(f3);
        }

        if(variables.size>=3) {
            add(l7);
            add(t7);
            add(l8);
            add(t8);
            add(l9);
            add(t9);
            add(l15);
            l7.setBounds(30,550,200,30);
            l7.setForeground(Color.white);
            l7.setFont(f1);
            t7.setBounds(250,550,150,30);
            l8.setBounds(450,550,200,30);
            l8.setForeground(Color.white);
            l8.setFont(f1);
            t8.setBounds(680,550,150,30);
            l9.setBounds(880,550,200,30);
            l9.setForeground(Color.white);
            l9.setFont(f1);
            t9.setBounds(1100,550,150,30);
            l15.setBounds(600, 450, 200, 30);
            l15.setForeground(Color.white);
            l15.setFont(f3);
        }

        if(variables.size>=4) {
            add(l10);
            add(t10);
            add(l11);
            add(t11);
            add(l12);
            add(t12);
            add(l16);
            l10.setBounds(30,750,200,30);
            l10.setForeground(Color.white);
            l10.setFont(f1);
            t10.setBounds(250,750,150,30);
            l11.setBounds(450,750,200,30);
            l11.setForeground(Color.white);
            l11.setFont(f1);
            t11.setBounds(680,750,150,30);
            l12.setBounds(880,750,200,30);
            l12.setForeground(Color.white);
            l12.setFont(f1);
            t12.setBounds(1100,750,150,30);
            l16.setBounds(600, 650, 200, 30);
            l16.setForeground(Color.white);
            l16.setFont(f3);
        }

        add(b);
        b.addActionListener(this);
        b.setBounds(600,850,150,40);
        b.setFont(f1);

        //  pid1.setBounds(230,230,100,100);
        addWindowListener(new MyWindowAdapter2(this));
    }
    public void actionPerformed(ActionEvent a)
    {
        variables.formFlag=1;

        if(variables.size>=1 && ((t1.getText()).isEmpty() || (t2.getText()).isEmpty() || (t3.getText()).isEmpty()||!isNum(t1.getText()) ||  !isNum(t2.getText()) ||  !isNum(t3.getText()) ))
        {
            variables.finalwalatemp=0;
            repaint();
        }
        if(variables.size>=1 && !((t1.getText()).isEmpty() || (t2.getText()).isEmpty() || (t3.getText()).isEmpty()))
            if( !(!isNum(t1.getText()) ||  !isNum(t2.getText()) ||  !isNum(t3.getText()))){
            variables.data[0][0] = Integer.valueOf(t1.getText());
            variables.data[1][0] = Integer.valueOf(t2.getText());
            variables.data[2][0] = Integer.valueOf(t3.getText());
            variables.finalwalatemp=1;
                for(int i=0;i<1;i++)
                    if(variables.data[2][i]<1 || variables.data[1][i]<0)
                        variables.finalwalatemp=0;

            }
        if(variables.size>=2 && ((t4.getText()).isEmpty() || (t5.getText()).isEmpty() || (t6.getText()).isEmpty()||!isNum(t4.getText()) ||  !isNum(t5.getText()) ||  !isNum(t6.getText())))
        {
            variables.finalwalatemp=0;
            repaint();
        }
        if(variables.size>=2 && !((t4.getText()).isEmpty() || (t5.getText()).isEmpty() || (t6.getText()).isEmpty()))
            if( !(!isNum(t4.getText()) ||  !isNum(t5.getText()) ||  !isNum(t6.getText()))){
            variables.data[0][1] = Integer.valueOf(t4.getText());
            variables.data[1][1] = Integer.valueOf(t5.getText());
            variables.data[2][1] = Integer.valueOf(t6.getText());
            variables.finalwalatemp=1;

                for(int i=0;i<2;i++)
                    if(variables.data[2][i]<1 || variables.data[1][i]<0)
                        variables.finalwalatemp=0;

            }
        if(variables.size>=3 && ((t7.getText()).isEmpty()||(t8.getText()).isEmpty()||(t9.getText()).isEmpty()|| !isNum(t7.getText()) ||  !isNum(t8.getText()) ||  !isNum(t9.getText())))
        {
            variables.finalwalatemp=0;
            repaint();
        }
        if(variables.size>=3 && !((t7.getText()).isEmpty()||(t8.getText()).isEmpty()||(t9.getText()).isEmpty()))
            if( !(!isNum(t7.getText()) ||  !isNum(t8.getText()) ||  !isNum(t9.getText()))){
            variables.data[0][2] = Integer.valueOf(t7.getText());
            variables.data[1][2] = Integer.valueOf(t8.getText());
            variables.data[2][2] = Integer.valueOf(t9.getText());
            variables.finalwalatemp=1;
            if(Integer.valueOf(t1.getText())==Integer.valueOf(t4.getText())||Integer.valueOf(t1.getText())==Integer.valueOf(t7.getText())||Integer.valueOf(t4.getText())==Integer.valueOf(t7.getText()))
                variables.finalwalatemp=0;
                for(int i=0;i<3;i++)
                    if(variables.data[2][i]<1 || variables.data[1][i]<0)
                        variables.finalwalatemp=0;

            }
        if(variables.size>=4 && ((t10.getText()).isEmpty()||(t11.getText()).isEmpty()||(t12.getText()).isEmpty()||!isNum(t10.getText()) ||  !isNum(t11.getText()) ||  !isNum(t12.getText())))
        {
            variables.finalwalatemp=0;
            repaint();
        }
        if(variables.size>=4 && !((t10.getText()).isEmpty()||(t11.getText()).isEmpty()||(t12.getText()).isEmpty()))
            if( !(!isNum(t10.getText()) ||  !isNum(t11.getText()) ||  !isNum(t12.getText()))){
            variables.data[0][3] = Integer.valueOf(t10.getText());
            variables.data[1][3] = Integer.valueOf(t11.getText());
            variables.data[2][3] = Integer.valueOf(t12.getText());
            variables.finalwalatemp=1;

            if(Integer.valueOf(t1.getText())==Integer.valueOf(t4.getText())||Integer.valueOf(t1.getText())==Integer.valueOf(t7.getText())||Integer.valueOf(t1.getText())==Integer.valueOf(t10.getText())||Integer.valueOf(t4.getText())==Integer.valueOf(t7.getText())||Integer.valueOf(t4.getText())==Integer.valueOf(t10.getText())||Integer.valueOf(t7.getText())==Integer.valueOf(t10.getText()))
                variables.finalwalatemp=0;

            for(int i=0;i<4;i++)
                if(variables.data[2][i]<1 || variables.data[1][i]<0)
                    variables.finalwalatemp=0;

        }
        if(variables.finalwalatemp==1)
            variables.t.start();



    }

    public static boolean isNum(String strNum) {
        boolean ret = true;
        try {

            Double.parseDouble(strNum);

        }catch (NumberFormatException e) {
            ret = false;
        }
        return ret;
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        if(variables.finalwalatemp==0)
            g.drawString("PLEASE ENTER VALID DETAILS!",100,100);
    }



}
class MyWindowAdapter2 extends WindowAdapter
{

    formFinal sampleFrame;
    public MyWindowAdapter2(formFinal sampleFrame)
    {
        this.sampleFrame = sampleFrame;
    }
    public void windowClosing(WindowEvent we) {
        sampleFrame.setVisible(false);
    }
}


public class check extends Applet implements Runnable
{
    int n=variables.size;
    static int removeDuplicates(int temp[], int n)
    {
        // Return, if array is empty
        // or contains a single element
        if (n==0 || n==1)
            return n;

        int[] tempz = new int[n];

        // Start traversing elements
        int j = 0;
        for (int i=0; i<n-1; i++)
            // If current element is not equal
            // to next element then store that
            // current element
            if (temp[i] != temp[i+1])
                tempz[j++] = temp[i];

        // Store the last element as whether
        // it is unique or repeated, it hasn't
        // stored previously
        tempz[j++] = temp[n-1];

        // Modify original array
        for (int i=0; i<j; i++)
            temp[i] = tempz[i];

        return j;
    }
    int x =250,j;
    int y =50,k=0,l=1;
    int cnt =0,count;
    Image img;
    int max_bt=0;
    Font f1,f2,f3,f4;
    public void setHritik()
    {
        variables.data[0][0]=2;
        variables.data[0][1]=1;
        variables.data[0][2]=3;
        variables.data[0][3]=4;
        variables.data[1][0]=1;
        variables.data[1][1]=3;
        variables.data[1][2]=4;
        variables.data[1][3]=6;
        variables.data[2][0]=7;
        variables.data[2][1]=3;
        variables.data[2][2]=7;
        variables.data[2][3]=2;
        variables.process_id[0]=2;
        variables.process_id[1]=1;
        variables.process_id[2]=3;
        variables.process_id[3]=4;
        max_bt=7;
    }



    String P1="P1",P2="P2",P3="P3",P4="P4";
    String[] str = {P1,P2,P3,P4};

    public void init()
    {
        variables.f= new form("Size Form");
        variables.f.setSize(500,500);
        variables.f.setVisible(true);

        variables.t = new Thread(this);

        setSize(1500,1500);
        setBackground(Color.black);
        f1 = new Font("Arial",Font.BOLD,22);
        f2 = new Font("Arial",Font.BOLD,18);
        f3= new Font("Arial",Font.BOLD,28);
        f4= new Font("Arial",Font.ITALIC,20);



    }
    public void run() {
        if(variables.formFlag==1 && variables.submitFlag==1)
        {
            n=variables.size;
            variables.f.setVisible(false);
            variables.ff1.setVisible(false);

            int temp[]=new int[n];
            variables.bt_array=new int[n];
            //System.out.println(n);
            for(int i=0;i<n;i++)
            {
                variables.bt_array[i]=variables.data[2][i];
                temp[i]=variables.data[1][i];
                variables.process_id[i]=variables.data[0][i];
            }
            for(int i=0;i<n;i++)
                System.out.println(variables.bt_array[i]);

            // setHritik();
            int count=0,ttq1=0,flag1=0,ttq2=0,flag2=0;
            // int temp[]={1,3,4,6};

            Arrays.sort(temp);
            int q=removeDuplicates(temp,n);
            System.out.println("Temp : "+Arrays.toString(temp));
            for(int i=0;i<n;i++)
                System.out.println(variables.data[0][i]);
            int max_time=temp[n-1]+max_bt;
            for(int i=0;i<q;i++)
                for(int j=0;j<n;j++)
                    if(temp[i]==variables.data[1][j])
                        variables.readyq.add(variables.process_id[j]);

            while (variables.time<=30)
            {
                repaint();
                try{
                    variables.t.sleep(2000);}
                catch(Exception e)
                {

                }

                if(!variables.q1.isEmpty())
                {

                    if(ttq1==0 || flag1==1)
                        ttq1=variables.tq1;
                    flag1=0;
                    for(count=0;count<n;count++)
                        if(variables.q1.peek()==variables.data[0][count])
                        {
                            variables.data[2][count]--;
                            //System.out.println(variables.data[2][count]);
                            if(variables.data[2][count]==0)
                            {
                                variables.q1.remove();//deque q1;
                                flag1=1;
                                break;
                            }
                        }
                    ttq1--;
                    if(ttq1==0 && flag1!=1)
                        variables.q2.add(variables.q1.poll());                    //Demote q1.peek();

                }

                else if(variables.q1.isEmpty() && !variables.q2.isEmpty())
                {

                    if(ttq2==0 || flag2==1)
                        ttq2=variables.tq2;
                    flag2=0;
                    for(count=0;count<n;count++)
                        if(variables.q2.peek()==variables.data[0][count])
                        {
                            variables.data[2][count]--;
                            //System.out.println(variables.data[2][count]);
                            if(variables.data[2][count]==0)
                            {
                                variables.q2.remove();//deque q1;
                                flag2=1;
                                break;
                            }
                        }
                    ttq2--;
                    if(ttq2==0 && flag2!=1)
                        variables.q3.add(variables.q2.poll());                    //Demote q1.peek();

                }
                else if(!variables.q3.isEmpty() && variables.q2.isEmpty())
                {
                    for(count=0;count<n;count++)
                        if(!variables.q3.isEmpty())
                            if(variables.q3.peek()==variables.data[0][count])
                            {
                                variables.data[2][count]--;
                                if(variables.data[2][count]==0)
                                {
                                    variables.q3.remove();
                                    break;
                                }
                            }



                }
                //System.out.println(variables.readyq.peek());
                for(count=0;count<n;count++)
                    if(!variables.readyq.isEmpty())
                        if(variables.readyq.peek()==variables.data[0][count])
                            if(variables.time==variables.data[1][count])
                            {
                                int d=variables.readyq.poll();
                                //System.out.println(d);
                                if(variables.q1.size()<3)
                                    variables.q1.add(d);
                                else if(variables.q2.size()<3)
                                    variables.q2.add(d);
                                else if(variables.q3.size()<3)
                                    variables.q3.add(d);
                                variables.flagg=1;

                                //   System.out.println(variables.readyq.peek());
                            }



                variables.time++;
                if(variables.flagg==1)
                    repaint();
                try{
                    variables.t.sleep(20);}
                catch(Exception e)
                {

                }


            }


        }
    }

    public void paint(Graphics g)
    {

        int  flag = 0;
        j = 1 ;
        g.setColor(Color.white);
        g.drawRect(5, 30, 90, 250);
        g.setFont(f2);
        g.drawString("CPU", 30, 50);
        g.setFont(f4);
        g.drawString("Ready Queue", 650, 70);
        g.drawString("Queue 1", 650, 270);
        g.drawString("Queue 2", 650, 470);
        g.drawString("Queue 3", 650, 670);
        g.drawLine(200, 30, 200, 80);
        g.drawLine(200, 80, 600, 80);
        g.drawLine(600, 80, 600, 30);
        g.drawLine(200, 30, 600, 30);

        g.drawRect(200, 230, 400, 50);//Black rectangles
        g.drawRect(200, 430, 400, 50);
        g.drawRect(200, 630, 400, 50);
        for(int k =0; k<4;k++)
        {
            for (int i = 3; i < 6; i++) {
                g.drawLine(i * 100, 30+200*k, i * 100, 80 + 200*k);//vertical
            }
        }

        g.setColor(Color.black);

        g.fillRect(225, 40, 50, 30);
        g.fillRect(325, 40, 50, 30);
        g.fillRect(425, 40, 50, 30);
        g.fillRect(525, 40, 50, 30);

        g.setColor(Color.white);

        int count1=0,count2=0,count3=0,countf=0;
        //Iterator iterator = variables.q1.iterator();

        for(Integer itemf : variables.readyq)
        {
            for(int i=0;i<n;i++)
                if(itemf==variables.data[0][i] && variables.data[1][i]==variables.time) {
                    String tz = String.valueOf(itemf);
                    g.setFont(f2);
                    g.drawString(tz, 250 + 100 * countf, 60);
                    countf++;
                }
        }

        for (Integer item1: variables.q1) {
            String tz = String.valueOf(item1);
            g.setFont(f2);
            g.drawString(tz, 250 + 100 * count1, 260);
            count1++;

        }
        //111Iterator iterator = variables.q2.iterator();
        for (Integer item2: variables.q2) {
            String tz = String.valueOf(item2);
            g.setFont(f2);
            g.drawString(tz, 250 + 100 * count2, 460);
            count2++;
        }
        for (Integer item3: variables.q3){
            String tz = String.valueOf(item3);
            g.setFont(f2);
            g.drawString(tz, 250 + 100 * count3, 660);
            count3++;
        }
        for(int i =0; i<variables.size;i++)
        {
            g.setFont(f1);
            g.setColor(Color.white);
            String strP= " Process ID :   "+ String.valueOf(variables.data[0][i]);
            String strA=" Arrival Time :   "+ String.valueOf(variables.data[1][i]);
            String strBT= " Total Burst Time :   "+String.valueOf(variables.bt_array[i]);;
            String strBTL= " Burst Time Left :   "+ String.valueOf(variables.data[2][i]);
            g.drawString(strP,1000,50+220*i);
            g.drawString(strA,1000,80+220*i);
            g.drawString(strBT,1000,110+220*i);
            g.drawString(strBTL,1000,140+220*i);
            g.setFont(f3);
            g.drawString(" Time :  " + String.valueOf(variables.time),1200,30);
            g.setColor(Color.red);
            g.fillRect(1000,170+220*i,variables.data[2][i]*50,50);


        }

        for(int i=0;i<n;i++)
        {

            if(variables.data[2][i]==0 && variables.formFlag==1)
            {

                g.setColor(Color.black);
                g.fillRect(1145, 30+220*i, 30, 20);
                g.setColor(Color.green);
                g.setFont(f2);
                g.drawString(String.valueOf(variables.data[0][i]),30,200-i*30);
                g.setFont(f3);
                g.drawString(String.valueOf(variables.data[0][i]), 1145, 50+220*i);
            }
            g.setColor(Color.white);
        }

    }
}