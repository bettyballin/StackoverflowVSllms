try {\n    // Test piece straight off the Zend tutorial\n    $slashdotRss = Zend_Feed::import('http://rss.slashdot.org/Slashdot/slashdot');\n} catch (Zend_Feed_Exception $e) {\n    // handle feed import errors\n    echo "Feed exception caught: {$e->getMessage()}\n";\n} catch (Zend_Http_Client_Adapter_Exception $e) {\n    // handle HTTP client errors\n    echo "HTTP client error caught: {$e->getMessage()}\n";\n} catch (Exception $e) {\n    // general exception handling\n    echo "An unexpected error occurred: {$e->getMessage()}\n";\n}