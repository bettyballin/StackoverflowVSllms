use OpenXML\OpenXML;\n\n$openxml = new OpenXML('path/to/presentation.pptx');\n$slides = $openxml->getSlides();\n\nforeach ($slides as $slide) {\n    $text = $slide->getText();\n    echo $text . "\n";\n}