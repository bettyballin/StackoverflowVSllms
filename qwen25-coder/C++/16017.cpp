#include <iostream>\n#include <string>\n#include <fstream>\n#include <sys/time.h>\n#include <sys/wait.h>\n\nusing namespace std;\n\nstruct timeval first, second, lapsed;\nstruct timezone tzp; \n\nint main(int argc, char* argv[]) {\n    int pCount = 5; // process count\n\n    gettimeofday (&first, &tzp); //start time\n\n    pid_t* pID = new pid_t[pCount];\n\n    for(int indexOfProcess=0; indexOfProcess<pCount; indexOfProcess++) {\n        pID[indexOfProcess] = fork();\n\n        if (pID[indexOfProcess] == 0) { // child\n            // code only executed by child process\n\n            // magic here\n\n            exit(0);\n        } else if (pID[indexOfProcess] < 0) { // failed to fork\n            cerr << "Failed to fork" << endl;\n            exit(1);\n        }\n    }\n\n    // Parent waits for all children to complete\n    int status;\n    for(int i=0; i<pCount; i++) {\n        waitpid(pID[i], &status, 0); // Wait for each child process to finish\n    }\n\n    gettimeofday (&second, &tzp); //stop time\n    if (first.tv_usec > second.tv_usec) {\n        second.tv_usec += 1000000;\n        second.tv_sec--;\n    }\n\n    lapsed.tv_usec = second.tv_usec - first.tv_usec;\n    lapsed.tv_sec = second.tv_sec - first.tv_sec; \n\n    cout << "Job performed in " <<lapsed.tv_sec << " sec and " << lapsed.tv_usec << " usec" << endl;\n\n    delete[] pID; // Don't forget to free the allocated memory\n\n    return 0;\n}