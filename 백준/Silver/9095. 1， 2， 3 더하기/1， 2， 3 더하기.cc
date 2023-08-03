#include <iostream>

using namespace std;

int main()
{

    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int T;
    int d[10000];
    d[1]=1; 
    d[2]=2;
    d[3]=4; 
    
    cin >> T ;
    int n; 
   
      
      for(int i=4; i <=11; i++)
        {
            d[i] = d[i-1] + d[i-2] + d[i-3];             
        }
    
    while(T--)
    {
        cin >>n;
        
        cout <<d[n]<<"\n";
    }
    
    return 0;
}