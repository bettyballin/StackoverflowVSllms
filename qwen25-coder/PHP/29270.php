// PHP 5.x style assertion (using eval)\nassert('return $a > $b;'); // not recommended due to use of eval()\n\n// PHP 7+ style assertion (without eval)\nassert($a > $b); // preferred method