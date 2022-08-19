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
                withcredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')])
                sh 'docker build -t sun10deepak/java-maven:jma-4.2 .'
                sh "echo $PASS | docker login -u $USER --password-stdin"
                sh 'docker push sun10deepak/java-maven:jma-4.2'
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
