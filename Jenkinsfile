def gv
pipeline{
    agent any
    parameters{
       // string(name: 'VERSION', defaulValue: '', description: 'version to deploy on prod')
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0' ], description: '')
        booleanParam(name: 'executeTest', defaultValue: true, description: '')

    }
        stages {
            stage("init"){
                steps {
                    script {
                        gv = load "script.groovy"
                    }
                }
            }
            stage("build"){
                steps {
                    script {
                        gv.buildApp()
                    }
            }
        }
            stage("test"){
                when{
                    expression {
                        params.executeTest
                    }
                }
                steps {
                    script {
                        gv.testApp()
                    }            
                }
        }
             stage("deploy"){
                steps {
                    input {
                        message "(select the env to deply to)"
                        ok "(done)"
                        parameters {
                        choice(name: 'ENV', choices: ['Dev', 'Test', 'Prod' ], description: '')
                        }
                    }
                    script {
                        gv.deployApp()
                        echo "Deploy to ${ENV}"
                    }
            }
        }

        
           
    }
}
