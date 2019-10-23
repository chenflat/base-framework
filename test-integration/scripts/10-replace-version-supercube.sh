#!/bin/bash

set -e
source $(dirname $0)/00-init-env.sh

if [[ $VERSION == '' ]]; then
    VERSION=0.0.0-CICD
fi

# artifact version of framework-parent
sed -e '/<artifactId>framework-parent<\/artifactId>/{N;s/<version>.*<\/version>/<version>'$VERSION'<\/version>/1;}' pom.xml > pom.xml.sed
mv -f pom.xml.sed pom.xml

# base-framework.version property in framework-parent
sed -e 's/<base-framework.version>.*<\/base-framework.version>/<base-framework.version>'$VERSION'<\/base-framework.version>/1' pom.xml > pom.xml.sed
mv -f pom.xml.sed pom.xml

# parent version of base-dependencies
sed -e '/<artifactId>framework-parent<\/artifactId>/{N;s/<version>.*<\/version>/<version>'$VERSION'<\/version>/1;}' dependencies/pom.xml > dependencies/pom.xml.sed
mv -f dependencies/pom.xml.sed dependencies/pom.xml

# parent version of framework
sed -e '/<artifactId>base-dependencies<\/artifactId>/{N;s/<version>.*<\/version>/<version>'$VERSION'<\/version>/1;}' framework/pom.xml > framework/pom.xml.sed
mv -f framework/pom.xml.sed framework/pom.xml
