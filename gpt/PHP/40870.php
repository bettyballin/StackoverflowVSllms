<?php\n   require 'vendor/autoload.php';\n   \n   use ChartJs\ChartJS;\n\n   $chart = new ChartJS('bar', [\n       'labels' => ['January', 'February', 'March', 'April', 'May', 'June', 'July'],\n       'datasets' => [\n           [\n               'label' => 'My First dataset',\n               'backgroundColor' => 'rgba(255,99,132,0.2)',\n               'borderColor' => 'rgba(255,99,132,1)',\n               'borderWidth' => 1,\n               'data' => [65, 59, 80, 81, 56, 55, 40],\n           ],\n           [\n               'label' => 'My Second dataset',\n               'backgroundColor' => 'rgba(54,162,235,0.2)',\n               'borderColor' => 'rgba(54,162,235,1)',\n               'borderWidth' => 1,\n               'data' => [28, 48, 40, 19, 86, 27, 90],\n           ],\n       ],\n   ]);\n\n   echo $chart->render();