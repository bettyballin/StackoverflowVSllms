# Team A workflow\ngit checkout release-v1.0\ngit checkout -b fix-123\n# make changes and commit\ngit commit -m "Fix bug 123"\ngit checkout release-v1.0\ngit merge --no-ff fix-123\ngit push origin release-v1.0\n\n# Team B workflow\ngit checkout main\ngit checkout -b feature-789\n# make changes and commit\ngit commit -m "Implement feature 789"\ngit checkout main\ngit merge --no-ff feature-789\ngit push origin main\n\n# Integrating changes from version 1.1 to version 2.0\ngit checkout main\ngit cherry-pick <commit-hash-from-release-v1.0>\n\n# Integrating changes from version 2.0 to version 1.1\ngit checkout release-v1.0\ngit cherry-pick <commit-hash-from-main>