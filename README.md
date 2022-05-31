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

### Add Minimal Repo into New or Existing Repo

1.	Click `Repositories` from Cloud Manager menu
2.	Click `…` associated with `aemcs-minimal`, the click `Copy Repository URL`
3.	Open `Terminal`, type
      ```
      git clone [repository URL]
      ```
      * Example `git clone https://git.cloudmanager.adobe.com/myname/aemcs-minimal/`
4.	Switch folder, type
      ```
      cd aemcs-minimal
      ```
5.	Remove all files and directories, type
      ```
      git rm -rf .
      ```
6. Clean all unstaged files, type
   ```
   git clean -fxd
   ```
7. Commit all changes to git, type
   ```
   git commit -a -m "clean"
   ```
8. Get latest from minimal, type
   ```
   git clone https://github.com/AdobeAEMXSC/minimal.git
   ```
9. Copy latest from minimal
      * If MacOS, type
         ```
         cp -r minimal/* .
         cp minimal/.gitignore .
         cp minimal/.gitmodules .
         ```
      * If Windows, type
         ```
         xcopy /S /I /E minimal .
         ```
10. remove artifacts from minimal, type
      ```
      rm -rf minimal
      ```
11. add submodules, type
      ```
      git submodule add https://github.com/AdobeAEMXSC/aem-dispatcher.git
      git submodule add https://github.com/AdobeAEMXSC/aem-workfront-connector.git
      ```
12. Commit all new files to git, type
      ```
      git add --all
      ```
13. Commit all changes to git, type
      ```
      git commit -am "updated minimal"
      ```
14. push all commits back to New Repo, type
      ```
      git push
      ```

### Add a New Submodule to Repo
1. Add submodule reference to `.submodules`, type
      ```
      git submodule add <git repository path>
      ```
2. Add the new repository to the `<modules>` section in the root `pom.xml` file to include it into maven build process
