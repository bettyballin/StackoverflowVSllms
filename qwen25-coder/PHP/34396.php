<ul id="handles" class="tabs">\n    <?php \n        for ($i = 0, $n = count($list); $i < $n; $i++) :\n            if ($i == 0) {\n                // Handle the first item differently\n                modSankeSlideHelper::getTabsWithClass($list[$i], 'class="your-special-class"');\n            } else {\n                // Handle other items normally\n                modSankeSlideHelper::getTabs($list[$i]);\n            }\n        endfor; \n    ?>\n    <li class="end"></li>\n</ul>