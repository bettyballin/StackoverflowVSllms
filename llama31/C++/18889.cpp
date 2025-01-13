boost::transform_iterator<Second, First> begin(secondVec.begin(), [](const Second& sec) { return sec.s1; });\nboost::transform_iterator<Second, First> end(secondVec.end(), [](const Second& sec) { return sec.s1; });\n\nstd::copy(begin, end, std::back_inserter(firstVec));