#include "mex.h" /* include MATLAB engine header file */

/* ... other includes and definitions */

void mexFunction(int nlhs, mxArray *plhs[], int nrhs, const mxArray *prhs[]) {
    /*  ... Your code here... */
    bool success = false; // assuming 'success' is your boolean indicator for function calls.
    mxArray *mxLastError;

    if ( !success ) { 
        mexCallMATLAB(1, &mxLastError, 0, NULL); /* Call lasterror() and retrieve the error message */
        const char *msg = mxArrayToString(mxLastError);
        /* Now you can do something with 'msg', e.g., log it or print an error message*/
        printf("Error: %s\n", msg); // print error message
        mxDestroyArray(mxLastError); // clean up
    }
}