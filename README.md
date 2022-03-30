Starter Repo for Adobe Experience Manager as a Cloud Service
===

Start you Adobe Experience Manager cloud projects with a default repository and directly include maintained versions
of some additional handy features.

## How to Use

This repository uses git submodules to include other git repositories into a larger project.

### Discover Repos

Find the out of the box repos at https://github.com/ez-aem-helpers

### Add a New Repo
```
git add submodule <git repository path>
```

you also should add the new repository to the `<modules>` section in the root `pom.xml` file. 
