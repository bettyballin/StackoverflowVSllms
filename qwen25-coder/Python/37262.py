from tkinter import Frame, Label\n\nf = Frame(root, width=1000, bg="blue")\nf.pack(fill='x', expand=True)\nf.pack_propagate(False)  # Prevent the frame from shrinking to fit its contents\n\nl = Label(f, text="hi", width=10, bg="red", fg="white")\nl.pack()