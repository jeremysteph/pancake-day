
/*Jeremiah Stephens
//CompSci 337
//Dr. Jason Rock
//Assignment 8
//April 13, 2015
*/
#ifndef MYSHELL_H
#define MYSHELL_H

#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <string.h>

#include <iostream>

#include "enum.h"

class myShell
{
public:
    //Default constructor
    myShell();
 
    //Runs the myShell program
    void runShell();

protected:

    //Parses input into the first argument and additional arguments
    //Sees if there are any pipes, indirection, or redirection
    //Returns number of arguments if needed
    int parse(char *inputString, char *cmdArgv[], char **sPtr);
    
    //Delimits end of word with a null character
    void nullDelimateArgs(char *srcPtr);

    //Function which executes OS calls
    void execute(char **cmdArgv, char **sPtr);

private:
    modes mode;
    char currentWorkingDirectory[MAX_PATH];
    char *userInput;
    size_t len;
};
#endif