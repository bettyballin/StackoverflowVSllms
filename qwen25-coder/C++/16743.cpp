#include <vector>\n\nint HashVector(const std::vector<int>& v) {\n  const int N = 1049527; // A large prime number as the modulus.\n  const int w[] = {831529, 661529, 235237, 97751, 44773, 22507}; // Distinct primes.\n  int result = 0;\n  for (size_t i = 0; i < v.size(); ++i) {\n    result = (result + static_cast<long long>(w[i]) * v[i]) % N;\n  }\n  return result;\n}