$example = 'Hello &amp; Goodbye';\n// Use html_entity_decode with ENT_XML1 flag to decode XML entities\n$decodedExample = html_entity_decode($example, ENT_QUOTES | ENT_XML1, 'UTF-8');\necho $decodedExample; // Outputs: Hello & Goodbye