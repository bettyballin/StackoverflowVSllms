response = HttpResponse(mimetype="image/png")\nimg.save(response, "PNG")\nreturn response