# Add DEF as submodule to keep history temporarily\n    git submodule add /path/to/def\n    git mv def/ def-workspace/\n    \n    # Go into DEF directory and prepare its files to be added directly\n    cd def-workspace\n    mv .git ../.git-defs\n    cd ..\n    \n    # Merge DEF's history into PPP-repo's root\n    git read-tree --prefix=def -u .git-defs/HEAD\n    rm -rf .git-defs\n    \n    git add -A .\n    git commit -m "Merged DEF repository into PPP-repo"