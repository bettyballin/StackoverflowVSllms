$inputString = "こんにちは"; // Japanese for "hello"\necho strlen($inputString);    // May output 15, treating each multibyte character as single bytes\necho mb_strlen($inputString, 'UTF-8'); // Outputs 5, correctly counting characters