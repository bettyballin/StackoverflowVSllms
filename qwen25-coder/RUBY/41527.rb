rescue_from ActiveRecord::RecordNotFound do |e|\n     render json: { error: e.message }, status: :not_found\n   end