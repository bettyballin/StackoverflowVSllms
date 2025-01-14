def anagram_signature(word)\n  word.chars.sort.chunk_while { |a, b| a == b }.map { |c, chars| "#{chars.size}#{c}" }.join\nend\n\n# Example usage:\nputs anagram_signature("mississippi") # Output: "4i1m2p4s"