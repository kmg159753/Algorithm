#include <iostream>
#include <utility>
#include <string>
#include <queue>

using namespace std;

#define X first
#define Y second 

int vis [200002];


int n,m;


int main()
{
    ios:: sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >>m;
    
    for(int i=0; i<100001; i++)
        vis[i] =-1;
    
    vis[n]=0; 
    queue<int > Q ;
    Q.push(n);
    
    while(vis[m] ==-1)
    {
        int cur = Q.front(); Q.pop();
        
        for(int nxt : {cur-1,cur+1,2*cur} )
        {
            if(nxt  < 0 || nxt > 100000  ) continue;
            if(vis[nxt] != -1) continue; 
            vis[nxt] = vis[cur] +1; 
            Q.push(nxt);
        }
    }
    
    cout<<vis[m];
}