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
      withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'NEXUS_PASSWORD', usernameVariable: 'USERNAME', 
                      passwordVariable: 'NEXUS_PASSWORD']]){
                          sh(libraryResource('test.sh'))
            }
    }
}
