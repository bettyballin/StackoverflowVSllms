++
#include <iostream>
#include <vector>
#include <algorithm>

#define PRINT(DATA,N) for(int i=0; i<N; i++) { std::cout << (i>0?", ":"") << DATA[i]; } std::cout << std::endl;

int
main()  
{
    // Creating and Sorting a stack-based array.
  int d [10] = { 1, 4, 0, 2, 8, 6, 3, 5, 9, 7 };
  PRINT(d,10);
  std::sort( d, d+10 );
  PRINT(d,10);

  std::cout << std::endl;

    // Creating a vector.
  int eData [10] = { 1, 4, 0, 2, 8, 6, 3, 5, 9, 7 };
  std::vector<int> e;
  for(int i=0; i<10; i++ )
    e.push_back( eData[i] );

    // Sorting a vector.
  for (auto& elem : e) {
    std::cout << elem << " ";
  }
  std::cout << std::endl;
  std::sort(e.begin(), e.end());
  for (auto& elem : e) {
    std::cout << elem << " ";
  }
  std::cout << std::endl;
}