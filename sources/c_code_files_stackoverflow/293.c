pp
#include <iostream>
#include <set>

int main() {
    const int maxNum = 3600000;
    const int windowSize = 1000;

    // Create a multiset and insert the first windowSize numbers
    std::multiset<int> sortedContainer;
    for (int i = 0; i < windowSize; ++i) {
        sortedContainer.insert(i);
    }

    // Loop through the rest of the numbers
    for (int j = 1; j < maxNum - windowSize + 1; ++j) {
        // Remove the number that is now irrelevant
        sortedContainer.erase(sortedContainer.find(j - 1));

        // Add the new relevant number
        sortedContainer.insert(j + windowSize - 1);
    }

    return 0;
}