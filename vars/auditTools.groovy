import org.jenkinsci.plugins.pipeline.modeldefinition.Utils

def call() {
    node {
      Utils.markStageSkippedForConditional("Audit tools")

      sh '''
        git version
        docker version
        echo "Audit Tools groovy"
        #dotnet --list-sdks
        #dotnet --list-runtimes
        echo "Running from shared library..."
      '''
      env.JENKINS_SKIP_RELEASE = 'TRUE'
      withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'NEXUS_PASSWORD', usernameVariable: 'USERNAME', 
                      passwordVariable: 'NEXUS_PASSWORD']]){
                          sh(libraryResource('test.sh'))
            }
    }
}
