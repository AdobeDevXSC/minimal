Starter Repo for Adobe Experience Manager as a Cloud Service
===

Start you Adobe Experience Manager cloud projects with a default repository and directly include maintained versions
of some additional handy features.

## How to Use

This repository uses git submodules to include other git repositories into a larger project.

### Discover Repos

Find the out of the box repos at https://github.com/AdobeAEMXSC

### Add a New Repo to AEM Program in Cloud Manager

1.	Click `Repositories` from Cloud Manager menu
2.	Click `Add Repository` from Repositories screen
3.	Enter `aemcs-minimal` as repository name, click `Save`
4.	Click `…`, the click `Check Branches / Create Project`
5.	Click `Create` using the default settings

### Add Minimal Repo into New Repo

1.	Click `Repositories` from Cloud Manager menu
2.	Click `…` associated with `aemcs-minimal`, the click `Copy Repository URL`
3.	Open `Terminal`, type `git clone [repository URL]`
    * Example `git clone https://git.cloudmanager.adobe.com/myname/aemcs-minimal/`
4.	Switch folder, enter `cd aemcs-minimal`
5.	Remove all files and directories, type `rm -r *`, type `y` and pressing `enter` to confirm
6.	Remove .gitignore, type `rm .gitignore`
7.	Commit all changes to git, type `git commit -a -m "clean"`
8.	Set minimal repo as remote target, type `git remote add github-minimal https://github.com/AdobeAEMXSC/minimal.git`
9.	Pull minimal repo into current repo, type `git pull --allow-unrelated-histories --no-edit github-minimal main`
10.	push all commits back to New Repo, type, `git push`

### Add a New Submodule to Repo
```
git submodule add <git repository path>
```

you also should add the new repository to the `<modules>` section in the root `pom.xml` file. 

### Update Submodules to latest version

```
git submodule update --remote
```
