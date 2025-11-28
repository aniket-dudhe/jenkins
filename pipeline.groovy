pipeline {
    agent {label 'slave'}
    stages {
        stage('pull-stage') {
            steps {
                git branch: 'main', url: 'https://github.com/Anilbamnote/student-ui-app.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        // stage('test') {
        //     steps {
        //         withSonarQubeEnv(installationName:'sonar',credentialsId: 'sonar-token') {
        //                 sh '/opt/maven/bin/mvn sonar:sonar'
        //            }   
        //     }
        // }
        //  stage('Quality-gate') {
        //     steps {
        //         timeout(10) {
    
        //     }
        //         waitForQualityGate true
        //     }
        // }
         stage('s3-artifactory') {
            steps {
                sh 'aws s3 cp target/studentapp-2.2-SNAPSHOT.war  s3://zhat12'
            }
        }
        // stage('deploy') {
        //     steps {
        //         deploy adapters: [tomcat9(alternativeDeploymentContext: '', credentialsId: 'tomcat-cred', path: '', url: 'http://35.78.123.34:8080')], contextPath: '/', war: '**/*.war'
        //     }
        // }
    }
}
