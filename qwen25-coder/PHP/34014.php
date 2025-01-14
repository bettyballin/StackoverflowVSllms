// Get the length of the ticket excluding the last 20 bytes (the hash)\n$ticketLn = strlen($buf) - 20;\n// Grab all but the last 20 bytes\n$ticket = substr($buf, 0, $ticketLn);\n// Extract the last 20 bytes which is the hash\n$hashFromBuf = substr($buf, $ticketLn);\n\n// Compute SHA1 of the ticket\n$computedHash = sha1($ticket, true); // Use binary output\n\n// Compare the computed hash with the hash from the buffer\nif ($computedHash === $hashFromBuf) {\n    echo "Hashes match!";\n} else {\n    echo "Hashes do not match.";\n}