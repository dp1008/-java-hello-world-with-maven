pipeline{
    agent any
    tools{
        maven 'Maven'
    }
    stages{
        stage("build jar"){
            steps{

               script {
                echo "building the applition..."
                sh 'mvn package'
            }
           }
        }

        stage("build docker image"){
            steps{

               script {
                echo "building the docker image..."
              //  withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')])
                withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'user', passwordVariable: 'password')]) {
                sh 'docker build -t sun10deepak/java-maven:jma-4.2 .'
                sh "echo $password | docker login -u $user --password-stdin"
                sh 'docker push sun10deepak/java-maven:jma-4.2'
                }
            }

           }
        }       
        stage("deploy"){
            steps{

               script {
                echo "deploying the applition..."
            }
        }
    
    }

 }
}
