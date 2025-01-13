$xml = $response->body->QueryWithAttributesResult->Item;\n\nforeach ($xml as $item) {\n    $name = (string) $item->Name;\n    $attributes = $item->Attribute;\n\n    foreach ($attributes as $attribute) {\n        $attributeName = (string) $attribute->Name;\n        $attributeValue = (string) $attribute->Value;\n\n        // Handle the attribute here\n        echo "$attributeName: $attributeValue\n";\n    }\n\n    // Handle the item here\n    echo "Item: $name\n";\n}