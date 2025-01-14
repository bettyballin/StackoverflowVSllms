def simulate_fluid(particles, boundaries):\n    dt = 1 / FPS  # Time step based on frames per second\n\n    while running:\n        # Calculate forces\n        for particle in particles:\n            density = calculate_density(particle, particles)\n            pressure_force = calculate_pressure_force(particle, particles)\n            viscosity_force = calculate_viscosity_force(particle, particles)\n            gravity_force = calculate_gravity_force(particle)\n\n            total_force = pressure_force + viscosity_force + gravity_force\n\n            # Update particle velocity\n            particle.velocity += (total_force / density) * dt\n\n        # Update positions\n        for particle in particles:\n            update_position(particle, dt)\n\n        # Handle boundary conditions\n        handle_boundaries(particles, boundaries)\n\n        # Render the fluid\n        render_particles(particles)