int node_id = omp_get_node_id();\nint num_nodes = omp_get_num_nodes();\nint population_size = 1000; // total population size\nint local_population_size = population_size / num_nodes;\n\nIndividual* local_population = new Individual[local_population_size];