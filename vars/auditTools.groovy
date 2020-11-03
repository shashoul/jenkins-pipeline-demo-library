def call() {
    node {
      sh '''
        git version
        docker version
        echo "Audit Tools groovy"
        #dotnet --list-sdks
        #dotnet --list-runtimes
      '''
    }
}
