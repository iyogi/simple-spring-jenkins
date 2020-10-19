pipeline {
    agent any

    tools {
        jdk 'jdk11'
        //jdk 'jdk8'
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
                //sh "mvn -U clean test cobertura:cobertura -Dcobertura.report.format=xml"
                sh "mvn -U clean test"
            }
            post {
                always {
                    junit '**/target/*-reports/TEST-*.xml'
                    //cobertura coberturaReportFile: 'target/site/cobertura/coverage.xml'
                    //step([$class: 'CoberturaPublisher', coberturaReportFile: 'target/site/cobertura/coverage.xml'])
                }
            }
        }

        // temporarily comment sonar
        // stage('Sonar') {
        //     steps {
        //         sh "mvn sonar:sonar -Dsonar.host.url=${env.SONARQUBE_HOST}"
        //     }
        // }

        stage('deploy') {
            steps {
                    //sh "mvn deploy -DskipTests"
                configFileProvider([configFile(fileId: 'custom_maven_settings', variable: 'SETTINGS')]) {
                    sh "mvn -s $SETTINGS deploy -DskipTests -Dartifactory_url=${env.ARTIFACTORY_URL}"
                }
            }
        }

    }
}