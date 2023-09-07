#include <iostream>

using namespace std;

int main()

{
     int N;//과목수
     double arr[1000]={};//시험 점수 
     double sum=0;
     double mean=0;
      
     cin.tie(NULL);
     ios_base::sync_with_stdio(false);
     cin >>N;
    
  
       for(int i=0; i<N; i++)
       {
          cin >> arr[i]; 
       } 
    
    // 점수 입력 
    
    
    int max=-1;// 최대 점수값 
    
    for(int i=0; i<N; i++)
    {
        if(max < arr[i])
            max = arr[i];
    }
    // 최대 점수를 구하기
    
    
    
    for(int i=0 ; i<N; i++)
    {
       sum=sum+100*arr[i]/max;
    }
    mean = sum/N;
    
    cout<<mean;
}
