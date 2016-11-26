#!groovy

stage name: 'Start Sample Stage'

echo 'Hello World from pipeline!'

node() {
    stage name: 'Code Checkout'
    checkout scm

    stage name: 'Version Handling'
    def version = '1.5.0'
    stage name : 'Write file'
    writeFile([file: 'version.txt', text: version])
    stage name: 'Hello GDG'

    archive('version.txt')
}
