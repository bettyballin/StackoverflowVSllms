respond_to do |format|\n  format.xml { render plain: "OK" }\nend\n\n# Ensure no further code is executed after sending the response\nretur