#include <vector>

void copyVecFast(std::vector<int> original) // no reference
{
  std::vector<int> new_;
  new_.swap(original); 
}

int main() {
    std::vector<int> original = {1, 2, 3, 4, 5};
    copyVecFast(original);
    return 0;
}