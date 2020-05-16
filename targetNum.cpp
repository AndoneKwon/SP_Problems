//
//  main.cpp
//  targetNum
//
//  Created by 권진우 on 2020/05/16.
//  Copyright © 2020 권진우. All rights reserved.
//

#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <typeinfo>

using namespace std;

int answer = 0;

void dfs(vector<int> numbers,int sum,int count,int targetNum){
    if(numbers.size()<=count&&(count!=-1)){
        //cout<<sum<<endl;
        if(targetNum==sum){
            answer++;
            return;
        }
        return;
    }
    cout<<count<<endl;
    dfs(numbers,sum+numbers[count],count+1,targetNum);
    dfs(numbers,sum-numbers[count],count+1,targetNum);
}

int solution(vector<int> numbers, int target) {
    dfs(numbers,0,0,target);
    return answer;
}

int main(){
    int a;
    vector<int> number = {1,1,1,1,1};
    a=solution(number,3);
    cout<<a<<endl;
}
