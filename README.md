
## Deployment Guide on VM

### Set Java JDK
To install the Java Development Kit (JDK), run the following command:
```sh
sudo apt install openjdk-17-jre
```
To set java in path and set java home:
For permanently changing, add to ~/.bash_profile
```
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
```


### Set Chrome Browser
Install unzip for extracting the file to be downloaded
```
sudo apt-get install unzip
sudo apt-get install -y libgbm-dev
```

Browser may require libgbm-dev library so install that too
```
sudo apt-get install -y libgbm-dev
```

Set the version of browser that's required in a variable
```
VERSION="125.0.6422.141"
```
Download the zip file
```
wget "https://storage.googleapis.com/chrome-for-testing-public/${VERSION}/linux64/chrome-linux64.zip"
```
Make all missing parent directories to extract the zip file
```
mkdir -p bin/chrome/linux-${VERSION}/chrome-linux64
```
extracting the zip file
```
unzip chrome-linux64.zip -d ~/bin/chrome/linux-${VERSION}
```

### Set Environment Variables
write a shell script for setting up env variables
```
nano set_env_variables.sh
```

Provide access to the file
```
chmod +x set_env_variables.sh
```

### Building JAR from service
Run the command to generate a JAR file in target as CollingwoodCourier-x.x.x-SNAPSHOT.jar
```
mvn clean package -DskipTests
```

### Copy JAR to VM:
For copying the jar from current machine to the server VM
```
scp /Users/ashhad/projects/CollingwoodCourier/target/CollingwoodCourier-0.0.1-SNAPSHOT.jar root@165.22.122.93:/root/
```

### RUN Java Service:
Run the shell file to load the env variables. Only required when variables need to be updated from the file
```
source set_env_variables.sh
```

The command to run the java service
```
nohup java -jar CollingwoodCourier-0.0.1-SNAPSHOT.jar > output.log 2>&1 &
```

To see the logs:
```
cat output.log
```
To tail the log:
```
tail -f output.log
```
To see the usage, first get the pid then run the 2nd command:
```
ps aux | grep 'java'
ps -p PROCESS_PID -o %cpu,%mem,cmd
```

To kill the process
```
kill -9 PROCESS_PID
```

we can find and kill like this too

```
ps aux | grep 'java -jar ' | grep -v 'grep' | awk '{print $2}' | xargs kill -9
```