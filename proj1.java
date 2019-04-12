import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

class process
{
    public int process_id;
    public int arrival_time;
    public int burst_time;
    Scanner s1 = new Scanner(System.in);

    void put_process()
    {
        System.out.println("Process Id : "+process_id+" Arrival Time : "+arrival_time+" Burst Time : "+burst_time);
    }
}

class make_q
{
    public static final int MAX=4;
    int front=0,end=0;
    int queue_array[];
    make_q()
    {
        queue_array=new int[MAX];
    }

    void deque()
    {
        front=(front+1)%MAX;
    }

    int enque(int i)
    {
        if(front==(end+1)%MAX)
            return 0;
        queue_array[end]=i;
        end=(end+1)%MAX;
        return 1;
    }

    void print()
    {
        for(int i=front;i<end;i++)
            System.out.print((queue_array[i]+1)+" ");
        System.out.println("");
    }

    int front(int i)
    {
        if(queue_array[front]==i)
            return 1;
        return 0;
    }

    int isfront(int i)
    {
        if(queue_array[front]==i)
            return 1;
        return 0;
    }


}
class proj1 {
    public static void main(String[] args) {
        Scanner s1=new Scanner(System.in);
        System.out.println("Enter the number of queues");
        int n_q=s1.nextInt();
        make_q queue_array[]=new make_q[n_q];

        for(int i=0;i<n_q;i++)
        {
            queue_array[i]=new make_q();
        }

        System.out.println("Enter the no of process");
        int n_process=s1.nextInt();

        int process_id_array[]=new int[n_process];
        int arrival_time_array[]=new int[n_process];
        int burst_time_array[]=new int[n_process];

        process processes_array[]=new process[n_process];

        for(int i=0;i<n_process;i++)
        {
            System.out.println("Enter value of process_id,arrival_time,burst_time");
            process_id_array[i]=s1.nextInt();
            arrival_time_array[i]=s1.nextInt();
            burst_time_array[i]=s1.nextInt();
        }

        for(int i=0;i<n_process;i++)
        {
            processes_array[i]=new process();
            int loc=0,min=100000;
            for(int j=0;j<n_process;j++)
                if(arrival_time_array[j]<min)
                {
                    min=arrival_time_array[j];
                    loc=j;
                }
                processes_array[i].arrival_time=arrival_time_array[loc];
                processes_array[i].burst_time=burst_time_array[loc];
                processes_array[i].process_id=process_id_array[loc];
                arrival_time_array[loc]=999999;
        }

        for (int i=0;i<n_process;i++)
            processes_array[i].put_process();

        int time=0;
        while (time!=10)
        {
                int flag=0;
                for (int i = 0; i < n_process; i++) {
                    if (processes_array[i].arrival_time == time)
                        for (int j = 0; j < n_q; j++) {
                            int res = queue_array[j].enque(i);
                            if (res == 1)
                                break;
                        }

                    if (processes_array[i].burst_time == 0)
                    {
                        queue_array[0].deque();
                        processes_array[i].burst_time--;
                        flag=1;
                    }

                    if (time > processes_array[i].arrival_time && processes_array[i].burst_time > 0 && queue_array[0].front(i) == 1 && flag==0)
                        processes_array[i].burst_time--;


                }
                System.out.print("Time : " + time);
                for (int i = 0; i < n_q; i++) {
                    System.out.print(" Queue " + (i + 1) + " : ");
                    queue_array[i].print();
                }
                time++;
            }

    }
}