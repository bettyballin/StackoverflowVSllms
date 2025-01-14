$parsedDoc = new MiniXMLDoc();\n    try {\n        $parsedDoc->fromString($xml);\n        $root = $parsedDoc->getElement('my-root-element');\n        if ($root === null) {\n            throw new Exception('Root element not found');\n        }\n        $lists = $root->getElement($type);\n        if ($lists === null) {\n            throw new Exception('Element type not found');\n        }\n        // Process $lists as needed\n    } catch (Exception $e) {\n        echo 'Error: ',  $e->getMessage(), "\n";\n    }