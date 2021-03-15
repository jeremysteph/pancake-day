#include "courseClassDriver.h"
#include <fstream>
int main(){
	vector<Course> schedule;
	char cinput[512];
	string input;
	cout << "Class Scheduler";
	do{
		cout << ': ';
		cin.getline(cinput, 512);
		input = cinput;
		size_t size = wordCount(input);
		if (size != 0){
			string parsed[size];
			parseInput(parsed, input, size);
			string cmd = parsed[0];

			if (cmd == "add") add(schedule, parsed, size);
			else if (cmd == "clear") clear(schedule);

			else if (cmd == "export"){
				if (size == 2)exportSchedule(schedule, parsed[1]);
			}
			else if (cmd == "import"){
				if (size == 2) importSchedule(schedule, parsed[1]);
			}
			else if (cmd == "remove"){
				if (size == 3)remove(schedule, parsed[1], parsed[2]);
			}
			else if (cmd == "validate") validate(schedule);
			else if (cmd == "quit"){}
			else cout << "invalid command" << endl;
		}
	} while (input != "quit");
	return 0;
}
void help(){
	cout << "add <days> <start time> <end time> <course code> <section> <instructor>\n" << endl;
	cout << "clear\n	Delete all courses from the current schedule\n" << endl;
	cout << "export <file name>\n	Save the contents of schedule to text file\n" << endl;
	cout << "import <file name>\n	Read the contents of a schedule text file\n" << endl;
	cout << "remove <course code> <section>\n" << endl;
	cout << "validate\n	Check the current schedule to determine whether any instructor is teaching  courses at the same time\n" << endl;
	cout << "quit" << endl;
}
void add(vector<Course>& s, const string* parsed, size_t size){
	DaysOfWeek dow(parsed[1]);
	DigitalTime start;
	istringstream st, en;
	st.str(parsed[2]);
	start.input(st);
	DigitalTime end;
	en.str(parsed[3]);
	end.input(en);
	TimeInterval time(start, end);
	s.push_back(Course(parsed[4], parsed[5], dow, time, parsed[6]));

}
void clear(vector<Course>& sch){
	sch.clear();
}
void exportSchedule(const vector<Course>& s, string fileName){
	ofstream outputs;
	outputs.open(fileName.c_str());
	vector<Course>::size_type sz = s.size();
	for (unsigned int i = 0; i < sz; ++i){
		s[i].output(outputs);
	}
	outputs.close();


}
void importSchedule(vector<Course>& s, string fileName){
	ifstream input;
	string line;
	input.open(fileName.c_str());
	while (getline(input, line)){
		size_t size = wordCount(line);
		string parsed[size];
		parseInput(parsed, line, size);
		add(s, parsed, size);
	}
	input.close();
}
void remove(vector<Course>& s, string courseCode, string sections){
	vector<Course>::size_type sz = s.size();
	for (unsigned int i = 0; i < sz; ++i){
		if (s[i].getCourse() == courseCode && s[i].getSection() == sections)s.erase(s.begin() + (i));
	}
}
void validate(const vector<Course>& s){
	vector<Course>::size_type sz = s.size();
	for (unsigned int i = 0; i < sz; ++i){
		Course c = s[i];
		for (unsigned int j = i + 1; j < sz; ++j){
			if (s[j] == c) {
				cout << "ERROR!\n";
				c.output(cout);
				cout << "overlaps with\n";
				s[j].output(cout);
				cout << endl;
			}
		}
	}
}
void parseInput(string* parse, string input, size_t size){
	string str = input;
	char *pch, *cstr;
	cstr = new char[input.size() + 1];
	strcpy(cstr, input.c_str());

	int index = 0;
	pch = strtok(cstr, " <>");
	while (pch != NULL)
	{
		parse[index] = pch;
		++index;
		pch = strtok(NULL, " <>");
	}
}
int wordCount(string input){
	int words = 1;
	for (unsigned int i = 0; i < input.size(); ++i){
		if (input[i] == ' ') ++words;
	}
	return words;
}