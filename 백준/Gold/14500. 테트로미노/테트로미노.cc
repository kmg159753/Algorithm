#include<bits/stdc++.h>

using namespace std;


int n,m; 
int board[505][505];

bool vis[505][505]; 
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1}; 

int result =0 ;  

void dfs(int x, int y, int cnt, int sum){
      
    if(cnt == 3){
        result = max(result , sum)  ; 
        return ;
    }  
    for(int dir=0; dir<4; dir++){
        int nx = x + dx[dir];
        int ny = y + dy[dir]; 
        
        if(nx >= n || nx <0 || ny >= m || ny <0) continue;
        if(vis[nx][ny]  )continue;
        
        vis[nx][ny] =1; 
        
        dfs(nx, ny, cnt+1, sum + board[nx][ny]);
        
       vis[nx][ny] = 0; 
    }
    
    
}

void func1(int x, int y){
    int sum = board[x][y] + board[x+1][y] + board[x+2][y] + board[x+1][y+1];
    if(x+2 < n && y+1 < m  ){
        result = max(result, sum);
    }
}

void func2(int x, int y){
    int sum = board[x][y] + board[x][y+1] + board[x][y+2] + board[x-1][y+1];
    if(y+2 < m && x-1 >=0  ){
        result = max(result, sum);
    }
}

void func3(int x, int y){
    int sum = board[x][y] + board[x][y+1] + board[x][y+2] + board[x+1][y+1];
    if(y+2 < m && x+1 < n  ){
        result = max(result, sum);
    }
}

void func4(int x, int y){
    int sum = board[x][y] + board[x-1][y+1] + board[x][y+1] + board[x+1][y+1];
    if(x-1 >=0 && x+1 <n && y+1 <m  ){
        result = max(result, sum);
    }
}

int main(){
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    
    
    cin >>n  >> m; 
    
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin >> board[i][j];
        }
    }
    
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            vis[i][j] = 1;
            dfs(i,j,0,board[i][j]);
            vis[i][j] = 0;
            func1(i,j);
            func2(i,j);
            func3(i,j);
            func4(i,j);
        }
    }
    
    cout<< result; 
    
    
}