#include<iostream>

using namespace std;

int main()
{
    cin.tie(0);
    ios::sync_with_stdio(0);
        
    int n,m;
    int a[1000005];
    int d[1000005];
    
    cin>>n>>m;
    
    for(int i=1; i<=n; i++)
    {
        cin >> a[i];
        d[i] = d[i-1] + a[i];
    }
    
    while(m--)
    {
         int i,j;
        cin >>i>>j;
        cout <<d[j]-d[i-1]<<"\n";
        
        
    }
}