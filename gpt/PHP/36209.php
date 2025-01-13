// Calculate the age from a given birth date\n// Example: echo getAge("1986-06-18");\nfunction getAge($Birthdate) {\n    // Explode the date into meaningful variables\n    list($BirthYear, $BirthMonth, $BirthDay) = explode("-", $Birthdate);\n\n    // Get the current date\n    $currentYear = date("Y");\n    $currentMonth = date("m");\n    $currentDay = date("d");\n\n    // Calculate the age\n    $age = $currentYear - $BirthYear;\n\n    // Adjust the age if the birthday has not occurred yet this year\n    if ($currentMonth < $BirthMonth || ($currentMonth == $BirthMonth && $currentDay < $BirthDay)) {\n        $age--;\n    }\n\n    return $age;\n}\n\necho getAge('1990-04-04');