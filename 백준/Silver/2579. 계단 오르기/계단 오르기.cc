#include <iostream>

using namespace std;


int main()
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int T;
    int d[1000005][3];
    int s[1000005];
    
    cin >> T;
    
    
    for(int i=1; i<=T; i++ )
    {
        cin >>s[i];
    }
    d[1][1] =s[1];
    d[1][2] =0;
    d[2][1] =s[2];
    d[2][2]= s[1]+s[2];
    
    if(T==1)
    {
        cout<<s[1];
        return 0;
    }
    
    for(int i=3; i<=T; i++ )
    {
        d[i][1] = max (d[i-2][2],d[i-2][1]) + s[i];
        d[i][2] = d[i-1][1] + s[i];
    }
    
    cout<<max(d[T][1],d[T][2]);
    
    
}