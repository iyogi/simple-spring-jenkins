pipeline {
    agent any

    tools {
        jdk 'jdk11'
        maven 'maven3'
    }

    stages {
        stage('Install') {
            steps {
                sh "pwd"
                sh "ls"
                sh "cat Jenkinsfile"
                sh "which java"
                sh "which mvn"
                sh "java -version"
                sh "mvn -version"
                sh "mvn clean test"
            }
        }
    }
}