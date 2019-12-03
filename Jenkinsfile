pipeline {
    agent {
        label "master"
    }
    tools {
        // Note: this should match with the tool name configured in your jenkins instance (JENKINS_URL/configureTools/)
        maven "Maven 3.6.2"
    }
    environment {
        // This can be nexus3 or nexus2
        NEXUS_VERSION = "nexus3"
        // This can be http or https
        NEXUS_PROTOCOL = "http"
        // Where your Nexus is running
        NEXUS_URL = "localhost:8081"
        // Repository where we will upload the artifact
        NEXUS_REPOSITORY = "nexus_tutorial"
        // Jenkins credential id to authenticate to Nexus OSS
        NEXUS_CREDENTIAL_ID = "admin"
        
        //Build Variables
        VERSION = VersionNumber([versionNumberString : '1.0.${BUILD_NUMBER}', projectStartDate : '']);
        ARTIFACT_ID = 'junit-tutorial'
        GROUP_ID = 'io.kotiq'
        PACKAGING = 'jar'
        
    }
    stages {
        stage(" Clean "){
            steps{
                echo  "version: ${VERSION}"
                bat "mvn clean"
            }
        }
        stage(" Run Unit Tests") {
            steps {
                script {
                   bat "mvn test"
                }
            }
        }
        stage ("Package Project")  {
            steps {
                script {
                    //can combine clean and test with package for a single stage : mvn clean package...
                    bat "mvn package -Drevision=${VERSION}-SNAPSHOT"
                }
            }
        }
        stage(" Publish "){
            steps{
                nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: "${NEXUS_REPOSITORY}", 
                packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', 
                filePath:  "$WORKSPACE\\target\\$ARTIFACT_ID-${VERSION}-SNAPSHOT.$PACKAGING"]], 
                mavenCoordinate: [artifactId: "$ARTIFACT_ID", groupId: "$GROUP_ID", packaging: "$PACKAGING", version: "${VERSION}"]]]
               
            }
        }
        stage('Results') {
            steps{
                junit '**/target/surefire-reports/TEST-*.xml'
                archiveArtifacts  "target/*.$PACKAGING"
               // perform workspace cleanup only if the build have passed
            // if the build has failed, the workspace will be kept
            //cleanWs cleanWhenFailure: false
            }
        }
   }               
           
    
}
