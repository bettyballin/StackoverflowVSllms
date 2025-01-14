def fetch_new_messages\n  # Assuming each user keeps track of their last fetched time.\n  last_fetched = session[:last_message_fetch] || Time.at(0).utc # Default to the start of time if not set\n  new_messages = @user.messages.where("created_at > ?", last_fetched)\n\n  # Update the last fetch time in the session\n  session[:last_message_fetch] = Time.zone.now\n\n  respond_to do |format|\n    format.json { render json: { messages: render_to_string(partial: "messages/message", collection: new_messages) } }\n  end\nend