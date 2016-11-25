#!groovy
/*

Example workflow to demonstrate simple logic

 */

// Here is a sample stage so we can see it in our pipeline view
stage name: 'Start Sample Stage'
// Let's do a pipeline groovy call to print to screen (no node needed.)
echo 'Hello World from pipeline!'

// Must always start with a node to do any real/node logic.
node() {
    // Checkout the code from SCM (if using the same repo as the Jenkinsfile, we can use the keyword scm)
    stage name: 'Code Checkout'
    checkout scm

    // Next area of our job is to do some logic around versioning our build.
    stage name: 'Version Handling'
    def version = '1.5.0'


    // Let's write a file to the workspace with our version information
    writeFile([file: 'version.txt', text: version])

    // Let's archive the version data file for later use.
    archive('version.txt')
}
