/*Jeremiah Stephens
//CompSci 337 
//Dr. Jason Rock
//Assignment 2
//February 12, 2015
*/

#include<stdlib.h>
#include <cctype>
#include <string>
#include <functional>
#include <algorithm>
#include<iostream>
#include<fstream> //class declarations for all file stream objhects
#include<sstream>

using namespace std;

int lineCounter=0;
int numOfWords=0;
bool bad_word(string word, int line, ostream& out);
bool word_search(string word, string dict)
{

string lowerCaseWord = word;
//converts word to lowercase
std::transform(lowerCaseWord.begin(), lowerCaseWord.end(), lowerCaseWord.begin(), ::tolower);

//position index
	int pos;
//string to hold dictionary word
string dictWord;

//proccess dictionary input file
ifstream inputDictionary; // input dictionary

inputDictionary.open(dict.c_str());

//if file cannot be found displah error and termnate program
if (inputDictionary.fail())
{
cout<<"Failed to open dictionary file.";
exit(1);
}

//Loops through dictionary comparing words from input file to words in dictionary
while (inputDictionary >> dictWord){
	if(dictWord.compare(lowerCaseWord) ==0){
		inputDictionary.close();
		return true; 
		}
	}
	bad_word(word, lineCounter, cout <<"");

//stringstream ss(line);
inputDictionary.close();

 
}


bool bad_word(string word, int line, ostream& out)
{

	cout << word << " is spelled wrong, on line: " << line << " " << endl;

}

int main()
{

//string to hold file name
string fileName;

//Prompts user to enter a file 
cout<<"Enter a file to spell check: ";

//Takes user inputed fileName and sotres it into a string
cin>>fileName;

ifstream inputFile; //an input file stream object

inputFile.open(fileName.c_str());

if(inputFile.fail())
{
cout<<"Failed to open file";
exit(1);
}

//prompts for dictionary file
cout<<"Enter a dictionary to use: " ;
cin>>fileName;
cout<<endl;
//decalres a new string object named "word"
string word;

while(inputFile>>word){
	for(string::iterator i = word.begin(); i!=word.end(); i++)
		{
			if(!isalpha(word.at(i-word.begin())))
			{
				word.erase(i);
				i--;
			}
		}
//increments line counter
lineCounter++;
numOfWords++;

word_search(word,fileName);

}

}



