template<class Ret, class Iter>\nRet count_permutations(Iter first, Iter last)\n{\n    Ret ret = 1;\n    for (auto it = first; it != last; ++it) {\n        ret *= (last - first) - (it - first) + 1;\n    }\n    return ret;\n}