respond_to do |format|\n  format.html # index.html.erb\n  format.xml  { render :xml => @things }\n\n  # This should work as expected\n  format.json { render :json => @things.to_json(:include => :photos) }\nend