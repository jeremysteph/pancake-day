#ifndef HAND_H
#define HAND_H


public:
	int size() const; // returns the number of cards in the deck
		hand(); // Initializes an empty hand
		bool add(const card& c); // if the hand is not (full 5 cards) return true and add c to the hand otherwise false
		bool isLess(hand& h) const;
