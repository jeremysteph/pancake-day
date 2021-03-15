#ifndef DAYSOFWEEK_H
#define DAYSOFWEEK_H

#include <iostream>
#include <string> 
#include <string.h>

using namespace std;

	class DaysOfWeek
{
	public:
		DaysOfWeek();
		DaysOfWeek(string d);
		void setDays(string d);
		string getDays() const;
		const bool* getDaysBool() const;
		bool isEqual(const DaysOfWeek& d) const;
		bool isOverlap(const DaysOfWeek& d) const;
		void output(ostream& outs) const;
		void input(istream& input) const;
	private:
		bool days[6];
		static const int daySize = 6;
		static const char* dayChar;
};
	bool operator==(const DaysOfWeek& a, const DaysOfWeek& b);
	bool operator!=(const DaysOfWeek& a, const DaysOfWeek& b);
	bool operator&&(const DaysOfWeek& a, const DaysOfWeek& b);
#endif