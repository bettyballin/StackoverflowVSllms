awk '{gsub(/foo/, "foo_" ++count)} 1' count=0 input.txt