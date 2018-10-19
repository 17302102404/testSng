pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                sh  'nohup java -jar /root/webProject/docker_spring_boot/docker_spring_boot.jar'
            }
        }
    }
}