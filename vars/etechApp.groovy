def call(String repoUrl){
  pipeline {
       agent any
       tools {
           maven 'maven'
           jdk 'jdk-11'
       }
       stages {
           stage("Tools initialization") {
               steps {
                   sh "mvn --version"
                   sh "java -version"
               }
           }
           stage("Checkout Code") {
               steps {
                   git branch: 'main',
                       url: "${repoUrl}"
               }
           }
           stage("to-test-maven") {
              steps {
                   sh "mvn test"
               }
           }
       }
   }
}
