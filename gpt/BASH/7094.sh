#!/bin/sh\n   PHPRC="/home/przepisy/conf/"\n   export PHPRC\n   PHP_FCGI_CHILDREN=4\n   export PHP_FCGI_CHILDREN\n   PHP_FCGI_MAX_REQUESTS=200\n   export PHP_FCGI_MAX_REQUESTS\n   exec /usr/bin/php5-cgi