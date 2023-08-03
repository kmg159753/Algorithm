#include <iostream>
#include <string>
#include <deque>

using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    deque<int> DQ;
    
    int T;
    cin >> T;
    
    while(T--)
    {
        string S;
        cin >>S;
        
        if(S=="push_back")
        {
            int num;
            cin >> num;
            
            DQ.push_back(num);
        }
        else if(S=="push_front")
        {
            int num;
            cin >> num;
            
            DQ.push_front(num);
        }
        else if(S=="pop_back")
        {
            if(DQ.empty())
                cout<<-1<<"\n";
            else
            {            
                cout<<DQ.back()<<"\n";
                DQ.pop_back();
            }
        }
        else if(S=="pop_front")
        {
            if(DQ.empty())
                cout<<-1<<"\n";
            else
            {            
                cout<<DQ.front()<<"\n";
                DQ.pop_front();
            }
        }
        
        else if(S=="size")
        {
            cout<<DQ.size()<<"\n";
        }
        else if(S=="front")
        {
            if(DQ.empty())
                cout<<-1<<"\n";
            else
            {            
                cout<<DQ.front()<<"\n";
            }
        }
         else if(S=="back")
        {
            if(DQ.empty())
                cout<<-1<<"\n";
            else
            {            
                cout<<DQ.back()<<"\n";
            }
        }
        else{
            //empty
            cout<<DQ.empty()<<"\n";
        }
    }
    return 0;
}