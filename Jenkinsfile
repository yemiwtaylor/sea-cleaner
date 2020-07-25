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
    }
}
