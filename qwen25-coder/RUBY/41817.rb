require 'sinatra'\n\nclass MultipartApp < Sinatra::Base\n  get '/multipart' do\n    boundary = "rn9012"\n    content_type "multipart/x-mixed-replace;boundary=#{boundary}"\n    \n    stream(:keep_open) do |out|\n      out.write "--#{boundary}\n"\n      out.write "Content-type: application/xml\n\n"\n      out.write "<?xml version='1.0'?>\n"\n      out.write "<content>First Part</content>\n"\n      out.write "--#{boundary}\n"\n      \n      # Simulate a delay\n      sleep 5\n      \n      out.write "Content-type: application/xml\n\n"\n      out.write "<?xml version='1.0'?>\n"\n      out.write "<content>Second Part</content>\n"\n      out.write "--#{boundary}--\n"\n      \n      out.close\n    end\n  end\nend\n\nMultipartApp.run! host: 'localhost', port: 4567