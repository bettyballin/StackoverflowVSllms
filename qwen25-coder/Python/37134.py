def kendall_tau_rank_distance(x, y):\n    # Create rank dictionary for both lists\n    rank_x = {v: i for i, v in enumerate(x)}\n    rank_y = {v: j for j, v in enumerate(y)}\n    \n    distance = 0\n    n = len(x)\n    \n    # Count the number of inversions\n    count = [0] * n\n    \n    def merge_and_count(arr, temp_arr, left, mid, right):\n        i = left # Starting index for left subarray \n        j = mid + 1 # Starting index for right subarray \n        k = left # Starting index to be sorted  \n        inv_count = 0\n        \n        while i <= mid and j <= right: \n            if rank_y[arr[i]] < rank_y[arr[j]]:\n                temp_arr[k] = arr[i]\n                k += 1\n                i += 1\n            else: \n                temp_arr[k] = arr[j]\n                inv_count += (mid-i + 1)\n                k += 1\n                j += 1\n\n        while i <= mid: \n            temp_arr[k] = arr[i]\n            k += 1\n            i += 1\n\n        while j <= right: \n            temp_arr[k] = arr[j]\n            k += 1\n            j += 1\n\n        for i in range(left,right + 1): \n            arr[i] = temp_arr[i]\n                \n        return inv_count \n    \n    def merge_sort_and_count(arr, temp_arr, left, right):  \n        inv_count = 0\n        if left < right: \n            mid = (left + right)//2\n    \n            inv_count += merge_sort_and_count(arr, temp_arr, left, mid) \n            inv_count += merge_sort_and_count(arr, temp_arr, mid + 1, right) \n            inv_count += merge_and_count(arr, temp_arr, left, mid, right)\n        \n        return inv_count \n    \n    temp_arr = [0]*n\n    distance = merge_sort_and_count(x, temp_arr, 0, n-1) \n    return distance\n\nlist1 = [1, 2, 3, 4]\nlist2 = [1, 3, 2, 4]\nprint(kendall_tau_rank_distance(list1, list2))  # Output should be small for lists with similar order