# Rails: Parse ISO 8601 date string\nclass YourController < ApplicationController\n  def your_action\n    date_string = params[:date]\n    date = DateTime.iso8601(date_string)\n\n    # Now you can work with the date object\n    # ...\n  end\nend