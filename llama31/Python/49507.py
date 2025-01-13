import random\n\nclass TrieNode:\n    def __init__(self):\n        self.children = {}\n        self.is_word = False\n\nclass Trie:\n    def __init__(self):\n        self.root = TrieNode()\n\n    def insert(self, word):\n        node = self.root\n        for char in word:\n            if char not in node.children:\n                node.children[char] = TrieNode()\n            node = node.children[char]\n        node.is_word = True\n\n    def search(self, word):\n        node = self.root\n        for char in word:\n            if char not in node.children:\n                return False\n            node = node.children[char]\n        return node.is_word\n\ndef aho_corasick_score(trie, word):\n    score = 0\n    for i in range(len(word)):\n        for j in range(i + 1, len(word) + 1):\n            if trie.search(word[i:j]):\n                score += 1\n    return score\n\ndef word_scramble(trie, letters):\n    scrambled = ""\n    letters = list(letters)\n    while letters:\n        max_score = 0\n        next_letter = None\n        for letter in letters:\n            temp_scrambled = scrambled + letter\n            score = aho_corasick_score(trie, temp_scrambled)\n            if score > max_score:\n                max_score = score\n                next_letter = letter\n        scrambled += next_letter\n        letters.remove(next_letter)\n    return scrambled\n\n# Example usage:\ntrie = Trie()\nwords = ["the", "there", "her", "here", "ere"]\nfor word in words:\n    trie.insert(word)\n\nletters = ["e", "e", "h", "r", "s", "t"]\nscrambled = word_scramble(trie, letters)\nprint(scrambled)