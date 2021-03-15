#ifndef courseClassDriver_H
#define courseClassDriver_H
#include "daysOfWeek.h"
#include "courseClass.h"
#include "dtime.h"
#include "timeInterval.h"
#include <vector>
#include <string>
#include <iostream>
#include <sstream>
using namespace std;
	void add(vector<courseClass>& s, const string* input, size_t size);
	void clear(vector<courseClass>& sch);
	void exportSchedule(const vector<courseClass>& s, string fileName);
	void importSchedule(vector<courseClass>& s, string fileName);
	void remove(vector<courseClass>& s, string courseCode, string sections);
	void validate(const vector<courseClass>& s);
	void parseInput(string* parse, string input, size_t size);
	int wordCount(string input);
#endif