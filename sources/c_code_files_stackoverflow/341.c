++
#include <vector>
#include <algorithm>
#include <iostream>
#include <stdlib.h>

int data[] = {98, 50, 54, 43, 39, 91, 17, 85, 42, 84, 23, 7, 70, 72, 74, 65, 66, 47, 20, 27, 61, 62, 22, 75, 24, 6, 2, 68, 45, 77, 82, 29, 59, 97, 95, 94, 40, 80, 86, 9, 78, 69, 15, 51, 14, 36, 76, 18, 48, 73, 79, 25, 11, 38, 71, 1, 57, 3, 26, 37, 19, 67, 35, 87, 60, 34, 5, 88, 52, 96, 31, 30, 81, 4, 92, 21, 33, 44, 63, 83, 56, 0, 12, 8, 93, 49, 41, 58, 89, 10, 28, 55, 46, 13, 64, 53, 32, 16, 90};

int tosearch[] = {53, 5, 40, 71, 37, 14, 52, 28, 25, 11, 23, 13, 70, 81, 77, 10, 17, 26, 56, 15, 94, 42, 18, 39, 50, 78, 93, 19, 87, 43, 63, 67, 79, 4, 64, 6, 38, 45, 91, 86, 20, 30, 58, 68, 33, 12, 97, 95, 9, 89, 32, 72, 74, 1, 2, 34, 62, 57, 29, 21, 49, 69, 0, 31, 3, 27, 60, 59, 24, 41, 80, 7, 51, 8, 47, 54, 90, 36, 76, 22, 44, 84, 48, 73, 65, 96, 83, 66, 61, 16, 88, 92, 98, 85, 75, 82, 55, 35, 46};

bool binsearch(int i, std::vector<int>::const_iterator begin,
                      std::vector<int>::const_iterator end) {
  return std::binary_search(begin, end, i);
}

bool linsearch(int i, std::vector<int>::const_iterator begin,
                      std::vector<int>::const_iterator end) {
  return std::find(begin, end, i) != end;
}

int main(int argc, char *argv[])
{
  int n = 6;
  if (argc < 2) {
    std::cerr << "need at least 1 arg (l or b!)" << std::endl;
    return 1;
  }
  char algo = argv[1][0];
  if (algo != 'b' && algo != 'l') {
    std::cerr << "algo must be l or b, not '" << algo << "'" << std::endl;
    return 1;
  }
  if (argc > 2) {
    n = atoi(argv[2]);
  }
  std::vector<int> vv;
  for (int i=0; i<n; ++i) {
    if(data[i]==-1) break;
    vv.push_back(data[i]);
  }
  if (algo=='b') {
    std::sort(vv.begin(), vv.end());
  }
  bool (*search)(int i, std::vector<int>::const_iterator begin,
                        std::vector<int>::const_iterator end);
  if (algo=='b') search = binsearch;
  else search = linsearch;
  int nf = 0;
  int ns = 0;
  for(int k=0; k<10000; ++k) {
    for (int j=0; tosearch[j] >= 0; ++j) {
      ++ns;
      if (search(tosearch[j], vv.begin(), vv.end()))
        ++nf;
    }
  }
  std::cout << nf <<'/'<< ns << std::endl;

  return 0;
}