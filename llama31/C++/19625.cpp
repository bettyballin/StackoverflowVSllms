unique_ptr<int[]> VecToArray(vector<int> Vec)\n{\n    unique_ptr<int[]> ary(new int[Vec.size()]);\n\n    for(int i = 0; i < Vec.size(); i++)\n        ary[i] = Vec[i];\n\n    return ary;\n}