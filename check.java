import java.applet.*;
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
    public static int bt_array[]={7,3,7,2};
    public static int count=0;

}


public class check extends Applet implements Runnable
{
    int n=4;
    Thread t;
    int x =250,j;
    int y =50,k=0,l=1;
    int cnt =0,count;
    Image img;
    int max_bt=0;
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
        t = new Thread(this);
        t.start();
        setSize(1500,1500);
        setBackground(Color.black);
        //0setHritik();

    }
    public void run() {
        setHritik();
        int count=0,ttq1=0,flag1=0,ttq2=0,flag2=0;
        int temp[]={1,3,4,6};

        Arrays.sort(temp);
        System.out.println("Temp : "+Arrays.toString(temp));
        for(int i=0;i<n;i++)
            System.out.println(variables.data[0][i]);
        int max_time=temp[n-1]+max_bt;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(temp[i]==variables.data[1][j])
                    variables.readyq.add(variables.process_id[j]);

            while (variables.time<=30)
            {
                repaint();
                try{
                    t.sleep(2000);}
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
                    t.sleep(2000);}
                catch(Exception e)
                {

                }


            }


        }

    public void paint(Graphics g)
    {

        int  flag = 0;
        j = 1 ;
        g.setColor(Color.white);
        g.drawLine(5, 30, 5, 100);//4 lines CPU
        g.drawLine(5, 30, 50, 30);
        g.drawLine(5, 100, 50, 100);
        g.drawLine(50, 100, 50, 30);
        g.drawString("CPU", 16, 50);
        g.drawString("Ready Queue", 650, 70);// 4 lines RQ
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
                        g.drawString(tz, 250 + 100 * countf, 60);
                        countf++;
                    }
            }

                for (Integer item1: variables.q1) {
                String tz = String.valueOf(item1);
                g.drawString(tz, 225 + 100 * count1, 270);
                count1++;

            }
            //111Iterator iterator = variables.q2.iterator();
            for (Integer item2: variables.q2) {
                String tz = String.valueOf(item2);
                g.drawString(tz, 225 + 100 * count2, 450);
                count2++;
            }
            for (Integer item3: variables.q3){
                String tz = String.valueOf(item3);
                g.drawString(tz, 225 + 100 * count3, 650);
                count3++;
            }
            for(int i =0; i<n;i++)
            {
                String strP= " Process ID :   "+ String.valueOf(variables.data[0][i]);
                String strA=" Arrival Time :   "+ String.valueOf(variables.data[1][i]);
                String strBT= " Total Burst Time :   "+ String.valueOf(variables.bt_array[i]);
                String strBTL= " Burst Time Left :   "+ String.valueOf(variables.data[2][i]);
                g.drawString(strP,1000,50+220*i);
                g.drawString(strA,1000,80+220*i);
                g.drawString(strBT,1000,110+220*i);
                g.drawString(strBTL,1000,140+220*i);
                g.fillRect(1000,170+220*i,variables.data[2][i]*50,50);
                g.drawString(" Time :  " + String.valueOf(variables.time),1200,30);
            }






    }
}
