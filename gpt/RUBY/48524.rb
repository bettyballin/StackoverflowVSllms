# In your Rails controller\n\ndef my_action\n  respond_to do |format|\n    format.json { render json: { key: 'value' } }\n  end\nend