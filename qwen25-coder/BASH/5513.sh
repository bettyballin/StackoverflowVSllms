# Example commands in a typical feature branching workflow with Git\ngit checkout main\ngit pull origin main # ensure up-to-date before creating new feature branch\ngit checkout -b feature/my-feature\ngit commit -am "Initial work on my feature"\ngit push --set-upstream origin feature/my-feature