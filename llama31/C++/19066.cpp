std::set<int> s1;\nstd::vector<int> s2;\ns1 = getAnExcitingSet();\nstd::transform(s1.begin(), s1.end(), std::back_inserter(s2), ExcitingUnaryFunctor());\nstd::sort(s2.begin(), s2.end());