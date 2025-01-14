<?php\n\nfunction tokenize($text) {\n    // Simple word tokenizer using regex to extract words\n    preg_match_all('/\b[^\d\W]+\b/', strtolower($text), $matches);\n    return $matches[0];\n}\n\nfunction calculateTfIdf(array $documents, array $wordList) {\n    $tfidfMatrix = [];\n    $docCount = count($documents);\n\n    foreach ($documents as $i => $document) {\n        $words = tokenize($document);\n        $wordCounts = array_count_values($words);\n        $totalWords = count($words);\n\n        foreach ($wordList as $word) {\n            // Term frequency\n            $tf = isset($wordCounts[$word]) ? $wordCounts[$word] / $totalWords : 0;\n\n            // Inverse Document Frequency\n            $idf = 0;\n            if ($tf > 0) {\n                $wordInDocsCount = 0;\n                foreach ($documents as $doc) {\n                    if (in_array($word, tokenize($doc))) {\n                        $wordInDocsCount++;\n                    }\n                }\n                $idf = log($docCount / ($wordInDocsCount + 1));\n            }\n\n            // Store TF-IDF value\n            $tfidfMatrix[$i][$word] = $tf * $idf;\n        }\n    }\n\n    return $tfidfMatrix;\n}\n\n// Example usage\n\n$documents = [\n    "This is the first document.",\n    "This document is the second document.",\n    "And this is the third one.",\n    "Is this the first document?",\n];\n\n$allWords = array_unique(array_merge(...array_map('tokenize', $documents)));\n$tfidfMatrix = calculateTfIdf($documents, $allWords);\n\n// Assuming you have an SVD function `svd` that returns [U, S, VT]\n[spl_object_hash(U), spl_object_hash(S), spl_object_hash(VT)] = svd($tfidfMatrix);\n\n$k = 2; // Number of topics\n$reducedDimensionS = array_slice(array_map(null, ...$S), 0, $k);\n$selectedUColumns = [];\nforeach ($U as $i => $row) {\n    $selectedUColumns[$i] = array_slice($row, 0, $k);\n}\n$selectedVT = array_slice(VT, 0, $k);\n\n// `selectedUColumns` and `$reducedDimensionS`, `$selectedVT` are now reduced dimensional matrices