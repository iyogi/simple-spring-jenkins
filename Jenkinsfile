pipeline {
    agent any

    tools {
        jdk 'jdk8'
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
                sh "mvn -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true clean test"
            }
        }
    }
}