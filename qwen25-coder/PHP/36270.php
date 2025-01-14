use Joomla\CMS\Response\JsonResponse;\nuse Joomla\CMS\Factory;\n\n// Get the Joomla document object\n$document = Factory::getApplication()->getDocument();\n\n// Change the Content-Type of the response\n$document->setMimeEncoding('application/pdf');\n\n// Optionally, if you are outputting raw PDF data and don't want Joomla to modify it further\nFactory::getApplication()->close();