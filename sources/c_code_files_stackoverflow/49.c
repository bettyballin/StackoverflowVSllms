#include <math.h>

double log_subtract(double x, double y) {
  if(x <= y)
    // error!! computing the log of a negative number
    return NAN;  // Return Not a Number for invalid input
  if(y == -INFINITY)
    return x;
  return x + log1p(-exp(y-x));
}