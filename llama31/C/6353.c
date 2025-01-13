double log_subtract(double x, double y) {\n  if(y == neginf)\n    return x;\n  if(x == neginf)\n    return neginf; // or throw an error, since subtracting from -inf is undefined\n  if(x <= y)\n    return neginf; // or throw an error, since subtracting a larger value results in a non-real number\n  return x + log1p(-exp(y - x));\n}