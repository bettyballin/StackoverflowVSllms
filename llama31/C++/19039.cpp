vector<int*> v1;\nvector<const int*> v2;\nv2.reserve(v1.size());\nstd::transform(v1.begin(), v1.end(), std::back_inserter(v2),\n               [](int* p) { return static_cast<const int*>(p); });