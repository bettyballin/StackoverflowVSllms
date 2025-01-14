#include <stdio.h>     // for printf() function
#include <math.h>      // Math constants and functions

typedef double Double2D[2];

double calculateAngle(Double2D v1, Double2D v2) {  // v1 from P1 to P2, v2 from P1 to P3
    double dp = v1[0]*v2[0] + v1[1]*v2[1]; // Dot product of the vectors.
    double magnitude_v1 = sqrt(v1[0]*v1[0] + v1[1]*v1[1]);
    double magnitude_v2 = sqrt(v2[0]*v2[0] + v2[1]*v2[1]);
    return acos(dp / (magnitude_v1 * magnitude_v2)); // Use formula to calculate angle and arc cosine function
}

int main () {
    Double2D P1={2,50}, P2 ={9,40};//First vector with origin at Point P3 from P1 to P2

    Double2D P3 = {5,20}; //Second Vector with origin at P3  from P1 to P3

    double angRadians;      // Angle in radians
    double angDegrees;        // Converted angle in degrees

    // Calculate vectors from P1 to P2 and P1 to P3
    Double2D v1 = {P2[0] - P1[0], P2[1] - P1[1]};
    Double2D v2 = {P3[0] - P1[0], P3[1] - P1[1]};

    angRadians = calculateAngle(v1, v2);         // Calculate Angle and pass vector parameters to function
    angDegrees  = (angRadians * 180.0)/M_PI ;
    printf("The angle in degrees is : %.15lf\n", angDegrees); // Print the calculated angle to console
    return 0;
}