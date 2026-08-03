def call(String imageName, String imageTag) {
    echo "Scanning Docker Image ${imageName}:${imageTag} with Trivy..."
    sh "trivy image --severity HIGH,CRITICAL --exit-code 0 ${imageName}:${imageTag}"
}