# controllers/test_controller.rb\nclass TestController < ApplicationController\n  def index\n    render :text => lambda { |response|\n      # Your CGI script code goes here\n      print "HTTP/1.0 200 OK\r\n"\n      print "Content-type: text/html\r\n\r\n"\n      print "<html><body>Hello World!</body></html>\r\n"\n    }.call\n  end\nend