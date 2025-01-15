#include <algorithm>
#include <vector>

void subarray(const double a, const double b, std::vector<double>& sub, std::vector<int> pn) {
    std::vector<int>::const_iterator begin, end;
    begin = std::lower_bound(pn.begin(), pn.end(), a);
    end = std::upper_bound(pn.begin(), pn.end(), b);
    sub.insert(sub.begin(), begin, end);
}