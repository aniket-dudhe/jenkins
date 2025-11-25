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
  
         stage('deploy') {
             steps {
                  sh '''/opt/maven/bin/mvn sonar:sonar \\
                       -Dsonar.projectKey=sonar \\
                       -Dsonar.host.url=http://172.17.65.108:9000\\
                       -Dsonar.login=sqa_c5be7a4aaa200ef1731750b8e93b7c49acc40749'''
             }
         }
     }
 }
