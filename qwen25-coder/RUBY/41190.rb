respond_to do |format|\n  format.html # new.html.erb\n  format.xml { render :xml => @post }\nend