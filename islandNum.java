import java.io.*;                                                                                                                             
import java.lang.reflect.Array;                                                                                                               
import java.util.*;                                                                                                                           
                                                                                                                                              
class XY{                                                                                                                                     
    int x;                                                                                                                                    
    int y;                                                                                                                                    
                                                                                                                                              
    XY(int x,int y){                                                                                                                          
        this.x=x;                                                                                                                             
        this.y=y;                                                                                                                             
    }                                                                                                                                         
}                                                                                                                                             
                                                                                                                                              
public class Main {                                                                                                                           
    static int[][] map;                                                                                                                       
    static List<Integer> answer = new ArrayList<>();                                                                                          
    static int[][] visted;                                                                                                                    
                                                                                                                                              
                                                                                                                                              
    public static void main(String[] args) throws IOException {                                                                               
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                                             
        StringTokenizer st;                                                                                                                   
        Deque<XY> deque = new ArrayDeque<>();                                                                                                 
        int[] dx = {0,0,-1,1,1,1,-1,-1};                                                                                                      
        int[] dy = {-1,1,0,0,1,-1,1,-1};                                                                                                      
                                                                                                                                              
        while (true){                                                                                                                         
            String temp=br.readLine();                                                                                                        
            st = new StringTokenizer(temp);                                                                                                   
            int N=Integer.parseInt(st.nextToken());                                                                                           
            int M=Integer.parseInt(st.nextToken());                                                                                           
                                                                                                                                              
            map=new int[M][N];                                                                                                                
                                                                                                                                              
            if(N==0&&M==0)                                                                                                                    
                break;                                                                                                                        
                                                                                                                                              
            for(int i=0;i<M;i++){                                                                                                             
                String temp2 = br.readLine();                                                                                                 
                st = new StringTokenizer(temp2);                                                                                              
                for(int j=0;j<N;j++){                                                                                                         
                    map[i][j]=Integer.parseInt(st.nextToken());                                                                               
                }                                                                                                                             
            }                                                                                                                                 
                                                                                                                                              
            int x=0;                                                                                                                          
            int y=0;                                                                                                                          
            visted=new int[M][N];                                                                                                             
            int count=0;                                                                                                                      
            for(int i=0;i<M;i++){                                                                                                             
                for(int j=0;j<N;j++){                                                                                                         
                    if(map[i][j]==1&&visted[i][j]!=1){                                                                                        
                        deque.add(new XY(i,j));                                                                                               
                        visted[i][j]=1;                                                                                                       
                        count++;                                                                                                              
                    }                                                                                                                         
                    while (!deque.isEmpty()){                                                                                                 
                        for(int k=0;k<8;k++){                                                                                                 
                            int nx = deque.peek().x+dx[k];                                                                                    
                            int ny = deque.peek().y+dy[k];                                                                                    
                            if(nx>=0&&ny>=0&&nx<M&&ny<N){                                                                                     
                                if(visted[nx][ny]==0&&map[nx][ny]==1){                                                                        
                                    deque.add(new XY(nx,ny));                                                                                 
                                    visted[nx][ny]=1;                                                                                         
                                }                                                                                                             
                            }                                                                                                                 
                        }                                                                                                                     
                        deque.poll();                                                                                                         
                    }                                                                                                                         
                                                                                                                                              
                }                                                                                                                             
            }                                                                                                                                 
            answer.add(count);                                                                                                                
        }                                                                                                                                     
                                                                                                                                              
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));                                                           
        for(int item : answer){                                                                                                               
            bw.write(Integer.toString(item));                                                                                                 
            bw.newLine();                                                                                                                     
        }                                                                                                                                     
        bw.flush();                                                                                                                           
        bw.close();                                                                                                                           
    }                                                                                                                                         
}
