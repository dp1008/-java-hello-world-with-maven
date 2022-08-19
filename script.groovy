def buildApp(){
    echo 'Builing the application'
}
def testApp(){
    echo 'testing Builing the application'
}
def deployApp(){
    echo 'deploying the application...'
    echo "deploy version ${params.VERSION}"

}
return this
