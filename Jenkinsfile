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
                sh "mvn -U clean test cobertura:cobertura -Dcobertura.report.format=xml"
            }
            post {
                always {
                    junit '**/target/*-reports/TEST-*.xml'
                    //cobertura coberturaReportFile: 'target/site/cobertura/coverage.xml'
                    //step([$class: 'CoberturaPublisher', coberturaReportFile: 'target/site/cobertura/coverage.xml'])
                }
            }
        }

        stage('Sonar') {
            steps {
                sh "mvn sonar:sonar -Dsonar.host.url=${env.SONARQUBE_HOST}"
            }
        }

    }
}