/*Jeremiah Stephens
**CompSci 337
**Dr. Jayson Rock
**Assignment 1
**2/4/2015
*/
#include<stdio.h>
#include<string>
#include<iostream>
using namespace std;
const int size=26;

void printResults(long freq[], char sortedAlphaChar[])
{
for(int i=0; i<size;i++){
if(freq[i] !=0){
cout<<sortedAlphaChar[i]<<" "<<freq[i]<<endl;
}

}
}
void sortResults(long freq[],char alphaChar[])
{
int i,j;
int tempAlphaChar,tempFreq;
for(i=0; i<size-1;i++)
{
for(j=i+1; j<size;j++)
{
if(freq[j]>freq[i])
{
tempAlphaChar = alphaChar[i];
tempFreq = freq[i];
alphaChar[i] = alphaChar[j];
freq[i]= freq[j];
alphaChar[j] = tempAlphaChar;
freq[j]= tempFreq;
}
}
}

printResults(freq,alphaChar);
}
int main()
{
char alphabetChar[size] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N'
				,'O', 'P','Q','R','S','T','U','V','W','X'
				,'Y','Z'};

//Populates freq array with zeros
long freq[size] = {0};
char c;
cout<<"Enter the cypher text (<Enter><Ctrl> -D to end): " ;

while(cin>>c)
{
c = toupper(c);
freq[c-'A']++;

}

sortResults(freq,alphabetChar);
return 0;
}
