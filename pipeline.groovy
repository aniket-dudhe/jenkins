pipeline {
    agent any
    stages {
        stage('pull-stage') {
            steps {
                git branch: 'main', url: 'https://github.com/Anilbamnote/student-ui-app.git'
            }
        }
        stage('Build') {
            steps {
                echo " build sucess"
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
