# Install PHP 5.0.0 (might not be available as precompiled binaries)\nphpbrew install php-5.2.8 +default\n\n# If you encounter any issues, try installing with all variants for missing modules/libraries\nphpbrew -d ext-xsl install --without-apxs2 php-5.2.8 +all