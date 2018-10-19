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
                sh  'echo kaishi'
                sh   'cp -r /root/.jenkins/workspace/mypipe_line/target/docker_spring_boot.jar  /root/webProject/docker_spring_boot'
                sh    'echo "diyi_success'
                 sh    'PID=`jps -lm |  grep   docker |  awk  '{print $1}'`
                     if [ "$PID" != "" ];then
                        echo $PID
                        kill -9 $PID
                     fi'
                  sh   'echo jar_start'
                  sh   'nohup java -jar /root/webProject/docker_spring_boot/docker_spring_boot.jar >>/root/webProject/docker_spring_boot/stderr.log 2>1 &'
                  sh   'echo jar_success'
            }
        }
    }
}