def call(String imageName, String imageTag, String contextDir = ".") {
    echo "Building Docker Image: ${imageName}:${imageTag}..."
    sh "docker build -t ${imageName}:${imageTag} ${contextDir}"
}