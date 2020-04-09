#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
int solution(string s)
{
    string temp1, temp2;
	int answer = 0;
	bool result;
	for (int i = 1; i <= s.length(); i++) {
		for (int j = 0; j < s.length() - i + 1; j++) {
			if (i % 2 == 0) {
				temp1 = s.substr(j, i/2);
				temp2 = s.substr(j+i/2, i/2);
				reverse(temp2.begin(), temp2.end());
				result=temp1.compare(temp2);
				if (result == 0 && answer<i) {
					answer = i;
					j = i/2;
					break;
				}
			}
			else {
				temp1 = s.substr(j, i/2);
				temp2 = s.substr(j + i/2 + 1, i/2);
				reverse(temp2.begin(), temp2.end());
				result = temp1.compare(temp2);
				if (result == 0 && answer < i) {
					answer = i;
					j = i / 2;
					break;
				}
			}
		}
	}
    return answer;
}
