import java.lang.String;
import java.util.Scanner;

public class Main_41
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int temp = k;
        int i;
        int j;
        int count = 0;
        int max = 0;
        int a[] = new int[n];
        int b[] = new int[n];
        for(i=0; i<n; i++)
        {
            a[i] = sc.nextInt();
        }

        for(i=0; i<n; i++)
        {
            if(a[i] == temp)
            {
                count++;
                max = a[i];
            }
        }
        for(i=0; i<n; i++)
        {
            if(a[i] < k && a[i] > max)
            {
                max = a[i];
            }
        }
        if(temp > max)
        {
            System.out.println(temp);
        }
        else
        {
            System.out.println(max);
        }
    }
}