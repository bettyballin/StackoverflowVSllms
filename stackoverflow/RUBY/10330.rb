def first_words(s, n)\n  a = s.split(/\s/) # or /[ ]+/ to only split on spaces\n  a[0...n].join(' ') + (a.size > n ? '...' : '')\nend\n\ns = "The quick brown fox jumps over the lazy dog. " * 20\n\nputs "#{s.size}, #{s.split(/\s/).size}" \n#-> 900, 180\n\nputs first_words(s, 10)\n#-> The quick brown fox jumps over the lazy dog. The...\n\nputs first_words("a b c d", 10)\n#-> a b c d