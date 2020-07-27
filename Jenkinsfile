pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh './mvnw compile'
            }
        }
        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }
        stage('Build & push Docker image') {
            environment {
                DOCKER_HUB_LOGIN = credentials('docker-hub')
            }
            steps {
                sh 'docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
                sh './mvnw compile jib:build'
            }
        }
    }
}
