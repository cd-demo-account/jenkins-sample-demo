#!groovy

stage name: 'Start Sample Stage'

echo 'Hello World from pipeline!'

node() {
    stage name: 'Code Checkout'
    checkout scm

    stage name: 'Version Handling'
    def version = '1.5.0'

    writeFile([file: 'version.txt', text: version])

    archive('version.txt')
}
