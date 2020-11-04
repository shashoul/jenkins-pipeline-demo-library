import org.jenkinsci.plugins.pipeline.modeldefinition.Utils

def call() {
    node {
      println(env.RC)
      if (!env.RC){
          Utils.markStageSkippedForConditional("Audit tools")
      }
      else{
          sh '''
                git version
                docker version
                echo "Audit Tools groovy"
                #dotnet --list-sdks
                #dotnet --list-runtimes
                echo "Running from shared library..."
                echo "${RC}"
              '''
      env.JENKINS_SKIP_RELEASE = 'TRUE'
      withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'NEXUS_PASSWORD', usernameVariable: 'USERNAME', 
                      passwordVariable: 'NEXUS_PASSWORD']]){
                          sh(libraryResource('test.sh'))
            }
    }
  }

      
}
