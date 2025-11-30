pipeline {
    agent {label 'slave'}
    stages {
        stage('pull-stage') {
            steps {
                git branch: 'main', url: 'https://github.com/aniket-dudhe/student-ui-app.git'
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
            stage('test') {
            steps {

               sh '''mvn sonar:sonar
                    -Dsonar.projectKey=sonar
                    -Dsonar.host.url=http://3.109.202.95:9000
                    -Dsonar.login=sqp_841640b096734c3f49eba5b4d64e8f894ebe0ada'''
               
                //     sh '/opt/maven/bin/mvn sonar:sonar -Dsonar.projectKey=studentapp -Dsonar.host.url=http://35.74.27.54:9000  -Dsonar.login=9c547e0733545b5a64a73f56e83c0169e6b5e1d7'
            }
        }
        //  stage('Quality-gate') {
        //     steps {
        //         timeout(10) {
    
        //     }
        //         waitForQualityGate true
        //     }
        // }
        //  stage('s3-artifactory') {
        //     steps {
        //         sh 'aws s3 cp target/studentapp-2.2-SNAPSHOT.war  s3://docker-buck-artifact-0099955'
        //     }
        // }
        // stage('deploy') {
        //     steps {
        //         deploy adapters: [tomcat9(alternativeDeploymentContext: '', credentialsId: 'tomcat-cred', path: '', url: 'http://35.78.123.34:8080')], contextPath: '/', war: '**/*.war'
        //     }
        // }
    }
}
