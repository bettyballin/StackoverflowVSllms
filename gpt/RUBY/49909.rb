require 'net/http'\n\nclass PhpController < ApplicationController\n  def call_php_method\n    url = URI.parse('http://your-php-server/php_server.php')\n    response = Net::HTTP.get(url)\n    render plain: response\n  end\nend