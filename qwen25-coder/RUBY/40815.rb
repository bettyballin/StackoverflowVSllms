class YourController < ApplicationController\n     before_action :check_ssl\n\n     private\n\n     def check_ssl\n       redirect_to request.original_url.gsub(/^http/, 'https') unless request.ssl?\n     end\n   end