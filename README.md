
SETUP:
install JDK
sudo apt install openjdk-17-jre

Set java home
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
sudo apt-get install unzip


set the version that's required in a variable
VERSION="127.0.6532.0"

download the zip file
wget "https://storage.googleapis.com/chrome-for-testing-public/${VERSION}/linux64/chrome-headless-shell-linux64.zip"

make all missing parent directories to extract the zip file
mkdir -p bin/chrome/linux-${VERSION}/chrome-linux64

extracting the zip file
unzip chrome-headless-shell-linux64.zip -d ~/bin/chrome/linux-${VERSION}/chrome-linux64

write a shell script for setting up env variables
nano set_env_variables.sh

provide access to the file
chmod +x set_env_variables.sh


COPYING JAR to VM:
for copying the jar from current machine to the server VM
scp /Users/ashhad/projects/CollingwoodCourier/target/CollingwoodCourier-0.0.1-SNAPSHOT.jar root@165.22.122.93:/root/

RUN:
run the shell file to load the env variables. Only required when variables need to be updated from the file
source set_env_variables.sh

The command to run the java service
java -jar CollingwoodCourier-0.0.1-SNAPSHOT.jar

