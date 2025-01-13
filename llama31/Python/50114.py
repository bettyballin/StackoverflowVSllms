def greet(name: str) -> str:\n    """Return a personalized greeting message"""\n    return f"Hello, {name}!"\n\n# Reuse the routine in different contexts\nprint(greet("Alice"))  # Output: Hello, Alice!\nprint(greet("Bob"))    # Output: Hello, Bob!