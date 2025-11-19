pipeline {
    agent any
    stages {
        stage('pull-stage') {
            steps {
                git branch: 'main', url: 'https://github.com/aniket-dudhe/jenkins-44.git'
            }
        }
        stage('Build') {
            steps {
                sh '/opt/maven/bin/mvn clean package'
            }
        }
        stage('test') {
            steps {
                echo "test suecss"
            }
        }
        stage('deploy') {
            steps {
                echo "deploy sucess"
            }
        }
    }
}
