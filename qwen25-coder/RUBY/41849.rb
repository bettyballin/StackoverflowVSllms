def foo(x)\n  Enumerator.new do |yielder|\n    x.times { |i| yielder.yield(i) if bar(i) }\n  end\nend\n\nresult = foo(100).to_a