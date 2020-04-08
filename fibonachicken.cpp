//
//  main.cpp
//  pibonachicken
//
//  Created by 권진우 on 2020/04/04.
//  Copyright © 2020 권진우. All rights reserved.
//

#include <iostream>

using namespace std;

int fibonachi(int arr[],int a);

int chicken(int a){
    int i=0;
    int arr[100000];
    fibonachi(arr,a);
    int temp,k;
    int stack[100000]={0};
    int total=0;
    while (i<a+2){
        //cout<<arr[i]<<endl;
        if(a==0){
            return 0;
        }else if(a==1){
            return 1;
        }else if(a==2){
            return 1;
        }else if(a==arr[i]){
            return arr[i-1];
        }else if(a>arr[i]){
            i++;
        }
        else{
            temp = arr[i-1];
            int j=i-1;
            k=0;
            stack[0]=temp;
            k++;
            while(1){
                temp+=arr[j-1];
                if(temp>a){
                    temp-=arr[j-1];
                }else if(temp<a){
                    stack[k]=arr[j-1];
                    k++;
                }else if(temp==a){
                    stack[k]=arr[j-1];
                    int l=0;
                    while(stack[l]!=0){
                        total+=chicken(stack[l]);
                        l++;
                    }
                    return total;
                }
                j--;
            }
        }
    }
    return 0;
}

int fibonachi(int arr[],int a){
    arr[0]=0;
    arr[1]=1;
    arr[2]=1;
    if(a==0){
        return 0;
    }else if(a==1){
        return 0;
    }
    else if(a==2){
        return 0;
    }else{
        for(int i=2;i<=a;i++){
            arr[i]=arr[i-2]+arr[i-1];
            //cout<<arr[i]<<endl;
        }
        return 0;
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    cout<<"result:"<<chicken(500);
    return 0;
}
