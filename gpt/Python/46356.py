list_1 = ["name1", "name2", "name3"]\nlist_2 = [{"key1": "value1a"}, {"key1": "value1b"}, {"key1": "value1c"}]\nlist_3 = ["data1", "data2", "data3"]\n\nresult = {list_1[i]: {"dict": list_2[i], "data": list_3[i]} for i in range(len(list_1))}\n\nprint(result)