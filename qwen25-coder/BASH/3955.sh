# Install PHPStan globally\ncomposer global require phpstan/phpstan\n\n# Analyze your project\nphpstan analyse -l 7 --memory-limit=-1 /path/to/your/project/