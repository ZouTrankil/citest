node {
    def gradle = tool 'gradle'

    // holds reference to docker image
    def dockerImage
    // ip address of the docker private repository(nexus)

    def dockerImageTag = "devopsexample:${env.BUILD_NUMBER}"

    stage('Clone Repo') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/ZouTrankil/citest.git'
      gradle = tool 'gradle'
    }

    stage('Build Project') {
      sh "'${gradle}/bin/gradle' assemble"
    }

    stage('Build Docker Image') {
      // build docker image
      dockerImage = docker.build("devopsexample:${env.BUILD_NUMBER}")
    }

    stage('Deploy Docker Image'){

      // deploy docker image to nexus

      echo "Docker Image Tag Name: ${dockerImageTag}"

	  sh "docker stop devopsexample"

	  sh "docker rm devopsexample"

	  sh "docker run --name devopsexample -d -p 8888:8888 devopsexample:${env.BUILD_NUMBER}"

	  // docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
      //    dockerImage.push("${env.BUILD_NUMBER}")
      //      dockerImage.push("latest")
      //  }
// :${env.BUILD_NUMBER}
    }
}