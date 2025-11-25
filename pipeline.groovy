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
                sh '''/opt/maven/bin/mvn sonar:sonar
                    -Dsonar.projectKey=sonar
                    -Dsonar.host.url=http://172.17.65.108:9000/
                    -Dsonar.login=sqa_11dd3211844b33ecc452ab9099b8c9283c3d8537'''
        }
        stage('deploy') {
            steps {
                echo "deploy sucess"
            }
        }
    }
}
