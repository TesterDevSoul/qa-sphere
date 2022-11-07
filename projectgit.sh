git add .
git rm -r --cached .idea
git rm -r --cached .gitignore
git rm -r --cached .mvn
git rm -r --cached mvnw
git rm -r --cached mvnw.cmd
git config user.name "testeru"
git commit -m $1
git push
