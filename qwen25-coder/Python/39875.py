from nltk.metrics import edit_distance\n\n   def find_irregularities(texts):\n       irregularities = []\n       for i in range(len(texts)):\n           distances = [edit_distance(texts[i], texts[j]) for j in range(len(texts)) if i != j]\n           avg_distance = sum(distances) / len(distances)\n           if max(distances) > 2 * avg_distance:  # This threshold can be adjusted\n               irregularities.append(i)\n       return irregularities\n\n   texts_as_strings = ["Name 1, Comment", "Name 2, Comment", "Name 3 , Comment", "5. Name 10, Comment"]\n   print(find_irregularities(texts_as_strings))