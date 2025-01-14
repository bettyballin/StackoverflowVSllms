// Example of creating a basic bar graph with PChart\n   require "pchart/class/pDraw.class.php";\n   require "pchart/class/pImage.class.php";\n   require "pchart/class/pData.class.php";\n\n   $MyData = new pData();\n   $MyData->addPoints([4,5,6], "ScoreA");\n   $MyData->setSerieDescription("ScoreA", "Player A");\n\n   $myPicture = new pImage(300, 200, $MyData);\n   $myPicture->drawScale();\n   $myPicture->drawBarChart();\n\n   $myPicture->Render("example.png");