/*Jeremiah Stephens
//CompSci 337 
//Dr. Jason Rock
//Assignment 5
//March 4, 2015
*/
#include <fcntl.h>
#include <assert.h>
#include <dirent.h>
#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <string.h>
#include <sys/stat.h>
#include <sys/types.h>
#include<pwd.h>
#include <unistd.h>
using namespace std;

//Returns value from "PathFileExists".
int retval;



int count_directory_links(const char* path, int numOfLinks);

struct stat sb;



int main(int argc, char *argv[])
{

	
	char *dir_path;
	DIR* dir;
	struct dirent*entry;
	char entry_path[PATH_MAX + 1];
	size_t path_len;
	mode_t owner, group, other;

	if (argc >= 2){
		struct stat dirStat;
		dir_path = argv[1];
		string s = dir_path;
		strncpy(entry_path, dir_path, sizeof(entry_path));
		path_len = strlen(dir_path);

		if (access(dir_path, F_OK) != -1)
		{
			//if directory exists
			if ((dir = opendir(dir_path)) != NULL)
			{
								
				/* If the directory path doesn’t end with a slash, append a slash. */
				if (entry_path[path_len - 1] != '/ ') {
					entry_path[path_len] = '/';
					entry_path[path_len + 1] = '\0';
					++path_len;
				}

				/* Start the listing operation of the directory specified on the
				command line. */
				dir = opendir(dir_path);
				int numOfLinks = 0;
				char str[11], *s = str;

				*s++ = owner & S_IRUSR ? 'r' : '-';
				*s++ = owner & S_IWUSR ? 'w' : '-';
				*s++ = owner & S_IXUSR ? 'x' : '-';

				*s++ = group & S_IRGRP ? 'r' : '-';
				*s++ = group & S_IWGRP ? 'w' : '-';
				*s++ = group & S_IXGRP ? 'x' : '-';

				*s++ = other & S_IROTH ? 'r' : '-';
				*s++ = other & S_IWOTH ? 'w' : '-';
				*s++ = other & S_IXOTH ? 'x' : '-';

				printf((S_ISDIR(dirStat.st_mode)) ? "d" : "-");
				printf((dirStat.st_mode & S_IRUSR) ? "r" : "-");
				printf((dirStat.st_mode & S_IWUSR) ? "w" : "-");
				printf((dirStat.st_mode & S_IXUSR) ? "x" : "-");
				printf((dirStat.st_mode & S_IRGRP) ? "r" : "-");
				printf((dirStat.st_mode & S_IWGRP) ? "w" : "-");
				printf((dirStat.st_mode & S_IXGRP) ? "x" : "-");
				printf((dirStat.st_mode & S_IROTH) ? "r" : "-");
				printf((dirStat.st_mode & S_IWOTH) ? "w" : "-");
				printf((dirStat.st_mode & S_IXOTH) ? "x" : "-");
				
				/* Loop over all directory entries. */
				while ((entry = readdir(dir)) != NULL) {
					/* Build the path to the directory entry by appending the entry
					name to the path name. */
					strncpy(entry_path + path_len, entry->d_name,
						sizeof (entry_path)-path_len);
					/* Determine the type of the entry. */
					numOfLinks = count_directory_links(entry_path, numOfLinks);

					/* Print the type and path of the entry. */


				}
				string rawname = argv[1];
				
				printf("\n%-5s%-5 %-5s %d\n", rawname,"", (dirStat.st_nlink));

			}
//if path leads to file
			else
			{
				char str[11], *s = str;

				struct stat fileStat;
				char* buffer;
				/* Get information about the file. */
				stat(entry_path, &fileStat);

				if (S_ISREG(fileStat.st_mode))
					*s++ = '-';
				else if (S_ISDIR(fileStat.st_mode))
					*s++ = 'd';
				else if (S_ISCHR(fileStat.st_mode))
					*s++ = 'c';
				else if (S_ISBLK(fileStat.st_mode))
					*s++ = 'b';
				else if (S_ISFIFO(fileStat.st_mode))
					*s++ = 'f';
				else if (S_ISLNK(fileStat.st_mode))
					*s++ = 'l';
				else
					*s++ = 's';

				owner = fileStat.st_mode & S_IRWXU;
				group = fileStat.st_mode & S_IRWXG;
				other = fileStat.st_mode & S_IRWXO;

				*s++ = owner & S_IRUSR ? 'r' : '-';
				*s++ = owner & S_IWUSR ? 'w' : '-';
				*s++ = owner & S_IXUSR ? 'x' : '-';

				*s++ = group & S_IRGRP ? 'r' : '-';
				*s++ = group & S_IWGRP ? 'w' : '-';
				*s++ = group & S_IXGRP ? 'x' : '-';

				*s++ = other & S_IROTH ? 'r' : '-';
				*s++ = other & S_IWOTH ? 'w' : '-';
				*s++ = other & S_IXOTH ? 'x' : '-';

				printf("File Size: \t\t%d bytes\n", fileStat.st_size);

				printf(entry_path);
				printf((S_ISDIR(fileStat.st_mode)) ? "d" : "-");
				printf((fileStat.st_mode & S_IRUSR) ? "r" : "-");
				printf((fileStat.st_mode & S_IWUSR) ? "w" : "-");
				printf((fileStat.st_mode & S_IXUSR) ? "x" : "-");
				printf((fileStat.st_mode & S_IRGRP) ? "r" : "-");
				printf((fileStat.st_mode & S_IWGRP) ? "w" : "-");
				printf((fileStat.st_mode & S_IXGRP) ? "x" : "-");
				printf((fileStat.st_mode & S_IROTH) ? "r" : "-");
				printf((fileStat.st_mode & S_IWOTH) ? "w" : "-");
				printf((fileStat.st_mode & S_IXOTH) ? "x" : "-");
				printf("\n\n");

				*s = '\0';

				/* Make sure the file is an ordinary file. */
				if (!S_ISREG(fileStat.st_mode)) {
					/* It’s not, so give up. */
					return NULL;
				}
			
				return 0; // path exists, but not directory

			}
		}
		else{

			printf("\n%s  %s",entry_path, " not found \n");
			return -1; //c does not exist at all
		}
	}
	else{

		//Print error and terminate program
		printf("\nDirectory path missing! Program will now terminate! \n\n");
	}//	return 0;
	

}
	/* Return a string that describes the type of the file system entry PATH. */
	int count_directory_links(const char* path, int numOfLinks)
	{
			struct stat st;
		lstat(path, &st);
		if ((S_ISLNK(st.st_mode))||(S_ISDIR(st.st_mode)) || (S_ISREG(st.st_mode)))
		{
			numOfLinks++;
		}
		/* Unexpected. Each entry should be one of the types above. */
			return numOfLinks;
			
	}


	
