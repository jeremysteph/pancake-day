/*Jeremiah Stephens
//CompSci 337 
//Dr. Jason Rock
//Assignment 4
//February 26, 2015
*/

#include<stdlib.h>
#include <cctype>
#include <string>
#include <functional>
#include <algorithm>
#include<iostream>
#include<fstream> //class declarations for all file stream objhects
#include<sstream>
#include <sys/stat.h> 
#include <fcntl.h>
using namespace std;

int offset = 0;
string fpermissions, defaultPermission = "rwx------";
//two functions to edit file permissions
//int stat(const char *path, struct stat *buf);
//int chmod(const char *path, mode_t mode);
//ifstream class (look up get() method to return)

//encrypts letters by user specified offset and stores it in new file
void letterShift(char c, ofstream& outputFile, int offset)
{


	/*function that always ensures offset is positive by
	*converting negative offsets to the equivalent positive shift
	*/
	if (offset < 0){

		offset = 26 - (-offset % 26);
		}


	if (isalpha(c)){
		if (isupper(c))
		{
			c = (((c - 'A') + offset) % 26) + 'A';

		}
		else{
			c = (((c - 'a') + offset) % 26) + 'a';

	}


/*	if (((c >= 'A')&&(c <= 'Z')) || ((c >= 'A')&&(c <= 'Z'))) //only code letters
	{
		
		c = (c - 'A' + offset)&+'A';
		
		if (c < 'A')
		{
			c += 26;
		}
			c += offset;         //add shift 
			if (c > 'z' || c > 'Z'&&c < 'a'){   //ascii A=65, Z=90,a=97,z=122
				c -= 26;
				wrap =c %= 26;
				if (wrap < 0)
				{
					wrap += 26;
				}

			}*/
		}
		
		outputFile << c;
		//chmod(outputFile, fpermissions);
		outputFile.close();
	}

	int main()
	{

		//string to hold file name
		string fileName;

		//Prompts user to enter a file 
		cout << "Enter name of input file: ";

		//Takes user inputed fileName and stores it into a string
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
		ofstream  outputFile;
	
		//decalres a new char object named "c"
		char c;

		//prompts user to enter an offset
		cout << "Enter an offset value (between -25 and 25)";
	
		cin >> offset;

		//Offset must be between -25 or 25 else will keep prompting user
		while (offset > 25 || offset < -25)
		{
			cout << "Error: Offset out of range. Offset value must be between -25 and 25!" << endl;
			cout << "Enter an offset value (between -25 and 25)";
			cin >> offset;
		}


		//promopts user to enter an permissions for file
		cout << "Set the permissions for the file (must be in format rwxrwxrwx)";
		cin >>fpermissions;

		fpermissions = '-' + fpermissions;

		cout << fpermissions<<endl;
		outputFile.open((fileName.c_str()), O_WRONLY | O_CREAT);

		while (inputFile >> noskipws >> c)
		{
			letterShift(c, outputFile, offset);
		}
		return 0;

	}


	
