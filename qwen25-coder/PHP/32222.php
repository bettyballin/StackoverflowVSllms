if ($subcat !== null) {\n    $showCategory = "<p><strong>Auction Category:</strong> " . htmlspecialchars($tmp['subcat']) . "</p>";\n} else {\n    $showCategory = "<form name=\"categoryForm\">\n      <input name=\"radiobutton\" type=\"radio\" value=\"fakeapproved\" />Fake (Approved)<br>\n      <input name=\"radiobutton\" type=\"radio\" value=\"fakesuspected\" />Fake (Suspected)<br>\n      <input name=\"radiobutton\" type=\"radio\" value=\"keyword\" />Forbidden Keywords<br>\n      <input name=\"radiobutton\" type=\"radio\" value=\"parallelimport\" />Parallel Imports\n      <input name=\"Submit\" type=\"submit\" value=\"Update\" onclick=\"handleClick(" . htmlspecialchars($pk) . ");return false;\"/>\n    </form>";\n}