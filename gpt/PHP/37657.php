<?php if (count($_associatedProducts)): ?>\n    <?php foreach ($_associatedProducts as $_item): ?>\n        <tr>\n            <?php\n            // Check if the attribute is a text type, then use getYearmade()\n            $yearMade = $_item->getYearmade();\n            if ($yearMade) {\n                echo $this->htmlEscape($yearMade);\n            } else {\n                // For other types of custom attributes, use getAttributeText()\n                echo $this->htmlEscape($_item->getAttributeText('yearmade'));\n            }\n            ?>\n        </tr>\n    <?php endforeach; ?>\n<?php endif; ?>