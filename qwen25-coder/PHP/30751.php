require_once('jpgraph.php');\nrequire_once('jpgraph_bar.php');\n\n// Some data to plot\n$datay = array(12, 8, 19, 3, 10);\n\n// Create the graph. These two calls are always required\n$graph = new Graph(450,300);\n$graph->SetScale("textlin");\n\n// Add some grace to the top of the scale.\n// Adjust the autoscaling a little to make room for title and legend\n$graph->yscale->SetGrace(20);\n\n// Set title and subtitle and fonts\n$graph->title->SetFont(AFFONT_BATANG,FS_BOLD,18);\n$graph->title->SetColor("#b967ff");\n$graph->subtitle->Set("(The local bar's collection)");\n$graph->subtitle->SetColor("darkred");\n\n// Create a new bar pot and set default graph attributes\n$bplot = new BarPlot($datay);\n\n// Set default colors\n$bplot->SetFillGradient('#fef182','#f9b400',GRAD_HOR);\n\n// Add the plot to the graph\n$graph->Add($bplot);\n\n// Show column legend values\n$bplot->value->Show();\n$bplot->value->SetFont(AFFONT_BATANG,FS_BOLD);\n$bplot->value->SetFormat('%d');\n$bplot->value->SetColor('#6cb0f5');\n\n// Finally send the graph to the browser\n$graph->Stroke();