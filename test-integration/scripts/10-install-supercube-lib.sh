#!/bin/bash

set -e
source $(dirname $0)/00-init-env.sh

#-------------------------------------------------------------------------------
# Install supercube Dependencies and Server-side library
#-------------------------------------------------------------------------------
cd "$HOME"
if [[ "$JHI_REPO" == *"/supercube1" ]]; then
    echo "*** supercube1: use local version at JHI_REPO=$JHI_REPO"

    cd "$JHI_CLONED"
    git --no-pager log -n 10 --graph --pretty='%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset' --abbrev-commit

    test-integration/scripts/10-replace-version-supercube.sh

    ./mvnw clean install -Dgpg.skip=true
    ls -al ~/.m2/repository/io/github/supercube1/base-framework/
    ls -al ~/.m2/repository/io/github/supercube1/base-dependencies/
    ls -al ~/.m2/repository/io/github/supercube1/framework-parent/

elif [[ "$JHI_LIB_BRANCH" == "release" ]]; then
    echo "*** supercube1: use release version"

else
    echo "*** supercube1: JHI_LIB_REPO=$JHI_LIB_REPO with JHI_LIB_BRANCH=$JHI_LIB_BRANCH"
    git clone "$LIB_REPO" supercube1
    cd supercube1
    if [ "$JHI_LIB_BRANCH" == "latest" ]; then
        LATEST=$(git describe --abbrev=0)
        git checkout "$LATEST"
    elif [ "$JHI_LIB_BRANCH" != "master" ]; then
        git checkout "$JHI_LIB_BRANCH"
    fi
    git --no-pager log -n 10 --graph --pretty='%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset' --abbrev-commit

    test-integration/scripts/10-replace-version-supercube.sh

    ./mvnw clean install -Dgpg.skip=true
    ls -al ~/.m2/repository/io/github/supercube/base-framework/
    ls -al ~/.m2/repository/io/github/supercube/base-dependencies/
    ls -al ~/.m2/repository/io/github/supercube/framework-parent/
fi

#-------------------------------------------------------------------------------
# Override config
#-------------------------------------------------------------------------------

# replace 00-init-env.sh
cp "$JHI_CLONED"/test-integration/scripts/00-init-env.sh "$JHI_HOME"/test-integration/scripts/
