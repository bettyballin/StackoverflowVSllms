# sketchup_script.rb\nmodel = Sketchup.active_model\nentities = model.entities\npoints = [[0,0,0], [10,0,0], [10,10,0], [0,10,0]]\nface = entities.add_face(points)