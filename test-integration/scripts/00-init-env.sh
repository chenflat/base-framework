#!/bin/bash

init_var() {
    result=""
    if [[ $1 != "" ]]; then
        result=$1
    elif [[ $2 != "" ]]; then
        result=$2
    fi
    echo $result
}

# uri of repo
REPO=$(init_var "$BUILD_REPOSITORY_URI" "$TRAVIS_REPO_SLUG")

# folder where the repo is cloned
CLONED=$(init_var "$BUILD_REPOSITORY_LOCALPATH" "$TRAVIS_BUILD_DIR")


# folder for test-integration
INTEG="$HOME"/test-integration

# folder for samples
SAMPLES="$INTEG"/samples

# folder for scripts
SCRIPTS="$INTEG"/scripts

# folder for app
FOLDER_APP="$HOME"/app

# folder for uaa app
FOLDER_UAA="$HOME"/uaa
