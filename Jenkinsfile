pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                sh  'echo "kaishi"
                     cp -r /root/.jenkins/workspace/mypipe_line/target/docker_spring_boot.jar  /root/webProject/docker_spring_boot
                     echo "diyi_success"
                     PID=`jps -lm |  grep   docker |  awk  '{print $1}'`
                     if [ "$PID" != "" ];then
                        echo $PID
                        kill -9 $PID
                     fi
                     echo "jar_start"
                     nohup java -jar /root/webProject/docker_spring_boot/docker_spring_boot.jar >>/root/webProject/docker_spring_boot/stderr.log 2>1 &
                     echo "jar_success"'
            }
        }
    }
}