#include <iostream>

using namespace std;

int n,m;
int arr[10];
bool isused[10];

void func(int k)//현재까지 k개의 수를 택함 
{
  if(k == m) //k개의 수를 다 택했다면  
  {
     for(int i = 0; i < m; i++)
      cout << arr[i] << ' '; // arr에 기록해둔 수를 출력
      
      cout<<"\n";
     return;
  }
  
  for(int i=1; i<=n; i++)
  {
    if(!isused[i]){//아직 i가 사용되지 않았다면 
      arr[k] = i; //k번째 수를 i로 정함 
      isused[i]=1; // i를 사용되었다고 표시
      func(k+1); //다음수를 정하러 한 단계 더 들어감
      isused[i]=0;//k번째 수를 i로 정한 모든 경우에 대해 모두 확인했으니 이제 isused를 사용하지 않았다고 변경 
  
    }
  }
    
    
    
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> m;
    
    func(0);
    
    return 0;
    
}