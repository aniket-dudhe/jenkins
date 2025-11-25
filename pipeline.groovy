pipeline {
    agent any
    stages {
        stage('pull-stage') {
            steps {
                git branch: 'main', url: 'https://github.com/aniket-dudhe/student-ui-app.git'
            }
        }
        stage('Build') {
            steps {
                sh '/opt/maven/bin/mvn clean package'
            }
        }
        stage('test') {
            steps {
        echo "ab"
            }
        }
        stage('deploy') {
            steps {
                echo "deploy sucess"
            }
        }
    }
}
