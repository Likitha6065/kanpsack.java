import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class knapsack {
	static int []p =new int[50];
    static int []w =new int[50];
    static int []x =new int[50];
    static int []t =new int[50];
    static double maxprofit;
    static int n,m,i,j;

    static void greedyknapsack(int n, int w[], int p[], int m)
    {
        int rc=m;
        bubblesort(n,w,p,t);

        for(i=1;i<=n;i++)
        {
            if(w[t[i]]>rc)
                continue;
            x[t[i]]=1;
            rc-=w[t[i]];
            maxprofit+=p[t[i]];
        }

        System.out.println("optimal solution for greedy method:"+maxprofit);
        System.out.println("solution vector for greedy method:");
        for(i=1;i<=n;i++)
            System.out.print(x[i]+"\t");
    }
    static void bubblesort(int n, int w[], int p[], int t[])
    {
        int temp;
        for(i=1;i<=n;i++)
            t[i]=i;
        for(i=1;i<n;i++)
            for(j=1;j<=n;j++)

                if((double)p[t[j]]/w[t[j]]<(double)p[t[j+1]]/w[t[j+1]])
                {
                    temp=t[j];
                    t[j]=t[j+1];
                    t[j+1]=temp;
                }
    }

	public static void main(String[] args) {
		
		   File text = new File(args[0]);
	        Scanner sc = null;
	        try {
	            sc = new Scanner(text);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        int n = sc.nextInt();
	        int m = sc.nextInt();

	        for(int i = 0;i <n;i++) {
	            w[i] = sc.nextInt();
	            System.out.println(w[i]);
	        }
	        for(int i = 0;i <n;i++)
	            p[i]=sc.nextInt();
	        greedyknapsack(n,w,p,m);

	}

}
