import os\nfrom fpdf import FPDF\n\n# Get the username from the environment variables\nusername = os.getenv('USERNAME') or os.getenv('USER')\n\n# Create a PDF document\npdf = FPDF()\npdf.add_page()\npdf.set_font("Arial", size=12)\n\n# Add the username to the PDF\npdf.cell(200, 10, txt=f"Printed by: {username}", ln=True)\n\n# Output the PDF\npdf.output("output.pdf")