// index.php\nrequire 'Calculator.php';\n\n$calculator = new Calculator();\n$result = $calculator->add(10, 5);\necho "The sum is: " . Calculator::format($result);