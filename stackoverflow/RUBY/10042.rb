def singleton(array)\n  number = 0\n  array.each{|n| number = number ^ n}\n  number\nend\n\nirb(main):017:0> singleton([1, 2, 2, 3, 1])\n=> 3