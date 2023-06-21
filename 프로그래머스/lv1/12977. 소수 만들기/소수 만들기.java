class Solution {
    public int solution(int[] nums) {
         int answer = -1;

        int num = 2;

        int[] arr = new int[3005];

//        for(int j=2; j*j<= 3000 ; j++){
//            if(arr[i]%j ==0 ){
//                check = true;
//                break;
//            }
//        }

        boolean check = false;
        
        int cnt=0; 

        for(int i = 0 ; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    
                    int sum = nums[i] + nums[j] + nums[k];

                    for(int l=2; l*l<= sum ; l++){
                        if(sum%l ==0 ){//
                            check = true;
                            
                        }
                    }
                    
                    if(!check){
                        cnt++;
                        
                    }
                    check=false;
                }
            }
        }


        answer = cnt;
        return answer;
    }
}