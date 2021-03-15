#ifndef DECK_H
#define DECK_H

#include <vector>
#include<iostream>
#include<fstream>
#include "Card.h"

public:
	deck(); // initializes to a standard 52 card deck
	void reset(); // resets a standard 52 card deck
	void shuffle(int swaps); // the cards in the host objects are shuffled
	Card deal(); // returns the top card from the cards container
	void output(std::ostream& o) const;
