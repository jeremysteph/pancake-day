#ifndef COURSE_H
#define COURSE_H

#include "daysOfWeek.h"
#include "timeInterval.h"
#include <iostream>
#include <string>
using namespace std;

	class Course
{
	public:
		/**
		Sets all private data members to 0 or null;
		**/
		Course();
		/**
		Sets a Course with no meeting = 00:00 and no day of week
		**/
		Course(string Course, string sec, string inst);		
		/**
		**/
		Course(string course, string sec, const DaysOfWeek& dow, const TimeInterval& time, string inst);
		/** Getters **/		
		string getCourse() const;
		string getSection() const;
		string getInst() const;
		DaysOfWeek getDaysOfWeek() const;
		TimeInterval getMeet() const;		
		/** Setters **/
		void setCourse(string c);
		void setSection(string s);
		void setInst(string i);
		void setDaysOfWeek(const DaysOfWeek& dow);
		void setTime(const TimeInterval& t);		
		/**
		If the this course has the same instructor and overlapping times as Course other, the isOverlap member  		function returns true. Times a and b overlap if the start of a is less than or equal to the end time of b 			and the end time of a is greater than or equal to the start time of b. Otherwise, it returns false.
		**/
		bool isOverlap(const Course& other) const;
		/**
		If this course has the same course code and section and Course other return true, else return false
		**/
		bool isMatch(const Course& other) const;
		/**
		Output Course in SFF format to given output stream
		**/
		void output(ostream& o) const;
	private:
		string courseCode;
		string section;
		DaysOfWeek dayOfWeek;
		TimeInterval meetTime;
		string instructor;
};

	bool operator==(const Course& a, const Course& b);
	bool operator&&(const DigitalTime& a, const DigitalTime& b);
#endif