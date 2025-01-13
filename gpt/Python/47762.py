import tkinter as tk\n    from tkinter import Label\n    from PIL import Image, ImageTk\n    import graphviz\n\n    def render_dot_file(dot_path, output_path):\n        # Create a Graphviz source object\n        with open(dot_path, 'r') as file:\n            dot_data = file.read()\n        src = graphviz.Source(dot_data)\n        \n        # Render the dot file to an image\n        src.render(output_path, format='png', cleanup=True)\n\n    def display_image(image_path, root):\n        # Load the image using PIL\n        image = Image.open(image_path)\n        photo = ImageTk.PhotoImage(image)\n        \n        # Create a Label widget to display the image\n        label = Label(root, image=photo)\n        label.image = photo  # Keep a reference to avoid garbage collection\n        label.pack()\n\n    if __name__ == "__main__":\n        # File paths\n        dot_file_path = "1.dot"\n        output_image_path = "output"\n\n        # Render the .dot file to an image\n        render_dot_file(dot_file_path, output_image_path)\n\n        # Create the Tkinter window\n        root = tk.Tk()\n        root.title("Graph Visualization")\n\n        # Display the rendered image in the Tkinter window\n        display_image(f"{output_image_path}.png", root)\n\n        # Run the Tkinter main loop\n        root.mainloop()