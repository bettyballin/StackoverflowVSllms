grep API file | awk '{ arr[$5]+=$7 } END {for (i in arr) {print i,arr[i]}   } ' -