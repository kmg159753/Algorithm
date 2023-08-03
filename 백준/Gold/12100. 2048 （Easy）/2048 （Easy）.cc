#include<bits/stdc++.h>

using namespace std;

int N; 
int board[25][25];
int c_board[25][25];
bool vis[5] ;
int Answer=0; 


void copy(int copy[25][25], int origin[25][25]){
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            copy[i][j] = origin[i][j];
        }
    }
}

void left(int temp[25][25]){
    
    for(int i=0; i<N; i++){
        //숫자를 모두 왼쪽으로 정리
        for(int j=0; j<N; j++){
            if(temp[i][j] !=0){//0이 아닌수를 발견하면 
                // 가능한한 최대한 왼쪽으로 옮김 
                for(int k=0; k<j; k++){
                    if(temp[i][k]==0){//0이면 
                        //그쪽으로 숫자를 밀어버림 
                        temp[i][k]= temp[i][j];
                        temp[i][j]=0;
                        break;
                    }
                }
            }
        }
        //같은 숫자를 합침 
        for(int j=0; j<N-1; j++){
            if(temp[i][j]==temp[i][j+1]){
                temp[i][j] *=2;
                temp[i][j+1]=0;
            }
        }
        
        //숫자를 모두 왼쪽으로 정리
        for(int j=0; j<N; j++){
            if(temp[i][j] !=0){//0이 아닌수를 발견하면 
                // 가능한한 최대한 왼쪽으로 옮김 
                for(int k=0; k<j; k++){
                    if(temp[i][k]==0){//0이면 
                        //그쪽으로 숫자를 밀어버림 
                        temp[i][k]= temp[i][j];
                        temp[i][j]=0;
                        break;
                    }
                }
            }
        }
        
    }
    
    
    
}

void right(int temp[25][25]){
    for(int i=0; i<N; i++){
        //숫자를 모두 오른쪽으로 정리
        for(int j=N-1; j>=0; j--){
            if(temp[i][j] !=0){//0이 아닌수를 발견하면 
                // 가능한한 최대한 오른쪽으로 옮김 
                for(int k=N-1; k>j; k--){
                    if(temp[i][k]==0){//0이면 
                        //그쪽으로 숫자를 밀어버림 
                        temp[i][k]= temp[i][j];
                        temp[i][j]=0;
                        break;
                    }
                }
            }
        }
        //같은 숫자를 합침 
        for(int j=N-1; j>=1; j--){
            if(temp[i][j]==temp[i][j-1]){
                temp[i][j] *=2;
                temp[i][j-1]=0;
            }
        }
        
        //숫자를 모두 오른쪽으로 정리
        for(int j=N-1; j>=0; j--){
            if(temp[i][j] !=0){//0이 아닌수를 발견하면 
                // 가능한한 최대한 오른쪽으로 옮김 
                for(int k=N-1; k>j; k--){
                    if(temp[i][k]==0){//0이면 
                        //그쪽으로 숫자를 밀어버림 
                        temp[i][k]= temp[i][j];
                        temp[i][j]=0;
                        break;
                    }
                }
            }
        }
        
    }
    
    
    
}

void up(int temp[25][25]){
    for(int j=0; j<N; j++){
        //숫자를 모두 위쪽으로 정리
        for(int i=0; i<N; i++){
            if(temp[i][j] !=0){//0이 아닌수를 발견하면 
                // 가능한한 최대한 위쪽으로 옮김 
                for(int k=0; k<i; k++){
                    if(temp[k][j]==0){//0이면 
                        //그쪽으로 숫자를 밀어버림 
                        temp[k][j]= temp[i][j];
                        temp[i][j]=0;
                        break;
                    }
                }
            }
        }
        //같은 숫자를 합침 
        for(int i=0; i<N-1; i++){
            if(temp[i][j]==temp[i+1][j]){
                temp[i][j] *=2;
                temp[i+1][j]=0;
            }
        }
        
        //숫자를 모두 위쪽으로 정리
        for(int i=0; i<N; i++){
            if(temp[i][j] !=0){//0이 아닌수를 발견하면 
                // 가능한한 최대한 위쪽으로 옮김 
                for(int k=0; k<i; k++){
                    if(temp[k][j]==0){//0이면 
                        //그쪽으로 숫자를 밀어버림 
                        temp[k][j]= temp[i][j];
                        temp[i][j]=0;
                        break;
                    }
                }
            }
        }
        
    }
    
    

}


void down(int temp[25][25]){
    for(int j=0; j<N; j++){
        //숫자를 모두 아래쪽으로 정리
        for(int i=N-1; i>=0; i--){
            if(temp[i][j] !=0){//0이 아닌수를 발견하면 
                // 가능한한 최대한 아래쪽으로 옮김 
                for(int k=N-1; k>i; k--){
                    if(temp[k][j]==0){//0이면 
                        //그쪽으로 숫자를 밀어버림 
                        temp[k][j]= temp[i][j];
                        temp[i][j]=0;
                        break;
                    }
                }
            }
        }
        //같은 숫자를 합침 
        for(int i=N-1; i>=1; i--){
            if(temp[i][j]==temp[i-1][j]){
                temp[i][j] *=2;
                temp[i-1][j]=0;
            }
        }
        
        for(int i=N-1; i>=0; i--){
            if(temp[i][j] !=0){//0이 아닌수를 발견하면 
                // 가능한한 최대한 아래쪽으로 옮김 
                for(int k=N-1; k>i; k--){
                    if(temp[k][j]==0){//0이면 
                        //그쪽으로 숫자를 밀어버림 
                        temp[k][j]= temp[i][j];
                        temp[i][j]=0;
                        break;
                    }
                }
            }
        }
        
    }
    
    
    
}

void func(int val){
    if(val==5){
        //최댓값을 업데이트
      for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            Answer= max(Answer,c_board[i][j]) ;
        }
      }
    
    
        return ; 
    }
    
    int back_up[25][25]; 
    
    for(int i=1; i<=4; i++){
        copy(back_up,c_board);
        
        vis[i] =1; 
        
        if(i==1){
            // 왼쪽으로 가는거
            left(c_board);
        }
        else if(i==2){
            //위쪽으로 가는거
            up(c_board);
        }
        else if (i==3){
            //오른쪽으로 가는거 
            right(c_board);
        }
        else {
            // 아래쪽으로 가는거 
            down(c_board);
        }
        
        func(val+1);
        
        vis[i]=0; 
        copy(c_board,back_up);
    }
    
}
int main(){
    cin.tie(0);
    ios::sync_with_stdio(0);

    cin >>N; 
    
    for(int i=0 ; i<N; i++){
        for(int j=0; j<N; j++){
            cin >> board[i][j]; 
            c_board[i][j] = board[i][j];
        }
    }
    
    func(0); 
    
    cout<<Answer;
}