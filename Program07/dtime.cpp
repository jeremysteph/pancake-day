#include "dtime.h"


//Returns true if time1 and host represent the same time;
//otherwise, returns false.
bool DigitalTime::isEqual(const DigitalTime& time1) const{
	return time1.hour == hour && time1.minute == minute;
}


//Returns true if host is strictly less than time1;
//otherwise, returns false.
bool DigitalTime::isLess(const DigitalTime& time1) const{
	return time1.hour < hour && time1.minute < minute;
}

	//Precondition: 0 <= the_hour <= 23 and 0 <= the_minute <= 59.
	//Initializes the time value to the_hour and the_minute.
		DigitalTime::DigitalTime(int the_hour, int the_minute) : hour(the_hour), minute(the_minute)
	{

	}

	//Initializes the time value to 0:00 (which is midnight).
	DigitalTime::DigitalTime(): hour(0), minute(0)
	{

	}

	//Reads a white-space delimited token from ins. If the token is of the form
	//hh:mm where hh is an integer from 0 to 23 (inclusive) and mm is an integer
	//from 0 to 59 (inclusive), host is set to these values and the function returns true.
	//Otherwise host is left unchanged and the function returns false.
	//Precondition: If ins is a file input stream, then ins has already been 
	//connected to a file. 
	bool DigitalTime::input(istream& ins)
	{
		string hh = "";
		string mm = "";
		char dtime[6];
		ins.getline(dtime, 6);
		hh += dtime[0];
		hh += dtime[1];
		mm += dtime[3];
		mm += dtime[4];
		const int h = atoi(hh.c_str());
		const int m = atoi(mm.c_str());
		if (h >= 0 && h <= 23 && m >= 0 && m <= 59){
			set(h, m);
			return true;
		}
		return false;
	}

	//Outputs digital time in the form hour:minute
	//Precondition: If outs is a file output stream, then outs has already been 
	//connected to a file.
	void DigitalTime::output(ostream& outs) const
	{
		outs << hour << ':' << minute;

	}


	int DigitalTime::getHour() const
	{
		return hour;

	}

	int DigitalTime::getMinute() const
	{

		return minute;
	}
	void DigitalTime::set(int h, int m)
	{
		hour = h;
		minute = m;
	}
	//If <hour>:<minute> is valid, the digitalTime is set to that value. If either hour
	//or minute is not valid, the host object is unchanged.



	bool operator<(const DigitalTime& a, const DigitalTime& b){ return a.isLess(b); }
	bool operator>(const DigitalTime& a, const DigitalTime& b){ return !a.isLess(b); }
	bool operator<=(const DigitalTime& a, const DigitalTime& b){
		if (!a.isLess(b) && !a.isEqual(b)) return false;
		return true;
	}
	bool operator>=(const DigitalTime& a, const DigitalTime& b){
		if (a.isLess(b) || !a.isEqual(b)) return false;
		return true;
	}
	bool operator==(const DigitalTime& a, const DigitalTime& b){ return a.isEqual(b); }
	bool operator!=(const DigitalTime& a, const DigitalTime& b){ return !a.isEqual(b); }

	//Use the input member function to implement stream extraction for DigitalTime
	istream& operator>>(istream& ins, DigitalTime& d){
		d.input(ins);
		return ins;
	}

	//Use the output member function to implement stream insertion for DigitalTime
	ostream& operator<<(ostream& outs, const DigitalTime& d){
		d.output(outs);
		return outs;
	}