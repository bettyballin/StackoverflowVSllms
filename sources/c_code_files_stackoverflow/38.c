#include <stdio.h>

// This is actually C++ code, not C. C does not support operator overloading.
// So we will convert it to a C++ code.

struct array1 {
    int mArray[10];
    int & operator[](int i) {
      return mArray[i]; // return the ith element of mArray
    }
};

int main() {
    array1 arr;
    arr.mArray[0] = 10; // initialize the first element of mArray
    
    // test the operator overloading
    arr[0] = 20; // change the value of the first element using operator overloading
    printf("%d\n", arr.mArray[0]); // print the value

    return 0;
}