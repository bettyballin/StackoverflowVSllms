# Sanitize tags input\ntags = params[:question][:tag_list].split(',').map { |tag| sanitize(tag.strip) }\n@question.tag_list = tags\n@question.save