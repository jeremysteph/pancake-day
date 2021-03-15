#include "timeInterval.h"
#include <iostream>

        //Initializes the interval to [0:00, 0:00].
	TimeInterval::TimeInterval( ){
		startTime.set(0,0);
		endTime.set(0,0);
	}

        //Initializes the interval to [a, b], if a <= b. Otherwise intialize to [0:00, 0:00]
	TimeInterval::TimeInterval(const DigitalTime& a, const DigitalTime& b){
			startTime.set(a.getHour(), a.getMinute());
			endTime.set(b.getHour(), b.getMinute());
	
	}

	//Initializes the interval to [a, b], if a <= b. Otherwise leave host unchanged
       	void TimeInterval::setInterval(const DigitalTime& a, const DigitalTime& b){
		if(a <= b){
			startTime.set(a.getHour(), a.getMinute());
			endTime.set(b.getHour(), b.getMinute());
		}
	}

        DigitalTime TimeInterval::getStart() const{ return startTime; }
        DigitalTime TimeInterval::getEnd() const { return endTime; }

        //Outputs the interval in the form a - b. For example, 9:30 - 10:45
        //Precondition: If outs is a file output stream, then outs has already been
        //connected to a file.
        void TimeInterval::output(ostream& outs) const{

		outs << startTime << " - " << endTime;
	}

	//Returns true if a and b overlap, false otherwise
	bool operator&&(const TimeInterval& a, const TimeInterval& b){
		return a.getStart() <= b.getEnd() && a.getStart() >= b.getEnd();
	}

        ostream& operator<<(ostream& outs, const TimeInterval& d){
		d.output(outs);
		return outs;
	}              