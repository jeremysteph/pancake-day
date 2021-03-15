myShellDriver: myShellDriver.o myShell.o
	g++ myShellDriver.o myShell.o -o myShellDriver
myShellDriver.o: myShellDriver.cpp myShell.h
	g++ -c myShellDriver.cpp
	
myShell.o: myShell.cpp myShell.h enum.h
	g++ -c myShell.cpp
clean:
	rm -rf *o myShell
