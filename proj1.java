import java.util.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Collections;
//This code has the algorithm needed for MLFQ.
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
}

class operations extends variables
{
}

class proj1
{
public static void main(String[] args)
{
    Scanner s1=new Scanner(System.in);
    System.out.println("Enter the number of processes");
    int n=s1.nextInt();
    int temp[]=new int[n];
    int max_bt=0;

    for(int i=0;i<n;i++)
    {
        System.out.println("Enter PID,AT,BT");
        variables.process_id[i]=s1.nextInt();
        variables.data[0][i]=variables.process_id[i];
        variables.data[1][i]=s1.nextInt();
        variables.data[2][i]=s1.nextInt();
        /*variables.arrival_time[i]=s1.nextInt();
        variables.burst_time[i]=s1.nextInt();
        //variables.priority[i]=s1.nextInt();*/
        temp[i]=variables.data[1][i];
        if(variables.data[2][i]>max_bt)
            max_bt=variables.data[2][i];
    }
    Arrays.sort(temp);
    int max_time=temp[n-1]+max_bt;
    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            if(temp[i]==variables.data[1][j])
                variables.readyq.add(variables.process_id[j]);

    for (int i=0;i<n;i++)
        System.out.println(variables.data[0][i]);

    int count=0,ttq1=0,flag1=0,ttq2=0,flag2=0;
    while (variables.time<=12)
    {

        if(!variables.q1.isEmpty())
        {

            if(ttq1==0 || flag1==1)
                ttq1=variables.tq1;
            flag1=0;
            for(count=0;count<n;count++)
                if(variables.q1.peek()==variables.data[0][count])
                {
                    variables.data[2][count]--;
                    System.out.println(variables.data[2][count]);
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

        if(variables.q1.isEmpty() && !variables.q2.isEmpty())
        {

            if(ttq2==0 || flag2==1)
                ttq2=variables.tq2;
            flag2=0;
            for(count=0;count<n;count++)
                if(variables.q2.peek()==variables.data[0][count])
                {
                    variables.data[2][count]--;
                    System.out.println(variables.data[2][count]);
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
        //System.out.println(variables.readyq.peek());
        for(count=0;count<n;count++)
            if(!variables.readyq.isEmpty())
            if(variables.readyq.peek()==variables.data[0][count])
                    if(variables.time==variables.data[1][count])
                    {
                        int d=variables.readyq.poll();
                        System.out.println(d);
                        if(variables.q1.size()<3)
                            variables.q1.add(d);
                        else if(variables.q2.size()<3)
                            variables.q2.add(d);
                        else if(variables.q3.size()<3)
                            variables.q3.add(d);

         //   System.out.println(variables.readyq.peek());
                    }



        variables.time++;
        System.out.println("Ready Q : "+variables.readyq);
        System.out.println("Queue 1 : "+variables.q1);
        System.out.println("Queue 2 : "+variables.q2);
        System.out.println("Queue 3 : "+variables.q3);
    }
    System.out.println("Ready Q : "+variables.readyq);
    System.out.println("Queue 1 : "+variables.q1);
    System.out.println("Queue 2 : "+variables.q2);
    System.out.println("Queue 3 : "+variables.q3);

    /*int count=0,time=0;
    while (time<=max_time)
    {


            time++;
    }

    System.out.println("Queue 1 : "+variables.q1);
    System.out.println("Queue 2 : "+variables.q2);
    System.out.println("Queue 3 : "+variables.q3);*/
}
}
