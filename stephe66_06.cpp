/*Jeremiah Stephens
//CompSci 337 
//Dr. Jason Rock
//Assignment 6
//March 12, 2015
*/

#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <signal.h>

#define CHILD (pid_t) 0

int main(int argc, char *argv[])
{
	pid_t child;
	int fdes[2];
	//static char message[BUFSIZ];
	//retval = init_command(&command_a);
	char *stoken1, *stoken2; //char array to store stdin as tokens
	char delimiter[] = " ";//char array of spaces
	//  fg = fgets(ar, BUF, stdin); //get input from stdin and store in array
	// fg[strlen(ar)-1]='\0';

	stoken1 = strtok(argv[1], delimiter);//store argv1 in stoken1
	int j = 0, z = 0, c = 0;
	char *newar[20], *newar1[20];
	while (stoken1 != NULL)
	{
		newar[c] = strdup(stoken1);
		j = ++c;
		stoken1 = strtok(NULL, delimiter);
	}
	newar[j] = NULL;

	c = 0;
	stoken2 = strtok(argv[2], delimiter);//store argv1 in stoken2
	while (stoken2 != NULL)
	{
		newar1[c] = strdup(stoken2);
		c = ++z;
		stoken2 = strtok(NULL, delimiter);
	}
	newar1[z] = NULL;

	if (pipe(fdes) == -1)
	{
		perror("Pipe");
		exit(-1);
	}

	printf("parent process id is: %d\n", getpid());
	if ((child = fork()) == CHILD)
	{
		printf("in child, my process id is %d\n", getpid());
		/* close stdout, and send it to fdes[1] (our "write" pipe) */
		//close(fileno(stdout));
		//dup(fdes[1]);
		dup2(fdes[1], fileno(stdout));//fileno returns the fd for stdout, in this case 1.
		/* now we can close the child's descriptors, as we don't need them */
		/* exec will inherit the dup'd stdout */
		close(fdes[0]);
		close(fdes[1]);
		execvp(newar[0], newar);
		//	execlp("ls","ls", "/usr/bin", NULL);//chile is running ls /usr/bin
		exit(5);
	}
	else
	{
		printf("still in parent, my process id is still %d\n", getpid());
		printf("and my child is %d\n", child);
		/* close stdin, and send it to fdes[0] (our "read" pipe) */
		dup2(fdes[0], fileno(stdin));//parent gets the read of the pipe. dup closes 
		/* now we can close the parent's descriptors, as we don't need them */
		/* exec will inherit the dup'd stdin */
		close(fdes[0]);
		close(fdes[1]);
		execvp(newar1[0], newar1);
		//execlp("sort","sort",NULL);//parent is running sort; there is a pipe between the two
		exit(6);
	}
}