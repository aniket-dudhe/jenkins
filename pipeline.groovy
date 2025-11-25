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
                 sh '/opt/maven/bin/mvn clean package'
             }
         }
         stage('test') {
             steps {

                sh '''/opt/maven/bin/mvn sonar:sonar \\
                       -Dsonar.projectKey=sonar \\
                       -Dsonar.host.url=http://172.17.65.108:9000\\
                       -Dsonar.login=11dd3211844b33ecc452ab9099b8c9283c3d8537'''
               
                 //     sh '/opt/maven/bin/mvn sonar:sonar -Dsonar.projectKey=studentapp -Dsonar.host.url=http://35.74.27.54:9000  -Dsonar.login=9c547e0733545b5a64a73f56e83c0169e6b5e1d7'
             }
         }
         stage('deploy') {
             steps {
                 echo "deploy sucess"
             }
         }
     }
 }
