def repeated(array)\n  counts = Hash.new(0)\n  array.each{|val|counts[val]+=1}\n  counts.reject{|val,count|count==1}.keys\nend