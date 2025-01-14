#include <iostream>
#include <initializer_list>

int findCommon(std::initializer_list<int> nums)
{
    std::initializer_list<int>::iterator it;
    for (it = nums.begin() ; it != nums.end() ; ++it)
    {
        std::cout << *it << std::endl;  
    }
    return 1;
}

int main()
{
    findCommon({1, 2, 3, 4, 5});
    return 0;
}