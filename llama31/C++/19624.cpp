template<class Ret, class Iter>\nRet count_permutations(Iter first, Iter last)\n{\n    auto n = std::distance(first, last);\n    return std::tgamma(n + 1);\n}