$encodedInput = $this->input->get('q'); // Get the encoded query string parameter\n$decodedInput = rawurldecode($encodedInput); // Decode the input for processing\n\n// Use $decodedInput safely in your applicatio