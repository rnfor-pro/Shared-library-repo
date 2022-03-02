def call(String repoUrl){
  pipeline {
       agent any
       tools {
           maven 'Maven'
           jdk 'jdk8'
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
