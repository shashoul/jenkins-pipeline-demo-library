def call() {
    node {
      sh '''
        git version
        docker version
        echo "Audit Tools groovy"
        #dotnet --list-sdks
        #dotnet --list-runtimes
        echo "Running from shared library..."
      '''
      withCredentials(
        [[$class: 'UsernamePasswordMultiBinding', credentialsId: 'b185f16c-556f-4434-9b1b-938574bc802b', usernameVariable: 'USERNAME', 
            passwordVariable: 'NEXUS_PASSWORD']]) {
                          sh(libraryResource('test.sh'))
            }
    }
}
