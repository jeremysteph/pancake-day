
/*Jeremiah Stephens
//CompSci 337
//Dr. Jason Rock
//Assignment 8
//April 13, 2015
*/
#ifndef CARD_H
#define CARD_H

#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <string.h>

#include <iostream>

#include "enum.h"

class Card
{
public:
    //Default constructor that initializes to the ace of Spades
	card();
    //Runs the runCard program
    void runCard();

	card(char *suitCode, int *denom)
		char getSuit() const;
	int	 getDenom() const;

private:
	void set(char suit, int denom);
	void output(ostream& o) const;
};
#endif