CC = g++
CFLAGS = -Wall 



classScheduler: courseClassDriver.o Course.o timeInterval.o dtime.o daysOfWeek.o
	$(CC) $(CFLAGS) courseClassDriver.o Course.o timeInterval.o dtime.o daysOfWeek.o -o classScheduler
courseClassDriver.o : courseClassDriver.cpp courseClassDriver.h timeInterval.h dtime.h daysOfWeek.h
	$(CC) $(CFLAGS) -c courseClassDriver.cpp 
Course.o : Course.cpp Course.h timeInterval.h dtime.h daysOfWeek.h
	$(CC) $(CFLAGS) -c Course.cpp
timeInterval.o : timeInterval.cpp Course.h timeInterval.h dtime.h daysOfWeek.h
	$(CC) $(CFLAGS) -c timeInterval.cpp
dtime.o : dtime.cpp
	$(CC) $(CFLAGS) -c dtime.cpp Course.h timeInterval.h dtime.h daysOfWeek.h
daysOfWeek.o : daysOfWeek.cpp Course.h timeInterval.h dtime.h daysOfWeek.h
	$(CC) $(CFLAGS) -c daysOfWeek.cpp