def update_states\n  puts "Attempting to update states..."\n  q = params[:country]\n  states = Carmen::states(Carmen::country_code(q))\n  puts "Country = #{q}, states = #{states.collect{|s| s[0]}.join(", ")}."\n\n  render :update do |page|\n    page.replace_html "states_div", \n      :partial => 'states',\n      :object => states,\n      :locals => {:form => @template.form_for(@person)}\n  end\n  puts "OK"\nend