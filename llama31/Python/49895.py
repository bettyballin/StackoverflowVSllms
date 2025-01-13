def kendall_tau_distance(list1, list2):\n    n = len(list1)\n    distance = 0\n    for i in range(n):\n        for j in range(i+1, n):\n            if (list1[i] < list1[j]) != (list2[i] < list2[j]):\n                distance += 1\n    return distance