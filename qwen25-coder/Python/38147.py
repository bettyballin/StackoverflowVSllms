import random\n\ndef generate_initial_population(letters, pop_size):\n    return [''.join(random.sample(letters, len(letters))) for _ in range(pop_size)]\n\ndef crossover(parent1, parent2):\n    size = len(parent1)\n    point = random.randint(1, size - 1)\n    child1 = parent1[:point] + parent2[point:]\n    child2 = parent2[:point] + parent1[point:]\n    return fix_duplicates(child1), fix_duplicates(child2)\n\ndef fix_duplicates(s):\n    # Ensure each character appears the same number of times as in the original\n    from collections import Counter\n    required_counts = Counter(original_letters)\n    actual_counts = Counter(s)\n    result = list(s)\n    for i, char in enumerate(result):\n        if actual_counts[char] > required_counts[char]:\n            # Replace extra character with one that's missing\n            needed_char = next((c for c in required_counts if actual_counts[c] < required_counts[c]), None)\n            if needed_char:\n                result[i] = needed_char\n    return "".join(result)\n\ndef mutate(individual, mutation_rate=0.01):\n    individual_list = list(individual)\n    for i in range(len(individual)):\n        if random.random() < mutation_rate:\n            # Swap with a random position\n            j = random.randint(0, len(individual) - 1)\n            individual_list[i], individual_list[j] = individual_list[j], individual_list[i]\n    return "".join(individual_list)\n\n# Main Genetic Algorithm\noriginal_letters = list("eehrst")\npopulation_size = 50\ngenerations = 100\n\npopulation = generate_initial_population(original_letters, population_size)\nbest_fitness = -1\nbest_individual = None\n\nfor generation in range(generations):\n    # Evaluate fitness of each individual\n    evaluations = [(ind, score(ind)) for ind in population]\n    evaluations.sort(key=lambda x: x[1], reverse=True)  # Sort by fitness descending\n    selected = [ind for ind, _ in evaluations[:population_size//2]]  # Select top half\n\n    # Create children via crossover and mutation\n    children = []\n    while len(children) < population_size:\n        parent1, parent2 = random.sample(selected, 2)\n        child1, child2 = crossover(parent1, parent2)\n        child1, child2 = mutate(child1), mutate(child2)\n        children.extend([child1, child2])\n\n    # New generation\n    population = selected + children[:population_size-len(selected)]\n    \n    # Track best result found\n    current_best_fitness, current_best_individual = evaluations[0]\n    if current_best_fitness > best_fitness:\n        best_fitness = current_best_fitness\n        best_individual = current_best_individual\n\nprint("Best solution:", best_individual, "with", best_fitness, "words")