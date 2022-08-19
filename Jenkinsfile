pipeline{
    agent any
    parameters{
       // string(name: 'VERSION', defaulValue: '', description: 'version to deploy on prod')
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0' ], description: '')
        booleanParam(name: 'executeTest', defautValue: true, description: '')

    }
        stages {
            stage("build"){
                steps {
                    echo 'Building the application...'
            }
        }
            stage("test"){
                when{
                    expression {
                        params.executeTest
                    }
                }
                steps {
                    echo 'Testing the application...'
            }
        }
             stage("deploy"){
                steps {
                    echo 'deploying the application...'
                    echo "deploy version ${version}"
            }
        }

        
           
    }
}
