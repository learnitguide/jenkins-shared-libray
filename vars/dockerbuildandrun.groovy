def call(Map config = [:]) {
    def imageName = config.imageName ?: error("Image name not provided")
    def imageTag = config.imageTag ?: 'latest'
    def containerPort = config.containerPort ?: '8080'
    def hostPort = config.hostPort ?: containerPort

    stage("Docker Build and Run") {
        sh "docker build -t ${imageName}:${imageTag} ."
        sh "docker run -d -p ${hostPort}:${containerPort} ${imageName}:${imageTag}"
        echo "Docker container running on host port ${hostPort}"
    }
}
