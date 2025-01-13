<?php\n\n/**\n * windowsize must be odd\n *\n * @param int $totalItems \n * @param int $currentPage \n * @param int $windowSize \n * @param int $anchorSize \n * @param int $itemsPerPage \n * @return void\n */\nfunction paginate($totalItems, $currentPage=1, $windowSize=3, $anchorSize=3, $itemsPerPage=10) {\n    $halfWindowSize = ($windowSize-1)/2;\n\n    $totalPages = ceil($totalItems / $itemsPerPage);\n    $elipsesCount = 0;\n    for ($page = 1; $page <= $totalPages; $page++) {\n        // do we display a link for this page or not?\n        if ( $page <= $anchorSize ||  \n            $page > $totalPages - $anchorSize ||\n            ($page >= $currentPage - $halfWindowSize &&\n            $page <= $currentPage + $halfWindowSize) ||\n            ($page == $anchorSize + 1 &&\n             $page == $currentPage - $halfWindowSize - 1) ||\n            ($page == $totalPages - $anchorSize &&  \n             $page == $currentPage + $halfWindowSize + 1 ))\n        {\n            $elipsesCount = 0;\n            if ($page == $currentPage)\n                echo ">$page< ";\n            else\n                echo "[$page] ";\n        // if not, have we already shown the elipses?\n        } elseif ($elipsesCount == 0) {\n            echo "... ";\n            $elipsesCount+=1; // make sure we only show it once\n        }\n    }\n    echo "\n";\n}\n\n//\n// Examples and output\n//\n\npaginate(1000, 1, 3, 3);\n// >1< [2] [3] ... [98] [99] [100] \n\npaginate(1000, 7, 3, 3);\n// [1] [2] [3] ... [6] >7< [8] ... [98] [99] [100] \n\npaginate(1000, 4, 3, 3);\n// [1] [2] [3] >4< [5] ... [98] [99] [100] \n\npaginate(1000, 32, 3, 3);\n// [1] [2] [3] ... [31] >32< [33] ... [98] [99] [100] \n\npaginate(1000, 42, 7, 2);\n// [1] [2] ... [39] [40] [41] >42< [43] [44] [45] ... [99] [100] 