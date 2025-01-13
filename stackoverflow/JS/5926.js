// Words to match\nvar words = ["dell", "ledl", "abc", "cba"];\n\n// The output object\nvar anagrams = {};\n\nfor (var i in words) {\n    var word = words[i];\n\n    // sort the word like you've already described\n    var sorted = sortWord(word);\n\n    // If the key already exists, we just push\n    // the new word on the the array\n    if (anagrams[sorted] != null) {\n        anagrams[sorted].push(word);\n    } \n    // Otherwise we create an array with the word\n    // and insert it into the object\n    else {\n        anagrams[sorted] = [ word ];\n    }\n}\n\n// Output result\nfor (var sorted in anagrams) {\n    var words = anagrams[sorted];\n    var sep = ",";\n    var out = "";\n    for (var n in words) {\n        out += sep + words[n];\n        sep = "";\n    }\n    document.writeln(sorted + ": " + out + "<br />");\n}