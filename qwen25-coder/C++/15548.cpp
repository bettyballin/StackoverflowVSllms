#include <algorithm>\n#include <vector>\n\n// Function to generate the next combination\ntemplate<class BidirectionalIterator>\nbool next_combination(BidirectionalIterator first, BidirectionalIterator middle,\n                      BidirectionalIterator last) {\n    if (first == middle || middle == last)\n        return false;\n\n    auto i = middle;\n    --i;\n    auto j = last;\n    --j;\n    while (*i >= *j) {\n        if (i == first) {\n            std::rotate(first, middle, last);\n            return false; // Combinations exhausted\n        }\n        --i;\n        --j;\n    }\n    ++j;\n    std::iter_swap(i,j);\n    i++;\n    j = last;\n    while (j != i) {\n        std::iter_swap(i,--j);\n        ++i;\n    }\n    return true;\n}\n\n// Function to generate the next partial permutation\ntemplate<class BidirectionalIterator>\nbool next_partial_permutation(BidirectionalIterator first,\n                              BidirectionalIterator middle,\n                              BidirectionalIterator last) {\n    if (!std::next_permutation(first, middle))\n        return next_combination(first, middle, last);\n    return true;\n}