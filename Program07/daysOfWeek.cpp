/*Jeremiah Stephens
//CompSci 337
//Dr. Jason Rock
//Assignment 7
//April 9, 2015
*/

#include "daysOfWeek.h"
const char* DaysOfWeek::dayChar = "MTWRFS";
DaysOfWeek::DaysOfWeek(){
	for (int i = 0; i < daySize; ++i) days[i] = false;
}
DaysOfWeek::DaysOfWeek(string d){
	for (int z = 0; z < daySize; ++z) days[z] = false;
	char* cd;
	cd = new char[daySize];
	strcpy(cd, d.c_str());
	for (int i = 0; i < daySize; ++i){
		char letter = cd[i];
		if (letter != 0){
			for (int j = 0; j < daySize; ++j){
				if (letter == dayChar[j]) days[j] = true;
			}

		}
	}
}
void DaysOfWeek::setDays(string d){
	for (int z = 0; z < daySize; ++z) days[z] = false;
	char* cd;
	cd = new char[daySize];
	strcpy(cd, d.c_str());
	for (int i = 0; i < daySize; ++i){
		char letter = cd[i];
		if (letter != 0){
			for (int j = 0; j < daySize; ++j){
				if (letter == dayChar[j]) days[j] = true;
			}

		}
	}
}
string DaysOfWeek::getDays() const{
	string day = "";
	for (int i = 0; i < daySize; ++i){
		if (days[i]){
			day += dayChar[i];
		}
	}
	return day;
}
const bool* DaysOfWeek::getDaysBool() const{ return days; }
bool DaysOfWeek::isEqual(const DaysOfWeek& d) const{ return d.getDays() == this->getDays(); }
bool DaysOfWeek::isOverlap(const DaysOfWeek& d) const{
	bool overlap = false;
	const bool* db = d.getDaysBool();
	for (int i = 0; i < daySize; ++i){
		if (db[i] == days[i]) overlap = true;
	}
	return overlap;
}
//TODO
void DaysOfWeek::output(ostream& outs) const{
	outs << getDays();
}
void DaysOfWeek::input(istream& input) const{}

bool operator==(const DaysOfWeek& a, const DaysOfWeek& b){ return a.isEqual(b); }
bool operator!=(const DaysOfWeek& a, const DaysOfWeek& b){ return !a.isEqual(b); }
bool operator&&(const DaysOfWeek& a, const DaysOfWeek& b){ return a.isOverlap(b); }

