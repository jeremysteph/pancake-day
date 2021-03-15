/*Jeremiah Stephens
//CompSci 337 
//Dr. Jason Rock
//Assignment 3
//February 19, 2015
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

int offset = 0;

//ifstream class (look up get() method to return)

//encrypts letters by user specified offset and stores it in new file
void letterShift(char c, ofstream& outputFile, int offset)
{

	if (c >= 'a'&&c <= 'z' || c >= 'A'&&c <= 'Z') //only code letters
	{
		c += offset;         //add shift , but if > z must "wrap around"
		if (c > 'z' || c > 'Z'&&c < 'a'){   //ascii A=65, Z=90,a=97,z=122
			c -= 26;
		}
	}
	outputFile << c;

}
	int main()
	{

		//string to hold file name
		string fileName;

		//Prompts user to enter a file 
		cout << "Enter name of input file: ";

		//Takes user inputed fileName and sotres it into a string
		cin >> fileName;

		ifstream inputFile; //an input file stream object

		inputFile.open(fileName.c_str());

		if (inputFile.fail())
		{
			cout << "Failed to open file. Program will terminate";
			exit(1);
		}

		//prompts for output filename
		cout << "Enter a name for output file: ";
		cin >> fileName;
		ofstream  outputFile(fileName.c_str());
	
		//decalres a new string object named "line"
		char c;

		//promopts user to enter an offset
		cout << "Enter an offset value (between -25 and 25)";
	
		cin >> offset;

		//Offset must be between -25 or 25 else will keep prompting user
		while (offset > 25 || offset < -25)
		{
			cout << "Error: Offset out of range. Offset value must be between -25 and 25!" << endl;
			cout << "Enter an offset value (between -25 and 25)";
			cin >> offset;
		}

		while (inputFile >> noskipws >> c)
		{
			letterShift(c, outputFile, offset);
		}
		return 0;
	}