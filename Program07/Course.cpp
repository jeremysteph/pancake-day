/*Jeremiah Stephens
//CompSci 337
//Dr. Jason Rock
//Assignment 7
//April 9, 2015
*/

#include "Course.h"
using namespace std;

/**
Sets all private data members to 0 or null;
**/
Course::Course(){
	courseCode = "";
	section = "";
	instructor = "";
}
/**
Sets a course with no meeting = 00:00 and no day of week
**/
Course::Course(string course, string sec, string inst){
	courseCode = course;
	section = sec;
	instructor = inst;
	
}
/**
**/
Course::Course(string course, string sec, const DaysOfWeek& dow, const TimeInterval& time, string inst){
	courseCode = course;
	section = sec;
	instructor = inst;
	dayOfWeek = dow;
	meetTime = time;
	//output(cout);
}
/** Getters **/
string Course::getCourse() const{ return courseCode; }
string Course::getSection() const{ return section; }
string Course::getInst() const{ return instructor; }
DaysOfWeek Course::getDaysOfWeek() const{ return dayOfWeek; }
TimeInterval Course::getMeet() const{ return meetTime; }
/** Setters **/
void Course::setCourse(string c){ courseCode = c; }
void Course::setSection(string s){ section = s; }
void Course::setInst(string i){ instructor = i; }
void Course::setDaysOfWeek(const DaysOfWeek& dow){ dayOfWeek = dow; }
void Course::setTime(const TimeInterval& t){ meetTime = t; }
/**
If the this course has the same instructor and overlapping times as Course other, the isOverlap member  		function returns true. Times a and b overlap if the start of a is less than or equal to the end time of b 			and the end time of a is greater than or equal to the start time of b. Otherwise, it returns false.
**/
bool Course::isOverlap(const Course& other) const{
	return other.getInst() == instructor && (other.getMeet() && meetTime);
}
/**
If this course has the same course code and section as Course other return true, else return false
**/
bool Course::isMatch(const Course& other) const{
	return courseCode == other.getCourse() && section == other.getSection();
}
/**TODO
Output Course in SFF format to given output stream
**/
void Course::output(ostream& o) const{
	dayOfWeek.output(o);
	o << " " << meetTime.getStart() << " " << meetTime.getEnd() << " "
		<< courseCode << " " << section << " " << instructor << endl;
}
bool operator==(const Course& a, const Course& b){ return a.isMatch(b); }
bool operator&&(const Course& a, const Course& b){ return a.isOverlap(b); }
