#include<iostream>
#include<queue>
#include<utility>
#include<tuple>

using namespace std;

#define X first
#define Y second

int dx[4] = {0,1,0,-1};
int dy[4] = {1,0,-1,0};

char board[1000][1000];
int dist[1000][1000][2];
// dist[x][y][0] : 벽을 하나도 부수지 않고 (x,y)까지 오는데 걸리는 비용
// dist[x][y][1] : 벽을 하나만 부수고 (x,y)까지 오는데 걸리는 비용, (x,y)가 벽이라서 부수는 경우 포함

int n, m;

int main(){
    cin.tie(0);
    ios::sync_with_stdio(0);
    cin >> n >> m;
    for (int i = 0; i < n; ++i)
       for (int j = 0; j < m; ++j)
          cin >> board[i][j];
    
  
    for (int i = 0; i < n; ++i)
       for (int j = 0; j < m; ++j)
          dist[i][j][0] = dist[i][j][1] = -1;
    
    dist[0][0][0]= dist[0][0][1]= 0;
    
    queue< tuple<int,int,int> > q; 
    
    q.push({0,0,0});
    
    int tmp=0; 
    
    while(!q.empty())
    {
        int x, y, broken;
        tie(x, y, broken) = q.front(); q.pop();        
        
        
        for(int dir=0; dir<4; dir++)
        {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if( nx>=n || ny>=m || nx <0|| ny<0) continue;
            if(dist[nx][ny][broken] ==-1 && board[nx][ny] =='0' ) {
            
                dist[nx][ny][broken] = dist[x][y][broken] + 1;
                q.push({nx,ny,broken});
            }
            
            if (!broken && board[nx][ny] =='1' && dist[nx][ny][1]==-1 ){
                
                dist[nx][ny][1] = dist[x][y][broken] + 1;
                q.push({nx,ny,1});
            }
            
            
        }        
    }
     
    
            
    if(dist[n-1][m-1][0] >=0 || dist[n-1][m-1][1] >=0 ) {
        int mn; 
        
        if(dist[n-1][m-1][0]==-1){
            mn= dist[n-1][m-1][1]; 
        } 
        else if(dist[n-1][m-1][1] ==-1 ){
            mn =dist[n-1][m-1][0];
        }
        else {
            mn= min(dist[n-1][m-1][0],dist[n-1][m-1][1]);
        }
        cout<< mn+1 ;
        return 0;        
    }
    
    cout<< -1;
    
    
}

