package test;

public class TheShortestWay2 {
	
		static int MAX_SIZE=9;
		public static void dijkstra(int v,float[][]a,float[]dist,int[]prev)
		{
		   int n=dist.length-1;
		   if(v<0||v>n)return;
		   boolean []s=new boolean[n+1];
		  
		   for(int i=0;i<=n;i++)
		   {
		    dist[i]=a[v][i];
		    s[i]=false;
		    if(dist[i]==Float.MAX_VALUE)
		     prev[i]=0;
		    else
		     prev[i]=v;
		   }
		   
		   dist[v]=0;s[v]=true;
		   for(int i=0;i<n;i++)
		   {
		    float temp=Float.MAX_VALUE;
		    int u=v;
		    for(int j=0;j<=n;j++)
		     if((!s[j])&&(dist[j]<temp))
		     {
		      u=j;
		      temp=dist[j];
		     }
		    s[u]=true;
		    for(int j=0;j<=n;j++)
		     if((!s[j])&&(a[u][j]<Float.MAX_VALUE))
		     {
		      float newdist=dist[u]+a[u][j];
		      if(newdist<dist[j])
		      {
		       dist[j]=newdist;
		       prev[j]=u;
		      }
		     }
		   }
		}
		public static void main(String args[])
		{
		   float a[][]=new float[MAX_SIZE][MAX_SIZE];float[] dist=new float[MAX_SIZE];int[] prev=new int[MAX_SIZE];
		   for(int i=0;i<9;i++){
		    for(int j=0;j<9;j++){
		     a[i][j]=Float.MAX_VALUE;
		    }
		   }
		   a[0][1]=4;
		   a[0][7]=8;

		   a[1][0]=4;
		   a[1][7]=11;
		   a[1][2]=8;

		   a[2][1]=8;
		   a[2][3]=7;
		   a[2][8]=2;
		   a[2][5]=4;

		   a[3][2]=7;
		   a[3][4]=9;
		   a[3][5]=14;

		   a[4][3]=9;
		   a[4][5]=10;

		   a[5][2]=4;
		   a[5][3]=14;
		   a[5][4]=10;
		   a[5][6]=2;

		   a[6][5]=2;
		   a[6][8]=6;
		   a[6][7]=1;

		   a[7][0]=8;
		   a[7][1]=11;
		   a[7][8]=7;
		   a[7][6]=1;

		   a[8][2]=2;
		   a[8][6]=6;
		   a[8][7]=7;
		   
		   int v=0;//����Ӷ���1������
		  
		   dijkstra(v,a,dist,prev);
		  
		   System.out.println("��0������1��2��3�����·��������:");
		   for(int j=1;j<5;j++)
		   {
		    System.out.println(dist[j]);
		   }
		  
		   int z=prev[4],y=prev[z],x=prev[y];
		   System.out.println("��0��4���·�������ĵ�Ϊ��");
		   System.out.print(x+" "+y+" "+z+" "+"4");

		}

		}