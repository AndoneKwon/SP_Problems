//
//  main.cpp
//  bestAlbum
//
//  Created by 권진우 on 2020/04/07.
//  Copyright © 2020 권진우. All rights reserved.
//

#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <array>
#include <functional>

using namespace std;

bool desc(pair<int, int> a, pair<int, int> b){
    if(a.first==b.first&&a.second>b.second) return a>b;
    else return a<b;
}

void pairsort(vector<int>& a, vector<string>& b, int n)
{
    pair<int, string> pairt[n];
  
    // Storing the respective array
    // elements in pairs.
    for (int i = 0; i < n; i++)
    {
        pairt[i].first = a[i];
        pairt[i].second = b[i];
    }
  
    // Sorting the pair array.
    sort(pairt, pairt + n);
      
    // Modifying original arrays
    for (int i = 0; i < n; i++)
    {
        a[i] = pairt[i].first;
        b[i] = pairt[i].second;
    }
}
/* 오버로딩 */
void pairsort2(vector<int>& a, vector<int>& b, int n)
{
    pair<int, int> pairt[n];
    // Storing the respective array
    // elements in pairs.
    for (int i = 0; i < n; i++)
    {
        pairt[i].first = a[i];
        pairt[i].second = b[i];
    }
  
    // Sorting the pair array.
    sort(pairt, pairt + n,desc);
      
    // Modifying original arrays
    for (int i = 0; i < n; i++)
    {
        a[i] = pairt[i].first;
        b[i] = pairt[i].second;
        cout<<a[i]<<" "<<b[i]<<endl;
    }
}


vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<string> beforeGenres(genres);
    vector<string> searchedGenres;
    vector<int> searchedPlays;
    vector<int> sortedGenresNum;
    vector<int> sortedPlayNum;
    vector<int> answer;
    pair<int, char> temp;
    int a;
    for(int i=0;i<genres.size();i++){
        a = count(searchedGenres.begin(),searchedGenres.end(),genres[i]);
        if(a!=0){
            for(int j=0;j<searchedGenres.size();j++){
                if(searchedGenres[j]==genres[i]){
                    searchedPlays[j]+=plays[i];
                }
            }
            continue;
        }else{
            searchedGenres.push_back(genres[i]);
            searchedPlays.push_back(plays[i]);
        }
    }
    pairsort(searchedPlays, searchedGenres, searchedPlays.size());
    for(int i=searchedGenres.size();i>0;i--){
        for(int j=0;j<genres.size();j++){
            if(searchedGenres[i-1]==genres[j]){
                sortedGenresNum.push_back(j);
                sortedPlayNum.push_back(plays[j]);
            }
        }
        cout<<"complete"<<endl;
        pairsort2(sortedPlayNum, sortedGenresNum, sortedPlayNum.size());
        for(int i=0;i<sortedPlayNum.size();i++){
            cout<<"new"<<" : "<<sortedGenresNum[i]<<" "<<sortedPlayNum[i]<<endl;
        }
        for(int k=0;k<2;k++){
            if(sortedPlayNum.size()==1){
                answer.push_back(sortedGenresNum[0]);
                sortedGenresNum.pop_back();
                sortedPlayNum.pop_back();
                break;
            }else{
                int a = sortedGenresNum.back();
                answer.push_back(a);
                sortedGenresNum.pop_back();
                sortedPlayNum.pop_back();
            }
        }
        int tempNum =sortedPlayNum.size();
        for(int i=0;i<tempNum;i++){
            cout<<"check"<<sortedPlayNum.size()<<endl;
            sortedGenresNum.pop_back();
            sortedPlayNum.pop_back();
        }
        cout<<"is cleared? : "<<sortedGenresNum.size()<<endl;
    }
    cout<<"final"<<" : ";
    for(int i=0;i<answer.size();i++){
        cout<<answer[i]<<" ";
    }
    return answer;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    array<string,5> array= {"classic", "classic", "classic", "classic", "pop"};
    vector<string> a;
    vector<int> b = {100, 100, 100, 100, 2500};
    for (int i = 0; i < array.size(); i++) {
        a.push_back(array[i]);
    }
    solution(a, b);
    return 0;
}
